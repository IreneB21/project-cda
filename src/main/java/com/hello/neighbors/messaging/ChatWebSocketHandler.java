package com.hello.neighbors.messaging;

import com.hello.neighbors.security.JwtUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

public class ChatWebSocketHandler extends TextWebSocketHandler {

    private static final Logger logger = LogManager.getLogger();

    private Map<String, WebSocketSession> userSessions = new HashMap<>();
    private final JwtUtilities jwtUtilities;

    @Autowired
    public ChatWebSocketHandler(JwtUtilities jwtUtilities) {
        this.jwtUtilities = jwtUtilities;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 1. Récupérer le token JWT depuis les headers
        // Assumer que le token est envoyé dans l'URL, par exemple "ws://localhost:8080/chat?token=<jwt>"
        String token = session.getUri().getQuery();

        // 2. Vérifier le token JWT
        if (token != null && jwtUtilities.validateToken(token)) {
            String email = jwtUtilities.extractUsername(token);
            // Trouver ou créer l'utilisateur en fonction de l'email extrait du token
            if (email != null) {
                // Ajouter la session de l'utilisateur à la map
                userSessions.put(email, session);
                logger.info("Logged user : " + email);
            }
        } else {
            session.close(); // Fermer la connexion si le token est invalide
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("Message received : " + message.getPayload());

        // Envoyer un message à un utilisateur spécifique :
        String targetUser = "target@example.com"; // Récupérer cette info depuis le message reçu
        WebSocketSession targetSession = userSessions.get(targetUser);
        if (targetSession != null) {
            targetSession.sendMessage(new TextMessage("Message reçu de " + session.getId()));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        userSessions.entrySet().removeIf(entry -> entry.getValue().equals(session));
        logger.info("Connection closed : " + session.getId());
    }
}
