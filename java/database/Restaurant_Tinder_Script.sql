BEGIN TRANSACTION;

DROP TABLE liked_restaurants IF EXISTS
DROP TABLE user_reaction IF EXISTS

CREATE TABLE liked_restaurants (
        liked_id SERIAL,
        like_dislike BOOLEAN NOT NULL DEFAULT false,
        restaurant_name varchar(40) NOT NULL,
        CONSTRAINT pk_liked_restaurants PRIMARY KEY(liked_id)
        );
        
CREATE TABLE user_reaction (
        user_liked SERIAL,
        user_id int NOT NULL,
        restaurant_id int NOT NULL,
        CONSTRAINT pk_user_liked PRIMARY KEY(user_liked)
        );
        
CREATE TABLE questionnaire (
        preference_id SERIAL,
        first_name varchar(50),
        city varchar(40),
        zip_code int(10),
        category varchar(20),
        cuisine varchar(20),
        service_option varchar(10),
        user_id int,
        CONSTRAINT pk_info_id PRIMARY KEY(info_id)
        );

ROLLBACK;