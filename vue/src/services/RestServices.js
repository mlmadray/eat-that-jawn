const apiKey = '565aaf5d257ecac2fb2db7425a942cc0';

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
    }
}