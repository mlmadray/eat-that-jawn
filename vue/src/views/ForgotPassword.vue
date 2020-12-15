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
    <div id="register" class="text-center">
      <h1 class="sign-up">Forgot Password</h1>
      <form class="form-register" @submit.prevent="newPassword">
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
          placeholder="New Password"
          v-model="user.password"
          required
        />
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm New Password"
          v-model="user.confirmPassword"
          required
        />
        <button
          class="btn btn-lg btn-primary btn-block"
          id="create-account-btn"
          type="submit"
        >
          Reset Password
        </button>
        <router-link :to="{ name: 'login' }" id="registered"
          >Back to Login</router-link
        >
      </form>
    </div>
  </body>
</template>

<script>
import authService from "../services/AuthService";

//**************Added user_id*****************

export default {
  name: "forgot-password",
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
      registrationErrorMsg: "There were problems resetting your password.",
    };
  },
  methods: {
    newPassword() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .resetPassword(this.user)
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
      this.registrationErrorMsg = "There were problems resetting your password.";
    },
  },
};
</script>

<style>
body {
  font-family: "Montserrat";
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
    "etj-round-and-text"
    "sign-up"
    "username"
    "password"
    "confirm-password"
    "create-account-btn"
    "registered";
}

.sign-up {
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
  grid-area: sign-up;
  margin: auto;
  margin-bottom: 20px;
  padding-top: 10px;
  box-shadow: 0px 20px 20px rgba(0, 0, 0, 0.25);
}

#confirmPassword {
  grid-area: confirm-password;
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
  font-weight: bold;
}

#create-account-btn {
  grid-area: create-account-btn;
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

#create-account-btn:hover {
  background-color: #ed147c;
  border: #006bb6 solid 5px;
}

#registered {
  grid-area: registered;
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

}

#registered:hover {
  border: #006bb6 solid 5px;
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

  .sign-up {
    width: 250px;
    font-size: 24px;
    padding-bottom: 8px;
  }

  #username,
  #password,
  #confirmPassword {
    width: 350px;
    height: 45px;
    font-size: 16px;
  }

  #create-account-btn {
    width: 300px;
    height: 45px;
    font-size: 18px;
  }

  #registered {
    width: 200px;
    font-size: 16px;
    padding-top: 3px;
    padding-bottom: 3px;
  }
}
</style>
