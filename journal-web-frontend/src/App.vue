
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
        <button  id="signup-btn" type="button" @click="showModal = true">Sign Up</button>
        <button class="" id="login-btn" type="button">Log In</button>
      </div>
    </header>

    <SignUpModal :visible="showModal" @update:visible="showModal = $event" />

</template>

<script>
  import SignUpModal from '@/components/SignUpModal.vue'

  export default{
    components: {
      SignUpModal,
    },
    data(){
      return{
        showModal: false,
      }
    }
  }
</script>