BEGIN TRANSACTION;

DROP TABLE IF EXISTS service_options;

CREATE TABLE service_options (
        id SERIAL,
        zomato_category_id int,
        category_name varchar(20),
        CONSTRAINT pk_service_option_id PRIMARY KEY(id)
        );
    
INSERT INTO service_options (zomato_category_id, category_name) VALUES (1,'Delivery');
INSERT INTO service_options (zomato_category_id, category_name) VALUES (5,'Takeaway');

rollback;
commit;