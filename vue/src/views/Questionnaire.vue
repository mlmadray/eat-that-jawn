<!-- show questionnaire form --> 
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
      <form class="form-question" @submit.prevent="questionnaire">
        <h1 class="welcome">FILTER RESULTS</h1>
        <div>
        <label for="neighborhood" class="sr-only"></label>
        <input
          type="text"
          id="neighborhood"
          class="form-control"
          placeholder="Neighborhood"
        />
        </div>
        <!-- v-model="results.neighborhood" -->
        <div>
          <label for="cuisine" class="sr-only"></label>
          <input
            type="text"
            id="cuisine"
            class="form-control"
            placeholder="Cuisine"
          />
          <!-- v-model="results.cuisine" -->
        </div>
        <div>
          <label for="category" class="sr-only"></label>
          <input
            type="text"
            id="category"
            class="form-control"
            placeholder="Category"
          />
          <!-- v-model="results.category" -->
        </div>
        <div>
          <label for="service-options" class="sr-only"></label>
          <input
            type="text"
            id="service-options"
            class="form-control"
            placeholder="Service Options"
          />
          <!-- v-model="results.service_option" -->
        </div>
        <div>
          <button type="submit" id="submit-btn">Submit</button>
        </div>
      </form>
    </div>
    <div>
      <!-- <input type="checkbox" id="cuisine" v-bind:checked="this.$store.cuisine_type = cuisine.name">-->
      <!-- <router-link v-bind:to="{ name: 'cuisine_type', params: { cuisine_type } }">{{this.$ }}</router-link>-->
      <questionnaire-form />
    </div>
  </body>
</template>

<script>
import QuestionnaireForm from "../components/QuestionnaireForm.vue";
import restService from "../services/RestServices";

export default {
  components: { QuestionnaireForm },
  data() {
    return {
      /*
      cuisines: [
        {
          name: "BBQ",
        },
        {
          name: "Chinese",
        },
        {
          name: "Italian",
        },
      ],
      */
    };
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