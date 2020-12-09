BEGIN TRANSACTION;

DROP TABLE IF EXISTS neighborhoods;

CREATE TABLE neighborhoods (
        id SERIAL,
        locality_subzone_id int,
        locality_subzone_name varchar(50),
        CONSTRAINT pk_neighborhood_id PRIMARY KEY(id)
        );
    
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (118279,'Washington Square West');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (118219,'Rittenhouse Square');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (118231,'Kensington');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (118264,'Old City');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (118273,'Fishtown');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (118243,'Passyunk Square');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (118225,'Queen Village');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (161630,'Newbold');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (118270,'Northern Liberties');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (118218,'Roxborough/Manayunk');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (118288,'Fairmount');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (161619,'East Falls');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (118246,'Graduate Hospital');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (161605,'Brewerytown');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (119092,'Point Breeze');
INSERT INTO neighborhoods (locality_subzone_id, locality_subzone_name) VALUES (118222,'Chinatown');

Rollback;
Commit;