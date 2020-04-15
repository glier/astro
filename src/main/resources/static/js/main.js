import Vue from 'vue'
import vuetify from './plugin/vuetify'
import VeeValidate from 'vee-validate';
import '@babel/polyfill'
import 'api/resource'
import router from 'router/router'
import App from 'pages/App.vue'
import store from './store'
import {connect} from './util/ws'

//Vue.config.productionTip = false;
Vue.use(VeeValidate);

if (frontendData.profile) {
    connect()
}


new Vue({
    el:'#app',
    store,
    router,
    vuetify,
    render: a=>a(App)
})