<template>
  <body>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <header>
      <img
        id="etj-round-and-text"
        src="../assets/img/etj-round-and-text.png"
        alt="Eat That Jawn?"
      />
      <img
        id="ETJ-76ers"
        src="../assets/img/ETJ-76ers-blue-white.png"
        alt="Eat That Jawn?"
      />
    </header>
    <div id="login" class="text-center">
      <h1 class="welcome">Welcome</h1>
      <form class="form-signin" @submit.prevent="login">
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
        </div>
        <label for="username" class="sr-only"></label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <div>
          <label for="password" class="sr-only"></label>
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
        </div>
        <div>
          <button type="submit" id="login-btn">Login</button>
        </div>
        <div>
          <router-link :to="{ name: 'register' }" id="forgot-pass"
            >Forgot password?</router-link
          >
        </div>
        <div>
          <router-link :to="{ name: 'register' }" id="sign-up"
            >Don't have an account? Sign Up</router-link
          >
        </div>
      </form>
    </div>
  </body>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/questionnaire");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style>
body {
  background-image: url("~@/assets/img/philly-map.png");
  background-position: center top;
  background-attachment: fixed;
  font-family: "Montserrat";
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
    "etj-round-and-text"
    "welcome"
    "username"
    "password"
    "login-btn"
    "forgot-pass"
    "sign-up";
  gap: 15px;
}

header {
  background: rgb(1, 1, 1);
  background: radial-gradient(
    circle,
    rgba(1, 1, 1, 1) 0%,
    rgba(0, 0, 0, 0.8603816526610644) 59%
  );
  border-radius: 20px;
  margin-bottom: 10px;
  margin-top: 60px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

#etj-round-and-text {
  grid-area: etj-round-and-text;
  width: 85%;
  display: block;
  margin: auto;
  padding-top: 40px;
  padding-bottom: 30px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

#ETJ-76ers {
  display: none;
}

.welcome {
  background: black;
  width: 170px;
  height: 32px;
  left: 103px;
  top: 264px;
  border-radius: 10px;
  font-size: 18px;
  font-weight: bold;
  color: #ffffff;
  text-align: center;
  grid-area: welcome;
  margin: auto;
  margin-bottom: 20px;
  padding-top: 10px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

#username,
#password {
  width: 279px;
  height: 41px;
  left: 49px;
  top: 330px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  border: 0;
  border-radius: 20px;
  display: block;
  margin: auto;
  margin-bottom: 20px;
  background-color: #a5acaf;
  font-weight: bold;
}

#username {
  grid-area: username;
}

#password {
  grid-area: password;
}

input {
  padding-left: 15px;
  font-family: "Montserrat";
}

::placeholder {
  color: black;
  font-family: "Montserrat";
  font-weight: bolder;
}

#login-btn {
  grid-area: login-btn;
  width: 279px;
  height: 41px;
  left: 49px;
  top: 462px;
  background: #09ae37;
  color: #ffffff;
  font-weight: bold;
  font-family: "Montserrat";
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border: 0;
  border-radius: 20px;
  display: block;
  margin: auto;
  margin-bottom: 15px;
  cursor: pointer;
}

#login-btn:hover {
  background-color: black;
  border: #09ae37 solid 5px;
}

#forgot-pass {
  grid-area: forgot-pass;
  background: #ffffff;
  text-shadow: 0px 4px 0px 0px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  text-align: center;
  border-radius: 15px;
  width: 144px;
  text-decoration: none;
  color: #000000;
  font-weight: bold;
  font-size: 14px;
  line-height: 17px;
  display: block;
  margin: auto;
  margin-bottom: 10px;
}

#sign-up {
  grid-area: sign-up;
  background: #ffffff;
  text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  text-align: center;
  border-radius: 15px;
  width: 249px;
  text-decoration: none;
  color: #000000;
  font-weight: bold;
  font-size: 14px;
  display: block;
  margin: auto;
}

/********************* TABLET *********************/
@media (min-width: 768px) {
  header {
    width: 75%;
    display: block;
    margin: auto;
    margin-top: 80px;
    margin-bottom: 80px;
  }
}

/********************* DESKTOP *********************/
@media (min-width: 1024px) {
  body {
    background-image: url("~@/assets/img/Philly-Downtown.jpg");
    background-position: center;
  }

  header {
    width: 75%;
    display: block;
    margin: auto;
    margin-top: 80px;
    margin-bottom: 80px;
    background: none;
    background-color: #ed174c;
  }

  #etj-round-and-text {
    display: none;
  }

  #ETJ-76ers {
    display: block;
    width: 85%;
    display: block;
    margin: auto;
    padding-top: 40px;
    padding-bottom: 40px;
  }

  .welcome {
    background-color: #006bb6;
  }

  #username,
  #password {
    background-color: white;
  }

  #login-btn {
    background-color: #ed174c;
  }

  #login-btn:hover {
    background-color: #006bb6;
    border: #ed174c solid 5px;
  }
}
</style>
