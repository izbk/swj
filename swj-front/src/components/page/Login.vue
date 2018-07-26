<template>
    <div class="login-wrap">
        <div class="ms-title">绵竹市商务局商务工作公共服务信息平台</div>
        <div class="ms-login">
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="0px" class="demo-ruleForm">
                <el-form-item prop="username">
                    <el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input type="password" placeholder="密码" v-model="ruleForm.password" @keyup.enter.native="submitForm('ruleForm')"></el-input>
                </el-form-item>
                <div class="login-btn">
                    <el-button type="primary" @click="submitForm('ruleForm')" :loading="loging">登录</el-button>
                </div>
                <p style="font-size:12px;line-height:30px;color:#999;">Tips : 请输入用户名密码。</p>
            </el-form>
        </div>
    </div>
</template>
<script>
    import {userLogin} from '../../api/api';
    export default {
        data: function(){
            return {
                ruleForm: {
                    username: '',
                    password: ''
                },
                rules: {
                    username: [
                        { required: true, message: '请输入用户名', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' }
                    ]
                },
                loging:false
            }
        },
        methods: {
            submitForm(formName) {
                const self = this;
                self.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.loging=true;
                        userLogin(this.ruleForm).then((res) => {
                            this.loging = false;
                            if (res.data.code == '000000') {
                                this.$message({
                                  message: '登陆成功！',
                                  type: 'success'
                                });
                                localStorage.setItem('voucher',res.data.data.voucher);
                                localStorage.setItem('user',JSON.stringify(res.data.data.userInfo));
                                self.$router.push('/readme');
                            } else {
                                this.$message.error(res.data.message);
                                return false;
                            }
                        }).catch(function (error) {
                            console.log(error)
                            self.loging=false;
                            self.$message.error('网络故障，请稍后再试');
                        });
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            }
        }
    }
</script>

<style scoped>
    .login-wrap{
        position: relative;
        width:100%;
        height:100%;
    }
    .ms-title{
        position: absolute;
        top:50%;
        width:100%;
        margin-top: -230px;
        text-align: center;
        font-size:30px;
        color: #fff;

    }
    .ms-login{
        position: absolute;
        left:50%;
        top:50%;
        width:300px;
        height:160px;
        margin:-150px 0 0 -190px;
        padding:40px;
        border-radius: 5px;
        background: #fff;
    }
    .login-btn{
        text-align: center;
    }
    .login-btn button{
        width:100%;
        height:36px;
    }
</style>
