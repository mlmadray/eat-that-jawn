<!-- show only liked restaurants --> 
<template>
<div>
  <div class="navs">
    <router-link id="logout-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    <router-link id="home-nav" v-bind:to="{ name: 'home' }">Match</router-link>
    <router-link id="quest-nav" v-bind:to="{ name: 'questionnaire' }">Filter</router-link>
  </div>
  <liked-restaurants/>
</div>
</template>

<script>
import LikedRestaurants from '../components/LikedRestaurants.vue'

export default {
  components: { LikedRestaurants }
}
</script>

<style>
</style>