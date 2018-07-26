<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 系统管理</el-breadcrumb-item>
                <el-breadcrumb-item>园区企业信息管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="企业类型">
                    <el-select v-model="queryParam.companyType" clearable placeholder="请选择企业类型">
                        <v-yvoption groupName="companyType"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="经营主体名称">
                    <el-input v-model="queryParam.businessSubject" :maxlength=30 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getIncubationParkCompanyList">查询</el-button>
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
             <el-table-column prop="name" label="姓名" width="220"></el-table-column>
             <el-table-column prop="businessSubject" label="经营主体全称" width="240"></el-table-column>
            <el-table-column prop="companyType" label="企业类型" width="240">
                <template scope="scope">
                    <v-yvtableoption groupName="companyType" :trueValue="scope.row.companyType"></v-yvtableoption>
                </template>
            </el-table-column>
             <el-table-column prop="rooms" label="办公室数量" width="150"></el-table-column>
             <el-table-column prop="areas" label="仓储面积" width="150"></el-table-column>
             <el-table-column prop="teamNumber" label="入驻团队人数" width="180"></el-table-column>
            <el-table-column prop="companyStatus" label="状态" width="180">
                <template scope="scope">
                    <v-yvtableoption groupName="companyStatus" :trueValue="scope.row.companyStatus"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="inDate" label="入园日期" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.inDate|date }}</span>
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
                        <el-form-item label="主键ID" prop="id" >
                            <el-input v-model="subform.id" auto-complete="off" disabled></el-input>
                        </el-form-item>
                    </el-col>
                    </el-row>
                    <el-row>
                    <el-col :span='12'>
                        <el-form-item label="企业类型" prop="companyType">
                            <el-select v-model="subform.companyType" placeholder="请选择企业类型">
                                <v-yvoption groupName="companyType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                 <el-col :span='12'>
                        <el-form-item label="经营主体全称" prop="businessSubject">
                            <el-input v-model="subform.businessSubject" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="姓名" prop="name">
                            <el-input v-model="subform.name" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="联系电话" prop="mobile">
                            <el-input v-model="subform.mobile" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    
                    <el-col :span='12'>
                        <el-form-item label="法人" prop="legalPerson">
                            <el-input v-model="subform.legalPerson" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    
                    <el-col :span='12'>
                        <el-form-item label="办公室数量" prop="rooms">
                            <el-input v-model="subform.rooms" auto-complete="off">
                                <template slot="append">间</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="仓储面积" prop="areas">
                            <el-input v-model="subform.areas" auto-complete="off">
                                <template slot="append">㎡</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="经营范围" prop="businessScope">
                            <el-input v-model="subform.businessScope" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="入驻团队人数" prop="teamNumber">
                            <el-input v-model="subform.teamNumber" auto-complete="off">
                                <template slot="append">人</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='12'>
                        <el-form-item  label="项目简介" prop="projectIntroduction">
                            <el-input type="textarea" v-model="subform.projectIntroduction" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="企业简介" prop="companyDesc">
                            <el-input type="textarea" v-model="subform.companyDesc" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="企业评价" prop="evaluate">
                            <el-input type="textarea" v-model="subform.evaluate" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="发展规划" prop="development">
                            <el-input  type="textarea" v-model="subform.development" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="入园审查意见" prop="ecExamination">
                            <el-input type="textarea" v-model="subform.ecExamination" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="状态" prop="companyStatus">
                            <el-select v-model="subform.companyStatus" placeholder="请选择状态">
                                <v-yvoption groupName="companyStatus"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='12'>
                        <el-form-item label="入园日期" prop="inDate">
                            <el-date-picker type="date" placeholder="选择日期" v-model="subform.inDate"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="出园日期" prop="outDate">
                            <el-date-picker type="date" placeholder="选择日期" v-model="subform.outDate"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="出园原因" prop="outReason">
                            <el-input type="textarea" v-model="subform.outReason" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="备注" prop="remark">
                            <el-input type="textarea" v-model="subform.remark" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="创建人" prop="createBy">
                            <el-select disabled v-model="subform.createBy" placeholder="">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="创建时间" prop="createTime">
                            <el-date-picker disabled type="datetime" placeholder="选择日期" v-model="subform.createTime"></el-date-picker>
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
    createIncubationParkCompany,
    getIncubationParkCompanyList,
    editIncubationParkCompany,
    delIncubationParkCompany,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {checkMoney,checkRequire,validNum} from '../../../utils/validator.js';
export default {
    data() {
            return {
                exportUrl: base+"/incubationParkCompanys/export",
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
                    companyType:'',
                    businessSubject:'',
                },
                subform: {},
                initform: {
                   id:'',
                   name:'',
                   mobile:'',
                   businessSubject:'',
                   legalPerson:'',
				   companyType:0,
				   rooms:0,
                   areas:'',
                   businessScope:'',
				   teamNumber:0,
                   projectIntroduction:'',
                   companyDesc:'',
                   evaluate:'',
                   development:'',
                   ecExamination:'',
				   companyStatus:0,
                   inDate:'',
                   outDate:'',
                   outReason:'',
                   remark:'',
				   createBy:0,
                   createTime:'',
                },
                formRules: {
                    name:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    mobile:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    businessSubject:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    companyType:[{validator:checkRequire, required: true,trigger: 'blur'}],
					companyStatus:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    applicationRoom:[{validator:validNum,trigger: 'blur'}],
                    applicationArea:[{validator:validNum,trigger: 'blur'}],
                    teamNumber:[{validator:validNum,trigger: 'blur'}],
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
                this.exportUrl=base+"/incubationParkCompanys/export?id="+this.queryParam.id+"&companyType="+this.queryParam.companyType+"&businessSubject="+this.queryParam.businessSubject;
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
                    delIncubationParkCompany(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getIncubationParkCompanyList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getIncubationParkCompanyList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            companyType: this.queryParam.companyType,
                            businessSubject: this.queryParam.businessSubject
                        }
                        getIncubationParkCompanyList(params).then((res) => {
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
                this.getIncubationParkCompanyList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editIncubationParkCompany(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getIncubationParkCompanyList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createIncubationParkCompany(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getIncubationParkCompanyList();
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
                    delIncubationParkCompany(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getIncubationParkCompanyList();
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
            this.getIncubationParkCompanyList()
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
