CREATE TABLE etudiant (
    id VARCHAR2(100) PRIMARY KEY NOT NULL,
    prenom VARCHAR2(100),
    attribute VARCHAR2(100)
);

CREATE TABLE exercice (
    id VARCHAR2(100) PRIMARY KEY NOT NULL,
    ennonce VARCHAR2(100),
    modele VARCHAR2(100) DEFAULT NULL,
    difficulte VARCHAR2(50) CHECK ( difficulte IN ('facile', 'moyen', 'difficile') ),
    temps_moyen FLOAT,
    temps_max FLOAT
);

CREATE TABLE langage(
    typeMime VARCHAR2(100) PRIMARY KEY NOT NULL,
    nom VARCHAR2(100)   
);

CREATE TABLE enseignant(
    nom VARCHAR2(100),
    prenom VARCHAR2(100),
    email VARCHAR2(100)
);

CREATE TABLE tentative (
    id VARCHAR2(100) PRIMARY KEY NOT NULL,
    date_soumission DATE,
    validation_exercice NUMBER(1),
    reponse_etudiant VARCHAR2(255),
    log_erreur VARCHAR2(255),
    utilisation_aide NUMBER(1),
    duree_initial_soumission VARCHAR2(255),
    etat_resultat VARCHAR2(50) CHECK ( etat_resultat IN ('Réponse juste', 'Réponse fausse', 'Erreur de compilation', 'Erreur execution') )
);

CREATE TABLE aide (
    id VARCHAR2(100) PRIMARY KEY NOT NULL,
    description VARCHAR2(255),
    ordre INT
);

CREATE TABLE theme (
    id VARCHAR2(100) PRIMARY KEY NOT NULL,
    description VARCHAR2(255),
    tag VARCHAR2(255)
);


CREATE TABLE module (
    id VARCHAR2(100) PRIMARY KEY NOT NULL,
    nom VARCHAR2(100)
);

CREATE TABLE filiere (
    id VARCHAR2(100) PRIMARY KEY NOT NULL,
    niveau VARCHAR2(50) CHECK ( niveau IN ('L1', 'L2', 'L3', 'M1') )
);

CREATE TABLE parcours (
    id VARCHAR2(100) NOT NULL PRIMARY KEY,
    difficulte VARCHAR2(50) CHECK ( difficulte IN ('facile', 'moyen', 'difficile') )
);


CREATE TABLE parcoursSequentiel (
    id VARCHAR2(100) NOT NULL PRIMARY KEY
);

CREATE TABLE elementDeParcours (
    id VARCHAR2(100) NOT NULL PRIMARY KEY
);

CREATE TABLE contexte (
    id VARCHAR2(100) NOT NULL PRIMARY KEY
);