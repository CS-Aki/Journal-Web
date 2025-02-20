<script setup>

import { ref, defineEmits } from 'vue'

const props = defineProps({
  show: Boolean
});

const emit = defineEmits(['close']);

const firstName = ref("");
const lastName = ref("");
const username = ref("");
const password = ref("");
const gender = ref("");
const birthdate = ref("");

const registerUser = () => {
  console.log("Registering user...");

  //   Might move this to a different function and use regex instead
  if(firstName.value.trim() === "" || lastName.value.trim() === "" || username.value.trim() === "" || password.value.trim() === "" || gender.value === "" || birthdate.value === ""){
    console.log("Invalid input")
  }

  console.log(firstName.value);
  console.log(lastName.value);
  console.log(username.value);
  console.log(password.value);
  console.log(gender.value);
  console.log(birthdate.value);
};

const signUpRef = ref(null);

const closeForm = () => {
  console.log("closing");
  firstName.value = "";
  lastName.value = "";
  username.value = "";
  password.value = "";
  gender.value = "";
  birthdate.value = "";

  // signUpRef.value.reset();
  emit('close');
};


</script>

<template>
  <Transition name="modal">
    <div v-if="show" class="modal-mask1">
      <div class="modal-container1">
        <div class="modal-header">
          <slot name="header">Registration</slot>
        </div>
        <form @submit.prevent="registerUser" ref="signUpRef">
          <div class="modal-body">
            <slot name="body">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="first-name-sizing-default">First Name</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Default" aria-describedby="firstName-sizing-default" v-model="firstName">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="last-name-sizing-default">Last Name</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Default" aria-describedby="last-name-sizing-default" v-model="lastName">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="username-sizing-default">Username</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Default" aria-describedby="username-sizing-default" v-model="username">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="password-sizing-default">Password</span>
                    </div>
                    <input type="password" class="form-control" aria-label="Default" aria-describedby="password-sizing-default" v-model="password">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="genderSelect">Gender</label>
                    </div>
                    <select class="custom-select" id="genderSelect" v-model="gender">
                        <option value=""></option>
                        <option value="2">Male</option>
                        <option value="3">Female</option>
                        <option value="3">Prefer not to say</option>
                    </select>
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="birthdate-sizing-default">Birthdate</span>
                    </div>
                    <input type="date" class="form-control" aria-label="Default" aria-describedby="birthdate-sizing-default" v-model="birthdate">
                </div>
            </slot>
          </div>

          <div class="modal-footer">
            <slot name="footer">
              <button type="submit" class="btn btn-primary">Register</button>
              <button type="button" class="btn btn-primary" @click="closeForm" aria-label="Close">Close</button>
            </slot>
          </div>
        </form>
      </div>
    </div>
  </Transition>
</template>

<style>
.modal-mask1 {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  transition: opacity 0.3s ease;
}

.modal-container1 {
  width: 80%; /* Increase width */
  max-width: 600px; /* Set a reasonable max width */
  min-width: 300px; 
  margin: auto;
  padding: 20px 30px;
  background-color: rgb(239, 250, 247) !important;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
}

/* .modal-header h3 {
  margin-top: 0;
  color: #42b983;
} */

/* .modal-body {
  margin: 20px 0;
}

.modal-default-button {
  float: right;
} */

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

.modal-enter-from {
  opacity: 0;
}

.modal-leave-to {
  opacity: 0;
}

.modal-enter-from .modal-container,
.modal-leave-to .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
</style>