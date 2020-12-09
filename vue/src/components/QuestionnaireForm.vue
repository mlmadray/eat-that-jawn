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
    </header>
    <div id="questionnaire" class="text-center">
      <h1 class="welcome">FILTER RESULTS</h1>
      <select id="statusFilter">
        <option>Neighborhood</option>
        <option
          v-for="neighborhood in neighorhoods"
          v-bind:key="neighborhood.locality_subzone_id"
        >
          {{ neighborhood.locality_subzone_name }}
        </option>
      </select>

      <select id="statusFilter">
        <option>Cuisine</option>
        <option
          v-for="cuisine in cuisines"
          v-bind:key="cuisine.zomatoCuisineId"
        >
          {{ cuisine.cuisineType }}
        </option>
      </select>

      <select id="statusFilter">
        <option>Category</option>
        <option
          v-for="category in categories"
          v-bind:key="category.zomatoCategoryId"
        >
          {{ category.categoryName }}
        </option>
      </select>
      <select id="statusFilter">
        <option>Service Options</option>
        <option
          v-for="service_option in serviceOptions"
          v-bind:key="service_option.zomatoCategoryId"
        >
          {{ service_option.categoryName }}
        </option>
      </select>
      <div>
        <button type="submit" id="submit-btn">Submit</button>
      </div>
    </div>
  </body>
</template>

<script>
import preferenceService from "../services/PreferencesService";
export default {
  name: "questionnaire-form",
  props: ["cuisine_type"],
  data() {
    return {
      cuisines: [],
      neighborhoods: [],
      categories: [],
      serviceOptions: [],
      Answers: {
        neighborhood: "",
        cuisine: "",
        category: "",
        service_option: "",
      },
    };
  },
  methods: {
    saveCuisine() {},
  },
  computed: {},
  created() {
    preferenceService.getAllCuisine().then((response) => {
      this.cuisines = response.data;
    }),
      preferenceService.getAllNeighborhoods().then((response) => {
        this.neighorhood = response.data;
      }),
      preferenceService.getAllCategories().then((response) => {
        this.category = response.data;
      }),
      preferenceService.getAllServiceOptions().then((response) => {
        this.service_option = response.data;
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
  padding-bottom: 40px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

.welcome {
  background: #09ae37;
  width: 170px;
  height: 32px;
  left: 103px;
  top: 264px;
  border-radius: 20px;
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
}

#cuisine {
  grid-area: cuisine;
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
}

#category {
  grid-area: category;
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
}

#service-options {
  grid-area: service-options;
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
  }
}
</style>