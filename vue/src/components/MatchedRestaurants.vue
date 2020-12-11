<!-- TODO: filter restuarants based off matching preferences-->
<template>
  <body class="matched">
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <header>
      <img src="../assets/img/etj-round.png" alt="Eat That Jawn?" />
    </header>
    <button class="like-btn" v-on:click="like">Like</button>
    <button class="dislike-btn" v-on:click="dislike">Dislike</button>
    <transition-group name="matches_list" tag="p" >
        <div class = "matches" 
          v-for="restaurant in restaurants"
          v-bind:key="restaurant.restaurant.id"
          v-show="restaurant === restaurants[index]"          
          >
            <p class="restaurant" >{{restaurant.restaurant.name }}</p>
          
            <p class="image">{{restaurant.restaurant.featured_image}}</p>
          
            <p class="rating">Average Rating: {{restaurant.restaurant.user_rating.aggregate_rating}}</p>
          
            <p class="price">Price: {{restaurant.restaurant.price_range}}</p>


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
  background: white;
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
  background-image:
}

.dislike-btn {

}
</style>