<template>
    <div class="displayusers">
    
        <table border="1">
            <thead>
                <tr>
                <th>Name</th>
                <th>Surname</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="user in users" :key="user.id" >
                <td>{{ user.name }}</td>
                <td>{{ user.surname }}</td>
                </tr>
            </tbody>
        </table>
  
    </div>
    </template>
  <script>

import axios from "axios";

  export default {
    name: 'DisplayUsers',
    data(){
    return{ 
      users:[]
    };
  },
    methods: {
        async getUsers() {
        try {
            const response = await axios.get("http://localhost:8081/api/users");
            this.users = response.data;
        } catch (error) {
            console.error("Error fetching users:", error);
            alert("Failed to load users.");
        }
        }
  },
    mounted(){
        this.getUsers();
    }
  }
  </script>
  
  <style scoped>
  .displayusers {
    min-height: 100vh;
    padding: 2rem;
    background: linear-gradient(to right, #f0f4f8, #ffffff);
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  </style>
  