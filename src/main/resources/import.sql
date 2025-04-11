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
INSERT INTO subscriber (id, city, postal_code, street, latitude, longitude, is_in_city, birthdate, introduction, phone, picture, notification_preferences, registration_date, withdrawal_date, withdrawal_reason, last_activity_date) VALUES (1, 'Paris', '75001', '1 rue de Rivoli', 48.862545013427734, 2.33602237701416, 1, '1990-01-01', 'Salut, moi c''est Jean !', '0601020304', '/jean-picture.jpg', 0, '2024-01-01', NULL, NULL, '2025-04-08');
INSERT INTO subscriber (id, city, postal_code, street, latitude, longitude, is_in_city, birthdate, introduction, phone, picture, notification_preferences, registration_date, withdrawal_date, withdrawal_reason, last_activity_date) VALUES (2, 'Suresnes', '92150', '12 avenue du Général de Gaulle', 48.86957931518555, 2.224191188812256, 0, '1985-12-12', 'Je suis Marie, ravie de vous rencontrer.', '0605060708', '/marie-picture.jpg', 0, '2024-01-02', NULL, NULL, '2025-04-08');
INSERT INTO subscriber (id, city, postal_code, street, latitude, longitude, is_in_city, birthdate, introduction, phone, picture, notification_preferences, registration_date, withdrawal_date, withdrawal_reason, last_activity_date) VALUES (3, 'Clamart', '92140', '17 rue Saint-Christophe', 48.79924392700195, 2.266437292098999, 0, '1985-12-12', 'Hello, moi c''est Lola, hâte de partager de bons conseils et des adresses avec vous !.', '0605060708', '/lola-picture.jpg', 0, '2024-01-02', NULL, NULL, '2025-04-08');

-- ========== PUBLICATIONS ==========
INSERT INTO publication (id, title, city, postal_code, street, latitude, longitude, description, publication_date, is_reported, is_archived, author_id, category) VALUES (1, 'Marché local ce samedi', 'Paris', '75020 ', '3 Rue des Pyrénées', 48.8634147644043, 2.399641275405884, 'Venez nombreux au marché local, producteurs et animations.', '2024-04-05T10:00:00', false, false, 1, 'INFO');
INSERT INTO publication (id, title, city, postal_code, street, latitude, longitude, description, publication_date, is_reported, is_archived, author_id, category) VALUES (2, 'Vol dans le quartier', 'Paris', '75020 ', '18 Rue de la Bidassoa', 48.866615295410156, 2.3930981159210205, 'Un cambriolage a eu lieu hier soir. Soyez vigilants !', '2024-04-06T15:30:00', false, false, 2, 'ALERT');
INSERT INTO publication (id, title, city, postal_code, street, latitude, longitude, description, publication_date, is_reported, is_archived, author_id, category) VALUES (3, 'Bon plombier à recommander ?', 'Paris', '75020 ', '72 Rue de Ménilmontant', 48.86906814575195, 2.391245126724243, 'Je cherche un bon plombier pas trop cher, des idées ?', '2024-04-07T08:45:00', false, false, 1, 'QUESTION');
INSERT INTO publication (id, title, city, postal_code, street, latitude, longitude, description, publication_date, is_reported, is_archived, author_id, category) VALUES (4, 'Donne canapé', 'Paris', '75020 ', '10 Villa Riberolle', 48.85801696777344, 2.3967792987823486, 'Canapé en bon état à donner, à venir chercher.', '2024-04-07T17:20:00', false, false, 2, 'HELP');
INSERT INTO publication (id, title, city, postal_code, street, latitude, longitude, description, publication_date, is_reported, is_archived, author_id, category) VALUES (5, 'Nouvel arrêt de bus', 'Paris', '75020 ', '15 Rue de Belleville', 48.875457763671875, 2.3918702602386475, 'Un nouvel arrêt a été installé près de la médiathèque.', '2024-04-08T12:00:00', false, false, 1, 'INFO');

-- ========== PUBLICATIONS_ILLUSTRATIONS ==========
INSERT INTO publication_illustrations (publication_id, illustrations) VALUES (1, 'marche.jpg');
INSERT INTO publication_illustrations (publication_id, illustrations) VALUES (2, 'vol_quartier.png');
INSERT INTO publication_illustrations (publication_id, illustrations) VALUES (3, 'plombier.jpg');
INSERT INTO publication_illustrations (publication_id, illustrations) VALUES (4, 'canape.jpg');
INSERT INTO publication_illustrations (publication_id, illustrations) VALUES (5, 'arret_bus.jpg');

-- ========== EVENTS ==========
INSERT INTO event (id, title, city, postal_code, street, latitude, longitude, start_date, end_date, description, author_id) VALUES (1, 'Fête des voisins', 'Paris', '75020', '8 Rue Julien Lacroix', 48.8688762, 2.3859789, '2024-05-10T18:00:00', '2024-05-10T23:00:00', 'Apportez un plat à partager, tout le monde est bienvenu !', 1);
INSERT INTO event (id, title, city, postal_code, street, latitude, longitude, start_date, end_date, description, author_id) VALUES (2, 'Collecte de vêtements', 'Paris', '75020', '35 Rue des Vignoles', 48.85437774658203, 2.400357246398926, '2025-04-15T09:00:00', '2025-04-15T18:00:00', 'Venez déposer des vêtements chauds pour les sans-abri.', 2);
INSERT INTO event (id, title, city, postal_code, street, latitude, longitude, start_date, end_date, description, author_id) VALUES (3, 'Atelier compost', 'Paris', '75020', '2 Rue du Capitaine Ferber', 48.866451263427734, 2.406411647796631, '2025-04-20T14:00:00', '2025-04-20T16:00:00', 'Initiation au compostage urbain avec démonstration.', 1);
INSERT INTO event (id, title, city, postal_code, street, latitude, longitude, start_date, end_date, description, author_id) VALUES (4, 'Repair Café', 'Paris', '75020', '20 Rue Haxo', 48.87263107299805, 2.4040002822875977, '2025-05-18T10:00:00', '2025-05-18T13:00:00', 'Apportez vos objets cassés, on les répare ensemble !', 2);
INSERT INTO event (id, title, city, postal_code, street, latitude, longitude, start_date, end_date, description, author_id) VALUES (5, 'Bal populaire', 'Paris', '75020', '9 Rue Saint-Blaise', 48.85808563232422, 2.407017946243286, '2025-06-21T19:00:00', '2025-06-21T23:59:00', 'Musique, danse et bonne humeur pour la fête de la musique !', 3);
INSERT INTO event (id, title, city, postal_code, street, latitude, longitude, start_date, end_date, description, author_id) VALUES (6, 'Troc de plantes', 'Paris', '75020', '14 Rue de Fontarabie', 48.85755157470703, 2.4014599323272705, '2025-05-05T09:30:00', '2025-05-05T12:30:00', 'Échangez vos plantes et boutures avec vos voisins jardiniers.', 2);

-- ========== EVENT_ILLUSTRATIONS ==========
INSERT INTO event_illustrations (event_id, illustrations) VALUES (1, 'voisins.jpg');
INSERT INTO event_illustrations (event_id, illustrations) VALUES (2, 'collecte.jpg');
INSERT INTO event_illustrations (event_id, illustrations) VALUES (3, 'compost.jpg');