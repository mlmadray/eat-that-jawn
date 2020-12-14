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
  padding: 5px 10px 5px 10px;
  width: 100%;
  text-shadow: 0px 10px 10px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.25);
  text-decoration: none;
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
