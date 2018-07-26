<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 企业</el-breadcrumb-item>
                <el-breadcrumb-item>企业信息表管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id"  :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="企业名称">
                    <el-input v-model="queryParam.companyName" :maxlength=30 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="企业类型">
                            <el-select v-model="queryParam.enterpriseType" clearable placeholder="请选择企业类型">
                                <v-yvoption groupName="enterpriseType"></v-yvoption>
                            </el-select>
                        </el-form-item></br>
                <el-form-item label="行业类型">
                            <el-select v-model="queryParam.industryType" clearable placeholder="请选择行业类型">
                                <v-yvoption groupName="industryType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                <el-form-item label="是否培育企业" >
                            <el-select v-model="queryParam.isSeed" clearable placeholder="请选择是否培育企业">
                                <v-yvoption groupName="isNo"></v-yvoption>
                            </el-select>
                        </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getCompanyList">查询</el-button>
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
             <el-table-column prop="companyName" width="280" label="企业名称"></el-table-column>
            <el-table-column prop="enterpriseType" width="150" label="企业类型">
                <template scope="scope">
                    <v-yvtableoption groupName="enterpriseType" :trueValue="scope.row.enterpriseType"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="industryType" width="150" label="行业类型">
                <template scope="scope">
                    <v-yvtableoption groupName="industryType" :trueValue="scope.row.industryType"></v-yvtableoption>
                </template>
            </el-table-column>
             <el-table-column prop="chargeName" width="150" label="企业负责人"></el-table-column>
             <el-table-column prop="avgTurnover" width="240" label="近三年营业额均值(千元)"></el-table-column>
             <el-table-column prop="employees" width="150" label="员工人数"></el-table-column>
            <el-table-column prop="isSeed" width="170" label="是否培育企业">
                <template scope="scope">
                    <v-yvtableoption groupName="isNo" :trueValue="scope.row.isSeed"></v-yvtableoption>
                </template>
            </el-table-column>
            
            <el-table-column prop="createTime" label="创建时间" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.createTime|time }}</span>
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
                        <el-form-item label="企业名称" prop="companyName">
                            <el-input v-model="subform.companyName" auto-complete="off"></el-input>
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
                        <el-form-item label="行业类型" prop="industryType">
                            <el-select v-model="subform.industryType" placeholder="请选择行业类型">
                                <v-yvoption groupName="industryType"></v-yvoption>
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
                        <el-form-item label="主营业务" prop="mianBusiness">
                            <el-input v-model="subform.mianBusiness" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="近三年营业额均值" prop="avgTurnover">
                            <el-input v-model="subform.avgTurnover" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="员工人数" prop="employees">
                            <el-input v-model="subform.employees" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='12'>
                        <el-form-item label="是否培育企业" prop="isSeed">
                            <el-select v-model="subform.isSeed" placeholder="请选择是否培育企业">
                                <v-yvoption groupName="isNo"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="审核状态" prop="status">
                            <el-select v-model="subform.status" placeholder="请选择状态">
                                <v-yvoption groupName="auditStatus"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='12'>
                        <el-form-item label="一级审核人" prop="audit1By">
                            <el-input v-model="subform.audit1By" readonly auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="一级审核时间" prop="audit1Time">
                            <el-date-picker type="datetime" placeholder="选择日期" readonly v-model="subform.audit1Time"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    </el-row>
                    <el-row>
                    <el-col :span='12'>
                        <el-form-item label="二级审核人" prop="audit2By">
                            <el-input readonly v-model="subform.audit2By" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="二级审核时间" prop="audit2Time">
                            <el-date-picker type="datetime" placeholder="选择日期" readonly v-model="subform.audit2Time"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    </el-row>
                    <el-row>
                    <el-col :span='12'>
                        <el-form-item label="三级审核人" prop="audit3By">
                            <el-input readonly v-model="subform.audit3By" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="三级审核时间" prop="audit3Time">
                            <el-date-picker type="datetime" placeholder="选择日期" readonly v-model="subform.audit3Time"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="创建时间" prop="createTime">
                            <el-date-picker type="datetime" placeholder="选择日期" readonly v-model="subform.createTime"></el-date-picker>
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
    createCompany,
    getCompanyList,
    editCompany,
    delCompany,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {checkMoney,checkRequire,validNum,checkNum} from '../../../utils/validator.js'
export default {
    data() {
            return {
                exportUrl: base+"/companys/export",
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
                    companyName:'',
                    enterpriseType:'',
                    industryType:'',
                    isSeed:''
                },
                subform:{},
                initform: {
                   id:'',
                   companyName:'',
				   enterpriseType:'',
				   industryType:'',
                   chargeName:'',
                   chargeMobile:'',
                   mianBusiness:'',
				   avgTurnover:'',
				   employees:'',
				   isSeed:'',
				   status:'',
				   audit1By:'',
                   audit1Time:'',
				   audit2By:'',
                   audit2Time:'',
				   audit3By:'',
                   audit3Time:'',
                   createTime:'',
                },
                formRules: {
                    companyName:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    chargeName:[{validator:checkRequire, required: true,trigger: 'blur' }],
                    chargeMobile:[{validator:checkRequire, required: true,trigger: 'blur' }],
                    mianBusiness:[{validator:checkRequire, required: true,trigger: 'blur' }],
                    avgTurnover:[{validator:checkMoney, required: true,trigger: 'blur'}],
                    employees:[{validator:checkNum, required: true,trigger: 'blur'}],
                    enterpriseType:[{validator:checkRequire, required: true,trigger: 'blur' }],
                    industryType:[{validator:checkRequire, required: true,trigger: 'blur' }],
                    isSeed:[{validator:checkRequire, required: true,trigger: 'blur' }],
                    status:[{validator:checkRequire, required: true,trigger: 'blur' }],
                    
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
            vYvtableoption
        },        
        methods: {
            getExportUrl(){
                this.exportUrl=base+"/companys/export?id="+this.queryParam.id+"&companyName="+this.queryParam.companyName+"&enterpriseType="+this.queryParam.enterpriseType+"&industryType="+this.queryParam.industryType+"&isSeed="+this.queryParam.isSeed;
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
                    delCompany(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getCompanyList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getCompanyList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            companyName: this.queryParam.companyName,
                            enterpriseType: this.queryParam.enterpriseType,
                            industryType: this.queryParam.industryType,
                            isSeed: this.queryParam.isSeed,
                        }
                        getCompanyList(params).then((res) => {
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
                this.getCompanyList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editCompany(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getCompanyList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createCompany(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getCompanyList();
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
                console.log(ids);
                this.$confirm('确认删除选中记录吗？', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: ids
                    };
                    delCompany(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getCompanyList();
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
            this.getCompanyList()
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
