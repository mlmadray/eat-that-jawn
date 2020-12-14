<template>
  <div>
    <div class="details">
      <h3 class="restaurantDetails">{{ details.name }}</h3>
      <img
        class="featured-image"
        v-if="details.featured_image != ''"
        v-bind:src="details.featured_image"
      />
      <img class="featured-image-alt" v-else src="../assets/img/sorry-no-image.png" />
      <!-- <p class="rating">
        Average Rating: {{ details.user_rating.aggregate_rating }}
      </p> -->
      <p
        class="rating-avg"
        v-if="
          details.user_rating.aggregate_rating >= 0 &&
          details.user_rating.aggregate_rating <= 1.5
        "
      >
        ⭐
      </p>
      <p
        class="rating-avg"
        v-if="
          details.user_rating.aggregate_rating > 1.5 &&
          details.user_rating.aggregate_rating <= 2.5
        "
      >
        ⭐⭐
      </p>
      <p
        class="rating-avg"
        v-if="
          details.user_rating.aggregate_rating > 2.5 &&
          details.user_rating.aggregate_rating <= 3.5
        "
      >
        ⭐⭐⭐
      </p>
      <p
        class="rating-avg"
        v-if="
          details.user_rating.aggregate_rating > 3.5 &&
          details.user_rating.aggregate_rating <= 4.5
        "
      >
        ⭐⭐⭐⭐
      </p>
      <p class="rating-avg" v-if="details.user_rating.aggregate_rating >= 4.6">
        ⭐⭐⭐⭐⭐
      </p>
      <p class="rating-text"> {{ details.user_rating.rating_text }} </p>
      <p class="rating-votes">
        Reviews: {{ details.user_rating.votes }}
      </p>
      <!-- <p class="price">Price: {{ details.price_range }}</p> -->
      <p class="price-details" v-if="details.price_range === 1">$</p>
      <p class="price-details" v-else-if="details.price_range === 2">$$</p>
      <p class="price-details" v-else-if="details.price_range === 3">$$$</p>
      <p class="price-details" v-else-if="details.price_range === 4">$$$$</p>
      <p class="price-details" v-else>$$$$$</p>

      <a href='' class="rest-url" target="_blank"><p class="website"> {{ details.url }}</p></a>
      <p class="address"> {{ details.location.address }} </p>
      <p class="phone"> {{ details.phone_numbers }}</p>
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
          address: "",
        },
        phone_numbers: "",
        cuisines: "",
      },
      rId: this.$store.state.resId,
    };
  },
  computed: {},
  methods: {
  },
  created() {
    restService.getFavoritesDetails(this.rId).then((response) => {
      this.details = response.data;
    });
  },
};
</script>

<style>
.details {
  grid-template-columns: 1fr;
  grid-template-areas:
    "navs"
    "restaurantDetails"
    "rating-avg"
    "rating-text"
    "rating-votes"
    "price-details"
    "website"
    "address"
    "phone"
    "cuisine"
}

.restaurantDetails {
  grid-area: restaurantDetails;
  background-color: #ed174c;
  height: 32px;
  left: 103px;
  top: 264px;
  border-radius: 10px;
  font-size: 18px;
  font-weight: bold;
  color: #ffffff;
  text-align: center;
  margin: auto;
  margin-top: 20px;
  margin-bottom: 20px;
  padding-top: 10px;
  box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.25);
}

.featured-image {
  width: 50%;
  border-radius: 15px; 
  border: #006bb6 ridge 6px;  
  margin-left: auto;
  margin-right: auto;
  display: flex;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

.rating-avg,
.rating-text,
.rating-votes,
.price-details,
.website,
.address,
.phone,
.cuisine {
  grid-area: rating;
  color: white;
  font-weight: bold;
  font-size: 20px;
  background-color: #ed174c;
  border-radius: 20px;
  width: 50%;
  padding: 2px;
  padding-bottom: 6px;
  text-align: center;
  margin-right: auto;
  margin-left: auto;
  text-shadow: 0px 5px 5px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 15px 15px rgba(0, 0, 0, 0.25);
  word-wrap: break-word;
}

.rating-avg {
  grid-area: rating-avg;
}

.price-details {
  grid-area: rating-text;
}

.website {
  grid-area: website;
}

.website:hover {
  text-decoration: underline;
}

.rest-url {
  text-decoration: none;
}

.address {
  grid-area: address;
}

.phone {
  grid-area: phone;
}

.cuisine {
  grid-area: cuisine;
}

</style>