<template>
    <div>
        <x-header :left-options="{showBack: true}">用户登录</x-header>
        <group gutter="20%">
            <x-input placeholder="用户名" v-model="loginForm.username" required :max=10 :min=3></x-input>
            <x-input placeholder="密码" v-model="loginForm.password" type="password" :max=12 :min=6 required></x-input>
        </group>
        <x-button :show-loading="loging" text="登陆" type="primary" @click.native="submitForm('loginForm')" style="margin-top:1em"></x-button>
    </div>
</template>
<script>
import Group from 'vux/src/components/group/index.vue'
import XInput from 'vux/src/components/x-input/index.vue'
import XButton from 'vux/src/components/x-button/index.vue'
import XHeader from 'vux/src/components/x-header/index.vue'
// import {
//     Group,
//     XInput,
//     XButton,
//     XHeader
// } from 'vux';
import {
    userLogin
} from '../api/api';
export default {
    components: {
        Group,
        XInput,
        XButton,
        XHeader
    },
    methods: {
        submitForm(formName) {
            const self = this;
            this.loging = true;
            userLogin(this.loginForm).then((res) => {
                this.loging = false;
                if (res.data.code == '000000') {
                    this.$vux.toast.text('登陆成功')
                    localStorage.setItem('voucher', res.data.data.voucher);
                    localStorage.setItem('user', JSON.stringify(res.data.data.userInfo));
                    self.$router.push('/userIndex');
                } else {
                  self.$vux.toast.text(res.data.message)
                    return false;
                }
            }).catch(function(error) {
                self.loging = false;
                self.$vux.toast.text('网络故障，请稍后再试')
            });
        }
    },
    data() {
        return {
            loging: false,
            loginForm: {
                username: '',
                password: ''
            }
        }
    }
}
</script>
