<!--this is where a user can like or dislike a restaurant --> 

<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <router-link v-bind:to="{ name: 'login' }">Login</router-link>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style>

</style>