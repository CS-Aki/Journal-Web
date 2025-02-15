<script setup>

import { ref, onMounted } from 'vue';

  const name = ref("Kang Haerin");
  const address = ref("South Korea");
  const age = ref(18);
  const status = ref("inactive");
  const isReg = ref("not registered");
  const notes = ref(["First Entry", "Second Entry", "Third Entry"]);
  const toReg = ref(false);

  const regName = ref("");
  const regAddress = ref("");
  const regAge = ref("");
  const users = ref([]);
  const regSuccess = ref(false);

  const login = () => {
    console.log("Login Clicked");
    name.value = "Kang Haerin";
    address.value = "South Korea";
    status.value ="active";
    isReg.value = "registered";
  };

  const logOut = () => {
    console.log("Log out Clicked");
    status.value = "inactive";
    isReg.value = "guest";
  };

  const toRegister = () => {
    toReg.value = true;
  }

  const backToLogin = () => {
    toReg.value = false;
  }

  const registerUser = () => {
      if(regName.value.trim() !== "" && regAddress.value.trim() !== "" && regAge.value.trim() !== "" && Number(regAge.value) >= 10){
        users.value.push({
          name: regName.value.trim(),
          address : regAddress.value.trim(),
          age : Number(regAge.value)
        });

        regName.value = "";
        regAddress.value = "";
        regAge.value = "";

        regSuccess.value = true;
        console.log(users);
      }
  };

  const removeNote = (index) => {
      notes.value.splice(index, 1);
  } 

  onMounted(async () => {
    try{
       const response = await fetch("https://jsonplaceholder.typicode.com/todos");
       const data = await response.json();
       notes.value.push(...data.map((note) => note.title));
    }catch(error){
      console.log("Error " + error)
    }
  });

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
      <li v-for="(note, index) in notes" :key="note">
        <span>
          {{ note }}
        </span>
        <button @click="removeNote(index)">X</button>
      </li>
    </ul>
  </div>

  <div v-if="toReg">
    <form @submit.prevent="registerUser">
      <label for="">Enter name</label>
      <input type="text" v-model="regName"><br>
      <label for="">Enter Address</label>
      <input type="text" v-model="regAddress"><br>
      <label for="">Enter Age</label>
      <input type="text" v-model="regAge"><br>
      <button type="submit">Register</button> 
    </form>

    <div v-if="regSuccess">
       <br>
       <h3>New User</h3>
       <p v-for="user in users" :key="user">
        {{ user.name }} <br>
        {{ user.address }} <br>
        {{ user.age }}
      </p>
    </div>

    <button @click="backToLogin">Back</button>
  </div>

  <div v-else>
    <button @click="login" v-if="status === 'inactive'">Login User</button> <br>
    <button @click="toRegister" v-if="status === 'inactive'">Register New User</button> <br>
    <button @click="logOut" v-if="status === 'active'">Log-out User : {{ name }}</button>
  </div>

</template>


