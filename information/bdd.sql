-- Table des Utilisateurs
CREATE DATABASE bibliotheque;
USE bibliotheque;

CREATE TABLE utilisateurs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    mot_de_passe VARCHAR(255) NOT NULL,
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES role_utilisateurs(id)
);

INSERT INTO utilisateurs (nom,email,mot_de_passe,role_id) VALUES 
("HERINANTENAINA","anthony@gmail.com","031013dter.",1);

-- Table des role utilisateurs 
CREATE TABLE role_utilisateurs(
    id INT AUTO_INCREMENT PRIMARY KEY,
    roles VARCHAR(50),
    quota INT DEFAULT 10,
    prolongement INT DEFAULT 0
);

INSERT INTO role_utilisateurs (roles) VALUES 
("BIBLIOTHECAIRE"),
("ANONYME"),
("ETUDIANT"),
("PROFESSIONNEL"),
("PROFESSEUR");


-- Table des Livres
CREATE TABLE livres (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    auteur VARCHAR(255) NOT NULL,
    editeur VARCHAR(100),
    annee_publication YEAR,
    synopsis TEXT,
    image_couverture VARCHAR(255),
    categorie_id INT,
    FOREIGN KEY (categorie_id) REFERENCES categories(id)
);

CREATE TABLE detail_livre(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_livre INT,
    id_teny INT,
    isany INT DEFAULT 1,
    FOREIGN KEY (id_livre) REFERENCES livres(id),
    FOREIGN KEY (id_teny) REFERENCES teny(id),
)

CREATE TABLE teny(
    id INT AUTO_INCREMENT PRIMARY KEY,
    fiteny VARCHAR(35)
);

CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE type_pret(
    id INT AUTO_INCREMENT PRIMARY KEY,
    type_pret VARCHAR(50)
);

INSERT INTO type_pret (type_pret) VALUES 
    ("DOMICILE"),
    ("SUR_PLACE");

-- mila mcree vue ho an'ny boky izay disponible na tsy
-- Table des Exemplaires
-- CREATE TABLE exemplaires (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     livre_id INT NOT NULL,
--     statut ENUM('DISPONIBLE', 'RESERVE', 'PRETE') DEFAULT 'DISPONIBLE',
--     type_pret ENUM('DOMICILE', 'SUR_PLACE') NOT NULL,
--     FOREIGN KEY (livre_id) REFERENCES livres(id)
-- );

-- Table des Prêts
CREATE TABLE prets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_utilisatateur INT NOT NULL,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL,
    prolongation BOOLEAN DEFAULT FALSE,
    rendu_le DATE DEFAULT NULL,
    penalite DECIMAL(10, 2) DEFAULT 0,
    FOREIGN KEY (id_utilisatateur) REFERENCES utilisateurs(id)
);

CREATE TABLE prolongation_pret(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_pret INT,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL,
    rendu_le DATE DEFAULT NULL,
);

-- -- Table des Réservations
-- CREATE TABLE reservations (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     utilisateur_id INT NOT NULL,
--     exemplaire_id INT NOT NULL,
--     date_reservation DATE NOT NULL,
--     statut ENUM('EN_ATTENTE', 'VALIDEE', 'ANNULEE') DEFAULT 'EN_ATTENTE',
--     FOREIGN KEY (utilisateur_id) REFERENCES utilisateurs(id),
--     FOREIGN KEY (exemplaire_id) REFERENCES exemplaires(id)
-- );

-- -- Table des Pénalités
-- CREATE TABLE penalites (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     pret_id INT NOT NULL,
--     montant DECIMAL(10, 2) NOT NULL,
--     type ENUM('RETARD', 'PERTE', 'DOMMAGE') NOT NULL,
--     FOREIGN KEY (pret_id) REFERENCES prets(id)
-- );

-- -- Table des Abonnements
-- CREATE TABLE abonnements (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     utilisateur_id INT NOT NULL,
--     type ENUM('MENSUEL', 'ANNUEL') NOT NULL,
--     date_debut DATE NOT NULL,
--     date_fin DATE NOT NULL,
--     renouvellement_automatique BOOLEAN DEFAULT FALSE,
--     FOREIGN KEY (utilisateur_id) REFERENCES utilisateurs(id)
-- );

-- -- Table des Jours Fériés
-- CREATE TABLE jours_feries (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     date DATE NOT NULL UNIQUE,
--     description VARCHAR(255) NOT NULL
-- );
