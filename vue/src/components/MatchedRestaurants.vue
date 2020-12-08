<!-- TODO: filter restuarants based off matching preferences-->
<template>
  <div>
      <ul class="restaurant" v-for="restaurant in restaurants" v-bind:key="restaurant.name">
          <li>{{restaurant.name}}</li>
      </ul>
  </div>
</template>

<script>
import preferenceService from '../services/PreferencesService';
import restService from '../services/RestServices';
export default {
    cuisine_ids: [],
    restaurants: [],
    props: ["cuisine_type"],
    methods: {

  },
  created(){
    preferenceService.getCuisineID(this.$store.cuisine_type).then( response =>{
        this.cuisine_ids = response.data;
    });
    restService.getRestByCuisineId(this.cuisine_ids).then(response =>{
        this.restaurants = response.data;
    })
  }
}
</script>

<style>

</style>