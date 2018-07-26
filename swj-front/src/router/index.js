import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/login'
        },
        {
            path: '/readme',
            component: resolve => require(['../components/common/Home.vue'], resolve),
            children:[
                {
                    path: '/',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/Readme.vue'], resolve)
                },
                {
                    path: '/basetable',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/BaseTable.vue'], resolve)
                },
                {
                    path: '/vuetable',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/VueTable.vue'], resolve)     // vue-datasource组件
                },
                {
                    path: '/baseform',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/BaseForm.vue'], resolve)
                },
                {
                    path: '/vueeditor',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/VueEditor.vue'], resolve)    // Vue-Quill-Editor组件
                },
                {
                    path: '/markdown',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/Markdown.vue'], resolve)     // Vue-Quill-Editor组件
                },
                {
                    path: '/upload',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/Upload.vue'], resolve)       // Vue-Core-Image-Upload组件
                },
                {
                    path: '/basecharts',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/BaseCharts.vue'], resolve)   // vue-echarts-v3组件
                },
                {
                    path: '/mixcharts',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/MixCharts.vue'], resolve)    // vue-echarts-v3组件
                },
                {
                    path: '/usermag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/manage/usermag.vue'], resolve)
                },
                {
                    path: '/rolemag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/manage/rolemag.vue'], resolve)
                },
                {
                    path: '/menumag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/manage/menumag.vue'], resolve)
                },
                {
                    path: '/logmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/manage/servicelogsmag.vue'], resolve)
                },
                {
                    path: '/depmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/manage/depmag.vue'], resolve)
                },
                {
                    path: '/townshipmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/townshipmag.vue'], resolve)
                },
                {
                    path: '/typegroupmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/typegroupmag.vue'], resolve)
                },
                {
                    path: '/realreportmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/realreportmag.vue'], resolve)
                },
                {
                    path: '/enterprisemanagemag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/enterprisemanagemag.vue'], resolve)
                },
                {
                    path: '/servicedefinemag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/servicedefinemag.vue'], resolve)
                },
                {
                    path: '/serviceforecastmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/serviceforecastmag.vue'], resolve)
                },
                {
                    path: '/subserviceforecast',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/subserviceforecast.vue'], resolve)
                },
                {
                    path: '/serviceforecast',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/serviceforecast.vue'], resolve)
                },
                {
                    path: '/projectmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/projectmag.vue'], resolve)
                },
                {
                    path: '/enterprisemag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/enterprisemag.vue'], resolve)
                },
                {
                    path: '/specialtymag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/specialtymag.vue'], resolve)
                },
                {
                    path: '/forecastdetailmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/forecastdetailmag.vue'], resolve)
                },
                {
                    path: '/forecastmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/forecastmag.vue'], resolve)
                },
                {
                    path: '/enterpriserisemag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/enterpriserisemag.vue'], resolve)
                },
                {
                    path: '/enterprisereportmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/enterprisereportmag.vue'], resolve)
                },
                {
                    path: '/enterprisereport',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/enterprisereport.vue'], resolve)
                },
                {
                    path: '/todolistmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/todolistmag.vue'], resolve),
                },
                {
                    path: '/articlecategorymag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/articlecategorymag.vue'], resolve)
                },
                {
                    path: '/articlemag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/articlemag.vue'], resolve)
                },
                {
                    path: '/auditconfigmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/auditconfigmag.vue'], resolve)
                },
                {
                    path: '/publish',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/publishmag.vue'], resolve)
                },
                {
                    path: '/adviceMag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/advicemag.vue'], resolve)
                },
                {
                    path: '/companyMag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/companymag.vue'], resolve)
                },
                {
                    path: '/subserviceforecastmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/subserviceforecastmag.vue'], resolve)
                },
                {
                    path: '/totalreportmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/totalreportmag.vue'], resolve)
                },
                {
                    path: '/weixintemplatemag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/weixin/weixintemplatemag.vue'], resolve)
                },
                {
                    path: '/weixintemplaterecordmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/weixin/weixintemplaterecordmag.vue'], resolve)
                },
                {
                    path: '/weixinmenumag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/weixin/weixinmenumag.vue'], resolve)
                },
                {
                    path: '/weixinsubscribemag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/weixin/weixinsubscribemag.vue'], resolve)
                },
                {
                    path: '/rangRules',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/pm/statisticianrangerulesmag.vue'], resolve)
                },
                {
                    path: '/scoringRules',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/pm/statisticianscoringrulesmag.vue'], resolve)
                },
                {
                    path: '/townTaskMag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/pm/townshipannualtaskmag.vue'], resolve)
                },
                {
                    path: '/townDoneMag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/pm/townshipannualdonemag.vue'], resolve)
                },
                {
                    path: '/statScoring',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/pm/statisticianscoringreportingmag.vue'], resolve)
                },
                {
                    path: '/statReward',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/pm/statisticianrewardmag.vue'], resolve)
                },
                {
                    path: '/exhibitionRecords',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/exhibitionrecordmag.vue'], resolve)
                },
                {
                    path: '/exhibitionmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/exhibitionmag.vue'], resolve)
                },
                {
                    path: '/exhibitionregistermag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/exhibitionregistermag.vue'], resolve)
                },
                {
                    path: '/parkAssessmentMag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/incubationparkassessmentmag.vue'], resolve)
                },
                {
                    path: '/parkCompanyMag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/incubationparkcompanymag.vue'], resolve)
                },
                {
                    path: '/parkRegisterMag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/incubationparkregistermag.vue'], resolve)
                },
                {
                    path: '/funddetailmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/funddetailmag.vue'], resolve)
                },
                {
                    path: '/fundmag',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/fundmag.vue'], resolve)
                },
                {
                    path: '/myarticle',
                    meta: {
                        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
                    },
                    component: resolve => require(['../components/page/mianz/myarticle.vue'], resolve)
                }   
            ]
        },
        {
            path: '/login',
            component: resolve => require(['../components/page/Login.vue'], resolve)
        },
    ]
})
