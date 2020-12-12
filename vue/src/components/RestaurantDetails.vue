<template>
  <div>
    <div class="details">
      <h3 class="restaurant">{{ details.name }}</h3>
      <img
        class="featured-image"
        v-if="details.featured_image != ''"
        v-bind:src="details.featured_image"
      />
      <img v-else src="../assets/img/etj-round-sixers.png" />
      <p class="rating">
        Average Rating: {{ details.user_rating.aggregate_rating }}
      </p>
      <p class="rating-text">
        Average Rating: {{ details.user_rating.rating_text }}
      </p>
      <p class="rating-votes">
        Average Rating: {{ details.user_rating.votes }}
      </p>
      <p class="price">Price: {{ details.price_range }}</p>
      <p class="website">Website: {{ details.url }}</p>
      <p class="address">address: {{ details.location.address }}</p>
      <p class="phone">phone_number: {{ details.phone_numbers }}</p>
      <p class="cuisine">{{ details.cuisines }}</p>
    </div>
  </div>
</template>

<script>
import restService from "../services/RestServices";

export default {
  name: "restaurant-details",
  components: {},
  data() {
    return {
      details: {
        name: "",
        featured_image: "",
        user_rating: {
          aggregate_rating: "",
          rating_text: "",
          rating_votes: "",
        },
        price_range: "",
        url: "",
        location: {
          address: ""
        },
        phone_numbers: "",
        cuisines: "",

      },
      rId: this.$store.state.resId,
    };
  },
  computed: {},
  methods: {},
  created() {
    restService.getFavoritesDetails(this.rId).then((response) => {
      this.details = response.data;
    });
  },
};
</script>

<style>
</style>