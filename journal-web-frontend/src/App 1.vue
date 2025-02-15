<script>
  export default {
    data(){
      return{
        name: "Kang Haerin",
        age: 18,
        address : "South Korea",
        isReg : "guest",
        status : "inactive",
        notes : ["First Entry", "Second Entry", "Third Entry"],
        toReg : false
      }
    },
    
    methods: {
      login(){
        console.log("Login Clicked");
        this.name = "Kang Haerin";
        this.address = "South Korea";
        this.status = "active";
        this.isReg = "registered";
      },

      logOut(){
        console.log("Logout Clicked");
        this.status = "inactive";
        this.isReg = "guest";
      },

      toRegister(){
          this.toReg = true;
      },

      backToLogin(){
        this.toReg = false;
      }

    }
  };
</script>

<template>
  <h1 v-if="isReg === 'registered'" >Welcome {{ name }}</h1>
  <h1 v-else>Welcome Guest</h1>

  <h2 v-if="status === 'active'">Status: Online</h2>
  <!-- <h2 v-else="status === 'inactive'">Status: Offline</h2> -->

  <div v-if="status === 'active'">
    <p>Your name is {{ name }}</p>
    <p>Your age is {{ age }}</p>
    <p>Your address is {{ address }}</p>
  </div>

  <div v-if="status === 'active'">
    <h3>List of Notes:</h3>
    <ul>
      <li v-for="note in notes" :key="note">{{ note }}</li>
    </ul>
  </div>

  <div v-if="toReg">
    <label for="">Enter name</label>
    <input type="text"><br>
    <label for="">Enter Address</label>
    <input type="text"><br>
    <label for="">Enter Age</label>
    <input type="text"><br>
    <button @click="registerUser">Register</button>
    <button @click="backToLogin">Back</button>
  </div>
  <div v-else>
    <button @click="login" v-if="status === 'inactive'">Login User</button> <br>
    <button @click="toRegister" v-if="status === 'inactive'">Register New User</button> <br>
    <button @click="logOut" v-if="status === 'active'">Log-out User : {{ name }}</button>
  </div>

</template>


