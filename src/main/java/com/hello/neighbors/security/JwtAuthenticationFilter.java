package com.hello.neighbors.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LogManager.getLogger();

    private JwtUtilities jwtUtilities;
    private CustomerUserDetailsService customerUserDetailsService;

    //////////// Méthodes /////////////////

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
                                    throws ServletException, IOException {
        String token = jwtUtilities.getToken(request) ;
        logger.info("Token JWT reçu : {}", token);

        if (token != null && jwtUtilities.validateToken(token)) {
            logger.info("Token JWT validé avec succès.");
            String email = jwtUtilities.extractUsername(token);
            logger.info("Nom d'utilisateur extrait du token : {}", email);
            UserDetails userDetails = customerUserDetailsService.loadUserByUsername(email);
            logger.info("Utilisateur récupéré : {}", userDetails);

            if (userDetails != null) {
                /// Créer un objet d'authentification et le mettre dans le SecurityContext
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails.getUsername() ,null , userDetails.getAuthorities());
                logger.info("Utilisateur authentifié avec l'identifiant : {}", email);
                logger.info("Authorities récupérées : {}", userDetails.getAuthorities());
                /// Mettre l'utilisateur dans le SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authentication);
                logger.info("Utilisateur authentifié avec le rôle(s) (JwtAuthFilter) : {}", userDetails.getAuthorities());
            }
        }
        filterChain.doFilter(request,response);
    }

    //////////// Setters /////////////////

    @Autowired
    public void setJwtUtilities(JwtUtilities jwtUtilities) {
        this.jwtUtilities = jwtUtilities;
    }

    @Autowired
    public void setCustomerUserDetailsService(CustomerUserDetailsService customerUserDetailsService) {
        this.customerUserDetailsService = customerUserDetailsService;
    }
}
