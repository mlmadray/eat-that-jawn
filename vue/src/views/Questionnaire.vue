<!-- show questionnaire form --> 
<template>
    <div>
       <!-- <input type="checkbox" id="cuisine" v-bind:checked="this.$store.cuisine_type = cuisine.name">-->
      <!-- <router-link v-bind:to="{ name: 'cuisine_type', params: { cuisine_type } }">{{this.$ }}</router-link>-->
       <questionnaire-form/>
    </div>
</template>

<script>
import QuestionnaireForm from '../components/QuestionnaireForm.vue';
import restService from '../services/RestServices';

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
</style>