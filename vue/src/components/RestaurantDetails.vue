<template>
  <body>
    <div class="details-page">
      <div class="restaurant-name-block">
        <h3 class="restaurant-name">{{ details.name }}</h3>
        <h4 class="restaurant-location">{{ details.location.locality }}</h4>
      </div>

      <div class="details-block">
        <img
          class="featured-image-details"
          v-if="details.featured_image != ''"
          v-bind:src="details.featured_image"
        />
        <img class="featured-image-details-alt" v-else src="/img/Gritty.png" />
        <h4 class="rating-title">Average Rating</h4>
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
        <p
          class="rating-avg"
          v-if="details.user_rating.aggregate_rating >= 4.6"
        >
          ⭐⭐⭐⭐⭐
        </p>
        <h4 class="review-title">Reviews</h4>
        <p class="rating-votes">{{ details.user_rating.votes }}</p>
        <h4 class="price-title">Pricing Info</h4>
        <p class="price-details" v-if="details.price_range === 1">$</p>
        <p class="price-details" v-else-if="details.price_range === 2">$$</p>
        <p class="price-details" v-else-if="details.price_range === 3">$$$</p>
        <p class="price-details" v-else-if="details.price_range === 4">$$$$</p>
        <p class="price-details" v-else>$$$$$</p>
        <h4 class="price-for-two-title">Average Price for Two</h4>
        <p class="price-for-two">
           ${{ details.average_cost_for_two }}
        </p>
        <h4 class="address-title">Address</h4>
        <p class="address">{{ details.location.address }}</p>
        <h4 class="phone-title">Phone Number</h4>
        <p class="phone">{{ details.phone_numbers }}</p>
        <h4 class="phone-title">Cuisine</h4>
        <p class="cuisine">{{ details.cuisines }}</p>
      </div>
    </div>
  </body>
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
    };
  },
  computed: {},
  methods: {},
  created() {
    restService.getFavoritesDetails(this.$route.params.id).then((response) => {
      this.details = response.data;
    });
  },
};
</script>

<style>
.details-page {
  grid-template-columns: 1fr;
  grid-template-areas:
    "navs"
    "restaurant-name"
    "restaurant-location"
    "featured-image-details"
    "rating-title"
    "rating-avg"
    "rating-votes"
    "price-details"
    "address-title"
    "address"
    "phone-title"
    "phone"
    "cuisine";
  width: 90%;
  margin-top: 80px;
  margin-left: auto;
  margin-right: auto;
}

.restaurant-name-block {
  background: rgb(237, 23, 76);
  background: radial-gradient(
    circle,
    rgba(237, 23, 76, 1) 0%,
    rgba(237, 23, 76, 0.6222864145658263) 81%
  );
  border-radius: 10px;
  height: auto;
  padding-top: 5px;
  padding-bottom: 5px;
  margin-top: 20px;
}
.restaurant-name {
  grid-area: restaurant-name;
  background-color: #006bb6;
  border-radius: 10px;
  font-size: 25px;
  font-weight: bold;
  color: #ffffff;
  text-align: center;
  margin: auto;
  margin-top: 20px;
  height: auto;
  width: 80%;
  padding: 10px;
  box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.25);
}
.restaurant-location {
  grid-area: restaurant-location;
  background-color: #006bb6;
  font-weight: bold;
  color: #ffffff;
  text-align: center;
  font-size: 18px;
  border-radius: 10px;
  width: 80%;
  height: auto;
  padding: 5px;
  margin-left: auto;
  margin-right: auto;
}

.details-block {
  background: rgb(237, 23, 76);
  background: radial-gradient(
    circle,
    rgba(237, 23, 76, 1) 0%,
    rgba(237, 23, 76, 0.6222864145658263) 81%
  );
  border-radius: 10px;
  padding-bottom: 10px;
  padding-top: 20px;
  margin-top: 10px;
}

.featured-image-details {
  grid-area: featured-image-details;
  display: flex;
  width: 80%;
  height: 80%;
  margin-left: auto;
  margin-right: auto;
  border-radius: 10px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  border: white solid 5px;
}

.featured-image-details-alt {
  display: flex;
  width: 80%;
  height: 80%;
  margin-left: auto;
  margin-right: auto;
  border-radius: 10px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  border: white solid 5px;
}

.review-title,
.price-for-two-title,
.rating-title,
.address-title,
.phone-title,
.price-title {
  color: #002B5C;
  font-weight: bold;
  font-size: 20px;
  text-align: center;
  margin-bottom: 0px;
}

.rating-avg,
.price-for-two,
.rating-votes,
.price-details,
.website,
.address,
.phone,
.cuisine {
  color: white;
  font-weight: bold;
  font-size: 20px;
  background-color: #ed174c;
  border-radius: 20px;
  width: 80%;
  padding: 2px;
  padding-bottom: 6px;
  text-align: center;
  margin-right: auto;
  margin-left: auto;
  text-shadow: 0px 5px 5px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 15px 15px rgba(0, 0, 0, 0.25);
  word-wrap: break-word;
  margin-top: 1px;
}

.rating-avg {
  grid-area: rating-avg;
}

.price-details {
  grid-area: rating-text;
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

/********************* DESKTOP *********************/
@media (min-width: 1024px) {


}
</style>