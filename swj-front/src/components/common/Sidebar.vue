<template>
    <div class="sidebar" v-show="collapse">
        <el-menu :default-active="onRoutes" class="el-menu-vertical-demo" theme="dark" unique-opened router>
            <el-menu-item index="readme">
                <i class="fa fa-info icon-right"></i>自述
            </el-menu-item>
            <!-- <el-submenu index="2">
                <template slot="title"><i class="el-icon-menu"></i>表格</template>
                <el-menu-item index="basetable">基础表格</el-menu-item>
                <el-menu-item index="vuetable">Vue表格组件</el-menu-item>
            </el-submenu>
            <el-submenu index="3">
                <template slot="title"><i class="el-icon-date"></i>表单</template>
                <el-menu-item index="baseform">基本表单</el-menu-item>
                <el-menu-item index="vueeditor">编辑器</el-menu-item>
                <el-menu-item index="markdown">markdown</el-menu-item>
                <el-menu-item index="upload">文件上传</el-menu-item>
            </el-submenu>
            <el-submenu index="4">
                <template slot="title"><i class="el-icon-star-on"></i>图表</template>
                <el-menu-item index="basecharts">基础图表</el-menu-item>
                <el-menu-item index="mixcharts">混合图表</el-menu-item>
            </el-submenu>
            <el-submenu index="5">
                <template slot="title"><i class="el-icon-menu"></i>系统管理</template>
                <el-menu-item index="usermag">用户管理</el-menu-item>
                <el-menu-item index="depmag">部门管理</el-menu-item>
                <el-menu-item index="rolemag">角色管理</el-menu-item>
                <el-menu-item index="menumag">菜单管理</el-menu-item>
                <el-menu-item index="logmag">日志管理</el-menu-item>
            </el-submenu> -->
            <template v-for="(item,index) in menuData">
                <el-submenu :index="index.toString()">
                    <template slot="title"><i :class="item.icon"></i>{{item.menuName}}</template>
                        <el-menu-item :index="subitem.path" v-for="subitem in item.children">{{subitem.menuName}}</el-menu-item>
                </el-submenu>
            </template>
        </el-menu>
    </div>
</template>

<script>
import {getUserMenu} from '../../api/api';
    export default {
        data: function(){
            return {
                menuData: []
            }
        },
        props: {
            collapse: Boolean
        },
        computed:{
            onRoutes(){
                return this.$route.path.replace('/','');
            },
        },
        methods:{
            getUserMenu() {
                const self = this;
                let params = {}
                getUserMenu(params).then((res) => {
                    if (res.data.code == '000000') {
                        this.menuData = res.data.data;
                    } else {
                        this.$message.error(res.data.message);
                    }
                }).catch(function(error) {
                    self.$message.error('网络故障，请稍后再试');
                });
            }
        },
        mounted: function() {
            this.getUserMenu();
        }
    }
</script>

<style scoped>
    .sidebar{
        display: block;
        position: absolute;
        width: 250px;
        left: 0;
        top: 70px;
        bottom:0;
        background: #2E363F;
        overflow: auto;
    }
    .sidebar > ul {
        height:100%;
    }
    .icon-right{
        vertical-align: baseline;
        margin-right: 10px;
    }
</style>
