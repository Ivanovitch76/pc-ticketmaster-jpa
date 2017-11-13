-- clients
CREATE TABLE clients(
	id SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL UNIQUE,
    iban CHAR(19) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO clients VALUES (DEFAULT, 'Betty Boop', 'US18 1234 5678 9012', 'betty.boop@hollywood.com');

-- salles
CREATE TABLE salles(
	id SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL UNIQUE,
    capacite INT NOT NULL
);

INSERT INTO salles VALUES (DEFAULT, 'Opera Royal de Wallonie', 1033);
INSERT INTO salles VALUES (DEFAULT, 'Theâtre Le Moderne', 300);

-- evenements
CREATE TABLE evenements(
	id SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    jour DATE NOT NULL,
    heure TIME NOT NULL,
    salle INT REFERENCES salles(id)
);
        
        
INSERT INTO evenements VALUES (DEFAULT, 'Stradella', '2012-09-19', '20:00:00', NULL);
UPDATE evenements SET salle = ( SELECT id FROM salles WHERE nom = 'Opera Royal de Wallonie' )
				  WHERE nom = 'Stradella';
				  
INSERT INTO evenements VALUES (DEFAULT, 'La Reine de beauté de Leenane', '2012-10-18', '20:30:00', NULL);
UPDATE evenements SET salle = ( SELECT id FROM salles WHERE nom = 'Theâtre Le Moderne' )
				  WHERE nom = 'La Reine de beauté de Leenane';

-- reservations
CREATE TABLE reservations(
	id SERIAL PRIMARY KEY,
    evenement INT REFERENCES evenements(id) NOT NULL,
    client INT REFERENCES clients(id) NOT NULL
);

