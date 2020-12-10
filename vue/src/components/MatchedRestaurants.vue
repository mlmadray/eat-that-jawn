<!-- TODO: filter restuarants based off matching preferences-->
<template>
  <div>
    <ul class="restaurant" v-for="restaurant in restaurants" v-bind:key="restaurant.name">
      <li>
        {{ restaurant.restaurant.name }}
      </li>
    </ul>
  </div>
</template>

<script>
//import preferenceService from '../services/PreferencesService';
import restService from "../services/RestServices";
export default {
  name: "matched-restaurants",
  data() {
    return {
      cuisine_ids: [],
      restaurants: [{ restaurant: {} }],
    };
  },

  created() {
    restService
      .getRestaurants(
        this.$store.state.Answers.neighborhood,
        this.$store.state.Answers.cuisine,
        this.$store.state.Answers.category,
        // this.$store.state.Answers.serviceOption
      )
      .then((response) => {
        this.restaurants = response.data.restaurants;
      });
  },
};
</script>

<style>
</style>