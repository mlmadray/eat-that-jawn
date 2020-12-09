BEGIN TRANSACTION;

DROP TABLE IF EXISTS category;

CREATE TABLE category (
        id SERIAL,
        zomato_category_id int,
        category_name varchar(20),
        CONSTRAINT pk_category_id PRIMARY KEY(id)
        );
    
INSERT INTO category (zomato_category_id, category_name) VALUES (3,'Nightlife');
INSERT INTO category (zomato_category_id, category_name) VALUES (6,'Cafe');
INSERT INTO category (zomato_category_id, category_name) VALUES (8,'Breakfast');
INSERT INTO category (zomato_category_id, category_name) VALUES (9,'Lunch');
INSERT INTO category (zomato_category_id, category_name) VALUES (10,'Dinner');
INSERT INTO category (zomato_category_id, category_name) VALUES (11,'Pubs & Bars');
INSERT INTO category (zomato_category_id, category_name) VALUES (14,'Clubs & Lounges');


commit;
rollback;