// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import FastClick from 'fastclick'
import router from './router';
import App from './App'
import axios from 'axios';
import Vuex from 'vuex'
import 'font-awesome/css/font-awesome.min.css'
Vue.use(Vuex);
const store = new Vuex.Store({}) // 这里你可能已经有其他 module

store.registerModule('vux', { // 名字自己定义
    state: {
        isLoading: false,
        direction: 'forward'
    },
    mutations: {
        updateLoadingStatus(state, payload) {
            state.isLoading = payload.isLoading
        },
        updateDirection(state, payload) {
            state.direction = payload.direction
        }
    }
})

FastClick.attach(document.body)

Vue.config.productionTip = false

// plugins
import { LocalePlugin, DevicePlugin, ToastPlugin, AlertPlugin, ConfirmPlugin, LoadingPlugin, WechatPlugin, AjaxPlugin, AppPlugin } from 'vux'
Vue.use(DevicePlugin)
Vue.use(ToastPlugin)
Vue.use(AlertPlugin)
Vue.use(ConfirmPlugin)
Vue.use(LoadingPlugin)
Vue.use(WechatPlugin)
Vue.use(AjaxPlugin)
Vue.use(LocalePlugin)

//微信jsapi用户分享
const getWxSign = params => { return axios.get(`http://www.yuanv.com.cn/wechats/jssign`, { params: params }); };
const wx = Vue.wechat;
Vue.prototype.wxConfig = function () {
    let params = {
        url: document.location.href
    };
    getWxSign(params).then((res) => {
        if (res.data.code == '000000') {
            var Data = res.data.data
            wx.config({
               debug: true, // 开启调试模式,开发时可以开启  
               appId: Data.appId,   // 必填，公众号的唯一标识   由接口返回
               timestamp: Data.timestamp, // 必填，生成签名的时间戳 由接口返回
               nonceStr: Data.nonce,    // 必填，生成签名的随机串 由接口返回
               signature: Data.signature,   // 必填，签名 由接口返回
               jsApiList: ['onMenuShareAppMessage', 'onMenuShareTimeline','onMenuShareQQ'] // 此处填你所用到的方法 
             });

        } 
    })
}

Vue.prototype.wxShare = function (title, desc, link) {
    wx.ready(() => {
      // 所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，
      // 则可以直接调用，不需要放在ready函数中。
      wx.onMenuShareAppMessage({ // 分享给朋友
        title: title,       // 分享标题
        desc: desc,   // 分享描述
        link: link,       // 分享链接 默认以当前链接
        // imgUrl: imgUrl + '/static/images/share.png',// 分享图标
        // 用户确认分享后执行的回调函数
        success: function () {
          console.log('分享到朋友成功');
        },
        // 用户取消分享后执行的回调函数
        cancel: function () {
          console.log('分享到朋友取消');
        }
      });
      //分享到朋友圈
      wx.onMenuShareTimeline({
        title: title,       // 分享标题
        desc: desc,   // 分享描述
        link: link,       // 分享链接 默认以当前链接
        // imgUrl: imgUrl + '/static/images/share.png',// 分享图标
        // 用户确认分享后执行的回调函数
        success: function () {
          console.log('分享到朋友圈成功');
        },
        // 用户取消分享后执行的回调函数
        cancel: function () {
          console.log('分享到朋友圈取消');
        }
      });
      //分享到qq
      wx.onMenuShareQQ({
        title: title,       // 分享标题
        desc: desc,   // 分享描述
        link: link,       // 分享链接 默认以当前链接
        // imgUrl: imgUrl + '/static/images/share.png',// 分享图标
        // 用户确认分享后执行的回调函数
        success: function () {
          console.log('分享到qq成功');
        },
        // 用户取消分享后执行的回调函数
        cancel: function () {
          console.log('分享到qq取消');
        }
      });
    });
};

Vue.filter('time', function(value) {
    // return new Date(parseInt(value)).toLocaleString();
    return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
})
Vue.filter('date', function(value) {
    // return new Date(parseInt(value)).toLocaleString();
    return new Date(value).Format("yyyy-MM-dd");
})

Date.prototype.Format = function(fmt) {
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
// simple history management
const history = window.sessionStorage
history.clear()
let historyCount = history.getItem('count') * 1 || 0
history.setItem('/', 0)
    //路由钩子函数，判断是否有登陆权限
router.beforeEach((to, from, next) => {
    store.commit('updateLoadingStatus', { isLoading: true })
    const toIndex = history.getItem(to.path)
    const fromIndex = history.getItem(from.path)

    if (toIndex) {
        if (!fromIndex || parseInt(toIndex, 10) > parseInt(fromIndex, 10) || (toIndex === '0' && fromIndex === '0')) {
            store.commit('updateDirection', { direction: 'forward' })
        } else {
            store.commit('updateDirection', { direction: 'reverse' })
        }
    } else {
        ++historyCount
        history.setItem('count', historyCount)
        to.path !== '/' && history.setItem(to.path, historyCount)
        store.commit('updateDirection', { direction: 'forward' })
    }

    if (to.meta.requireAuth) { // 判断该路由是否需要登录权限
        if (localStorage.voucher) { // 通过vuex state获取当前的token是否存在
            next();
        } else {

            next({
                path: '/login',
                query: { redirect: to.fullPath } // 将跳转的路由path作为参数，登录成功后跳转到该路由
            })
        }
    } else {
        next();
    }
})

router.afterEach(function(to) {
    store.commit('updateLoadingStatus', { isLoading: false })
})

// http request 拦截器
axios.interceptors.request.use(
    config => {
        if (localStorage.voucher) { // 判断是否存在token，如果存在的话，则每个http header都加上token
            config.headers.voucher = `${localStorage.voucher}`;
        }
        config.headers.source = '1';//移动端渠道标识
        return config;
    },
    err => {
        return Promise.reject(err);
    });

// http response 拦截器
axios.interceptors.response.use(
    response => {
        if (response.data.code == "010003") {
            router.replace({
                path: '/login',
                query: { redirect: router.currentRoute.fullPath }
            })
        }
        return response;
    });


/* eslint-disable no-new */
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app-box')
