-- Insert data into EMPRESA and OFERTES tables
INSERT INTO EMPRESA (ID, DESCRIPTION, JOB, LOCATION, NAME) VALUES (2L, 'Empresa nova', 'Programador Junior', 'Barcelona', 'Itic');
INSERT INTO EMPRESA (ID, DESCRIPTION, JOB, LOCATION, NAME) VALUES (3L, 'Nueva Empresa', 'Analista de Datos', 'Madrid', 'DataCorp');
INSERT INTO EMPRESA (ID, DESCRIPTION, JOB, LOCATION, NAME) VALUES (4L, 'Startup Innovadora', 'Ingeniero de Software', 'Valencia', 'TechSolutions');
INSERT INTO EMPRESA (ID, DESCRIPTION, JOB, LOCATION, NAME) VALUES (5L, 'Empresa Tecnológica', 'Desarrollador Full Stack', 'Sevilla', 'CodeWave');
INSERT INTO EMPRESA (ID, DESCRIPTION, JOB, LOCATION, NAME) VALUES (6L, 'Consultora IT', 'Consultor de Sistemas', 'Barcelona', 'InnoTech');


--INSERT INTO OFERTES (EMPRESA_ID, ID, DESCRIPTION, OFFER) VALUES (2L, 2L, 'Busquem estudiants', '3 mesos');

-- Com a usuari puc afegir una oferta d’una empresa a l'API

INSERT INTO OFERTES (EMPRESA_ID, ID, DESCRIPTION, OFFER) VALUES (6L, 6L, 'Busquem estudiants', '3 mesos');
INSERT INTO OFERTES (EMPRESA_ID, ID, DESCRIPTION, OFFER) VALUES (2L, 2L, 'Oportunitat per professionals', '6 mesos');
INSERT INTO OFERTES (EMPRESA_ID, ID, DESCRIPTION, OFFER) VALUES (3L, 3L, 'Oportunitat de creixement', '5 mesos');

-- Com a usuari puc consultar ofertes a l'API
SELECT * FROM OFERTES;

-- Com a usuari puc consultar ofertes d’una empresa donada a l'API

SELECT * FROM OFERTES WHERE EMPRESA_ID = 3L;

-- Com a usuari puc actualitzar una oferta d’una empresa donada l'API

UPDATE OFERTES SET DESCRIPTION = 'Nova descripció', OFFER = 'Nova oferta' WHERE ID = 3L;

-- Com a usuari puc eliminar una oferta d’una empresa donada l'API

DELETE FROM OFERTES WHERE ID = 2L;

--  Com a usuari, si elimino una empresa s’eliminen automàticament totes les ofertes de l’empresa.

DELETE FROM EMPRESA WHERE ID =3L;
