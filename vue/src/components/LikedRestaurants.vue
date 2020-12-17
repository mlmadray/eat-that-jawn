
<template>
  <body>
    <div class="matches">
      <div class="favorites-block">
        <h1 class="favorites">Favorites</h1>
      </div>
      <div v-for="restaurant in favorites" v-bind:key="restaurant.restaurantId">
        <router-link
          class="restaurant-fav-title"
          v-bind:to="{
            name: 'restaurant',
            params: { id: restaurant.restaurantId },
          }"
        >
          <div class="rest-box">
            <p>{{ restaurant.restaurantName }}</p>
            <img
              class="feature-img"
              v-if="restaurant.featuredImage != ''"
              v-bind:src="restaurant.featuredImage"
            />
            <img class="featured-image-alt" v-else src="img/Gritty.png" />
          </div>
        </router-link>
        <div class="button-block">
          <button type="delete" id="delete" v-on:click="remove(restaurant)">
            Remove Favorite
          </button>
          <button
            type="add"
            id="addVisit"
            v-if="restaurant.wasVisited == false"
            v-on:click="updateFavorite(restaurant)"
          >
            Haven't Been Here
          </button>
          <button
            type="add"
            id="addVisit"
            v-else
            v-on:click="updateFavorite(restaurant)"
          >
            I've Been Here
          </button>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
import preferenceService from "../services/PreferencesService";

export default {
  name: "liked-restaurants",
  components: {},
  data() {
    return {
      favorites: [],
      visited: {
        restaurantId: "",
        restaurantName: "",
        userId: this.$store.state.user.id,
      },
    };
  },
  methods: {
    updateFavorite(restaurant) {
      this.visited.restaurantId = restaurant.restaurantId;
      this.visited.name = restaurant.name;
      preferenceService.updateFavorite(this.$store.state.user.id, this.visited);
    },

    remove(restaurant) {
      preferenceService.deleteFavorite(this.$store.state.user.id, restaurant);
    },
  },
  created() {
    preferenceService
      .getFavorites(this.$store.state.user.id)
      .then((response) => {
        this.favorites = response.data;
      });
  },
  updated() {
    preferenceService
      .getFavorites(this.$store.state.user.id)
      .then((response) => {
        this.favorites = response.data;
      });
  },
};
</script>

<style>
body {
  margin-top: 0;
  margin-left: 0;
  margin-right: 0;
}
.matches {
  border-radius: 10px;
  width: 90%;
  margin-left: auto;
  margin-right: auto;
  margin-top: 80px;
  padding-bottom: 10px;
  padding-top: 1px;
  margin-bottom: 10px;
  grid-template-columns: 1fr;
  grid-template-areas:
    "navs"
    "favorites"
    "restaurant-fav-title"
    "feature-img"
    "addVisit"
    "delete";
}

.favorites {
  grid-area: favorites;
  background-color: #ed174c;
  width: 170px;
  height: 32px;
  left: 103px;
  top: 264px;
  border-radius: 10px;
  font-size: 18px;
  font-weight: bold;
  color: #ffffff;
  text-align: center;
  margin: auto;
  margin-bottom: 20px;
  margin-top: 20px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

.favorites-block {
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
  margin-left: auto;
  margin-right: auto;
}

.feature-img {
  grid-area: feature-img;
  display: flex;
  width: 70%;
  height: 70%;
  margin-left: auto;
  margin-right: auto;
  border-radius: 10px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  border: white solid 5px;
}

.feature-img-alt {
  display: flex;
  width: 60%;
  height: 60%;
  margin-left: auto;
  margin-right: auto;
  border-radius: 10px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  border: white solid 5px;
}

.restaurant-fav-title {
  grid-area: restaurant-fav-title;
  text-decoration: none;
  color: white;
  font-size: 30px;
  font-weight: bold;
  width: 50%;
  margin-left: auto;
  margin-right: auto;
  text-align: center;
  text-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

.rest-box {
  border-radius: 10px;
  padding-bottom: 15px;
  background: rgb(237, 23, 76);
  background: radial-gradient(
    circle,
    rgba(237, 23, 76, 1) 0%,
    rgba(237, 23, 76, 0.6222864145658263) 81%
  );
}

.feature-img:hover {
  filter: blur(2px);
}

.restaurant-fav-title:hover {
  color: #bb9754;
}

#addVisit {
  grid-area: addVisit;
}

#delete {
  grid-area: delete;
}

#addVisit,
#delete {
  width: 279px;
  height: 41px;
  left: 49px;
  top: 462px;
  background-color: #006bb6;
  color: #ffffff;
  font-weight: bold;
  font-family: "Montserrat";
  box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.25);
  text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border: 0;
  border-radius: 20px;
  display: block;
  margin: auto;
  margin-bottom: 15px;
  margin-top: 10px;
  cursor: pointer;
}

#delete:hover {
  color: #bb9754;
}

#addVisit:hover {
  color: #bb9754;
}

/********************* TABLET *********************/
@media (min-width: 768px) {

.button-block {
  display: flex;
}
}

/********************* DESKTOP *********************/
@media (min-width: 1024px) {
  .favorites {
    width: 40%;
    height: auto;
    font-size: 32px;
  }

  .favorites-block {
    width: 50%;
  }

  .matches {
    width: 70%;
    padding-bottom: 20px;
    margin-bottom: 20px;
  }

  .feature-img {
    width: 60%;
    height: 60%;
  }

  .restaurant {
    font-size: 30px;
  }
}
</style>