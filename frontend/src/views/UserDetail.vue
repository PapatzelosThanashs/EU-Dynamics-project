<!-- src/components/UserDetail.vue -->

<template>
  <div>
    
    <div class="userdetail" v-if="user">

      <table  class="user-table" >
           <thead>
                <tr>
                <th colspan="2">User Details</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><strong>Name</strong> </td>
                    <td @click="editField('name')" v-if="!editing.name">{{ user.name }}</td>
                    <td v-else><input type="text" v-model="user.name" @blur="saveField('name')" /></td>
                </tr>
                <tr>
                    <td><strong>Surname</strong></td>
                    <td @click="editField('surname')" v-if="!editing.surname">{{ user.surname }}</td>
                    <td v-else><input type="text" v-model="user.surname" @blur="saveField('surname')" /></td>
                </tr>
                <tr>
                    <td><strong>Gender</strong></td>
                    <td @click="editField('gender')" v-if="!editing.gender">{{ user.gender }}</td>
                        <td v-else>
                        <select v-model="user.gender" @blur="saveField('gender')">
                            <option value="M">M</option>
                            <option value="F">F</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><strong>Birthdate</strong> </td>
                    <td @click="editField('birthdate')" v-if="!editing.birthdate">{{ user.birthdate }}</td>
                    <td v-else><input type="date" v-model="user.birthdate" @blur="saveField('birthdate')" /></td>
                    </tr>
                <tr>
                    <td><strong>Work Address</strong></td>
                    <td @click="editField('address.workAddress')" v-if="!editing['address.workAddress']">{{ user.address.workAddress }}</td>
                    <td v-else><input type="text" v-model="user.address.workAddress" @blur="saveField('address.workAddress')" /></td>
                </tr>
                <tr>
                    <td><strong>Home Address</strong></td>
                    <td @click="editField('address.homeAddress')" v-if="!editing['address.homeAddress']">{{ user.address.homeAddress }}</td>
                    <td v-else><input type="text" v-model="user.address.homeAddress" @blur="saveField('address.homeAddress')" /></td>
                </tr>
            </tbody>
        </table>

      
    </div>
    <div v-else>
      <p>User not found.</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "UserDetail",
  data() {
    return {
      user: null,
      editing: {
      name: false,
      surname: false,
      gender: false,
      version: false,
      birthdate: false,
      'address.workAddress': false,
      'address.homeAddress': false,
      }
    };
  },
  async mounted() {
    await this.loadUser();
  },
    methods: {
    // Set the field to editing mode
    editField(field) {
      this.editing[field] = true;  // Directly assign to the editing object
    },

    // Save the edited field and exit editing mode
    async saveField(field) {
      this.editing[field] = false;  // Exit editing mode for the specific field
      try {
        // Make PATCH request to backend API to update the user details
        await axios.patch(`http://localhost:8081/api/users/${this.user.id}`, this.user);
        await this.loadUser();  // Reload latest data from database
        alert("User updated successfully!");
      } catch (error) {
        console.error("Error updating user:", error);
        alert("Error occurred while updating the user.");
      }
    },
    async loadUser() {
      const userId = this.$route.params.id;
        try {
          const response = await axios.get(`http://localhost:8081/api/users/${userId}`);
          this.user = response.data;
        } catch (error) {
          console.error("Failed to fetch user:", error);
          alert("User not found or error occurred.");
        }
      }
    }
};

</script>

<style scoped>
h2 {
  text-align: center;
}
p {
  font-size: 1.1em;
}

.user-table {
  border-collapse: collapse;
  text-align: left;

}
.user-table th,
.user-table td {
  border: 2px solid #000000;
  padding: 8px;
}
.userdetail{
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 0px;
    
    min-height: 100vh;
    padding: 2rem;
    background: rgb(255, 247, 237);
   
}

</style>
