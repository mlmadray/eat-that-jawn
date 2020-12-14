<!-- TODO: filter list of matches based of status of liked -->
<template>
  <body>  
  <div class ="matches">
    <div class="favorites-block">
    <h1 class="favorites">Favorites</h1>
    </div>
    <div      
      v-for="restaurant in details"
      v-bind:key="restaurant.id"

    >
      <router-link class="restaurant"
        v-bind:to="{ name: 'restaurant', params: { id: restaurant.id } }"
              v-bind:value="setRestaurant(restaurant.id)"
      ><div class="rest-box">
        <p>{{ restaurant.name }}</p>
        <img
          class="feature-img"
          v-if="restaurant.featured_image != ''"
          v-bind:src="restaurant.featured_image"
        />
        <img class="feature-img-alt" v-else src="../assets/img/sorry-no-image.png" />
      </div>
      </router-link>
    </div>
  </div>
  </body>
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

body {
  margin-top: 0;
  margin-left: 0;
  margin-right: 0;
}
.matches {
  /* background: rgb(237,23,76);
  background: radial-gradient(circle, rgba(237,23,76,1) 0%, rgba(237,23,76,0.6222864145658263) 81%); */
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
    "restaurant"
    "feature-img"
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
  padding-top: 10px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

.favorites-block {
  background: rgb(237,23,76);
  background: radial-gradient(circle, rgba(237,23,76,1) 0%, rgba(237,23,76,0.6222864145658263) 81%);
  border-radius: 10px;
  height: 50px;
  padding-top: 5px;
  padding-bottom: 40px;
  margin-bottom: auto;
  margin-top: 20px;
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
  width: 50%;
  height: 50%;
  margin-left: auto;
  margin-right: auto;  
  padding-bottom: 10px;
}

.restaurant {
  grid-area: restaurant;
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
  background: rgb(237,23,76);
  background: radial-gradient(circle, rgba(237,23,76,1) 0%, rgba(237,23,76,0.6222864145658263) 81%);
}

.feature-img:hover {
  filter: blur(2px);
}

.restaurant:hover {
  text-decoration: underline;
}

/********************* DESKTOP *********************/
@media (min-width: 1024px) {
  
  .favorites {
    width: 200px;
    height: 40px;
    font-size: 24px;
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