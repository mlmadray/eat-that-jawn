<template>
  <body>
    <div class="details-page">
      <div class="restaurant-name-block">
        <h3 class="restaurant-name">{{ details.name }}</h3>

      </div>
              <h4 class="restaurant-name">{{ details.location.locality }}</h4>
      <div class="details-block">
        <img
          class="featured-image-details"
          v-if="details.featured_image != ''"
          v-bind:src="details.featured_image"
        />
        <img
          class="featured-image-details-alt"
          v-else
          src="../assets/img/Fishtown.jpg"
        />
        <!-- <p class="rating">
        Average Rating: {{ details.user_rating.aggregate_rating }}
      </p> -->
      <h4 class = "rating-title">Average Rating</h4>
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
        <!-- <p class="rating-text">{{ details.user_rating.rating_text }}</p> -->
        <p class="rating-votes">Reviews: {{ details.user_rating.votes }}</p>
        <!-- <p class="price">Price: {{ details.price_range }}</p> -->
        <h4 class = "price-title">Pricing Info</h4>
        <p class="price-details" v-if="details.price_range === 1">$</p>
        <p class="price-details" v-else-if="details.price_range === 2">$$</p>
        <p class="price-details" v-else-if="details.price_range === 3">$$$</p>
        <p class="price-details" v-else-if="details.price_range === 4">$$$$</p>
        <p class="price-details" v-else>$$$$$</p>
         <p class="price"> Average Price for two ${{ details.average_cost_for_two }}</p>
        <!-- <a href="" class="rest-url" target="_blank"
          ><p class="website">{{ details.url }}</p></a
        > -->
        <h4 class = "address-title">Address</h4>
        <p class="address">{{ details.location.address }}</p>
        <h4 class = "phone-title">Phone Number</h4>
        <p class="phone">{{ details.phone_numbers }}</p>
         <h4 class = "phone-title">Cuisine</h4>
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
    "featured-image-details"
    "rating-title"
    "rating-avg"
    /* "rating-text" */
    "rating-votes"
    "price-details"
    /* "website" */
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
  height: 50px;
  padding-top: 5px;
  padding-bottom: 40px;
  margin-bottom: auto;
  margin-top: 20px; 
}
.restaurant-name {
  grid-area: restaurant-name;
  background-color: #006bb6;
  height: 32px;
  left: 103px;
  top: 264px;
  border-radius: 10px;
  font-size: 25px;
  font-weight: bold;
  color: #ffffff;
  text-align: center;
  margin: auto;
  margin-top: 20px;
  margin-bottom: 20px;
  width: 50%;
  padding: 10px;
  box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.25);
}

.details-block {
  background: rgb(237, 23, 76);
  background: radial-gradient(
    circle,
    rgba(237, 23, 76, 1) 0%,
    rgba(237, 23, 76, 0.6222864145658263) 81%
  );
  border-radius: 10px;
  padding-bottom: 20px;
}

.featured-image-details {
  grid-area: featured-image-details;
  display: flex;
  width: 70%;
  height: 70%;
  margin-left: auto;
  margin-right: auto;
  border-radius: 10px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  border: white solid 5px;
}
.featured-image-details-alt {
  display: flex;
  width: 50%;
  height: 50%;
  margin-left: auto;
  margin-right: auto;
  padding-bottom: 10px;
}

.rating-title,
.address-title,
.phone-title,
.price-title{
  color: black;
  font-weight: bold;
  font-size: 20px;
  text-align: center;
  margin-bottom: 0px;
}

.rating-avg,
.price,
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
  width: 50%;
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

/********************* DESKTOP *********************/
@media (min-width: 1024px) {
}
</style>