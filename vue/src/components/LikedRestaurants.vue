<!-- TODO: filter list of matches based of status of liked -->
<template>

<div>
    <!-- <restaurant-details v-bind:details="details"></restaurant-details> -->
  <div class = "matches" 
          v-for="restaurant in details"
          v-bind:key="restaurant.id" 
          v-bind="restaurantDetails = restaurant"         
          >
          
          <router-link v-bind:to="{name: 'restaurant', params:{id: restaurant.id}}" v-on:click="setRestaurant()">
            <p class="image">{{restaurant.featured_image}}</p>
            <p class="restaurant" >{{restaurant.name }}</p>
          </router-link>
          
      </div>
      
      </div>
</template>

<script>
import preferenceService from '../services/PreferencesService';
import restService from '../services/RestServices';
// import RestaurantDetails from './RestaurantDetails.vue';

export default {
    name: 'liked-restaurants',
    components:{
        // RestaurantDetails
    },
    data() {
        
        return {
            favorites: [],
            details: [],
            restaurantDetails: {}
        }
    },
    methods: {
        getDetails() {
               this.favorites.forEach(fav => {
                 restService.getFavoritesDetails(fav.restaurantId)
                .then( (response) => {
                    this.details.push(response.data)})
               })
        },
        setRestaurant(){
            this.$store.commit("SET_RESTAURANT", this.restaurantDetails)
        }
    },
    created() {
        preferenceService.getFavorites(this.$store.state.user.id)
        .then( (response) => {
            this.favorites = response.data;
            this.getDetails()
        })
    } 
}
</script>

<style>

</style>