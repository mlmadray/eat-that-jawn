<template>
  <body>
    <link rel='icon' href="<%= BASE_URL %>favicon.ico">
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <div id="app">
      <router-view />
    </div>
  </body>
</template>

<style>

.navs {
  grid-area: navs;
  display: flex;
  justify-content: space-evenly;  
  text-align: center;
  position: fixed;
  width: 100%;
  background-color: #006bb6;
}

#home-nav,
#logout-nav,
#fav-nav,
#quest-nav {
  background-color: #006bb6;
  /* border-radius: 20px; */
  font-size: 14px;
  font-weight: bold;
  color: #ffffff;
  /* padding: 5px 10px 5px 10px; */
  /* padding-left: 100%;
  padding-right: 100%; */
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 20px;
  padding-bottom: 20px;
  /* margin-left: 0;
  margin-right: 0;
  margin-top: 0;
  margin-bottom: 0; */
  width: auto;
  text-shadow: 0px 10px 10px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.25);
  text-decoration: none;
}

#logout-nav {
  /* padding-bottom: 10px; */
}

#app {
  margin-top: 0;
}

#home-nav:hover, 
#logout-nav:hover,
#fav-nav:hover,
#quest-nav:hover {
  background-color: #006bb6;
  border: #ed147c solid 5px;
}

/********************* TABLET *********************/
@media (min-width: 768px) {
  
}

/********************* DESKTOP *********************/
@media (min-width: 1024px) {

  #home-nav,
  #logout-nav,
  #fav-nav,
  #quest-nav {
    font-size: 20px;
  }
}
</style>
