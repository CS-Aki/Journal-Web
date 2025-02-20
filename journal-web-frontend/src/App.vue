 <script>
  export default{
    methods: {
      displayLoginModal(){
        this.$refs["login-modal"].show();
        console.log("Display Login");
      },
      hideLoginModal(){
        this.$refs["login-modal"].hide();
        console.log("Hide Login");
      }
    }
  }
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
        <button class="" id="signup-btn" type="button">Sign Up</button>
        <button class="" id="login-btn" type="button">Log In</button>
      </div>
    </header>

    <div>
      <b-button id="show-btn" @click="displayLoginModal">Open Modal</b-button>
      <b-button id="toggle-btn" @click="toggleModal">Toggle Modal</b-button>

      <b-modal ref="login-modal" hide-footer title="Using Component Methods">
        <div class="d-block text-center">
          <h3>Hello From My Modal!</h3>
        </div>
        <b-button class="mt-3" variant="outline-danger" block @click="hideLoginModal">Close Me</b-button>
      </b-modal>
    </div>
    

</template>