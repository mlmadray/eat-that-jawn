<template>
<div>
  <div class="details" v-for="rest in restaurant" v-bind:key="rest.id">
    <h3 class="restaurant">{{ rest.name }}</h3>
    <p class="image">{{ rest.featured_image }}</p>
    <p class="rating">
      Average Rating: {{ rest.user_rating.aggregate_rating }}
    </p>
    <p class="rating-text">
      Average Rating: {{rest.user_rating.rating_text }}
    </p>
    <p class="rating-votes">Average Rating: {{ rest.user_rating.votes }}</p>
    <p class="price">Price: {{ rest.price_range }}</p>
    <p class="website">Website: {{ rest.url }}</p>
    <p class="address">address: {{rest.location.address }}</p>
    <p class="phone">phone_number: {{ rest.phone_numbers }}</p>
    <p class="cuisine">{{ rest.cuisines }}</p>
  </div>
</div>
</template>

<script>

export default {
  name: "restaurant-details",
  components: {
    
  },
  data() {
    return {
      
    };
  },
  //props:['details'],
  computed: {
    restaurant(){
      return this.$store.state.restaurantDetails;
    }
  },
  methods: {},
};
</script>

<style>
</style>