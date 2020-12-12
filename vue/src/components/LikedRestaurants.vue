<!-- TODO: filter list of matches based of status of liked -->
<template>
  <div>
    <!-- <restaurant-details v-bind:details="details"></restaurant-details> -->
    <div
      class="matches"
      v-for="restaurant in details"
      v-bind:key="restaurant.id"
      v-bind:value="setRestaurant(restaurant.id)"
    >
      <router-link
        v-bind:to="{ name: 'restaurant', params: { id: restaurant.id } }"
      >
        <p class="restaurant">{{ restaurant.name }}</p>
        <img
          class="featureimg"
          v-if="restaurant.featured_image != ''"
          v-bind:src="restaurant.featured_image"
        />
        <img v-else src="../assets/img/etj-round-sixers.png" />
      </router-link>
    </div>
  </div>
</template>

<script>
import preferenceService from "../services/PreferencesService";
import restService from "../services/RestServices";

export default {
  name: "liked-restaurants",
  components: {},
  data() {
    return {
      favorites: [],
      details: [],
      featuredImage: "",
    };
  },
  methods: {
    getDetails() {
      this.favorites.forEach((fav) => {
        restService.getFavoritesDetails(fav.restaurantId).then((response) => {
          this.details.push(response.data);
        });
      });
    },
    setRestaurant(resId) {
      this.$store.commit("SET_RESTAURANT", resId);
    },
  },
  created() {
    preferenceService
      .getFavorites(this.$store.state.user.id)
      .then((response) => {
        this.favorites = response.data;
        this.getDetails();
      });
  },
};
</script>

<style>
.featureimg {
  width: 200px;
}
</style>