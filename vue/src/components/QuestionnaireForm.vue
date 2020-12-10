<!-- TODO Form for user information --> 
<template>
  <body>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <header>
      <img
        id="etj-round-and-text"
        src="../assets/img/etj-round-and-text.png"
        alt="Eat That Jawn?"
      />
      <img
        id="ETJ-76ers"
        src="../assets/img/ETJ-76ers-blue-white.png"
        alt="Eat That Jawn?"
      />
    </header>
    <form class="questionnaireForm" v-on:submit.prevent="saveForm">
      <div id="questionnaire" class="text-center">
        <h1 class="filter-results">Filter Results Below</h1>
        <select id="statusFilter" v-model="Questionnaire.neighborhood">
          <option value="" disabled selected>Neighborhood</option>
          <option
            v-for="neighborhood in neighborhoods"
            v-bind:key="neighborhood.localitySubzoneId"
            v-bind:value="neighborhood.localitySubzoneId"
          >
            {{ neighborhood.localitySubzoneName }}
          </option>
        </select>

        <select id="statusFilter" v-model="Questionnaire.cuisine">
          <option value="" disabled selected>Cuisine</option>
          <option
            v-for="cuisine in cuisines"
            v-bind:key="cuisine.zomatoCuisineId"
            v-bind:value="cuisine.zomatoCuisineId"
          >
            {{ cuisine.cuisineType }}
          </option>
        </select>

        <select id="statusFilter" v-model="Questionnaire.category">
          <option value="" disabled selected>Category</option>
          <option
            v-for="category in categories"
            v-bind:key="category.zomatoCategoryId"
            v-bind:value="category.zomatoCategoryId"
          >
            {{ category.categoryName }}
          </option>
        </select>
        <!-- <select id="statusFilter" v-model="Questionnaire.serviceOption">
          <option value="" disabled selected>Service Options</option>
          <option
            v-for="service_option in serviceOptions"
            v-bind:key="service_option.zomatoCategoryId"
            v-bind:value="neighborhood.zomatoCategoryId"
          >
            {{ service_option.categoryName }}
          </option>
        </select> -->
        <div>
          <button type="submit" id="submit-btn">Submit</button>
        </div>
      </div>
    </form>
  </body>
</template>

<script>
import preferenceService from "../services/PreferencesService";
export default {
  name: "questionnaire-form",
  data() {
    return {
      cuisines: [],
      neighborhoods: [],
      categories: [],
      // serviceOptions: [],
      Questionnaire: {
        neighborhood: "",
        cuisine: "",
        category: "",
        // serviceOption: "",
      },
    };
  },
  methods: {
    saveForm() {
      this.$store.commit("SET_ANSWER", this.Questionnaire);
      this.$router.push("/");
    },
  },
  computed: {
    neighborhoodId() {
      return this.neighorhood.localitySubzoneId;
    },
  },
  created() {
    preferenceService.getAllCuisine().then((response) => {
      this.cuisines = response.data;
    }),
      preferenceService.getAllNeighborhoods().then((response) => {
        this.neighborhoods = response.data;
      }),
      preferenceService.getAllCategories().then((response) => {
        this.categories = response.data;
      });
    // preferenceService.getAllServiceOptions().then((response) => {
    //   this.serviceOptions = response.data;
    // });
  },
};
</script>

<style>
body {
  font-family: "Montserrat";
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
    "etj-round-and-text"
    "welcome"
    "neighborhood"
    "cuisine"
    "category"
    "service-options"
    "submit-btn";
  gap: 15px;
}

#etj-round-and-text {
  grid-area: etj-round-and-text;
  width: 85%;
  display: block;
  margin: auto;
  padding-top: 40px;
  padding-bottom: 30px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

#ETJ-76ers {
  display: none;
}

.filter-results {
  background: black;
  width: 270px;
  height: 32px;
  left: 103px;
  top: 264px;
  border-radius: 10px;
  font-size: 18px;
  font-weight: bold;
  color: #ffffff;
  text-align: center;
  grid-area: welcome;
  margin: auto;
  margin-bottom: 20px;
  padding-top: 10px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

#neighborhood {
  grid-area: neighborhood;
}

#cuisine {
  grid-area: cuisine;
}

#category {
  grid-area: category;
}

#neighborhood,
#cuisine,
#category {
  width: 279px;
  height: 41px;
  left: 49px;
  top: 330px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  border: 0;
  border-radius: 20px;
  display: block;
  margin: auto;
  margin-bottom: 20px;
  background-color: #a5acaf;
  font-weight: bold;
}

#submit-btn {
  grid-area: submit-btn;
  width: 279px;
  height: 41px;
  left: 49px;
  top: 462px;
  background: #09ae37;
  color: #ffffff;
  font-weight: bold;
  font-family: "Montserrat";
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border: 0;
  border-radius: 20px;
  display: block;
  margin: auto;
  margin-bottom: 15px;
  cursor: pointer;
}

#submit-btn:hover {
  background-color: black;
  border: #09ae37 solid 5px;
}

#statusFilter {
  width: 279px;
  height: 41px;
  left: 49px;
  top: 330px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  border: 0;
  border-radius: 20px;
  display: block;
  margin: auto;
  margin-bottom: 20px;
  background-color: #a5acaf;
  font-family: "Montserrat";
  font-weight: bold;
  padding: 10px;
}

/********************* TABLET *********************/
@media (min-width: 768px) {
  header {
    width: 75%;
    display: block;
    margin: auto;
    margin-top: 80px;
    margin-bottom: 80px;
  }
}

/********************* DESKTOP *********************/
@media (min-width: 1024px) {
  header {
    width: 75%;
    display: block;
    margin: auto;
    margin-top: 80px;
    margin-bottom: 80px;
    background: none;
    background-color: #ed174c;
  }

  #etj-round-and-text {
    display: none;
  }

  #ETJ-76ers {
    display: block;
    width: 85%;
    display: block;
    margin: auto;
    padding-top: 40px;
    padding-bottom: 40px;
  }

  .filter-results {
    background-color: #006bb6;
  }

  #neighborhood,
  #cuisine,
  #category {
    background-color: white;
  }

  #statusFilter {
    background-color: white;
  }

  #submit-btn {
    background-color: #ed174c;
  }

  #submit-btn:hover {
    background-color: #006bb6;
    border: #ed174c solid 5px;
  }
}
</style>