BEGIN TRANSACTION;

DROP TABLE IF EXISTS user_reaction;
DROP TABLE IF EXISTS liked_restaurants;
DROP TABLE IF EXISTS questionnaire;
DROP TABLE IF EXISTS favorites;

        
CREATE TABLE favorites (
        favorites_id SERIAL,
        user_id int NOT NULL,
        restaurant_id int ,
        restaurant_name varchar(50),
        CONSTRAINT pk_favorites_favorites_id PRIMARY KEY(favorites_id)
        );
        
ALTER TABLE favorites 
        ADD CONSTRAINT fk_favorites_user_id FOREIGN KEY (user_id) REFERENCES users(user_id);

ROLLBACK;
COMMIT; 