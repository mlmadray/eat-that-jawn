const apiKey = 'cc747fb03ab46627bb5969ca001acc2a';

import axios from 'axios';

const http = axios.create({
    baseURL: "https://developers.zomato.com/api/v2.1"
});

export default {
    getRestaurants(neighborhood, cuisineId, categoryId) {
        return http.get(`/search?entity_id=${neighborhood}&entity_type=subzone&cuisines=${cuisineId}&category=${categoryId}&apikey=${apiKey}`);
    },
    getFavoritesDetails(restaurantId) {
        return http.get(`/restaurant?res_id=${restaurantId}&apikey=${apiKey}`);
    },
    getMoreRestaurants(neighborhood, cuisineId, categoryId, start_count) {
        return http.get(`/search?entity_id=${neighborhood}&entity_type=subzone&cuisines=${cuisineId}&category=${categoryId}&apikey=${apiKey}&start=${start_count}`);
    }
}