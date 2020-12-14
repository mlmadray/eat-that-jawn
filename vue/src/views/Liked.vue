<!-- show only liked restaurants --> 
<template>
<div>
  <div class="navs-liked">
    <router-link id="logout-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    <router-link id="home-nav" v-bind:to="{ name: 'home' }">Back to Search</router-link>
  </div>
  <liked-restaurants/>
</div>
</template>

<script>
import LikedRestaurants from '../components/LikedRestaurants.vue'

export default {
  components: { LikedRestaurants },

}
</script>

<style>
.navs-liked {
  display: flex;
  justify-content: space-between;  
}

#home-nav {
  justify-content: flex-end;
}

/********************* DESKTOP *********************/
@media (min-width: 1024px) {
  #logout-nav,
  #home-nav {
    font-size: 24px;
  }
}

</style>