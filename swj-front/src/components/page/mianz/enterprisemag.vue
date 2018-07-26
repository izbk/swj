<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 企业</el-breadcrumb-item>
                <el-breadcrumb-item>限上企业信息表管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="企业代码">
                    <el-input v-model="queryParam.enterpriseCode" :maxlength=20 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="企业名称">
                    <el-input v-model="queryParam.enterpriseName" :maxlength=30 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="企业类型">
                        <el-select v-model="queryParam.enterpriseType" clearable placeholder="请选择企业类型" style="width:90%" clearable>
                                <v-yvoption groupName="enterpriseType"></v-yvoption>
                            </el-select>
                </el-form-item>
                <el-form-item label="业态">
                        <el-select v-model="queryParam.industry" clearable placeholder="请选择企业业态" style="width:90%" clearable>
                                <v-yvoption groupName="comIndustry"></v-yvoption>
                            </el-select>
                </el-form-item>
                <el-form-item label="所属乡镇">
                        <el-select v-model="queryParam.townshipId" clearable placeholder="请选择所属乡镇" style="width:90%" clearable>
                                <v-yvoption tableName="township" label="name" value='id'></v-yvoption>
                            </el-select>
                </el-form-item>
                <el-form-item label="统计员ID">
                        <el-select v-model="queryParam.userId" clearable placeholder="请选择统计员" style="width:90%" clearable filterable>
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>
                </el-form-item>
                <el-form-item label="入库类型">
                        <el-select v-model="queryParam.inType" clearable placeholder="请选择入库类型" style="width:90%" clearable>
                                <v-yvoption groupName="comInOutStatus"></v-yvoption>
                            </el-select>
                </el-form-item>
                <el-form-item label="是否代报">
                    <el-select v-model="queryParam.agent" clearable placeholder="请选择是否代报" style="width:90%" clearable>
                                <v-yvoption groupName="isNo"></v-yvoption>
                            </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getEnterpriseList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item>
                <el-form-item>
                    <v-yvexcelimport :uploadUrl="uploadUrl"></v-yvexcelimport>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getExportUrl"><a :href="exportUrl" style="color:#fff" target="_blank">导出</a></el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary"><a :href="templateUrl" style="color:#fff" target="_blank">下载模板</a></el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
             <el-table-column prop="enterpriseCode" width="150" label="企业代码"></el-table-column>
             <el-table-column prop="enterpriseName" width="260" label="企业名称"></el-table-column>
             <el-table-column prop="enterpriseType" width="150" label="企业类型">
                 <template scope="scope">
                    <v-yvtableoption groupName="enterpriseType" :trueValue="scope.row.enterpriseType"></v-yvtableoption>
                </template>
             </el-table-column>
             <el-table-column prop="industry" width="150" label="业态">
                 <template scope="scope">
                    <v-yvtableoption groupName="comIndustry" :trueValue="scope.row.industry"></v-yvtableoption>
                </template>
             </el-table-column>
             <el-table-column prop="chargeName" width="150" label="企业负责人"></el-table-column>
             <el-table-column prop="inType" width="170" label="入库类型">
                 <template scope="scope">
                    <v-yvtableoption groupName="comInOutStatus" :trueValue="scope.row.inType"></v-yvtableoption>
                </template>
             </el-table-column>
             <el-table-column prop="agent" width="150" label="是否代报">
                 <template scope="scope">
                    <v-yvtableoption groupName="isNo" :trueValue="scope.row.agent"></v-yvtableoption>
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
                        <el-form-item label="企业代码" prop="enterpriseCode">
                            <el-input v-model="subform.enterpriseCode" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="企业名称" prop="enterpriseName">
                            <el-input v-model="subform.enterpriseName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                
                <el-col :span='12'>
                        <el-form-item label="企业类型" prop="enterpriseType">
                            <el-select v-model="subform.enterpriseType" placeholder="请选择企业类型">
                                <v-yvoption groupName="enterpriseType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="业态" prop="industry">
                            <el-select v-model="subform.industry" placeholder="请选择企业业态">
                                <v-yvoption groupName="comIndustry"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="企业负责人" prop="chargeName">
                            <el-input v-model="subform.chargeName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="负责人电话" prop="chargeMobile">
                            <el-input v-model="subform.chargeMobile" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="所属乡镇" prop="townshipId">
                            <el-select v-model="subform.townshipId" placeholder="请选择所属乡镇" @change="changeUserCon" filterable>
                                <v-yvoption tableName="township" label="name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    </el-row>
                    <el-row>
                <el-col :span='12'>
                        <el-form-item label="统计员ID" prop="userId">
                            <el-select v-model="subform.userId" placeholder="请先选择乡镇后选择统计员" filterable clearable>
                                <v-yvoption tableName="user" label="nick_name" value='id' :dataList="dataList"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                   
                <el-col :span='12'>
                        <el-form-item label="入库类型" prop="inType">
                            <el-select v-model="subform.inType" placeholder="请选择入库类型">
                                <v-yvoption groupName="comInOutStatus"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="是否代报" prop="agent">
                            <el-select v-model="subform.agent" placeholder="请选择是否代报">
                                <v-yvoption groupName="isNo"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                    <el-form-item label="入库时间" prop="inDate">
                        <el-date-picker type="date" placeholder="选择入库日期" v-model="subform.inDate"></el-date-picker>
                    </el-form-item>
                </el-col>
                <el-col :span='12'>
                    <el-form-item label="出库时间" prop="outDate">
                        <el-date-picker type="date" placeholder="选择出库日期" v-model="subform.outDate"></el-date-picker>
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
    createEnterprise,
    getEnterpriseList,
    editEnterprise,
    delEnterprise,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import vYvexcelimport from '../../common/yvexcelimport.vue';
import {checkRequire,validNum} from '../../../utils/validator.js'
export default {
    data() {
            return {
                uploadUrl: base + "/enterprises/import",
                exportUrl: base+"/enterprises/export",
                templateUrl: base + "/enterprises/exportTpl",
                dataList:"",
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
                    id: '',
                    enterpriseName: '',
                    enterpriseCode:'',
                    townshipId:'',
                    enterpriseType:'',
                    industry:'',
                    userId:'',
                    inType:'',
                    agent:'',
                },
                subform:{},
                initform: {
                   id:'',
                   enterpriseCode:'',
                   enterpriseName:'',
                   townshipId:0,
                   enterpriseType:0,
                   industry:0,
                   chargeName:'',
                   chargeMobile:'',
                   userId:'',
                   inDate:'',
                   outDate:'',
                   inType:0,
                   agent:0,
                },
                formRules: {
                    enterpriseCode:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    enterpriseName:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    chargeName:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    chargeMobile:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    townshipId:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    enterpriseType:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    industry:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    userId:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    inType:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    agent:[{validator:checkRequire, required: true,trigger: 'blur'}],
                },
                queryRules: {
                    id: [{
                        validator: validNum,
                        trigger: 'blur'
                    }],
                },
                formLoading: false
            }
        },
        components:{
            vYvoption,
            vYvtableoption,
            vYvexcelimport
        },
        methods: {
            getExportUrl(){
                this.exportUrl=base+"/enterprises/export?id="+this.queryParam.id+"&enterpriseName="+this.queryParam.enterpriseName+"&townshipId="+this.queryParam.townshipId+"&enterpriseType="+this.queryParam.enterpriseType+"&industry="+this.queryParam.industry+"&userId="+this.queryParam.userId+"&inType="+this.queryParam.inType+"&agent="+this.queryParam.agent;
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
                    this.dataList="{role_id:3,township_id:"+this.subform.townshipId+"}";
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
                    delEnterprise(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getEnterpriseList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getEnterpriseList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            enterpriseName: this.queryParam.enterpriseName,
                            enterpriseCode: this.queryParam.enterpriseCode,
                            townshipId:this.queryParam.townshipId,
                            enterpriseType:this.queryParam.enterpriseType,
                            industry:this.queryParam.industry,
                            userId:this.queryParam.userId,
                            inType:this.queryParam.inType,
                            agent:this.queryParam.agent
                        }
                        getEnterpriseList(params).then((res) => {
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
                this.getEnterpriseList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editEnterprise(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getEnterpriseList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createEnterprise(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getEnterpriseList();
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
                    delEnterprise(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getEnterpriseList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            changeUserCon(){
                this.dataList="{role_id:3,township_id:"+this.subform.townshipId+"}";
                // this.subform.userId="";
            }
        },
        mounted: function() {
            this.getEnterpriseList()
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
