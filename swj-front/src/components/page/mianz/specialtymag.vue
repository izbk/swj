<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 绵竹造</el-breadcrumb-item>
                <el-breadcrumb-item>绵竹造产品表管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="产品名称">
                    <el-input v-model="queryParam.productName" :maxlength=30 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getSpecialtyList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getExportUrl"><a :href="exportUrl" style="color:#fff" target="_blank">导出</a></el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
             <el-table-column prop="subject" width="200" label="产品所属主体名称"></el-table-column>
            <el-table-column prop="subjectType" width="240" label="主体类型">
                <template scope="scope">
                    <v-yvtableoption groupName="enterpriseType" :trueValue="scope.row.subjectType"></v-yvtableoption>
                </template>
            </el-table-column>
             <el-table-column prop="productName" width="200" label="产品名称"></el-table-column>
            <el-table-column prop="category" width="240" label="所属品类">
                <template scope="scope">
                    <v-yvtableoption groupName="tradeType" :trueValue="scope.row.category"></v-yvtableoption>
                </template>
            </el-table-column>
             <el-table-column prop="priceRange" width="240" label="价格区间"></el-table-column>
             <el-table-column prop="status" width="180" label="状态">
                <template scope="scope">
                    <v-yvtableoption groupName="auditStatus" :trueValue="scope.row.status"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column label="操作" width="180">
                <template scope="scope">
                    <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-row type="flex" justify="space-between" style="margin-top:10px">
            <el-col :span='12'>
                <el-button type="danger" @click="batchRemove">批量删除</el-button>
            </el-col>
            <el-col :span='6'>
                <el-pagination layout="prev, pager, next" :current-page='pageIndex' :page-size='pageSize' @current-change="handleCurrentChange" :total="totalCount" style="float:right;">
                </el-pagination>
            </el-col>
        </el-row>
		<!--新增界面-->
        <el-dialog :title="formTittle" v-model="formVisible" :close-on-click-modal="false" size="small">
            <el-form :model="subform" label-width="90px" :rules="formRules" ref="subform">
                <el-row>
                <el-col :span='12'>
                        <el-form-item label="主键ID" prop="id">
                            <el-input v-model="subform.id" auto-complete="off" disabled></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="产品名称" prop="productName">
                            <el-input v-model="subform.productName" :maxlength=30 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="产品所属主体名称" prop="subject">
                            <el-input v-model="subform.subject" :maxlength=30 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="主体类型" prop="subjectType">
                            <el-select v-model="subform.subjectType" placeholder="请选择主体类型">
                                <v-yvoption groupName="enterpriseType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    </el-row>
                    <el-row>
                    <el-col :span='12'>
                        <el-form-item label="所属品类" prop="category">
                            <el-select v-model="subform.category" placeholder="请选择所属品类">
                                <v-yvoption groupName="tradeType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                  <el-col :span='24'>
                        <el-form-item label="产品描述" prop="intro">
                            <el-input type="textarea" :maxlength=500 v-model="subform.intro" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 
                 <el-col :span='12'>
                        <el-form-item label="年生产或种植规模" prop="scale">
                            <el-input v-model="subform.scale" :maxlength=30 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="原产地" prop="origin">
                            <el-input v-model="subform.origin" :maxlength=30 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='12'>
                        <el-form-item label="产品季节性情况" prop="seasonal">
                            <el-input v-model="subform.seasonal" :maxlength=30 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="销售渠道" prop="saleChannel">
                            <el-input v-model="subform.saleChannel" :maxlength=30 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='12'>
                        <el-form-item label="销售情况评价" prop="salesStatus">
                            <el-input v-model="subform.salesStatus" :maxlength=30 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="价格区间" prop="priceRange">
                            <el-input v-model="subform.priceRange" :maxlength=30 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='12'>
                        <el-form-item label="产品认证情况" prop="accreditation">
                            <el-input v-model="subform.accreditation" :maxlength=30 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="商标注册情况" prop="trademark">
                            <el-input v-model="subform.trademark" :maxlength=30 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="电商销售情况" prop="onlineSale">
                            <el-input v-model="subform.onlineSale" :maxlength=30 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="联系电话" prop="contact">
                            <el-input v-model="subform.contact" :maxlength=20 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                 <el-col :span='12'>
                        <el-form-item label="状态" prop="status">
                            <el-select v-model="subform.status" placeholder="请选择状态">
                                <v-yvoption groupName="auditStatus"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                 <el-col :span='24'>
                        <el-form-item label="产品销售的意见及建议" prop="proposal">
                            <el-input type="textarea" :maxlength=200 v-model="subform.proposal" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                
                 </el-row>
                 <el-row>
                 <el-col :span='12'>
                        <el-form-item label="一级审核人" prop="audit1By" filterable>
                            <el-select disabled v-model="subform.audit1By" placeholder="请选择一级审核人">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>          
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="一级审核时间" prop="audit1Time">
                            <el-date-picker type="datetime" placeholder="选择日期" disabled v-model="subform.audit1Time"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    </el-row>
                    <el-row>
                    <el-col :span='12'>
                        <el-form-item label="二级审核人" prop="audit2By" filterable>
                            <el-select disabled v-model="subform.audit2By" placeholder="请选择二级审核人">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>          
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="二级审核时间" prop="audit2Time">
                            <el-date-picker type="datetime" placeholder="选择日期" disabled v-model="subform.audit2Time"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    </el-row>
                    <el-row>
                    <el-col :span='12'>
                        <el-form-item label="三级审核人" prop="audit3By" filterable>
                            <el-select disabled v-model="subform.audit3By" placeholder="请选择三级审核人">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>          
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="三级审核时间" prop="audit3Time">
                            <el-date-picker type="datetime" placeholder="选择日期" disabled v-model="subform.audit3Time"></el-date-picker>
                        </el-form-item>
                    </el-col>
                 </el-row>
                 <el-row>
                        <el-form-item label="产品展示形象" prop="productPic">
                            <el-col :span='12' v-for="(item, index) in imgs">
                                <a target="_blank" :href="item.src">
                                 <img  :src="item.src" class="avatar">
                                </a>
                            </el-col>
                        </el-form-item>
            </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="formVisible = false">取消</el-button>
                <el-button type="primary" @click.native="formSubmit" :loading="formLoading">提交</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script>
import {
    createSpecialty,
    getSpecialtyList,
    editSpecialty,
    delSpecialty,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {checkMonth,checkMoney,checkRequire,checkPersent,validNum} from '../../../utils/validator.js'
export default {
    data() {
            return {
                exportUrl: base+"/specialtys/export",
                tableData: [],
                pageIndex: 1,
                pageSize: 10,
                totalCount: 0,
                loading: true,
                sels: [],
                //form数据
                formTittle: '',
                formVisible: false,
                queryParam: {
                    id: '',
                    productName: ''
                },
                subform:{},
                initform: {
                   id:'',
                   subject:'',
				   subjectType:0,
                   productName:'',
                   scale:'',
                   category:0,
                   origin:'',
                   seasonal:'',
                   saleChannel:'',
                   salesStatus:'',
                   priceRange:'',
                   accreditation:'',
                   trademark:'',
                   onlineSale:'',
                   contact:'',
                   proposal:'',
                   productPic:'',
                   intro:'',
                   status:'',
                    audit1By: '',
                    audit1Time: '',
                    audit2By: '',
                    audit2Time: '',
                    audit3By: '',
                    audit3Time: '',
                },
                formRules: {
                    productName:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    subject:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    subjectType:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    category:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    contact:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    intro:[{validator:checkRequire, required: true,trigger: 'blur'}],
                },
                queryRules: {
                    id: [{
                        validator: validNum,
                        trigger: 'blur'
                    }],
                },
                formLoading: false,
            }
        },
        components:{
            vYvoption,
            vYvtableoption
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
            getExportUrl(){
                this.exportUrl=base+"/specialtys/export?id="+this.queryParam.id+"&productName="+this.queryParam.productName;
            },
            handleAdd(index, row) {
                this.formVisible = true;
                this.$nextTick(function () {
                    this.subform = Object.assign({}, this.initform);
                    this.$refs['subform'].resetFields();
                    this.formTittle = "新增"
                })
            },
            handleEdit(index, row) {
                this.formVisible = true;
                this.$nextTick(function () {
                    this.$refs['subform'].resetFields();
                    this.subform = Object.assign({}, row);
                    this.formTittle = "编辑"
                })
            },
            handleDelete(index, row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: row.id
                    };
                    delSpecialty(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getSpecialtyList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getSpecialtyList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            productName: this.queryParam.productName
                        }
                        getSpecialtyList(params).then((res) => {
                            this.loading = false;
                            if (res.data.code == '000000') {
                                this.tableData = res.data.data;
                                this.totalCount = res.data.count;
                            } else {
                           this.$message.error(res.data.message);
                            }
                        }).catch(function(error) {
                            self.loading = false;
                            self.$message.error('网络故障，请稍后再试');
                        });
                    }
                })
            },
            handleCurrentChange(val) {
                this.pageIndex = val;
                this.getSpecialtyList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editSpecialty(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getSpecialtyList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createSpecialty(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getSpecialtyList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        }

                    } else {
                        return false;
                    }
                })

            },
            selsChange(sels) {
                this.sels = sels;
            },
            batchRemove() {
                var ids = this.sels.map(item => item.id).toString();
                if (ids == "") {
                    this.$message.warning("您还没有选中记录");
                    return false;
                }
                this.$confirm('确认删除选中记录吗？', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: ids
                    };
                    delSpecialty(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getSpecialtyList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
        },

        mounted: function() {
            this.getSpecialtyList()
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
    width: 100%;
    height: 100%;
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    /*display: block;*/
}
</style>
