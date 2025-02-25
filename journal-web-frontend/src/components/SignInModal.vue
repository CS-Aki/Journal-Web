<script setup>
import axios from "axios";
import { ref, defineEmits } from 'vue'

const username = ref("");
const password = ref("");

const emit = defineEmits(['close']);

const props = defineProps({
  show: Boolean
});

const loginUser = async () => {
    try {
      const response = await axios.post("http://localhost:8080/api/v1/user/login", { 
           username: username.value,
            password: password.value
      },
      {
          headers: {
              "Content-Type": "application/json"
          }
      }
          );
      console.log(response.data);
    } catch (error) {
      console.error("Error:", error);
    }
};

const loginModalRef = ref(null);

const closeForm = () => {
    username.value = "";
    password.value = "";
    emit('close');
};

</script>

<template>
  <Transition name="modal">
    <div v-if="show" class="modal-mask">
      <div class="modal-container" >
        <div class="modal-header">
          <slot name="header"></slot>
        </div>
        <form @submit.prevent="loginUser" ref="loginModalRef">
            <div class="modal-body">
            <slot name="body">
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
            </slot>
            </div>

            <div class="modal-footer">
            <slot name="footer">
                <button type="submit" class="btn btn-primary">Login</button>
            </slot>
            <button type="button" class="btn btn-primary" @click="closeForm">Close</button>
            </div>
       </form>
      </div>
    </div>
  </Transition>
</template>

<style>
.modal-mask {
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

.modal-container {
  opacity: 1;
  width: 80%; /* Increase width */
  max-width: 400px; /* Set a reasonable max width */
  min-width: 200px; /* Ensure it doesn't get too small */
  margin: auto;
  padding: 30px;
  background-color: rgb(239, 250, 247) !important;
  border-radius: 8px; /* Optional: smoother corners */
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.4);
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