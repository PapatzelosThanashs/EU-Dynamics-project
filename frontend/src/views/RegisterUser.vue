<template>
    <div class="registerForm">
    
    <h2>Register New User</h2>
    <form @submit.prevent="createUser">
      <!-- Name (Mandatory) -->
      <div>
        <label for="name">
          <span class="required-asterisk">*</span> Name:
        </label>
        <input type="text" id="name" v-model="newUser.name" required />
      </div>

      <!-- Surname (Mandatory) -->
      <div>
        <label for="surname">
          <span class="required-asterisk">*</span> Surname:
        </label>
        <input type="text" id="surname" v-model="newUser.surname" required />
      </div>

      <!-- Gender (Mandatory) -->
      <div>
        <label for="gender">
          <span class="required-asterisk">*</span> Gender:
        </label>
        <select id="gender" v-model="newUser.gender" required>
          <option value="">Select Gender</option>
          <option value="M">Male</option>
          <option value="F">Female</option>
        </select>
      </div>

      <!-- Birthdate (Mandatory) -->
      <div>
        <label for="birthdate">
          <span class="required-asterisk">*</span> Birthdate:
        </label>
        <input type="date" id="birthdate" v-model="newUser.birthdate" required />
      </div>

      <!-- Work Address (Non-Mandatory) -->
      <div>
        <label for="workAddress">Work Address:</label>
        <textarea id="workAddress" v-model="newUser.address.workAddress"></textarea>
      </div>

      <!-- Home Address (Non-Mandatory) -->
      <div>
        <label for="homeAddress">Home Address:</label>
        <textarea id="homeAddress" v-model="newUser.address.homeAddress"></textarea>
      </div>

      <!-- Submit Button -->
      <div>
        <button type="submit">Register</button>
      </div>
    </form>
  </div>
    </template>
  <script>
  import axios from "axios";

  export default {
    name: 'RegisterUser',
      data() {
        return {
          users: [],  // Users list
          newUser: {  // New user data
          name: '',
          surname: '',
          gender: '',
          birthdate: '',
          address: {
              workAddress: '',
              homeAddress: ''
            }
          }, formStatus: null,
        };
    },
      methods: {
      async createUser() {
        try {
          // Send POST request to the backend to create the new user
          const response = await axios.post("http://localhost:8081/api/users", this.newUser);

          // Add the newly created user to the list locally
          this.users.push(response.data);

          // Reset the form fields
          this.newUser.name = '';
          this.newUser.surname = '';
          this.newUser.gender ='',
          this.newUser.birthdate ='',
          this.newUser.address.workAddress ="",
          this.newUser.address.homeAddress = "", 
            
          

          alert("User created successfully!");
        } catch (error) {
          console.error("Error creating user:", error);
          alert("Failed to create user.");
        }
      },
    }
  }
  </script>
  
  <style scoped>
  .registerForm{
    min-height: 100vh;
    padding: 2rem;
    background: rgb(255, 247, 237);
    display: flex;
    flex-direction: column;
    align-items: center;
  }

form {
  width: 300px;
  margin: auto;
}
label {
  display: block;
  margin-bottom: 5px;
}
input, select, textarea {
  width: 100%;
  margin-bottom: 10px;
  padding: 8px;
  font-size: 14px;
}
textarea {
  height: 100px;
}
button {
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: none;
  font-size: 16px;
  cursor: pointer;
}
button:hover {
  background-color: #0056b3;
}
span {
  font-size: 12px;
  color: red;
}
.required-asterisk {
  color: red;
  margin-left: 4px;
}

</style>

  