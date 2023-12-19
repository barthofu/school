CREATE TABLE Element (
                         id int NOT NULL ,
                         nom varchar(10) NOT NULL,
                         description varchar(150) NOT NULL,
                         constraint PK_ID_ELEMENT PRIMARY KEY(id));

CREATE TABLE Type (
                      id int NOT NULL,
                      nom varchar(50) NOT NULL,
                      niveau int NOT NULL,
                      constraint PK_ID_TYPE PRIMARY KEY (id));

CREATE TABLE Sort (
                      id int NOT NULL,
                      id_type int NOT NULL,
                      id_element int NOT NULL,
                      degat int NOT NULL,
                      point_magie int NOT NULL,
                      incantation varchar(200) NOT NULL,
                      CONSTRAINT PK_ID_SORT PRIMARY KEY (id),
                      CONSTRAINT FK_TYPE FOREIGN KEY (id_type) REFERENCES Type(id) ON DELETE CASCADE,
                      CONSTRAINT FK_ELMENT FOREIGN KEY (id_element) REFERENCES Element(id) ON DELETE CASCADE);

INSERT INTO Element VALUES (1,'terre','element de la terre');
INSERT INTO Element VALUES (2,'feu','element du feu');
INSERT INTO Element VALUES (3,'eau','element de l eau');
INSERT INTO Element VALUES (4,'air','element de l air');

INSERT INTO Type VALUES (1,'illusion',1);
INSERT INTO Type VALUES (2,'abjuration',1);
INSERT INTO Type VALUES (3,'enchantement',2);
INSERT INTO Type VALUES (4,'alteration',2);
INSERT INTO Type VALUES (5,'conjuration',3);
INSERT INTO Type VALUES (6,'evocation',4);
INSERT INTO Type VALUES (7,'invocation',5);
INSERT INTO Type VALUES (8,'divination',6);

INSERT INTO Sort VALUES (1,1,1,10,15,'on me voit on me voit plus');
INSERT INTO Sort VALUES (2,2,1,18,20,'vae victis');
INSERT INTO Sort VALUES (4,5,2,45,50,'pas de palais pas de palais');
INSERT INTO Sort VALUES (5,1,2,10,15,'dispersion facon puzzle');
INSERT INTO Sort VALUES (6,5,3,35,45,'je nie pas le cote farce');
INSERT INTO Sort VALUES (7,4,1,30,45,'les cons ca osent tout');
INSERT INTO Sort VALUES (8,1,3,10,15,'touche pas au grizby');
INSERT INTO Sort VALUES (9,2,3,24,30,'je suis sous le soleil');
INSERT INTO Sort VALUES (10,1,2,20,15,'je suis pas la la la');
INSERT INTO Sort VALUES (11,8,1,80,70,'je suis avec mes gars');
INSERT INTO Sort VALUES (12,5,4,30,35,'c est du brutal');
INSERT INTO Sort VALUES (13,1,3,12,15,'y en a aussi');
INSERT INTO Sort VALUES (14,1,2,10,15,'je fais quoi coach');
INSERT INTO Sort VALUES (15,1,1,19,15,'je me suis deconnecte');
INSERT INTO Sort VALUES (16,8,4,100,82,'par le pouvoir du crane ancestral');

COMMIT;