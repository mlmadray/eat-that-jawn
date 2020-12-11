<template>
  <div class = "details">
        <h3 class="restaurant" >{{details.name }}</h3>
        <p class="image">{{details.featured_image}}</p>
        <p class="rating">Average Rating: {{details.user_rating.aggregate_rating}}</p>
        <p class="rating-text">Average Rating: {{details.user_rating.rating_text}}</p>
        <p class="rating-votes">Average Rating: {{details.user_rating.votes}}</p>
        <p class="price">Price: {{details.price_range}}</p>
         <p class="website">Website: {{details.url}}</p>
         <p class="address">address: {{details.location.address}}</p>
         <p class="phone">phone_number: {{details.phone_numbers}}</p>
         <p class="cuisine">{{details.cuisines}}</p>
  </div>

</template>

<script>
import LikedRestaurants from "../components/LikedRestaurants";
export default {
    name: "restaurant-details",
    components:{
        LikedRestaurants
    },
    data(){
        return{
           
        };
    },
    props: {
        details: Object
    },
   computed: {
       
   },
    methods: {

    },
    
}
</script>

<style>

</style>