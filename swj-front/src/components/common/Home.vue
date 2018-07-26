<template>
    <div class="wrapper">
        <v-head></v-head>
        <v-sidebar :collapse="collapse"></v-sidebar>
        <div class="content_own" :style="getStyle">
            <div class="collapse">
                <el-tooltip :content="tooltip" placement="bottom">
                    <el-button type="primary" :icon="icon" size="mini" @click.native="onCollapse"></el-button>
                </el-tooltip>
            </div>
            <div style="margin:30px 40px">
                <transition name="move" mode="out-in"><router-view></router-view></transition>
            </div>
        </div>
    </div>
</template>

<script>
    import vHead from './Header.vue';
    import vSidebar from './Sidebar.vue';
    export default {
        data(){
            return{
                collapse:true,
                tooltip:'收缩',
                icon:'d-arrow-left'
            }
        },
        components:{
            vHead, vSidebar
        },
        computed:{
            getStyle(){
                if(this.collapse){
                    return '';
                }else{
                    return 'left:0'
                }
            }
        },
        methods:{
            onCollapse(){
                this.collapse=!this.collapse;
                if(this.collapse){
                    this.tooltip='收缩',
                    this.icon='d-arrow-left'
                }else{
                    this.tooltip='展开',
                    this.icon='d-arrow-right'
                }
            }
        }
    }
</script>
<style type="text/css">
    .collapse{
        margin:10px;
        cursor: pointer;
        width: 2em;
    }
</style>
