import Vue from 'vue';
import App from './App';
import router from './router';
import ElementUI from 'element-ui';
import VueResource from 'vue-resource'
import 'element-ui/lib/theme-default/index.css';    // 默认主题
import 'font-awesome/css/font-awesome.min.css'
// import '../static/css/theme-green/index.css';       // 浅绿色主题
import "babel-polyfill";
import axios from 'axios';
Vue.use(ElementUI);
Vue.use(VueResource);
Vue.filter('time', function (value) {
   // return new Date(parseInt(value)).toLocaleString();
   return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
})
Vue.filter('date', function (value) {
   // return new Date(parseInt(value)).toLocaleString();
   return new Date(value).Format("yyyy-MM-dd");
})
Vue.filter('month', function (value) {
   // return new Date(parseInt(value)).toLocaleString();
   return new Date(value).Format("yyyy-MM");
})
Vue.filter('year', function (value) {
   // return new Date(parseInt(value)).toLocaleString();
   return new Date(value).Format("yyyy");
})
Vue.filter('number', function (value) {
   if (!value) {
    return null;
  }
    if (isNaN(Number(value))) {
      console.error("转换数字错误")
      return "转换数字错误"
    } else {
      return Number(value);
    }
})

Vue.filter('string', function (value) {
   if (!value) {
    return null;
  }
  return String(value);
  
})

Date.prototype.Format = function (fmt) {
         var o = {
           "M+": this.getMonth() + 1, //月份
           "d+": this.getDate(), //日
           "h+": this.getHours(), //小时
           "m+": this.getMinutes(), //分
           "s+": this.getSeconds(), //秒
           "q+": Math.floor((this.getMonth() + 3) / 3), //季度
           "S": this.getMilliseconds() //毫秒
         };
         if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
         for (var k in o)
         if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
         return fmt;
   }
//路由钩子函数，判断是否有登陆权限
router.beforeEach((to, from, next) => {
    if (to.meta.requireAuth) {  // 判断该路由是否需要登录权限
        if (localStorage.voucher) {  // 通过vuex state获取当前的token是否存在
            next();
        }
        else {
            next({
                path: '/login',
                query: {redirect: to.fullPath}  // 将跳转的路由path作为参数，登录成功后跳转到该路由
            })
        }
    }
    else {
        next();
    }
})

// http request 拦截器
axios.interceptors.request.use(
    config => {
        if (localStorage.voucher) {  // 判断是否存在token，如果存在的话，则每个http header都加上token
            config.headers.voucher = `${localStorage.voucher}`;
        }
        config.headers.source = '5';//管理端渠道标识
        return config;
    },
    err => {
        return Promise.reject(err);
});

// http response 拦截器
axios.interceptors.response.use(
    response => {
    	if(response.data.code=="010003"){
    		router.replace({
                path: '/login',
                query: {redirect: router.currentRoute.fullPath}
            })
    	}
        return response;
});

new Vue({
    router,
    render: h => h(App)
}).$mount('#app');
