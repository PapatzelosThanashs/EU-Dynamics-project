<!-- src/components/UserDetail.vue -->

<template>
  <div>
    
    <div class="userdetail" v-if="user">

      <table  class="user-table" >
            <th colspan="2">
                User Details
            </th>
            <tr>
                <td><strong>Name</strong> </td>
                <td>{{ user.name }}</td>
            </tr>
            <tr>
                <td><strong>Surname</strong></td>
                <td>{{ user.surname }}</td>
            </tr>
            <tr>
                <td><strong>Gender</strong></td>
                <td>{{ user.gender }}</td>
            </tr>
            <tr>
                <td><strong>Birthdate</strong> </td>
                <td>{{ user.birthdate }}</td>
            </tr>
            <tr>
                <td><strong>Work Address</strong></td>
                <td>{{ user.address.workAddress }}</td>
            </tr>
            <tr>
                <td><strong>Home Address</strong></td>
                <td>{{ user.address.homeAddress }}</td>
            </tr>
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
      users: [],
      user: null,
    };
  },
  async mounted() {
    const userId = this.$route.params.id;
    try {
      const response = await axios.get(`http://localhost:8081/api/users/${userId}`);
      this.user = response.data;
    } catch (error) {
      console.error("Failed to fetch user:", error);
      alert("User not found or error occurred.");
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
    margin: 100px auto;
}

</style>
