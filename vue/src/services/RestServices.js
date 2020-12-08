const { valueOf } = require("core-js/fn/_");
const apiKey = '565aaf5d257ecac2fb2db7425a942cc0';

import axios from 'axios';

const http = axios.create({
    // baseURL: "https://developers.zomato.com/api/v2.1/search?entity_id=287&entity_type=city"
    baseURL: "https://developers.zomato.com/api/v2.1"
});

export default {

    getRestByCuisineId(cuisineId) {
        return axios.get(`/search?entity_id=287&entity_type=city&cuisines=${cuisineId}&apikey=${apiKey}`)
    },

    getCuisines() {
       // return axios.get(`/search?entity_id=287&entity_type=city&cuisines&apikey=${apiKey}`)
       return axios.get('/cuisines?city_id=287&apikey=${apiKey}')
    },

    getLiked(user_id) {
        return axios.get(`/restaurants/${user_id}`);
    },

    getAnswers(user_id) {
        return axios.get(`/questionnaire/${user_id}`);
    },

    updateAnswers(user_id) {
        return axios.put(`/questionnaire/${user_id}`);
    },

    addAnswers(user_id) {
        return axios.post(`/questionnaire/${user_id}`);
    },
    
    getRestaurants() {
        return axios.get('/restaurants');
    }

    // deleteLiked(user_id) {
    //     return axios.delete(`/restaurants/${user_id}`);
    // },
    
    // getHours() {
    //   return axios.get('/restaurants/timings');
    // }

    // getWebsite() {
    //   return axios.get('restaurants/url');
    // }

    /* match paths with java application*/
 
    // GET Restaurants (By Category) /categories/category_name ***NOT SEARCH
    // GET Restaurants (By Neighborhood) /search/locality
    // GET Restaurants (By Cuisine) /search/cuisines
    // GET Restaurants (By Service Options) /search/has_menu_status
    // GET Price Range /price_range
    // GET Rating /user_rating/aggregate_rating
    // GET Reviews /search/all_reviews/reviews
    // GET Website /url
    // GET Hours /timings
    // GET Highlights /highlights
}