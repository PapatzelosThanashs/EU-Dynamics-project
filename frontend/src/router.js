import { createRouter, createWebHistory } from 'vue-router'
import HomePage from './views/HomePage.vue'
import DisplayUsers  from './views/DisplayUsers.vue'
import RegisterUser  from './views/RegisterUser.vue'
import NotFound from './views/NotFound.vue'

const routes = [
  { path: '/', component: HomePage },
  { path: '/users', component: DisplayUsers },
  { path: '/register', component: RegisterUser},
  { path: '/:pathMatch(.*)*', component: NotFound},
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router
