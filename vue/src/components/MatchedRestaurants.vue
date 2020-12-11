<!-- TODO: filter restuarants based off matching preferences-->
<template>
  <body class="matched">
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <span>
    <router-link id="fav-nav" v-bind:to="{ name: 'liked' }">My Favorites</router-link>
    </span>
    <header class="favHead">
      <img src="../assets/img/etj-round-sixers.png" alt="Eat That Jawn?" />
    </header>
    <button class="like-btn" v-on:click="like">❤</button>
    <button class="dislike-btn" v-on:click="dislike">👎</button>
    <transition-group name="matches_list" tag="p" >
        <div class = "matches" 
          v-for="restaurant in restaurants"
          v-bind:key="restaurant.restaurant.id"
          v-show="restaurant === restaurants[index]"          
          >
            <p class="restaurant" >{{restaurant.restaurant.name }}</p>
          
            <p class="image">{{restaurant.restaurant.featured_image}}</p>
          
            <!-- <p class="rating">Average Rating: {{restaurant.restaurant.user_rating.aggregate_rating}}</p> -->
            <p class="rating" v-if="restaurant.restaurant.user_rating.aggregate_rating > 0 && restaurant.restaurant.user_rating.aggregate_rating <= 1.5">⭐</p>
            <p class="rating" v-if="restaurant.restaurant.user_rating.aggregate_rating > 1 && restaurant.restaurant.user_rating.aggregate_rating <= 2.5">⭐⭐</p>
            <p class="rating" v-if="restaurant.restaurant.user_rating.aggregate_rating > 2 && restaurant.restaurant.user_rating.aggregate_rating <= 3.5">⭐⭐⭐</p>
            <p class="rating" v-if="restaurant.restaurant.user_rating.aggregate_rating >= 4 && restaurant.restaurant.user_rating.aggregate_rating <= 4.5">⭐⭐⭐⭐</p>
            <p class="rating" v-if="restaurant.restaurant.user_rating.aggregate_rating = 5">⭐⭐⭐⭐⭐</p>

            <!-- <p class="price">Price: {{restaurant.restaurant.price_range}}</p> -->
            <p class="price" v-if="restaurant.restaurant.price_range === 1">$</p>
            <p class="price" v-else-if="restaurant.restaurant.price_range === 2">$$</p>
            <p class="price" v-else-if="restaurant.restaurant.price_range === 3">$$$</p>
            <p class="price" v-else-if="restaurant.restaurant.price_range === 4">$$$$</p>
            <p class="price" v-else>$$$$$</p>


      </div>
   </transition-group>
  </body>
</template>

<script>
import PreferencesService from '../services/PreferencesService';
//import preferenceService from '../services/PreferencesService';
import restService from "../services/RestServices";
export default {
  name: "matched-restaurants",
  data() {
    return {
      cuisine_ids: [],
      restaurants: [
                  { 
                    restaurant: {
                      id: '',
                      name: '',
                      featured_image: '',
                      user_rating:{
                        aggregate_rating: ''
                      },
                      price_range: ''
                    },  
                  }
                  ],
      index: 19,
      
      liked_restaurants: {
        restaurantId: "",
        restaurantName: "",
        userId: this.$store.state.user.id
      },
      
    };
  },
   methods: {
    like: function () {
        
        this.liked_restaurants.restaurantId = this.restaurants[this.index].restaurant.id;
        this.liked_restaurants.restaurantName = this.restaurants[this.index].restaurant.name;
        this.restaurants.splice(this.index, 1);
        this.index = this.index - 1;
        PreferencesService.addFavorite(this.$store.state.user.id, this.liked_restaurants)
        .catch((error) => {
          if(response.status === 500) {
            alert(error.message)
          }
        });
    },
    dislike: function () {
      this.restaurants.splice(this.index, 1)
      this.index = this.index - 1
    },

    saveFavorite() {
      PreferencesService.addFavorite(this.$store.state.user.user_id, this.liked_restaurants)
    }
  },
  created() {
    restService
      .getRestaurants(
        this.$store.state.Answers.neighborhood,
        this.$store.state.Answers.cuisine,
        this.$store.state.Answers.category
        // this.$store.state.Answers.serviceOption
      )
      .then((response) => {
        this.restaurants = response.data.restaurants;
      });
  },
};
</script>

<style>
.matched {
  background: linear-gradient(180deg, #000000 0%, rgba(0, 0, 0, 0.49) 100%);
  font-family: 'Montserrat';
  font-weight: bold;
  color: white;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
}

#fav-nav {
  background-color: #006bb6;
  border-radius: 20px;
  font-size: 16px;
  font-weight: bold;
  color: #ffffff;
  padding: 5px 10px 5px 10px;
  text-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  text-decoration: none;
  width: 7em;
  text-align: center;
}

.favHead {
  background: none;
}

.matches {
  display: inline-block;
  margin-right: 10px;
}
.matches_list-enter-active, .matches_list-leave-active {
  transition: all 1s;
}
.matches_list-enter, .matches_list-leave-to  {
  opacity: 0;
  transform: translateY(30px);
}

.like-btn {
  font-size: 80px;
  color: #006bb6;
  background: none;
  border: none;
  width: 40px;
  height: 40px;
  cursor: pointer;
}

.like-btn:hover {
  color: #ed147c;
}

.dislike-btn {
  font-size: 80px;
  background: none;
  border: none;
  width: 40px;
  height: 40px;
  cursor: pointer;
}

.rating {
  color: white;
  font-weight: 100;
  font-size: 40px;
  
}

.price {
  font-size: 30px;
}
</style>