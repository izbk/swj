<template>
    <div>
        <img class="img_1" src="../assets/wap/userIndex/bg_my.png">
        <span class="user-info">
          <!-- <img class="user-logo" :src="img"> -->
          <span class="user-text">
          {{username}}
          </span>
        </span>
        <div class="news-wrap">
            <cell title="个人信息" is-link link="/info">
            </cell>
            <cell title="修改密码" is-link link="/chgPwd">
            </cell>
            <cell title="待办事项" is-link link="/todos">
                <badge :text="todoCount"></badge>
            </cell>
            <cell title="社消零数据预报" is-link link="/upload" v-if="isSxlShow">
            </cell>
            <cell title="服务业数据预报" is-link link="/uploadServerData" v-if="isServerShow">
            </cell>
            <cell title="重点服务业数据预报" is-link link="/uploadSubServerData" v-if="isSubServerShow">
            </cell>
            <cell title="绑定微信" @click.native="bindWeixin">
              <badge :text="bindLabel"></badge>
            </cell>
            <cell title="退出登录" @click.native="userLoginout">
            </cell>
        </div>
    </div>
</template>
<script>
import XHeader from 'vux/src/components/x-header/index.vue'
import Cell from 'vux/src/components/cell/index.vue'
import XButton from 'vux/src/components/x-button/index.vue'
import Badge from 'vux/src/components/badge/index.vue'
// import {
//     Cell,
//     XButton,
//     Badge,
//     XHeader
// } from 'vux'
import {
    userLoginout,
    getToDoTotal,
    bindWx
} from '../api/api';
export default {
    components: {
        Cell,
        XButton,
        Badge,
        XHeader
    },
    methods: {
        notifyTodo() {
            getToDoTotal().then((res) => {
                if (res.data.code == '000000') {
                    if (this.todoCount != res.data.count) {
                        this.todoCount = res.data.count;
                    }
                } else {
                    this.$vux.toast.text(res.data.message)
                }
            });
        },
        bindWeixin(){
          const self = this;
          if(this.isBind==1){
            this.$vux.confirm.show({
              content: '您已绑定微信,确定重新绑定？',
              onConfirm () {self.invokeBind()}
            })
          }else{
            this.$vux.confirm.show({
              content: '确定绑定此微信？',
              onConfirm () {self.invokeBind()}
            })
          }
        },
        invokeBind(){
          const self = this;
          let openId = localStorage.getItem('openId');
          if(!openId){
            this.$vux.toast.text("没有找到微信用户,请从公众号菜单'微官网'重新进入绑定");
          }else{
          let req = {openId:openId};
          let params = Object.assign({}, req);
              bindWx(params).then((res) => {
                    if (res.data.code == '000000') {
                        localStorage.setItem("user",JSON.stringify(res.data.data));
                        this.isBind=1;
                        this.$vux.toast.text("绑定成功");
                    } else {
                        this.$vux.toast.text(res.data.message)
                        return false;
                    }
                }).catch(function(error) {
                    self.$vux.toast.text("网络故障，请稍后再试")
                });
            }
        },
        userLoginout() {
            const self = this;
            userLoginout().then((res) => {
                if (res.data.code == '000000') {
                    localStorage.removeItem('voucher');
                    localStorage.removeItem('user')
                    this.$router.push('/login');
                    this.$vux.toast.text("退出登陆成功")
                } else {
                    this.$vux.toast.text(res.data.message)
                    return false;
                }
            }).catch(function(error) {
                this.$vux.toast.text("网络故障，请稍后再试")
            });
        }
    },
    computed: {
        username() {
            let userStr = localStorage.getItem('user');
            let user = JSON.parse(userStr);
            this.loginUser = user;
            if(user.openId != null){
              this.isBind=1;
            }else{
              this.isBind=0;
            }
            this.img = user.pic;
            return user.nickName ? user.nickName : user.loginName;
        },
        isSxlShow(){
            if(this.loginUser.roleId==3){
                return true
            }else{
                return false
            }
        },
        isServerShow(){
            if(this.loginUser.roleId==2){
                return true
            }else{
                return false
            }
        },
        isSubServerShow(){
            if(this.loginUser.roleId==4){
                return true
            }else{
                return false
            }
        },
        bindLabel(){
          return this.isBind==1?"已绑定":"未绑定"
        }
    },
    data() {
        return {
            img: '',
            todoCount: 0,
            isBind:1,
            loginUser:{},
        }
    },
    mounted: function() {
        this.notifyTodo();
    }
}
</script>
<style>
.img_1 {
    width: 100%;
}

.user-info {
    position: absolute;
    left: 10%;
    top: 7%;
}

.user-logo {
    position: absolute;
    left: 10%;
    top: 7%;
    width: 4em;
    height: 4em;
    border-radius: 50%;
}

.user-text {
    position: absolute;
    margin-left: 2em;
    margin-top: 1em;
    width: 6em;
    color: #fff;
}
</style>
