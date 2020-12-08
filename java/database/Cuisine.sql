BEGIN TRANSACTION;

DROP TABLE IF EXISTS cuisine;

CREATE TABLE cuisine (
        id SERIAL,
        zomato_cuisine_id int,
        cuisine_type varchar(20),
        CONSTRAINT pk_cuisine_id PRIMARY KEY(id)
        );
   BEGIN TRANSACTION;     
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (193,'BBQ');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (25,'Chinese');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (55,'Italian');

COMMIT;
ROLLBACK;