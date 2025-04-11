-- ========== ROLES ==========
INSERT INTO role (id, role_name) VALUES (1, 'USER');
INSERT INTO role (id, role_name) VALUES (2, 'ADMIN');

-- ========== USERS ==========
-- Jean: password -> BCrypt
-- Marie: password -> BCrypt(idem pour les autres)
INSERT INTO user (id, firstname, lastname, pseudonym, password, email, role_type) VALUES (1, 'Jean', 'Dupont', 'jdupont', '$2a$10$3Uo.DNjvC3ESvshZH.Gy8.3IK1G3dTzFV8AFzDCsk7M1lWhMQwCE6', 'jean.dupont@mail.com', 'Subscriber');
INSERT INTO user (id, firstname, lastname, pseudonym, password, email, role_type) VALUES (2, 'Marie', 'Curie', 'mcurie', '$2a$10$3Uo.DNjvC3ESvshZH.Gy8.3IK1G3dTzFV8AFzDCsk7M1lWhMQwCE6', 'marie.curie@mail.com', 'Subscriber');
INSERT INTO user (id, firstname, lastname, pseudonym, password, email, role_type) VALUES (3, 'Lola', 'Panzani', 'lolo', '$2a$10$3Uo.DNjvC3ESvshZH.Gy8.3IK1G3dTzFV8AFzDCsk7M1lWhMQwCE6', 'lp@mail.com', 'Subscriber');

-- ========== USER_ROLES ==========
INSERT INTO user_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, roles_id) VALUES (2, 1);

-- ========== SUBSCRIBERS ==========
INSERT INTO subscriber (id, city, postal_code, street, is_in_city, birthdate, introduction, phone, picture, notification_preferences, registration_date, withdrawal_date, withdrawal_reason, last_activity_date) VALUES (1, 'Paris', '75001', '1 rue de Rivoli', 1, '1990-01-01', 'Salut, moi c''est Jean !', '0601020304', '/jean-picture.jpg', 0, '2024-01-01', NULL, NULL, '2025-04-08');
INSERT INTO subscriber (id, city, postal_code, street, is_in_city, birthdate, introduction, phone, picture, notification_preferences, registration_date, withdrawal_date, withdrawal_reason, last_activity_date) VALUES (2, 'Suresnes', '92150', '12 avenue du Général', 0, '1985-12-12', 'Je suis Marie, ravie de vous rencontrer.', '0605060708', '/marie-picture.jpg', 0, '2024-01-02', NULL, NULL, '2025-04-08');
INSERT INTO subscriber (id, city, postal_code, street, is_in_city, birthdate, introduction, phone, picture, notification_preferences, registration_date, withdrawal_date, withdrawal_reason, last_activity_date) VALUES (3, 'Clamart', '92140', '17 rue Saint-Christophe', 0, '1985-12-12', 'Hello, moi c''est Lola, hâte de partager de bons conseils et des adresses avec vous !.', '0605060708', '/lola-picture.jpg', 0, '2024-01-02', NULL, NULL, '2025-04-08');

-- ========== PUBLICATIONS ==========
INSERT INTO publication (id, title, city, postal_code, street, description, publication_date, is_reported, is_archived, author_id, category) VALUES (1, 'Marché local ce samedi', 'Lyon', '69003', 'Rue de la République', 'Venez nombreux au marché local, producteurs et animations.', '2024-04-05T10:00:00', false, false, 1, 'INFO');
INSERT INTO publication (id, title, city, postal_code, street, description, publication_date, is_reported, is_archived, author_id, category) VALUES (2, 'Vol dans le quartier', 'Lyon', '69003', 'Rue du Dauphiné', 'Un cambriolage a eu lieu hier soir. Soyez vigilants !', '2024-04-06T15:30:00', false, false, 2, 'ALERT');
INSERT INTO publication (id, title, city, postal_code, street, description, publication_date, is_reported, is_archived, author_id, category) VALUES (3, 'Bon plombier à recommander ?', 'Lyon', '69003', 'Rue Garibaldi', 'Je cherche un bon plombier pas trop cher, des idées ?', '2024-04-07T08:45:00', false, false, 1, 'QUESTION');
INSERT INTO publication (id, title, city, postal_code, street, description, publication_date, is_reported, is_archived, author_id, category) VALUES (4, 'Donne canapé', 'Lyon', '69003', 'Rue Paul Bert', 'Canapé en bon état à donner, à venir chercher.', '2024-04-07T17:20:00', false, false, 2, 'HELP');
INSERT INTO publication (id, title, city, postal_code, street, description, publication_date, is_reported, is_archived, author_id, category) VALUES (5, 'Nouvel arrêt de bus', 'Lyon', '69003', 'Cours Lafayette', 'Un nouvel arrêt a été installé près de la médiathèque.', '2024-04-08T12:00:00', false, false, 1, 'INFO');

-- ========== PUBLICATIONS_ILLUSTRATIONS ==========
INSERT INTO publication_illustrations (publication_id, illustrations) VALUES (1, 'marche.jpg');
INSERT INTO publication_illustrations (publication_id, illustrations) VALUES (2, 'vol_quartier.png');
INSERT INTO publication_illustrations (publication_id, illustrations) VALUES (3, 'plombier.jpg');
INSERT INTO publication_illustrations (publication_id, illustrations) VALUES (4, 'canape.jpg');
INSERT INTO publication_illustrations (publication_id, illustrations) VALUES (5, 'arret_bus.jpg');

-- ========== EVENTS ==========
INSERT INTO event (id, title, city, postal_code, street, start_date, end_date, description, author_id) VALUES (1, 'Fête des voisins', 'Lyon', '69003', 'Place Guichard', '2024-05-10T18:00:00', '2024-05-10T23:00:00', 'Apportez un plat à partager, tout le monde est bienvenu !', 1);
INSERT INTO event (id, title, city, postal_code, street, start_date, end_date, description, author_id) VALUES (2, 'Collecte de vêtements', 'Lyon', '69003', 'Rue Moncey', '2025-04-15T09:00:00', '2025-04-15T18:00:00', 'Venez déposer des vêtements chauds pour les sans-abri.', 2);
INSERT INTO event (id, title, city, postal_code, street, start_date, end_date, description, author_id) VALUES (3, 'Atelier compost', 'Lyon', '69003', 'Rue Dunoir', '2025-04-20T14:00:00', '2025-04-20T16:00:00', 'Initiation au compostage urbain avec démonstration.', 1);
INSERT INTO event (id, title, city, postal_code, street, start_date, end_date, description, author_id) VALUES (4, 'Repair Café', 'Paris', '75010', 'Rue du Faubourg Saint-Martin', '2025-05-18T10:00:00', '2025-05-18T13:00:00', 'Apportez vos objets cassés, on les répare ensemble !', 2);
INSERT INTO event (id, title, city, postal_code, street, start_date, end_date, description, author_id) VALUES (5, 'Bal populaire', 'Paris', '75010', 'Place Franz Liszt', '2025-06-21T19:00:00', '2025-06-21T23:59:00', 'Musique, danse et bonne humeur pour la fête de la musique !', 3);
INSERT INTO event (id, title, city, postal_code, street, start_date, end_date, description, author_id) VALUES (6, 'Troc de plantes', 'Paris', '75010', 'Rue de l\'Aqueduc', '2025-05-05T09:30:00', '2025-05-05T12:30:00', 'Échangez vos plantes et boutures avec vos voisins jardiniers.', 2);

-- ========== EVENT_ILLUSTRATIONS ==========
INSERT INTO event_illustrations (event_id, illustrations) VALUES (1, 'voisins.jpg');
INSERT INTO event_illustrations (event_id, illustrations) VALUES (2, 'collecte.jpg');
INSERT INTO event_illustrations (event_id, illustrations) VALUES (3, 'compost.jpg');