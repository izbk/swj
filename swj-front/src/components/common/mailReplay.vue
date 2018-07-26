<template>
    <div class="table">
        <el-dialog :title="formTittle" v-model="formVisible" :close-on-click-modal="false" size="big">
        <div v-if="subform">
            <el-form :model="subform" label-width="90px" ref="subform">
                <el-row>
                    <el-col :span='8'>
                        <el-form-item label="姓名" prop="name">
                            <el-input v-model="subform.name" auto-complete="off" disabled></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='8'>
                        <el-form-item label="电话" prop="mobile">
                            <el-input v-model="subform.mobile" auto-complete="off" disabled></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='8'>
                        <el-form-item label="邮箱" prop="email">
                            <el-input v-model="subform.email" auto-complete="off" disabled></el-input>
                        </el-form-item>
                 </el-col>
                 <el-col :span='8'>
                        <el-form-item label="意见类型" prop="adviceType">
                            <el-select v-model="subform.adviceType" placeholder="请选择意见类型" disabled>
                                <v-yvoption groupName="adviceType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                 <el-col :span='8'>
                        <el-form-item label="创建时间" prop="createTime">
                            <el-date-picker type="datetime" placeholder="选择日期" v-model="subform.createTime" disabled></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='16'>
                        <el-form-item label="标题" prop="adviceTitle">
                            <el-input v-model="subform.adviceTitle" auto-complete="off" disabled></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='16'>
                        <el-form-item label="内容" prop="adviceContent">
                            <el-input  type="textarea" :rows=5 v-model="subform.adviceContent" auto-complete="off" disabled></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='16'>
                        <el-form-item label="回复" prop="resContent">
                            <el-input type="textarea" :rows=5 v-model="subform.resContent" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
            </el-row>
            </el-form>
            </div>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="formVisible = false">取消</el-button>
                <el-button type="primary" @click.native="formSubmit" :loading="formLoading">提交</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script>
import {
    todoCheck,
    getAdviceById,
    base
} from '../../api/api';
import vYvoption from '../common/yvoption.vue';
export default {
    data() {
            return {
                loading: true,
                formTittle: '信件回复',
                formVisible: this.checkVisible,
                subform: null,
                formLoading: false
            }
        },
        components:{
            vYvoption,
        },      
        props: {
            mailId: Number,
            todoId:Number,
            checkVisible: Boolean
        },
        methods: {
            getMail() {
                let params = {id:this.mailId};
                this.loading=true;
                getAdviceById(params).then((res) => {
                    this.loading=false;
                    if (res.data.code == '000000') {
                        this.subform=res.data.data;
                    } else {
                   this.$message.error(res.data.message);
                    }
                }).catch(function(error) {
                    self.$message.error('网络故障，请稍后再试');
                });
            },
           
            formSubmit() {
                this.formLoading = true;
                let params = {id:this.todoId,content:this.subform.resContent};
                    todoCheck(params).then((res) => {
                        this.formLoading = false;
                        if (res.data.code == '000000') {
                            this.$message.success("回复成功");
                            this.formVisible = false;
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });

            },
           
        },

        watch: {
            mailId: 'getMail',
            checkVisible(val) {
                this.formVisible = val;
            },
            formVisible(val) {
                this.$emit("on-visible-change", val)
            }
        },

        mounted: function() {
            this.getMail()
        }
}
</script>
<style>

</style>
