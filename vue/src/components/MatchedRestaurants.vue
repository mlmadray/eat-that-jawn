<template>
  <body class="matchedBody">
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <transition-group name="matches_list" tag="p">
      <div v-if="index < 0" v-bind="getMoreRestaurants()"></div>

      <div
        class="matchesDetails"
        v-for="restaurant in restaurants"
        v-bind:key="restaurant.restaurant.id"
        v-show="restaurant === restaurants[index]"
        v-else
      >
        <p class="rest-name">{{ restaurant.restaurant.name }}</p>
        <img
          class="featured-image-matched"
          v-if="restaurant.restaurant.featured_image != ''"
          v-bind:src="restaurant.restaurant.featured_image"
        />
        <img class="featured-image-alt" v-else src="img/Gritty.png" />
        <div class="decisions">
          <button class="like-btn" v-on:click="like">💙</button>
          <button class="dislike-btn" v-on:click="dislike">👎</button>
        </div>

        <p
          class="rating"
          v-if="
            restaurant.restaurant.user_rating.aggregate_rating >= 0 &&
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
    <footer id="etj-round-sixers">
      <img
        class="etj-round-sixers"
        src="../assets/img/etj-round-sixers.png"
        alt="Eat That Jawn?"
      />
    </footer>
  </body>
</template>

<script>
import PreferencesService from "../services/PreferencesService";
import restService from "../services/RestServices";

export default {
  name: "matched-restaurants",
  data() {
    return {
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
            location: {
              locality: "",
            },
          },
        },
      ],
      index: 19,
      start_count: 0,
      liked_restaurants: {
        featuredImage: "",
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
      this.liked_restaurants.featuredImage = this.restaurants[
        this.index
      ].restaurant.featured_image;
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

    getMoreRestaurants() {
      this.start_count = this.start_count + 20;
      this.index = 19;
      restService
        .getMoreRestaurants(
          this.$store.state.Answers.neighborhood,
          this.$store.state.Answers.cuisine,
          this.$store.state.Answers.category,
          this.start_count
        )
        .then((response) => {
          this.restaurants = response.data.restaurants;
        });
    },
  },
  created() {
    restService
      .getRestaurants(
        this.$store.state.Answers.neighborhood,
        this.$store.state.Answers.cuisine,
        this.$store.state.Answers.category
      )
      .then((response) => {
        this.restaurants = response.data.restaurants;
      });
  },
};
</script>

<style>
.matches_list-enter-active,
.matches_list-leave-active {
  transition: all 1s;
}
.matches_list-enter,
.matches_list-leave-to {
  opacity: 0;
  transform: translateY(30px);
}

.matchedBody {
  margin-top: 80px;
  font-family: "Montserrat";
  font-weight: bold;
  color: white;
  grid-template-columns: 1fr;
  grid-template-areas:
    "navs"
    "rest-name"
    "featured-image-matched"
    "featured-image-alt"
    "decisions"
    "rating"
    "price"
    "etj-round-sixers";
}

.matchesDetails {
  background: rgb(237, 23, 76);
  background: radial-gradient(
    circle,
    rgba(237, 23, 76, 1) 0%,
    rgba(237, 23, 76, 0.6222864145658263) 81%
  );
  padding: 10px;
  border-radius: 10px;
  width: 90%;
  margin-left: auto;
  margin-right: auto;
}

.featured-image-matched {
  grid-area: featured-image-matched;
  width: 95%;
  height: 95%;
  border-radius: 15px;
  border: white ridge 6px;
  margin-left: auto;
  margin-right: auto;
  display: flex;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

.featured-image-alt {
  grid-area: featured-image-alt;
  margin-left: auto;
  margin-right: auto;
  display: flex;
  width: 95%;
  height: 95%;
  border-radius: 15px;
  border: white ridge 6px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

.decisions {
  grid-area: decisions;
  display: flex;
  flex-direction: row-reverse;
  justify-content: space-between;
  margin-bottom: 10px;
}
.dislike-btn {
  font-size: 40px;
  background: none;
  border: none;
  cursor: pointer;
  text-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  background-color: #002B5C;
  border: none;
  border-radius: 100%;
  box-shadow: 0 8px #C4CED4;
}

.dislike-btn:hover {
  background-color: #006bb6;
}

.dislike-btn:active {
  background-color: #006bb6;
  box-shadow: 0 5px #C4CED4;
  transform: translateY(4px);
}

.like-btn {
  font-size: 40px;
  background: none;
  border: none;
  cursor: pointer;
  text-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  background-color: #002B5C;
  border: none;
  border-radius: 100%;
  box-shadow: 0 8px #C4CED4;
}

.like-btn:hover {
  background-color: #006bb6;
}

.like-btn:active {
  background-color: #006bb6;
  box-shadow: 0 5px #C4CED4;
  transform: translateY(4px);
}

.rest-name {
  grid-area: rest-name;
  color: white;
  font-weight: bold;
  font-size: 24px;
  background-color: #ed174c;
  border-radius: 20px;
  width: auto;
  height: auto;
  padding-top: 8px;
  padding-bottom: 8px;
  text-align: center;
  margin-right: auto;
  margin-left: auto;
  text-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
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
  margin-right: auto;
  margin-left: auto;
  text-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
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
  margin-right: auto;
  margin-left: auto;
  text-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

footer img {
  grid-area: etj-round-sixers;
  text-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  margin-right: auto;
  margin-left: auto;
  margin-top: 40px;
  margin-bottom: 0;
  background: none;
  width: 100px;
  height: 100px;
  display: flex;
}

/********************* TABLET *********************/
@media (min-width: 768px) {
  .dislike-btn,
  .like-btn {
    font-size: 60px;
    margin-top: 10px;
    margin-bottom: 10px;
  }

  .rest-name,
  .rating,
  .price {
    width: auto;
    max-width: 600px;
    font-size: 36px;
    margin-top: 0px;
  }

  footer img {
    width: 150px;
    height: 150px;
    margin-top: 0px;
  }
}

/********************* DESKTOP *********************/
@media (min-width: 1024px) {
  .matchesDetails {
    width: 40%;
  }
  .featured-image-matched {
    width: 80%;
    max-width: 1200px;
    height: 80%;
    max-height: 800px;
  }

  .featured-image-alt {
    width: 60%;
    max-width: 1200px;
    height: 60%;
    max-height: 800px;
  }

  .decisions {
    justify-content: space-around;
  }

  .rest-name {
    max-width: 600px;
    font-size: 40px;
  }

  .rating {
    width: auto;
    height: 35px;
    max-width: 600px;
    font-size: 24px;
  }

  .price {
    width: auto;
    height: 30px;
    max-width: 600px;
    font-size: 24px;
    padding-top: 8px;
    padding-bottom: 8px;
  }
}
</style>