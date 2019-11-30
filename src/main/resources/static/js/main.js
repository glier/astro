import Vue from 'vue'
import vuetify from './plugin/vuetify'
import '@babel/polyfill'
import 'api/resource'
import router from 'router/router'
import App from 'pages/App.vue'
import store from 'store/store'
import {connect} from './util/ws'


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