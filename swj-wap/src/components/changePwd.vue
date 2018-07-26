<template>
    <div style="width:100%">
        <x-header :left-options="{showBack: true}">修改密码</x-header>
        <group>
            <x-input placeholder="旧密码" v-model="chgPwdForm.oldPwd" type="password" required :max=12 :min=6></x-input>
            <x-input placeholder="新密码" v-model="chgPwdForm.newPwd" type="password" :max=12 :min=6 required></x-input>
            <x-input placeholder="重复新密码" v-model="chgPwdForm.confirmPwd" type="password" :max=12 :min=6 required></x-input>
        </group>
        <x-button :show-loading="loging" text="提交" type="primary" @click.native="submitForm('chgPwdForm')" style="margin-top:1em"></x-button>
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
    changePwd
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
            if(this.chgPwdForm.newPwd == this.chgPwdForm.confirmPwd){
                changePwd(this.chgPwdForm).then((res) => {
                    this.loging = false;
                    if (res.data.code == '000000') {
                        this.$vux.toast.text('修改密码成功,请重新登陆')
                        localStorage.removeItem('voucher');
                        localStorage.removeItem('user')
                        this.$router.push('/login');
                    } else {
                      self.$vux.toast.text(res.data.message)
                        return false;
                    }
                }).catch(function(error) {
                    self.loging = false;
                    self.$vux.toast.text('网络故障，请稍后再试')
                });
            }else{
                self.$vux.toast.text("两次输入新密码不一致")
                this.loging = false;
            }
        }
    },
    data() {
        return {
            loging: false,
            chgPwdForm: {
                oldPwd: '',
                newPwd: '',
                confirmPwd:''
            }
        }
    }
}
</script>
