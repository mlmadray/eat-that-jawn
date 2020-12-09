import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'

Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

Vue.prototype.$http = axios;

new Vue({
  router,
  store,
  data: {
    restaurants: []
  },
  render: h => h(App),
  created() {
    var vm = this
    this.$http
      .get('https://developers.zomato.com/api/v2.1/search?entity_id=287&entity_type=city&apikey=565aaf5d257ecac2fb2db7425a942cc0')
      .then(function(response) {
        vm.restaurants = response.data
      })
  }
},).$mount('#app')

