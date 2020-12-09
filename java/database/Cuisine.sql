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
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (153,'Cuban');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (55,'Italian');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (148,'Indian');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (73,'Mexican');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (82,'Pizza');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (1,'American');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (308,'Vegetarian');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (162,'Peruvian');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (95,'Thai');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (40,'Fast Food');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (304,'Sandwiches');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (114,'Indonesian');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (954,'Amish');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (70,'Mediterranean');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (100,'Desserts');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (156,'Greek');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (218,'Israeli');
INSERT INTO cuisine (zomato_cuisine_id, cuisine_type) VALUES (177,'Sushi');

COMMIT;
ROLLBACK;