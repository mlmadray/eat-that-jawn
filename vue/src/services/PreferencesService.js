import axios from 'axios';


export default {

getCuisineID(cuisine_type){
    return axios.get(`/cuisine/${cuisine_type}`);
},
getAllCuisine(){
  return axios.get(`/questionnaire/cuisine`);
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