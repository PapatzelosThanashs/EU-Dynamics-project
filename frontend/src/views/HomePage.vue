<template>
    <div class="homepage">
        <h1>Welcome to the Home Page</h1>
        <p>This is where you can put your main content or introduction.</p>
        <div class="menu">
        <router-link to="/users" class="menu-item">
          <h2>👥 Display Users</h2>
          <p>View a list of all registered users.</p>
        </router-link>
        <router-link to="/register" class="menu-item">
          <h2>📝 Register New User</h2>
          <p>Add a new user to the system with a simple form.</p>
        </router-link>
      </div>
    </div>
  </template>
  
  <script>

  
  export default {
    name: 'HomePage',

  }
  </script>
  
  <style scoped>
  

  .menu-item:hover {
  transform: translateY(-5px);
  background-color: #e8f5e9;
  box-shadow: 0 6px 18px rgba(0, 0, 0, 0.15);
}

  .menu {
  display: flex;
  justify-content: center;
  gap: 2rem;
  flex-wrap: wrap;
}

.menu-item {
  flex: 1 1 300px;
  text-decoration: none;
  color: inherit;
  background: #f7f9fc;
  border-radius: 12px;
  padding: 2rem;
  transition: all 0.3s ease;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.menu-item h2 {
  margin-bottom: 1rem;
  font-size: 1.5rem;
}

.menu-item p {
  color: #555;
}
  </style>
  