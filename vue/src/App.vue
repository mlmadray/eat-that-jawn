<template>
  <body>
    <link rel='icon' href="<%= BASE_URL %>favicon.ico">
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <div id="app">
      <div id="nav">
        <!-- <router-link id="home-nav" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp; -->
        <!-- <router-link id="logout-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
      </div>
      <router-view />
    </div>
  </body>
</template>

<style>
#home-nav,
#logout-nav {
  background-color: #006bb6;
  border-radius: 20px;
  font-size: 16px;
  font-weight: bold;
  color: #ffffff;
  padding: 5px 10px 5px 10px;
  text-shadow: 0px 10px 10px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.25);
  text-decoration: none;
  width: 3em;
}

#logout-nav {
  width: 4em;
  box-shadow: 0px 6px 6px rgba(0, 0, 0, 0.25);

}

#home-nav:hover, 
#logout-nav:hover {
  background-color: #006bb6;
  border: #ed147c solid 5px;
}

/********************* TABLET *********************/
@media (min-width: 768px) {
#logout-nav {
  margin-left: 0px;
}
}

/********************* DESKTOP *********************/
@media (min-width: 1024px) {

  #home-nav,
  #logout-nav {
    font-size: 20px;
    width: 80px;

  }
}
</style>
