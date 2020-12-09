import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});
export default {

getCuisineID(cuisine_type){
    return http.get(`/cuisine/${cuisine_type}`);
},
getLiked(user_id) {
  return http.get(`/restaurants/${user_id}`);
},

getAnswers(user_id) {
  return http.get(`/questionnaire/${user_id}`);
},

updateAnswers(user_id) {
  return http.put(`/questionnaire/${user_id}`);
},

addAnswers(user_id) {
  return http.post(`/questionnaire/${user_id}`);
},


}