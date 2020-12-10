<!--this is where a user can like or dislike a restaurant --> 

<template>
  <body>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <div class="home">
      <h1>Home</h1>
      <p>You must be authenticated to see this</p>
      <router-link v-bind:to="{ name: 'login' }">Login</router-link>
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
    