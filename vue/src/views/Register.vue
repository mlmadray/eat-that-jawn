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
    <div id="register" class="text-center">
      <h1 class="sign-up">Sign Up</h1>
      <form class="form-register" @submit.prevent="register">
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
          id="create-account-btn"
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

/* header {
  background: rgb(1, 1, 1);
  background: radial-gradient(
    circle,
    rgba(1, 1, 1, 1) 0%,
    rgba(0, 0, 0, 0.8603816526610644) 59%
  );
  border-radius: 20px;
  margin-bottom: 50px;
  margin-top: 80px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
} */

#ETJ-76ers {
  display: none;
}

.sign-up {
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

#confirmPassword {
  grid-area: password;
}

#username,
#password,
#confirmPassword {
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

#create-account-btn {
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

#create-account-btn:hover {
  background-color: black;
  border: #09ae37 solid 5px;
}

#registered {
  background: #ffffff;
  text-shadow: 0px 4px 0px 0px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
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

/********************* DESKTOP *********************/
@media (min-width: 1024px) {
  header {
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

  .sign-up {
    background-color: #006BB6;
  }

  #username,
  #password,
  #confirmPassword {
    background-color: white;
  }

  #create-account-btn {
    background-color: #ed174c;
  }

  #create-account-btn:hover {
    background-color: #006bb6;
    border: #ed174c solid 5px;
  }
}
</style>
