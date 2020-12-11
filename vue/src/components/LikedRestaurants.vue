<!-- TODO: filter list of matches based of status of liked -->
<template>
<div>
  <div class = "matches" 
          v-for="restaurant in details"
          v-bind:key="restaurant.id"          
          >
            <p class="image">{{restaurant.featured_image}}</p>
            <p class="restaurant" >{{restaurant.name }}</p>
      </div>
      </div>
</template>

<script>
import preferenceService from '../services/PreferencesService';
import restService from '../services/RestServices';

export default {
    name: 'liked-restaurants',
    data() {
        return {
            favorites: [],
            details: []
        }
    },
    computed: {
        getDetails() {
            this.favorites.forEach((favorite => {
                restService.getFavoritesDetails(favorite.restaurantId)
    .then( (response) => {
    this.details.push(response.data)})
        }))
    },
created() {
    preferenceService.getFavorites(this.$store.state.user.id)
    .then( (response) => {
    this.favorites = response.data;
    }),
    restService.getFavoritesDetails(this.favorites.restaurantId)
    .then( (response) => {
    this.details = response.data})
} 
}
</script>

<style>

</style>