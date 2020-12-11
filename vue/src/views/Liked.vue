<!-- show only liked restaurants --> 
<template>
<div>
  <!-- <restaurant-details/> -->
  <liked-restaurants/>
</div>
</template>

<script>
import LikedRestaurants from '../components/LikedRestaurants.vue'
//import RestaurantDetails from '../components/RestaurantDetails.vue';
export default {
  components: { LikedRestaurants,
                //RestaurantDetails 
              },

}
</script>

<style>

</style>