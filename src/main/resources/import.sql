
-- ========== ROLES ==========
INSERT INTO role (id, role_name) VALUES (1, 'USER');
INSERT INTO role (id, role_name) VALUES (2, 'ADMIN');

-- ========== USERS ==========
INSERT INTO user (id, firstname, lastname, pseudonym, password, email, role_type) VALUES (1, 'Jean', 'Dupont', 'jdupont', '$2a$10$3Uo.DNjvC3ESvshZH.Gy8.3IK1G3dTzFV8AFzDCsk7M1lWhMQwCE6', 'jean@mail.com', 'Subscriber');
INSERT INTO user (id, firstname, lastname, pseudonym, password, email, role_type) VALUES (2, 'Marie', 'Curie', 'mcurie', '$2a$10$3Uo.DNjvC3ESvshZH.Gy8.3IK1G3dTzFV8AFzDCsk7M1lWhMQwCE6', 'marie@mail.com', 'Subscriber');
INSERT INTO user (id, firstname, lastname, pseudonym, password, email, role_type) VALUES (3, 'Lola', 'Panzani', 'lolo', '$2a$10$3Uo.DNjvC3ESvshZH.Gy8.3IK1G3dTzFV8AFzDCsk7M1lWhMQwCE6', 'lola@mail.com', 'Subscriber');
INSERT INTO user (id, firstname, lastname, pseudonym, password, email, role_type) VALUES (4, 'Alice', 'Morel', 'amorel', '$2a$10$3Uo.DNjvC3ESvshZH.Gy8.3IK1G3dTzFV8AFzDCsk7M1lWhMQwCE6', 'alice@mail.com', 'Subscriber');
INSERT INTO user (id, firstname, lastname, pseudonym, password, email, role_type) VALUES (5, 'Karim', 'Benali', 'kbenali', '$2a$10$3Uo.DNjvC3ESvshZH.Gy8.3IK1G3dTzFV8AFzDCsk7M1lWhMQwCE6', 'karim@mail.com', 'Subscriber');
INSERT INTO user (id, firstname, lastname, pseudonym, password, email, role_type) VALUES (6, 'Nina', 'Delcourt', 'nina_d', '$2a$10$3Uo.DNjvC3ESvshZH.Gy8.3IK1G3dTzFV8AFzDCsk7M1lWhMQwCE6', 'nina@mail.com', 'Subscriber');
INSERT INTO user (id, firstname, lastname, pseudonym, password, email, role_type) VALUES (7, 'Thomas', 'Roux', 'troux', '$2a$10$3Uo.DNjvC3ESvshZH.Gy8.3IK1G3dTzFV8AFzDCsk7M1lWhMQwCE6', 'thomas@mail.com', 'Subscriber');

-- ========== USER_ROLES ==========
INSERT INTO user_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, roles_id) VALUES (2, 1);
INSERT INTO user_roles (user_id, roles_id) VALUES (3, 1);
INSERT INTO user_roles (user_id, roles_id) VALUES (4, 1);
INSERT INTO user_roles (user_id, roles_id) VALUES (5, 1);
INSERT INTO user_roles (user_id, roles_id) VALUES (6, 1), (7, 1);

-- ========== SUBSCRIBERS ==========
INSERT INTO subscriber (id, city, postal_code, street, latitude, longitude, is_in_city, birthdate, introduction, phone, picture, notification_preferences, registration_date, withdrawal_date, withdrawal_reason, last_activity_date) VALUES (1, 'Colombes', '92700', '5 rue Paul Bert', 48.922000, 2.253400, true, '1990-01-01', 'Salut, moi c''est Jean !', '0601020304', '/jean-picture.jpg', 0, '2024-01-01', NULL, NULL, '2025-04-08');
INSERT INTO subscriber (id, city, postal_code, street, latitude, longitude, is_in_city, birthdate, introduction, phone, picture, notification_preferences, registration_date, withdrawal_date, withdrawal_reason, last_activity_date) VALUES (2, 'Colombes', '92700', '9 avenue Henri Barbusse', 48.921800, 2.254100, true, '1985-12-12', 'Je suis Marie, ravie de vous rencontrer.', '0605060708', '/marie-picture.jpg', 0, '2024-01-02', NULL, NULL, '2025-04-08');
INSERT INTO subscriber (id, city, postal_code, street, latitude, longitude, is_in_city, birthdate, introduction, phone, picture, notification_preferences, registration_date, withdrawal_date, withdrawal_reason, last_activity_date) VALUES (3, 'Colombes', '92700', '11 place du Général Leclerc', 48.922500, 2.252900, true, '1989-07-07', 'Lola ici ! Toujours partante pour un bon plan.', '0611223344', '/lola-picture.jpg', 0, '2024-01-03', NULL, NULL, '2025-04-08');
INSERT INTO subscriber (id, city, postal_code, street, latitude, longitude, is_in_city, birthdate, introduction, phone, picture, notification_preferences, registration_date, withdrawal_date, withdrawal_reason, last_activity_date) VALUES (4, 'Paris', '75020', '12 rue de Bagnolet', 48.8597, 2.3949, true, '1992-06-15', 'Alice, passionnée par les initiatives locales.', '0612345678', '/alice-picture.jpg', 0, '2024-02-01', NULL, NULL, '2025-04-08');
INSERT INTO subscriber (id, city, postal_code, street, latitude, longitude, is_in_city, birthdate, introduction, phone, picture, notification_preferences, registration_date, withdrawal_date, withdrawal_reason, last_activity_date) VALUES (5, 'Paris', '75020', '15 rue de la Réunion', 48.8588, 2.3962, true, '1988-03-22', 'Karim, toujours partant pour organiser des événements.', '0687654321', '/karim-picture.jpg', 0, '2024-02-05', NULL, NULL, '2025-04-08');
INSERT INTO subscriber (id, city, postal_code, street, latitude, longitude, is_in_city, birthdate, introduction, phone, picture, notification_preferences, registration_date, withdrawal_date, withdrawal_reason, last_activity_date) VALUES (6, 'Paris', '75011', '35 rue Saint-Maur', 48.8610, 2.3805, true, '1995-09-09', 'Nina, toujours en quête de nouveaux projets collaboratifs.', '0678901234', '/nina-picture.jpg', 0, '2024-03-01', NULL, NULL, '2025-04-08');
INSERT INTO subscriber (id, city, postal_code, street, latitude, longitude, is_in_city, birthdate, introduction, phone, picture, notification_preferences, registration_date, withdrawal_date, withdrawal_reason, last_activity_date) VALUES (7, 'Paris', '75011', '22 rue de la Fontaine au Roi', 48.8642, 2.3794, true, '1990-11-30', 'Thomas, habitant du 11e depuis toujours.', '0654321987', '/thomas-picture.jpg', 0, '2024-03-05', NULL, NULL, '2025-04-08');

-- ========== PUBLICATIONS ==========
INSERT INTO publication (id, title, city, postal_code, street, latitude, longitude, description, publication_date, is_reported, is_archived, author_id, category) VALUES (3, 'Donne jouets', 'Colombes', '92700', '10 avenue Henri Barbusse', 48.921700, 2.254000, 'Je donne des jouets en bon état.', '2024-05-03T15:00:00', false, false, 2, 'HELP');
INSERT INTO publication (id, title, city, postal_code, street, latitude, longitude, description, publication_date, is_reported, is_archived, author_id, category) VALUES (4, 'Infos stationnement', 'Colombes', '92700', '8 avenue Henri Barbusse', 48.921600, 2.253900, 'Nouvelles règles de stationnement à Colombes.', '2024-05-04T18:00:00', false, false, 2, 'INFO');
INSERT INTO publication (id, title, city, postal_code, street, latitude, longitude, description, publication_date, is_reported, is_archived, author_id, category) VALUES (1, 'Atelier jardinage', 'Colombes', '92700', '2 rue Paul Bert', 48.922050, 2.253100, 'Rejoignez-nous pour apprendre à faire pousser des légumes.', '2024-05-01T10:00:00', false, false, 1, 'INFO');
INSERT INTO publication (id, title, city, postal_code, street, latitude, longitude, description, publication_date, is_reported, is_archived, author_id, category) VALUES (2, 'Café rencontre', 'Colombes', '92700', '6 rue Paul Bert', 48.922020, 2.253500, 'Petit-déj entre voisins ce samedi matin.', '2024-05-02T09:00:00', false, false, 1, 'HELP');
INSERT INTO publication (id, title, city, postal_code, street, latitude, longitude, description, publication_date, is_reported, is_archived, author_id, category) VALUES (3, 'Donne jouets', 'Colombes', '92700', '10 avenue Henri Barbusse', 48.921700, 2.254000, 'Je donne des jouets en bon état.', '2024-05-03T15:00:00', false, false, 2, 'HELP');
INSERT INTO publication (id, title, city, postal_code, street, latitude, longitude, description, publication_date, is_reported, is_archived, author_id, category) VALUES (4, 'Infos stationnement', 'Colombes', '92700', '8 avenue Henri Barbusse', 48.921600, 2.253900, 'Nouvelles règles de stationnement à Colombes.', '2024-05-04T18:00:00', false, false, 2, 'INFO');
INSERT INTO publication (id, title, city, postal_code, street, latitude, longitude, description, publication_date, is_reported, is_archived, author_id, category) VALUES (5, 'Plantes à donner', 'Paris', '75020', '10 rue des Vignoles', 48.8589, 2.3930, 'Plusieurs plantes en bon état à donner.', '2025-07-15T10:00:00', false, false, 4, 'HELP');
INSERT INTO publication (id, title, city, postal_code, street, latitude, longitude, description, publication_date, is_reported, is_archived, author_id, category) VALUES (6, 'Conseils compostage', 'Paris', '75020', '8 rue de Buzenval', 48.8601, 2.3975, 'Session de conseils sur le compostage domestique.', '2025-07-20T16:00:00', false, false, 4, 'INFO');

-- ========== PUBLICATIONS_ILLUSTRATIONS ==========
INSERT INTO publication_illustrations (publication_id, illustrations) VALUES (1, 'https://images.pexels.com/photos/33104637/pexels-photo-33104637.jpeg'), (1, 'https://images.pexels.com/photos/11394948/pexels-photo-11394948.jpeg'), (1, 'https://images.pexels.com/photos/95215/pexels-photo-95215.jpeg');
INSERT INTO publication_illustrations (publication_id, illustrations) VALUES (5, 'https://images.pexels.com/photos/450326/pexels-photo-450326.jpeg'), (5, 'https://images.pexels.com/photos/190643/pexels-photo-190643.jpeg'), (6, 'https://images.pexels.com/photos/933054/pexels-photo-933054.jpeg');

-- ========== EVENTS ==========
INSERT INTO event (id, title, city, postal_code, street, latitude, longitude, start_date, end_date, description, author_id, creation_date) VALUES (1, 'Troc de livres', 'Colombes', '92700', '11 place du Général Leclerc', 48.922450, 2.252800, '2025-08-10T14:00:00', '2025-08-10T18:00:00', 'Échangez vos livres avec d''autres passionnés du quartier.', 3, '2025-03-03T16:00:00');
INSERT INTO event (id, title, city, postal_code, street, latitude, longitude, start_date, end_date, description, author_id, creation_date) VALUES (2, 'Pique-nique solidaire', 'Paris', '75020', 'Parc de Belleville', 48.8612, 2.3981, '2025-08-20T12:00:00', '2025-08-20T15:00:00', 'Rencontre conviviale autour d''un pique-nique.', 5, '2024-05-03T17:00:00');

-- ========== EVENT_ILLUSTRATIONS ==========
INSERT INTO event_illustrations (event_id, illustrations) VALUES (1, 'https://images.pexels.com/photos/33116158/pexels-photo-33116158.jpeg');
INSERT INTO event_illustrations (event_id, illustrations) VALUES (2, 'https://images.pexels.com/photos/2728242/pexels-photo-2728242.jpeg');

-- ========== EVENT PARTICIPANTS ==========
INSERT INTO event_participants (event_id, user_id) VALUES (1, 1), (1, 2), (1, 3);
