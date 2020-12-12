<template>
  <div>
    <router-link id="home-nav" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;
    <router-link id="logout-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    <router-link id="fav-nav" v-bind:to="{ name: 'liked' }">My Favorites</router-link>
    <restaurant-details/>
  </div>
</template>

<script>
import RestaurantDetails from '../components/RestaurantDetails.vue'
export default {
name: "restaurant",
components:{
RestaurantDetails
}
}
</script>

<style>
</style>