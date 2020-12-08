const { valueOf } = require("core-js/fn/_");

import axios from 'axios';

const http = axios.create({
    baseURL: "https://developers.zomato.com/api/v2.1/search?entity_id=287&entity_type=city"
});

export default {
    getLiked(user_id) {
        return axios.get(`/restaurants/${user_id}`);
    },

    postLiked(user_id) {
        return axios.post(`/restaurants/${user_id}`);
    },

    deleteLiked(user_id) {
        return axios.delete(`/restaurants/${user_id}`);
    },

    getRestaurants() {
        return axios.get('/restaurants');
    }

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