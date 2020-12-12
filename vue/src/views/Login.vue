<template>
  <body>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <header>
      <img
        id="header-image"
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
  background-image: url("~@/assets/img/Philly-Downtown.jpg");
  background-position: 49% 58%;
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
  background-color: #ed174c;
  border-radius: 20px;
  margin-bottom: 40px;
  margin-top: 80px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

#header-image {
  grid-area: etj-round-and-text;
  width: 85%;
  display: block;
  margin: auto;
  padding-top: 40px;
  padding-bottom: 30px;
}

.welcome {
  background-color: #006bb6;
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
  background-color: #ed174c;
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
  background-color: #ed147c;
  border: #006bb6 solid 5px;
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

#forgot-pass:hover {
  border: black solid 5px;
}

.alert {
  width: 400px;
  height: 30px;
  left: 49px;
  top: 462px;
  background-color: #ed174c;
  color: #ffffff;
  font-weight: bold;
  font-family: "Montserrat";
  text-align: center;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
  text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 10px;
  display: block;
  margin: auto;
  margin-bottom: 15px;
  cursor: pointer;
  padding-top: 10px;
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

#sign-up:hover {
  border: black solid 5px;
}

/********************* TABLET *********************/
@media (min-width: 768px) {
  body {
    background-position: 49% 70%;
  }

  header {
    width: 75%;
    display: block;
    margin: auto;
    margin-top: 180px;
    margin-bottom: 80px;
  }
}

/********************* DESKTOP *********************/
@media (min-width: 1024px) {
  header {
    width: 50%;
  }

  #header-image {
    display: block;
    margin: auto;
    padding-top: 40px;
    padding-bottom: 40px;
  }

  .welcome {
    width: 250px;
    font-size: 24px;
    padding-bottom: 8px;
  }

  #username,
  #password {
    width: 350px;
    height: 45px;
    font-size: 16px;
  }

  #login-btn {
    width: 300px;
    height: 45px;
    font-size: 18px;
  }

  #forgot-pass {
    width: 180px;
    font-size: 16px;
    padding-top: 3px;
    padding-bottom: 3px;
  }

  #sign-up {
    width: 300px;
    font-size: 16px;
    padding-top: 3px;
    padding-bottom: 3px;
  }
}
</style>
