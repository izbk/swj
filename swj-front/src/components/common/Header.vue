<template>
    <div class="header">
        <div class="logo">绵竹市商务局商务工作公共服务信息平台</div>
        
        <div class="user-info">
            <el-badge :value="todoCount" class="item" style="line-height: 20px">
                <el-tooltip content="待办事项" placement="bottom" effect="light">
                    <el-button size="small" class="el-icon-message" type="primary" @click="pushTodo"></el-button>
                </el-tooltip>
            </el-badge>
            <el-dropdown trigger="click" @command="handleCommand">
                <span class="el-dropdown-link">
                    <img class="user-logo" :src="img">
                    {{username}}
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command="loginout">退出</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>
<script>
    import {userLoginout,getToDoTotal} from '../../api/api';
    export default {
        data() {
            return {
                name: 'sky',
                img:'../../../static/img/img.jpg',
                todoCount:0,
                interval:null,
                userId:null,
                websocketUrl:'ws://'+document.domain+':8090/websocket/',
            }
        },
        computed:{
            username(){
                let userStr = localStorage.getItem('user');
                let user = JSON.parse(userStr);
                if(user.pic!=null && user.pic != ""){
                    this.img=user.pic;
                }
                this.userId = user.id;
                
                return user.nickName ? user.nickName : user.loginName;
            }
        },
        methods:{
            initWebSocket(){
                let self = this;
                var websocket = null;
                //判断当前浏览器是否支持WebSocket
                if('WebSocket' in window){
                    websocket = new WebSocket(this.websocketUrl+this.userId);
                }
                    //接收到消息的回调方法
                websocket.onmessage = function(event){
                    self.notifyTodo(); 
                }
                //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
                window.onbeforeunload = function(){
                    websocket.close();
                }
            },
            handleCommand(command) {
                if(command == 'loginout'){
                    userLoginout().then((res) => {
                        if (res.data.code == '000000') {
                            localStorage.removeItem('voucher');
                            localStorage.removeItem('user')
                            this.$router.push('/login');
                            this.$message({
                              message: '退出成功！',
                              type: 'success'
                            });
                            clearInterval(this.interval);
                        } else {
                            this.$message.error(res.data.message);
                            return false;
                        }
                    }).catch(function (error) {
                        self.loging=false;
                        self.$message.error('网络故障，请稍后再试');
                    });
                    
                }
            },
            notifyTodo(){
                getToDoTotal().then((res) => {
                        if (res.data.code == '000000') {
                            if(this.todoCount!=res.data.count){
                                this.todoCount=res.data.count;
                                if(res.data.count!=0){
                                    this.$notify.info({
                                      title: '提示',
                                      message: '您有'+this.todoCount+'条待办事项未处理',
                                      offset: 100
                                    });  
                                }
                              
                            }
                            
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
            },
            pushTodo(){
                this.$router.push("/todolistmag")
            }
        },
        mounted:function(){
             // this.interval = window.setInterval(this.notifyTodo, 10000); 
            this.notifyTodo();
            this.initWebSocket();
        }
    }
</script>
<style scoped>
    .header {
        position: relative;
        box-sizing: border-box;
        width: 100%;
        height: 70px;
        font-size: 22px;
        line-height: 70px;
        color: #fff;
    }
    .header .logo{
        float: left;
        width:450px;
        text-align: center;
    }
    .user-info {
        float: right;
        padding-right: 50px;
        font-size: 16px;
        color: #fff;
    }
    .user-info .el-dropdown-link{
        position: relative;
        display: inline-block;
        padding-left: 50px;
        color: #fff;
        cursor: pointer;
        vertical-align: middle;
    }
    .user-info .user-logo{
        position: absolute;
        left:0;
        top:15px;
        width:40px;
        height:40px;
        border-radius: 50%;
    }
    .el-dropdown-menu__item{
        text-align: center;
    }
    .item {
      margin-top: 10px;
      margin-right: 40px;
    }
</style>
