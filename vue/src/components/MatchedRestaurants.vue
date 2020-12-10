<!-- TODO: filter restuarants based off matching preferences-->
<template>
  <body class="matched">
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <header>
      <img src="../assets/img/etj-round.png" alt="Eat That Jawn?" />
    </header>
    <div>
      <ul
        class="restaurant"
        v-for="restaurant in restaurants"
        v-bind:key="restaurant.name"
      >
        <li>
          {{ restaurant.restaurant.name }}
        </li>
      </ul>
    </div>
  </body>
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
        this.$store.state.Answers.category
        // this.$store.state.Answers.serviceOption
      )
      .then((response) => {
        this.restaurants = response.data.restaurants;
      });
  },
};
</script>

<style>
.matched {
  background: linear-gradient(180deg, #000000 0%, rgba(0, 0, 0, 0.49) 100%);
}
</style>