<template>
    <div class="table">
    <el-dialog title="绵竹造审核" v-model="myMianzCheckVisible" :close-on-click-modal="false" size="big">
            <div v-if="loading">
                Loading...
            </div>
            <div v-if="subform">
                <el-form :model="subform" label-width="90px" ref="subform">
                <el-row>
                <el-col :span='8'>
                        <el-form-item label="主键ID" prop="id">
                            <el-input v-model="subform.id" auto-complete="off" disabled></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='8'>
                        <el-form-item label="产品所属主体名称" prop="subject">
                            <el-input disabled v-model="subform.subject" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='8'>
                        <el-form-item label="主体类型" prop="subjectType">
                            <el-select disabled v-model="subform.subjectType" placeholder="请选择主体类型">
                                <v-yvoption groupName="enterpriseType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='8'>
                        <el-form-item label="产品名称" prop="productName">
                            <el-input disabled v-model="subform.productName" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='8'>
                        <el-form-item label="年生产或种植规模" prop="scale">
                            <el-input disabled v-model="subform.scale" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='8'>
                        <el-form-item label="所属品类" prop="category">
                            <el-select disabled v-model="subform.category" placeholder="请选择所属品类">
                                <v-yvoption groupName="projectType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='8'>
                        <el-form-item label="原产地" prop="origin">
                            <el-input disabled v-model="subform.origin" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='8'>
                        <el-form-item label="产品季节性情况" prop="seasonal">
                            <el-input disabled v-model="subform.seasonal" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='8'>
                        <el-form-item label="销售渠道" prop="saleChannel">
                            <el-input disabled v-model="subform.saleChannel" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='8'>
                        <el-form-item label="销售情况评价" prop="salesStatus">
                            <el-input disabled v-model="subform.salesStatus" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='8'>
                        <el-form-item label="价格区间" prop="priceRange">
                            <el-input disabled v-model="subform.priceRange" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='8'>
                        <el-form-item label="产品认证情况" prop="accreditation">
                            <el-input disabled v-model="subform.accreditation" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='8'>
                        <el-form-item label="商标注册情况" prop="trademark">
                            <el-input disabled v-model="subform.trademark" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='8'>
                        <el-form-item label="电商销售情况" prop="onlineSale">
                            <el-input disabled v-model="subform.onlineSale" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='8'>
                        <el-form-item label="联系电话" prop="contact">
                            <el-input disabled v-model="subform.contact" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                 <el-col :span='8'>
                        <el-form-item label="状态" prop="status">
                            <el-select disabled v-model="subform.status" placeholder="请选择状态">
                                <v-yvoption groupName="auditStatus"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                 <el-col :span='16'>
                        <el-form-item label="产品销售的意见及建议" prop="proposal">
                            <el-input type="textarea" disabled v-model="subform.proposal" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    </el-row>
                   
                 <el-row>
                    <el-col :span='8'>
                        <el-form-item label="产品展示形象" prop="productPic">
                            <img  :src="item.src" v-for="(item, index) in imgs" class="avatar">
                        </el-form-item>
                 </el-col>
            </el-row>
            </el-form>
            </div>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="myMianzCheckVisible = false">取消</el-button>
                        <el-button type="primary" @click.native="checkSubmit(1)">审核通过</el-button>
                        <el-button type="primary" @click.native="checkSubmit(0)">审核不通过</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script>
import {
    getSpecialtyById,
    todoCheck,
    base
} from '../../api/api';
import vYvoption from '../common/yvoption.vue';
export default {
    data() {
            return {
                subform: null,
                loading:false,
                myMianzCheckVisible: this.mianzCheckVisible,
            }
        },
        props: {
            mianzId: Number,
            todoId:Number,
            mianzCheckVisible: Boolean
        },
        components:{
            vYvoption,
        }, 
        computed:{
            imgs(){
                if(this.subform.productPic==null||this.subform.productPic==''){
                    return [];
                }else{
                    return JSON.parse(this.subform.productPic);
                }
            }
        },
        methods: {
            getMianzDetail(){
                let params = {id:this.mianzId};
                this.loading=true;
                getSpecialtyById(params).then((res) => {
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
            checkSubmit(status){
                let params = {id:this.todoId,status:status};
                todoCheck(params).then((res) => {
                    if (res.data.code == '000000') {
                        this.$message.success("审核成功");
                        this.myMianzCheckVisible=false;
                    } else {
                   this.$message.error(res.data.message);
                    }
                }).catch(function(error) {
                    self.$message.error('网络故障，请稍后再试');
                });
            },
            
        },
        watch: {
            mianzId: 'getMianzDetail',
            mianzCheckVisible(val) {
                this.myMianzCheckVisible = val;
            },
            myMianzCheckVisible(val) {
                this.$emit("on-visible-change", val)
            }
        },

        mounted: function() {
            this.getMianzDetail()
        }
}
</script>
<style>
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
}

.avatar-uploader .el-upload:hover {
    border-color: #20a0ff;
}

.avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
}

.avatar {
    width: 178px;
    height: 178px;
    display: block;
}
</style>
