<!-- TODO: filter restuarants based off matching preferences-->
<template>
  <body class="matchedBody">
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <header id="etj-round-sixers">
      <img src="../assets/img/etj-round-sixers.png" alt="Eat That Jawn?" />
    </header>
    <span>
      <router-link id="fav-nav" v-bind:to="{ name: 'liked' }"
        >My Favorites</router-link
      >
    </span>
    <div>
      <button class="like-btn" v-on:click="like">💙</button>
      <button class="dislike-btn" v-on:click="dislike">👎</button>
    </div>
    <transition-group name="matches_list" tag="p">
      <div
        class="matchesDetails"
        v-for="restaurant in restaurants"
        v-bind:key="restaurant.restaurant.id"
        v-show="restaurant === restaurants[index]"
      >
        <p class="rest-name">{{ restaurant.restaurant.name }}</p>
        <img
          class="featureimg"
          v-if="restaurant.featured_image != ''"
          v-bind:src="restaurant.featured_image"
        />
        <img v-else src="../assets/img/etj-round-sixers.png" />

        <!-- <p class="rating">Average Rating: {{restaurant.restaurant.user_rating.aggregate_rating}}</p> -->
        <p
          class="rating"
          v-if="
            restaurant.restaurant.user_rating.aggregate_rating > 0 &&
            restaurant.restaurant.user_rating.aggregate_rating <= 1.5
          "
        >
          ⭐
        </p>
        <p
          class="rating"
          v-if="
            restaurant.restaurant.user_rating.aggregate_rating > 1.5 &&
            restaurant.restaurant.user_rating.aggregate_rating <= 2.5
          "
        >
          ⭐⭐
        </p>
        <p
          class="rating"
          v-if="
            restaurant.restaurant.user_rating.aggregate_rating > 2.5 &&
            restaurant.restaurant.user_rating.aggregate_rating <= 3.5
          "
        >
          ⭐⭐⭐
        </p>
        <p
          class="rating"
          v-if="
            restaurant.restaurant.user_rating.aggregate_rating > 3.5 &&
            restaurant.restaurant.user_rating.aggregate_rating <= 4.5
          "
        >
          ⭐⭐⭐⭐
        </p>
        <p
          class="rating"
          v-if="restaurant.restaurant.user_rating.aggregate_rating >= 4.6"
        >
          ⭐⭐⭐⭐⭐
        </p>

        <!-- <p class="price">Price: {{restaurant.restaurant.price_range}}</p> -->
        <p class="price" v-if="restaurant.restaurant.price_range === 1">$</p>
        <p class="price" v-else-if="restaurant.restaurant.price_range === 2">
          $$
        </p>
        <p class="price" v-else-if="restaurant.restaurant.price_range === 3">
          $$$
        </p>
        <p class="price" v-else-if="restaurant.restaurant.price_range === 4">
          $$$$
        </p>
        <p class="price" v-else>$$$$$</p>
      </div>
    </transition-group>
  </body>
</template>

<script>
import PreferencesService from "../services/PreferencesService";
//import preferenceService from '../services/PreferencesService';
import restService from "../services/RestServices";
export default {
  name: "matched-restaurants",
  data() {
    return {
      cuisine_ids: [],
      restaurants: [
        {
          restaurant: {
            id: "",
            name: "",
            featured_image: "",
            user_rating: {
              aggregate_rating: "",
            },
            price_range: "",
          },
        },
      ],
      index: 19,

      liked_restaurants: {
        restaurantId: "",
        restaurantName: "",
        userId: this.$store.state.user.id,
      },
    };
  },
  methods: {
    like: function () {
      this.liked_restaurants.restaurantId = this.restaurants[
        this.index
      ].restaurant.id;
      this.liked_restaurants.restaurantName = this.restaurants[
        this.index
      ].restaurant.name;
      this.restaurants.splice(this.index, 1);
      this.index = this.index - 1;
      PreferencesService.addFavorite(
        this.$store.state.user.id,
        this.liked_restaurants
      ).catch((error) => {
        if (error.status === 500) {
          alert(error.message);
        }
      });
    },
    dislike: function () {
      this.restaurants.splice(this.index, 1);
      this.index = this.index - 1;
    },

    saveFavorite() {
      PreferencesService.addFavorite(
        this.$store.state.user.user_id,
        this.liked_restaurants
      );
    },
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
.matchedBody {
  /* background: linear-gradient(180deg, #000000 0%, rgba(0, 0, 0, 0.49) 100%); */
  font-family: "Montserrat";
  font-weight: bold;
  color: white;
  grid-template-columns: 1fr;
  grid-template-areas:
    "etj-round-sixers"
    "fav-nav"
    "featured-image"
    "rest-name"
    "rating"
    "price"
    "dislike-btn"
    "like-btn";
}

#etj-round-sixers {
  grid-area: etj-round-sixers;
  display: flex;
  background: none;
  box-shadow: none;
}

#fav-nav {
  grid-area: fav-nav;
  background-color: #006bb6;
  border-radius: 20px;
  font-size: 16px;
  font-weight: bold;
  color: #ffffff;
  padding: 5px 10px 5px 10px;
  text-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  text-decoration: none;
  width: 7em;
  text-align: center;
  display: flex;
}

.matches_list-enter-active,
.matches_list-leave-active {
  transition: all 1s;
}
.matches_list-enter,
.matches_list-leave-to {
  opacity: 0;
  transform: translateY(30px);
}

.featured-image {
  grid-area: featured-image;
  width: 75%;
}

.dislike-btn {
  grid-area: dislike-btn;
  font-size: 60px;
  background: none;
  border: none;
  cursor: pointer;
}

.like-btn {
  grid-area: like-btn;
  font-size: 60px;
  background: none;
  border: none;
  cursor: pointer;
}

.rest-name {
  grid-area: rest-name;
  color: white;
  font-weight: bold;
  font-size: 16px;
  background-color: #ed174c;
  border-radius: 20px;
  width: auto;
  height: auto;
  padding-top: 8px;
  padding-bottom: 8px;
  text-align: center;
}

.rating {
  grid-area: rating;
  color: white;
  font-weight: bold;
  font-size: 20px;
  background-color: #ed174c;
  border-radius: 20px;
  width: auto;
  height: auto;
  padding: 2px;
  padding-bottom: 6px;
  text-align: center;
}

.price {
  grid-area: price;
  color: white;
  font-weight: bold;
  font-size: 20px;
  background-color: #ed174c;
  border-radius: 20px;
  width: auto;
  height: auto;
  padding: 2px;
  padding-top: 4px;
  padding-bottom: 6px;
  text-align: center;
}
</style>