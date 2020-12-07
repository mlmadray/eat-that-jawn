BEGIN TRANSACTION;

DROP TABLE IF EXISTS user_reaction;
DROP TABLE IF EXISTS liked_restaurants;
DROP TABLE IF EXISTS questionnaire;


CREATE TABLE liked_restaurants (
        id SERIAL,
        isLiked BOOLEAN NOT NULL DEFAULT false,
        restaurant_name varchar(40) NOT NULL,
        CONSTRAINT pk_liked_restaurants PRIMARY KEY(id)
        );
        
CREATE TABLE user_reaction (
        user_liked SERIAL,
        user_id int NOT NULL,
        liked_id int NOT NULL,
        CONSTRAINT pk_user_liked PRIMARY KEY(user_liked)
        );
        
CREATE TABLE questionnaire (
        preference_id SERIAL,
        first_name varchar(50),
        city varchar(40),
        zip_code int,
        category varchar(20),
        cuisine varchar(20),
        service_option varchar(10),
        user_id int,
        CONSTRAINT pk_preference_id PRIMARY KEY(preference_id)
        );

ALTER TABLE questionnaire 
        ADD CONSTRAINT fk_user_user_id FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE user_reaction 
        ADD CONSTRAINT fk_user_reaction_user_id FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE user_reaction 
        ADD CONSTRAINT fk_user_reaction_liked_id FOREIGN KEY (liked_id)
        REFERENCES liked_restaurants(id);
ROLLBACK;
COMMIT; 