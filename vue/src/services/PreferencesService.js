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

getAllServiceOptions(){
  return axios.get(`/questionnaire/serviceoption`);
},

addFavorite(user_id, favRestaurant) {
  return axios.post(`/favorites/${user_id}`, favRestaurant);
}
}