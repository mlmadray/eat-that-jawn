<template>
  <body>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <div id="app">
      <div id="nav">
        <router-link id="home-nav" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;
        <router-link id="logout-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
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
  text-align: center;
  padding: 5px 10px 5px 10px;
  text-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  text-decoration: none;
  display: flex;
  width: 50px;
}

#logout-nav {
  padding-right: 10px;
  
}

#home-nav:hover, #logout-nav:hover {
  background-color: #ed147c;
  border: #006bb6 solid 5px;
}

/********************* DESKTOP *********************/
@media (min-width: 1024px) {

  #home-nav,
  #logout-nav {
    font-size: 20px;
    width: 80px;
    padding-left: 25px;

  }
}
</style>
