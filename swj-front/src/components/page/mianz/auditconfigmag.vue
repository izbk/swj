<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 基础数据</el-breadcrumb-item>
                <el-breadcrumb-item>审核配置管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true">
                <el-form-item label="部门">
                            <el-select v-model="queryParam.departId" placeholder="请选择部门" clearable>
                                <v-yvoption tableName="department" label="departname" value='id'></v-yvoption>
                            </el-select>          
                        </el-form-item>
                    <el-form-item label="业务类型">
                            <el-select v-model="queryParam.busiType" placeholder="请选择业务类型" clearable>
                                <v-yvoption groupName="checkType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getAuditConfigList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
            <el-table-column prop="departId" width="150" label="部门">
                <template scope="scope">
                    <v-yvtableoption tableName="department" label="departname" value='id' :trueValue="scope.row.departId"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="userId1" width="200" label="一级审核人">
                <template scope="scope">
                    <v-yvtableoption tableName="user" label="nick_name" value='id' :trueValue="scope.row.userId1"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="userId2" width="200" label="二级审核人">
                <template scope="scope">
                    <v-yvtableoption tableName="user" label="nick_name" value='id' :trueValue="scope.row.userId2"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="userId3" width="200" label="三级审核人">
                <template scope="scope">
                    <v-yvtableoption tableName="user" label="nick_name" value='id' :trueValue="scope.row.userId3"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="busiType" width="200" label="业务类型">
                <template scope="scope">
                    <v-yvtableoption groupName="checkType" :trueValue="scope.row.busiType"></v-yvtableoption>
                </template>
            </el-table-column>
             <!-- <el-table-column prop="subBusiType" width="150" label="子业务类型"></el-table-column> -->
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
                        <el-form-item label="部门" prop="departId">
                            <el-select v-model="subform.departId" placeholder="请选择部门">
                                <v-yvoption tableName="department" label="departname" value='id'></v-yvoption>
                            </el-select>          
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="一级审核人" prop="userId1">
                            <el-select clearable v-model="subform.userId1" filterable placeholder="请选择一级审核人">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>          
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="二级审核人" prop="userId2">
                            <el-select clearable v-model="subform.userId2" filterable placeholder="请选择二级审核人">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>          
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="三级审核人" prop="userId3">
                            <el-select clearable v-model="subform.userId3" filterable placeholder="请选择三级审核人">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>          
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="业务类型" prop="busiType">
                            <el-select clearable v-model="subform.busiType" @change="typeChange" placeholder="请选择业务类型">
                                <v-yvoption groupName="checkType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="子业务类型" prop="subBusiType">
                            <el-select clearable v-model="subform.subBusiType" placeholder="请选择内容类型">
                                <v-yvoption :tableName="subTypeTable" :label="subTypeLabel" :value='subTypeValue' :groupName="subTypeGroupName"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
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
    createAuditConfig,
    getAuditConfigList,
    editAuditConfig,
    delAuditConfig,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
export default {
    data() {
            return {
                subTypeVisible:false,
                subTypeTable:"",
                subTypeLabel:"",
                subTypeValue:"",
                subTypeGroupName:"",
                tableData: [],
                pageIndex: 1,
                pageSize: 9,
                totalCount: 0,
                loading: true,
                sels: [],
                //form数据
                formTittle: '',
                formVisible: false,
                queryParam: {
                    departId:'',
                    busiType:'',
                },
                subform:{},
                initform: {
                   id:'',
				   departId:'',
				   userId1:'',
				   userId2:'',
				   userId3:'',
				   busiType:'',
				   subBusiType:'',
                },
                formRules: {

                },
                formLoading: false
            }
        },
        components:{
            vYvoption,
            vYvtableoption
        },        
        methods: {
            typeChange(val){
                // this.subform.subBusiType=""
                if(val==0){//文章articleType
                    this.subTypeGroupName="articleType";
                }else if(val==1){//项目
                    this.subTypeGroupName="projectType";
                }else if(val==2){//绵竹造
                    this.subTypeGroupName="projectType";
                }else if(val==3){//投诉建议
                    this.subTypeGroupName="adviceType";
                }else if(val==4){//企业备案
                    this.subTypeGroupName="enterpriseType";
                }
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
                    delAuditConfig(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getAuditConfigList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getAuditConfigList() {
                this.loading = true;
                const self = this;
                let params = {
                    page: this.pageIndex,
                    itemcount: this.pageSize,
                    departId:this.queryParam.departId,
                    busiType:this.queryParam.busiType,
                }
                getAuditConfigList(params).then((res) => {
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
            },
            handleCurrentChange(val) {
                this.pageIndex = val;
                this.getAuditConfigList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editAuditConfig(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getAuditConfigList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createAuditConfig(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getAuditConfigList();
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
                    delAuditConfig(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getAuditConfigList();
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
            this.getAuditConfigList()
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
