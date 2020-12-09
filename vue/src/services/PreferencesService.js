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

getAnswers(username) {
  return axios.get(`/questionnaire/${username}`);
},

updateAnswers(username) {
  return axios.put(`/questionnaire/${username}`);
},

addAnswers(username, questionnaire) {
  return axios.post(`/questionnaire/${username}`,questionnaire);
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