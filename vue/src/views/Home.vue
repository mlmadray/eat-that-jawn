<!--this is where a user can like or dislike a restaurant --> 

<template>
  <body>
    <link rel='icon' href="<%= BASE_URL %>favicon.ico">
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <div class="navs">
      <router-link id="logout-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link id="fav-nav" v-bind:to="{ name: 'liked' }">Favorites</router-link>
      <router-link id="quest-nav" v-bind:to="{ name: 'questionnaire' }">Filter</router-link>
    </div>
    <div class="home">
          <matched-restaurants />
    </div>

  </body>
</template>

<script>
import MatchedRestaurants from '../components/MatchedRestaurants.vue';
export default {
  name: "home",
  components:
    {
      MatchedRestaurants
  }
};
</script>

<style>
</style>
    