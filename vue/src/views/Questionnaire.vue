<!-- show questionnaire form --> 
<template>
  
    <div>
      <router-link id="logout-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <questionnaire-form />
    </div>
  
</template>

<script>
import QuestionnaireForm from "../components/QuestionnaireForm.vue";


export default {
  components: { QuestionnaireForm },
  methods: {
    
  },
  data() {
    return {
     
    };
  },
};
</script>

<style>

</style>