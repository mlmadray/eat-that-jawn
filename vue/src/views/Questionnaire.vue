<!-- show questionnaire form --> 
<template>
    <div>
        <input type="checkbox" id="cuisine" v-bind:checked="this.$store.cuisine_type = cuisine.name">
        <router-link v-bind:to="{ name: 'cuisine_type', params: { cuisine_type } }">{{ }}</router-link>
    </div>
</template>

<script>
export default {
  data() {
    return {
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
    };
  },
  props: ["cuisine_type"]
};
</script>

<style>
</style>