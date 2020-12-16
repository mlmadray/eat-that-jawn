import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    Answers: {
      neighborhood: "",
      cuisine: "",
      category: "",
    },
    restaurants: [
      {
        restaurant: {
          id: "",
          name: "",
          featured_image: '',
          user_rating: {
            aggregate_rating: "",
          },
          price_range: "",
        },
      },
    ],
    resName: ""
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },

    SET_ANSWER(state, Answers) {
      state.Answers.neighborhood = Answers.neighborhood,
        state.Answers.cuisine = Answers.cuisine,
        state.Answers.category = Answers.category
    },

    SET_RESNAME(state, res) {
      state.resName = res;
    }

    // SET_RESTAURANTS(state, restaurant) {
    //   restaurant.forEach(res => {
    //     state.restaurants.restaurant.id = res.id,
    //     state.restaurants.restaurant.name = res.name,
    //     state.restaurants.restaurant.featured_image = res.featured_image,
    //     state.restaurants.restaurant.user_rating.aggregate_rating = res.user_rating.aggregate_rating,
    //     state.restaurants.restaurant.price_range = res.price_range
    //   })
    // }

  }
})
