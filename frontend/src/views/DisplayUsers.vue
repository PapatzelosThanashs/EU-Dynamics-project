<template>
    <div class="displayusers">
    
        <table class="user-table">
            <thead>
                <tr>
                <th>NAME</th>
                <th>SURNAME</th>
                </tr>
            </thead>
            <tbody>
                <tr class="user-row" v-for="user in users" :key="user.id"  @click="userDetails(user.id)">
                <td>{{ user.name }}</td>
                <td>{{ user.surname }}</td>
                <td><button class="delete-button" @click.stop="deleteUser(user.id)">Delete User</button></td>
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
      data: null,
      intervalId: null,
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
        },
        async deleteUser(userId) {
      if (confirm("Are you sure you want to delete this user?")) {
        try {
          await axios.delete(`http://localhost:8081/api/users/${userId}`);
          this.users = this.users.filter(user => user.id !== userId);
          alert("User successfully deleted");
        } catch (error) {
          console.error("Error deleting user:", error);
          alert("Delete failed.");
        }
      }
    },
      async userDetails(userId){
        window.open(`/user/${userId}`, "_blank");

    },
    async fetchData() {
      try {
        const response = await axios.get('http://localhost:8081/api/users')
       this.users =  response.data;
      } catch (e) {
        console.error('Polling failed:', e)
      }
    }
  },
    mounted(){
        this.getUsers();
        this.fetchData()
        this.intervalId = setInterval(this.fetchData, 5000)
    },
    beforeUnmount() {
      clearInterval(this.intervalId)
    }
  }
  </script>
  
  <style scoped>
  .displayusers {
    min-height: 100vh;
    padding: 2rem;
    background: rgb(255, 247, 237);
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .user-table {
  width: 100%;
  border-collapse: collapse;
  border: 1px solid #ffffff;
  font-family: Arial, sans-serif;
}

.user-table th,
.user-table td {
  padding: 12px 15px;
  border: 1px solid #0f0101;
  text-align: left;
}

.user-table thead {
  background-color: #464545;
  color: white;
}

.user-row {
  cursor: pointer;
  transition: background-color 0.2s ease;
}

.user-row:hover {
  background-color: #e69e63;
}

.delete-button {
  background-color: #c2574c;
  color: white;
  border: none;
  padding: 6px 12px;
  border-radius: 4px;
  font-size: 14px;
  cursor: pointer;
}

.delete-button:hover {
  background-color: #e6331f;
}


  </style>
  