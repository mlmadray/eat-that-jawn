import axios from 'axios';

export default {

getAllCuisine(){
  return axios.get(`/questionnaire/cuisine`);
},

getAllNeighborhoods(){
  return axios.get(`/questionnaire/neighborhood`);
},

getAllCategories(){
  return axios.get(`/questionnaire/category`);
},

addFavorite(user_id, favRestaurant) {
  return axios.post(`/favorites/${user_id}`, favRestaurant);
},

getFavorites(user_id) {
  return axios.get(`/favorites/${user_id}`);
},

addVisit(user_id, visitedRestaurant){
  return axios.post(`/visited/${user_id}`, visitedRestaurant);
}

