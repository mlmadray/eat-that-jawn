<!-- show only liked restaurants --> 
<template>
<div>
  <router-link id="home-nav" v-bind:to="{ name: 'home' }">Back to Matching</router-link>&nbsp;
  <router-link id="logout-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
  <!-- <restaurant-details/> -->
  <liked-restaurants/>
</div>
</template>

<script>
import LikedRestaurants from '../components/LikedRestaurants.vue'
//import RestaurantDetails from '../components/RestaurantDetails.vue';
export default {
  components: { LikedRestaurants,
               // RestaurantDetails 
              },

}
</script>

<style>

</style>