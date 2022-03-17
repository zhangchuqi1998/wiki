import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import * as Icons from '@ant-design/icons-vue';
import axios from 'axios';

axios.defaults.baseURL = process.env.VUE_APP_SERVER;

/**
 * axios拦截器
 */
axios.interceptors.request.use(function (config) {
    console.log('parameter：', config);
    return config;
}, error => {
    return Promise.reject(error);
});
axios.interceptors.response.use(function (response) {
    console.log('return value：', response);
    return response;
}, error => {
    console.log('return false：', error);
    return Promise.reject(error);
});


const app = createApp(App);
app.use(store).use(router).use(Antd).mount('#app');


const icons: any = Icons;
for (const i in icons) {
    app.component(i, icons[i]);
}

console.log('environment：', process.env.NODE_ENV);
console.log('server：', process.env.VUE_APP_SERVER);