import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});
export default {

getCuisineID(cuisine_type){
    return http.get(`/cuisine/${cuisine_type}`);
}


}