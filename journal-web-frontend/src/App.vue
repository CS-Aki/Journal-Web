<script setup>

import SignInModal from './components/SignInModal.vue'
import SignUpModal from './components/SignUpModal.vue'

import { ref } from 'vue'

const showRegisterModal = ref(false);
const showLoginModal = ref(false);


  // import SignUpModal from '@/components/SignUpModal.vue'
  // import SignInModal from './components/SignInModal.vue';
  
  // export default{
  //   components: {
  //     SignUpModal,
  //     SignInModal
  //   },
  //   data(){
  //     return{
  //       showModal: false,
  //     }
  //   }
  // }

</script>

<template>

    <header id="index-header">
      <a href="#">
        <div id="header-logo">
          <!-- Will change this to image later on -->
          <h1>The Journey</h1> 
        </div> 
       </a>
      <div class="nav-header-btn">
        <button id="contacts-btn">Contacts</button>
        <button id="about-btn">About Us</button>
        <button  id="signup-btn" type="button" @click="showRegisterModal = true">Sign Up</button>
        <button class="" id="login-btn" type="button" @click="showLoginModal = true">Log In</button>
      </div>
    </header>

    <Teleport to="body">
      <SignInModal :show="showLoginModal" @close="showLoginModal = false">
        <template #header>
          <h3>Login</h3>
        </template>
      </SignInModal>
    </Teleport>

    <Teleport to="body">
      <SignUpModal :show="showRegisterModal" @close="showRegisterModal = false">
        <template #header>
          <h3>Registration</h3>
        </template>
      </SignUpModal>
    </Teleport>

    <!-- <SignUpModal :visible="showModal" @update:visible="showModal = $event" />
    <SignInModal :visible="showModal" @update:visible="showModal = $event"/> -->
</template>


