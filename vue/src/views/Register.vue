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
    </header>
    <div id="register" class="text-center">
      <form class="form-register" @submit.prevent="register">
        <h1 class="signUp">SIGN UP</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
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
        <label for="password" class="sr-only"></label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm Password"
          v-model="user.confirmPassword"
          required
        />
        <button
          class="btn btn-lg btn-primary btn-block"
          id="create-account"
          type="submit"
        >
          Create Account
        </button>
        <router-link :to="{ name: 'login' }" id="registered"
          >Already registered?</router-link
        >
      </form>
    </div>
  </body>
</template>

<script>
import authService from "../services/AuthService";

//**************Added user_id*****************

export default {
  name: "register",
  data() {
    return {
      user: {
        user_id: "",
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style>
body {
  font-family: "Montserrat";
}

header {
  background: rgb(1,1,1);
  background: radial-gradient(circle, rgba(1,1,1,1) 0%, rgba(0,0,0,0.8603816526610644) 59%);
  border-radius: 20px;
  margin-bottom: 50px;
  margin-top: 80px;
}

.signUp {
  background: #09ae37;
  width: 170px;
  height: 43px;
  left: 103px;
  top: 264px;
  border-radius: 20px;
  font-size: 24px;
  font-weight: bold;
  color: #ffffff;
  text-align: center;
  grid-area: welcome;
  margin: auto;
  margin-bottom: 20px;
  padding-top: 10px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}

#confirmPassword {
  grid-area: password;
  width: 279px;
  height: 41px;
  left: 49px;
  top: 330px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  display: block;
  margin: auto;
  margin-bottom: 20px;
}

#create-account {
  grid-area: login-btn;
  width: 279px;
  height: 41px;
  left: 49px;
  top: 462px;
  background: #09ae37;
  color: #ffffff;
  font-weight: bold;
  font-family: "Montserrat";
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  display: block;
  margin: auto;
  margin-bottom: 15px;
}

#registered {
  background: #ffffff;
  text-shadow: 0px 4px 0px 0px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  text-align: center;
  border-radius: 15px;
  width: 160px;
  text-decoration: none;
  color: #000000;
  font-weight: bold;
  font-size: 14px;
  line-height: 17px;
  display: block;
  margin: auto;
  margin-bottom: 10px;
}
</style>
