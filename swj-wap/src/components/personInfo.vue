<template>
    <div style="width:100%">
        <x-header>个人信息</x-header>
        <div class="news-wrap">
            <!-- <cell title="头像" >
                <img class="user_pic" :src="userInfo.pic">
            </cell> -->
            <cell title="昵称" :value="userInfo.nickName">
            </cell>
            <cell title="角色" :value="roleFormat">
            </cell>
            <cell title="注册时间" :value="userInfo.regTime|date">
            </cell>
        </div>
    </div>
</template>
<script>
import XHeader from 'vux/src/components/x-header/index.vue'
import Cell from 'vux/src/components/cell/index.vue'
import XButton from 'vux/src/components/x-button/index.vue'
import {
    getOptions
} from '../api/api';
// import {
//     Cell,
//     XButton,
//     XHeader
// } from 'vux'
export default {
    components: {
        Cell,
        XButton,
        XHeader
    },
    methods: {
       getUser(){
        let userStr = localStorage.getItem('user');
        let user = JSON.parse(userStr);
        this.userInfo=user;
       },
       getRoleName(roleId) {
            const self = this;
            let params = {
                tableName: 'role',
                label: 'name',
                value: 'id',
            }
            getOptions(params).then((res) => {
                if (res.data.code == '000000') {
                    var result = res.data.data;
                    if (result.length != 0) {
                        for (var o in result) {
                            var name = result[o].label;
                            var value = result[o].value;
                            if(value == roleId){
                                this.roleName=name;
                                break;
                            }
                        }
                    }
                } else {
                    self.$vux.toast.text(res.data.message);
                }
            }).catch(function(error) {
                self.$vux.toast.text('网络故障，请稍后再试');
            });
        },
    },
    computed: {
        roleFormat(){
            let roleId = this.userInfo.roleId
            this.getRoleName(roleId);
          return this.roleName;
        },
         
    },
    data() {
        return {
            userInfo:{},
            roleName:'未知'
        }
    },
    mounted: function() {
        this.getUser();
    }
}
</script>
<style>
.user_pic{
    width: 3em;
    height: 3em;
    border-radius: 50%;
}

</style>
