<!-- show questionnaire form --> 
<template>
  
    <div>
      <promotion class="promo" v-show="isModalVisible" @click="closeModal" />
      <div class="navs">
        <router-link id="logout-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        <router-link id="fav-nav" v-bind:to="{ name: 'liked' }">Favorites</router-link>
      </div>
      <questionnaire-form />
    </div>
  
</template>

<script>
import QuestionnaireForm from "../components/QuestionnaireForm.vue";
import promotion from "../components/Promotion"

export default {
  components: { QuestionnaireForm, 
                  promotion},
  methods: {
    closeModal() {
      this.isModalVisible = false;
    }
  },
  data() {
    return {
     isModalVisible: true,
    };
  },
};
</script>

<style>
</style>