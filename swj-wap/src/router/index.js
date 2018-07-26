import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
    routes: [{
        path: '/',
        component: resolve => require(['../components/index.vue'], resolve),
        children: [{
            path: '/',
            component: resolve => require(['../components/articleLt.vue'], resolve)
        }, 
        {
            path: '/login',
            component: resolve => require(['../components/login.vue'], resolve)
        },
        {
            path: '/upload',
            component: resolve => require(['../components/uploadData.vue'], resolve)
        },
        {
            path: '/userIndex',
            meta: {
                requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
            },
            component: resolve => require(['../components/userIndex.vue'], resolve)
        },
        {
            path: '/info',
            meta: {
                requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
            },
            component: resolve => require(['../components/personInfo.vue'], resolve)
        },
        {
            path: '/chgPwd',
            meta: {
                requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
            },
            component: resolve => require(['../components/changePwd.vue'], resolve)
        },
        {
            path: '/todos',
            meta: {
                requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
            },
            component: resolve => require(['../components/todoLt.vue'], resolve)
        },
        {
            path: '/uploadProject',
            component: resolve => require(['../components/uploadProject.vue'], resolve)
        },
        {
            path: '/mianzPro',
            component: resolve => require(['../components/mianzPro.vue'], resolve)
        },
        {
            path: '/mail',
            component: resolve => require(['../components/mail.vue'], resolve)
        },
        {
            path: '/upFunc',
            component: resolve => require(['../components/upFunc.vue'], resolve)
        },
        {
            path: '/statusQuery',
            component: resolve => require(['../components/statusQuery.vue'], resolve)
        },
        {
            path: '/upCompany',
            component: resolve => require(['../components/upCompany.vue'], resolve)
        },
        {
            path: '/uploadServerData',
            component: resolve => require(['../components/uploadServerData.vue'], resolve)
        },
        {
            path: '/uploadSubServerData',
            component: resolve => require(['../components/uploadSubServerData.vue'], resolve)
        },
        {
            path: '/detail/:id',
            component: resolve => require(['../components/detail.vue'], resolve)
        },{
            path: '/mzDetail/:id',
            component: resolve => require(['../components/mianzuDetail.vue'], resolve)
        },{
            path: '/projectDetail/:id',
            component: resolve => require(['../components/projectDetail.vue'], resolve)
        },{
            path: '/mailDetail/:id',
            component: resolve => require(['../components/mailDetail.vue'], resolve)
        },{
            path: '/exhibitionApply',
            component: resolve => require(['../components/exhibitionApply.vue'], resolve)
        },{
            path: '/parkApply',
            component: resolve => require(['../components/parkApply.vue'], resolve)
        } ]
    }]
})
