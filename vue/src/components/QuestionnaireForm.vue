
<template>
  <body>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <header class="quest-header">
      <img
        id="header-image"
        src="../assets/img/ETJ-76ers-blue-white.png"
        alt="Eat That Jawn?"
      />
    </header>
    <form class="questionnaireForm" v-on:submit.prevent="saveForm">
      <div id="questionnaire" class="text-center">
        <h1 class="filter-results">Filter Results Below</h1>
        <select id="statusFilter" v-model="Questionnaire.neighborhood" required>
          <option value="" disabled selected>Neighborhood</option>
          <option
            v-for="neighborhood in neighborhoods"
            v-bind:key="neighborhood.localitySubzoneId"
            v-bind:value="neighborhood.localitySubzoneId"
            min=""
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
      Questionnaire: {
        neighborhood: "",
        cuisine: "",
        category: "",
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
  },
};
</script>

<style>
body {
  font-family: "Montserrat";
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
    "navs"
    "etj-round-and-text"
    "filter-results"
    "neighborhood"
    "cuisine"
    "category"
    "submit-btn";  
}

.filter-results {
  grid-area: filter-results;
  background-color: #006bb6;
  width: 270px;
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
  font-weight: bold;
}

#submit-btn {
  grid-area: submit-btn;
  width: 279px;
  height: 41px;
  left: 49px;
  top: 462px;
  background-color: #ed174c;
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
  background-color: #ed147c;
  border: #006bb6 solid 5px;
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
  font-family: "Montserrat";
  font-weight: bold;
  padding: 10px;
}


/********************* TABLET *********************/
@media (min-width: 768px) {
  body {
    background-position: 49% 70%;
  }

  .quest-header {
    margin-top: 200px;
  }
}

/********************* DESKTOP *********************/
@media (min-width: 1024px) {

  .quest-header {
  margin-top: 200px;
  }

  .filter-results {
    width: 250px;
    font-size: 24px;
    padding-bottom: 8px;
  }

  #neighborhood,
  #cuisine,
  #category {
    width: 350px;
    height: 45px;
    font-size: 16px;
  }

  #submit-btn {
    width: 300px;
    height: 45px;
    font-size: 18px;
  }
}
</style>