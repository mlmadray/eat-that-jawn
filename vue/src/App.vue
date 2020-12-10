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
  background: #09ae37;
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

#home-nav:hover {
  background-color: black;
  border: #09ae37 solid 5px;
}

#logout-nav:hover {
  background-color: black;
  border: #09ae37 solid 5px;
}

/********************* DESKTOP *********************/
@media (min-width: 1024px) {
  #home-nav,
  #logout-nav {
    background-color: #006bb6;
  }

  #home-nav:hover {
    background-color: #006bb6;
    border: #ed174c solid 2px;
  }

  #logout-nav:hover {
    background-color: #006bb6;
    border: #ed174c solid 2px;
  }
}
</style>
