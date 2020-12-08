<!-- TODO Form for user information --> 
<template>
<div class = "questionnaire">
    <div class = "cuisine" v-for="cuisine in cuisines" v-bind:key="cuisine.cuisine_id">
        <input type="checkbox" id="cuisine" v-bind:vaule="cuisine.name"/>
        {{cuisine.name}}
    </div>
</div>
</template>

<script>
import restService from '../services/RestServices'

export default {
    name: 'questionnaire-form',
    props: ["cuisine_type"],
    data(){
        return{
        cuisines:[],
        
        };
    },
    computed: {
        
    },
    created(){
        restService.getCuisines().then(response =>{
            this.cuisines = response.data;
            //this.isLoading = false;
        })
    }
}
</script>

<style>

</style>