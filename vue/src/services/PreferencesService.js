import axios from 'axios';


export default {

getCuisineID(cuisine_type){
    return axios.get(`/cuisine/${cuisine_type}`);
},
getAllCuisine(){
  return axios.get(`/questionnaire/cuisine`);
},
getLiked(username) {
  return axios.get(`/restaurants/${username}`);
},

getAllNeighborhoods(){
  return axios.get(`/questionnaire/neighborhood`);
},

getAllCategories(){
  return axios.get(`/questionnaire/category`);
},

getAllServiceOptions(){
  return axios.get(`/questionnaire/serviceoption`);
}

}