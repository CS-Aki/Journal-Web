<template>
    <!--Sign Up Modal -->
    <div v-if="isRendered" class="modal fade" :class="{ show: visible, 'd-block': visible }" id="signUpModal" tabindex="-1" role="dialog" aria-labelledby="signUpModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="signUpModalLabel">Sign Up</h5>
                <button type="button" class="close" @click="closeModal()" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form @submit.prevent="registerUser">
            <div class="modal-body">
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

            </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" @click="closeModal()">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </form>
            </div>
        </div>
    </div>
    
    <div v-if="isRendered" class="modal-backdrop fade" :class="{ show: visible }"></div>

</template>

<script setup>
import { ref, watch, nextTick, defineProps, defineEmits, onMounted } from 'vue';

const firstName = ref("");
const lastName = ref("");
const username = ref("");
const password = ref("");
const gender = ref("");
const birthdate = ref("");

// Props
const props = defineProps({
  visible: Boolean
});

// Emits
const emit = defineEmits(["update:visible"]);

// Local State
const isRendered = ref(false);

// Methods
const closeModal = () => {
  console.log("closing");
  emit("update:visible", false);
};

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

// Watcher for visibility changes
watch(() => props.visible, (newVal) => {
  console.log(newVal);
  if (newVal) {
    isRendered.value = true;
    nextTick(() => {
      document.body.classList.add("modal-open");
    });
  } else {
    document.body.classList.remove("modal-open");
    setTimeout(() => {
      isRendered.value = false;
    }, 300);
  }
});

// Mounted Hook
onMounted(() => {
  if (props.visible) isRendered.value = true;
});
</script>
