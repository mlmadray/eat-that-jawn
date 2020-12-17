<script>
export default {
  name: "modal",
  data() {
    return {
      isVisible: true,
    };
  },
  methods: {
    close() {
      this.isVisible = false;
    },
  },
};
</script>

<template>
  <div class="modal-backdrop" v-show="isVisible">
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Lobster&display=swap"
      rel="stylesheet"
    />
    <div class="modal">
      <header id="modal-header">
        <div>
          <img
            id="ETJ-sixers-stacked"
            src="../assets/img/ETJ-sixers-stacked.png"
          />
        </div>
        <h1 id="header-text">Philly Restaurant News!</h1>
      </header>
      <section class="modal-body">
        <a
          id="closure-link"
          href="https://philly.eater.com/2020/5/18/21262156/philadelphia-restaurants-bars-closed-permanently-coronavirus-covid-19"
          target="_blank"
        >
          <img
            class="boot-saddle"
            src="../assets/img/bootsaddle.webp"
            alt="Eater Philly: The Philly Restaurants That Closed During the Coronavirus Pandemic So Far"
          />
          Philly Restaurants Closed During the Coronavirus Pandemic So Far
        </a>
        <a
          id="heated-link"
          href="https://philly.eater.com/maps/20-philly-restaurants-heated-patios-winter"
          target="_blank"
        >
          <img
            class="heated-outdoor-dining"
            src="../assets/img/heated-outdoor-dining.jpg"
            alt="Eater Philly: 20 Philly Restaurants With Top-Notch Heated Patios for the Winter"
          />
          20 Philly Restaurants With Top-Notch Heated Patios for the Winter
        </a>
      </section>
      <footer class="modal-footer">
        <slot name="footer">
          <button type="button" class="close-btn" @click="close">
            Close 🥨
          </button>
        </slot>
      </footer>
    </div>
  </div>
</template>

<style>
div.modal-backdrop {
  overflow-y: scroll;
}

.modal-backdrop {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.7);
}

.modal {
  background: rgb(237,23,76);
  background: linear-gradient(90deg, rgba(237,23,76,0.8183648459383753) 100%, rgba(255,255,255,0.7035189075630253) 100%);
  box-shadow: 2px 2px 20px 1px;
  border-radius: 15px;
  width: 300px;
  height: 680px;
  margin-left: auto;
  margin-right: auto;
  padding-left: 10px;
  padding-right: 10px;
  grid-template-columns: 1fr;
  grid-template-areas:
    "ETJ-sixers-stacked"
    "header-text"
    "boot-saddle"
    "closure-link"
    "heated-outdoor-dining"
    "heated-link";
}

#ETJ-sixers-stacked {
  grid-area: ETJ-sixers-stacked;
  display: block;
}

#modal-header {
  grid-area: header-text;
  display: block;
  text-align: center;
  color: white;
  font-weight: bold;
  box-shadow: none;
  padding-top: 10px;
  text-shadow: 0px 5px 5px rgba(0, 0, 0, 0.25);
  background: none;
  margin-bottom: 0;
}

#header-text {
  font-family: 'Lobster';
  margin-top: 0;
}

.modal-body {
 margin-top: 0;
}
.boot-saddle {
  grid-area: boot-saddle;
  width: 210px;
  height: 140px;
  border-radius: 15px;
  display: block;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 5px;
  cursor: pointer;
  box-shadow: 0px 30px 30px rgba(0, 0, 0, 0.25);
}

.boot-saddle:hover {
  filter: blur(2px);
}

#closure-link {
  grid-area: closure-link;
  text-decoration: none;
  color: white;
  font-weight: bold;
  display: block;
  text-align: center;
  margin-bottom: 15px;
  cursor: pointer;
}

#closure-link:hover {
  color: #BB9754;
}

.heated-outdoor-dining {
  grid-area: heated-outdoor-dining;
  width: 210px;
  height: 150px;
  border-radius: 15px;
  display: block;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 5px;
  cursor: pointer;
  box-shadow: 0px 30px 30px rgba(0, 0, 0, 0.25);
}

.heated-outdoor-dining:hover {
  filter: blur(2px);
}

#heated-link {
  grid-area: heated-link;
  text-decoration: none;
  color: white;
  font-weight: bold;
  display: block;
  text-align: center;
  cursor: pointer;
}

#heated-link:hover {
  color: #BB9754;
}

.modal-footer {
  color: white;
  font-weight: bold;
  margin-top: 20px;
  margin-left: 209px;
  padding-bottom: 10px;
  cursor: pointer;
}

.close-btn {
  font-size: 18px;
  background: none;
  border: none;
  font-family: "Montserrat";
  font-weight: bold;
  color: white;
  text-shadow: 0px 5px 5px rgba(0, 0, 0, 0.25);
}

.close-btn:hover {
  color: #BB9754;
}

/********************* TABLET *********************/
@media (min-width: 768px) {
  .modal { 
    height: 710px;
    width: 600px;
    margin-left: auto;
    margin-right: auto;
    margin-top: auto;
    margin-bottom: auto;
  }

  #ETJ-sixers-stacked {
    margin-left: auto;
    margin-right: auto;
  }

  .boot-saddle {
    margin-left: 0;
    width: 310px;
    height: 205px;
  }

  #closure-link {
    display: flex;
    font-size: 30px;
  }

  .heated-outdoor-dining {
    margin-left: 0;
    width: 307px;
    height: 230px;
  }

  #heated-link {
    display: flex;
    font-size: 30px;
  }

  .close-btn {
    margin-left: 291px;
    font-size: 20px;
  }
}

/********************* DESKTOP *********************/
@media (min-width: 1024px) {

  .modal { 
    height: 812px;
    width: 900px;
    margin-left: auto;
    margin-right: auto;
    margin-top: auto;
    margin-bottom: auto;
  }

  #header-text {
    font-size: 40px;
  }

  .boot-saddle {
    width: 380px;
    height: 250px;
    margin-left: auto;
  }

  #closure-link {
    display: flex;
    font-size: 50px;
  }

  .heated-outdoor-dining {
    margin-left: 0;
    width: 380px;
    height: 270px;
    margin-left: auto;
    margin-right: auto;
  }

  #heated-link {
    display: flex;
    font-size: 50px;
  }

  .close-btn {
    margin-left: 591px;
  }
}
</style>