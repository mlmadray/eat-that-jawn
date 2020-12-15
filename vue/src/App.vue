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
  justify-content: space-between;  
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
  font-size: 18px;
  font-weight: bold;
  color: #ffffff;
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 20px;
  padding-bottom: 20px;
  width: auto;
  margin-top: auto;
  margin-bottom: auto;
  text-shadow: 0px 10px 10px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.25);
  text-decoration: none;
}

#app {
  margin-top: 0;
}

#home-nav:hover, 
#logout-nav:hover,
#fav-nav:hover,
#quest-nav:hover {
color: #BB9754;
}

/********************* TABLET *********************/
@media (min-width: 768px) {
  #home-nav,
  #logout-nav,
  #fav-nav,
  #quest-nav {
    font-size: 20px
  }
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
