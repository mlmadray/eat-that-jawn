BEGIN;

INSERT INTO liked_restaurants (isLiked, restaurant_name) VALUES (true, 'Test');

INSERT INTO questionnaire (first_name, city, zip_code, category, cuisine, service_option, user_id) VALUES ('Testy', 'Philadelphia', '19107','Dinner','Italian', null,1);

INSERT INTO user_reaction (user_id, liked_id) VALUES (1,1);

ROLLBACK;
COMMIT;