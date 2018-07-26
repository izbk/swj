<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 电商孵化园</el-breadcrumb-item>
                <el-breadcrumb-item>园区企业考核</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="考核月份">
                    <el-date-picker type="month" placeholder="选择日期" v-model="queryParam.assessDate"></el-date-picker>
                </el-form-item>
                <el-form-item label="经营主体名称">
                    <el-input v-model="queryParam.businessSubject" :maxlength=30 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getIncubationParkAssessmentList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">考核</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getExportUrl"><a :href="exportUrl" style="color:#fff" target="_blank">导出</a></el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
             <el-table-column prop="businessSubject" label="单位名称" width="240"></el-table-column>
            <el-table-column prop="assessDate" label="考核月份" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.assessDate|month }}</span>
                </template>
            </el-table-column>
             <el-table-column prop="attendPoint" label="出勤得分" width="150"></el-table-column>
             <el-table-column prop="teamPoint" label="团队建设得分" width="180"></el-table-column>
             <el-table-column prop="performPoint" label="业绩得分" width="150"></el-table-column>
             <el-table-column prop="deductPoint" label="扣分项得分" width="150"></el-table-column>
             <el-table-column prop="plusPoint" label="加分项得分" width="150"></el-table-column>
             <el-table-column prop="totalPoint" label="总得分" width="150"></el-table-column>
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
                    <el-col :span='12'>
                        <el-form-item label="孵化园企业" prop="ipcompanyId">
                            <el-select :disabled="modFlag" v-model="subform.ipcompanyId" filterable>
                                <v-yvoption tableName="incubation_park_company" label="business_subject" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    
                    <el-col :span='12'>
                        <el-form-item label="考核月份" prop="assessDate">
                            <el-date-picker :disabled="modFlag" type="month" placeholder="选择日期" v-model="subform.assessDate"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    </el-row>
                    <el-row>
                    <el-col :span='12'>
                        <el-form-item label="出勤天数" prop="ycqts">
                            <el-input v-model="subform.ycqts" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="出勤率" prop="attendance">
                            <el-input v-model="subform.attendance" auto-complete="off">
                                <template slot="append">%</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="出勤得分" prop="attendPoint">
                            <el-input v-model="subform.attendPoint" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='12'>
                        <el-form-item label="日均在位人数" prop="avgTeamNum">
                            <el-input v-model="subform.avgTeamNum" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="团队建设得分" prop="teamPoint">
                            <el-input v-model="subform.teamPoint" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="评估" prop="evaluate">
                            <el-input type="textarea" maxlength=800 v-model="subform.evaluate" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="业绩得分" prop="performPoint">
                            <el-input v-model="subform.performPoint" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='12'>
                        <el-form-item label="扣分项" prop="deductReason">
                            <el-select v-model="subform.deductReason" placeholder="请选择扣分项">
                                <v-yvoption groupName="deductReason"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="扣分项得分" prop="deductPoint">
                            <el-input v-model="subform.deductPoint" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="加分项" prop="plusReason">
                            <el-select v-model="subform.plusReason" placeholder="请选择加分项">
                                <v-yvoption groupName="plusReason"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="加分项得分" prop="plusPoint">
                            <el-input v-model="subform.plusPoint" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="总得分" prop="totalPoint">
                            <el-input readonly placeholder="考核后系统自动计算" v-model="subform.totalPoint" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    </el-row>
                    <el-row>
                    <el-col :span='12'>
                        <el-form-item label="备注" prop="reamrk">
                            <el-input type="textarea" maxlength=500 v-model="subform.reamrk" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='12'>
                        <el-form-item label="创建人" prop="createBy">
                            <el-input disabled v-model="subform.createBy" auto-complete="off"></el-input>
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
    createIncubationParkAssessment,
    getIncubationParkAssessmentList,
    editIncubationParkAssessment,
    delIncubationParkAssessment,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {checkMoney,checkRequire,checkNum,validNum} from '../../../utils/validator.js';
export default {
    data() {
            return {
                exportUrl: base+"/incubationParkAssessments/export",
                modFlag:false,
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
                    businessSubject:'',
                    assessDate:''
                },
                subform: {},
                initform: {
                   id:'',
				   ipcompanyId:null,
                   businessSubject:'',
                   assessDate:'',
                   ycqts:'',
                   attendance:'',
				   attendPoint:null,
                   avgTeamNum:'',
				   teamPoint:null,
                   evaluate:'',
				   performPoint:null,
                   deductReason:'',
				   deductPoint:null,
                   plusReason:'',
				   plusPoint:null,
				   totalPoint:null,
                   reamrk:'',
				   createBy:null,
                   createTime:'',
                },
                formRules: {
                    ipcompanyId:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    assessDate:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    attendPoint:[{validator:checkNum, required: true,trigger: 'blur'}],
                    teamPoint:[{validator:checkNum, required: true,trigger: 'blur'}],
                    performPoint:[{validator:checkNum, required: true,trigger: 'blur'}],
                    ycqts:[{validator:validNum, trigger: 'blur'}],
                    attendance:[{validator:validNum, trigger: 'blur'}],
                    avgTeamNum:[{validator:validNum, trigger: 'blur'}],
                    deductPoint:[{validator:validNum, trigger: 'blur'}],
					plusPoint:[{validator:validNum, trigger: 'blur'}],
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
                this.exportUrl=base+"/incubationParkAssessments/export?id="+this.queryParam.id+"&businessSubject="+this.queryParam.businessSubject+"&assessDate="+this.queryParam.assessDate;
            },
            handleAdd(index, row) {
                this.formVisible = true;
                this.$nextTick(function () {
                    this.subform = Object.assign({}, this.initform);
                    this.$refs['subform'].resetFields();
                    this.modFlag=false;
                    this.formTittle = "考核"
                })
            },
            handleEdit(index, row) {
                this.formVisible = true;
                this.$nextTick(function () {
                    this.$refs['subform'].resetFields();
                    this.subform = Object.assign({}, row);
                    this.modFlag=true;
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
                    delIncubationParkAssessment(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getIncubationParkAssessmentList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getIncubationParkAssessmentList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            businessSubject: this.queryParam.businessSubject,
                            assessDate:this.queryParam.assessDate
                        }
                        getIncubationParkAssessmentList(params).then((res) => {
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
                this.getIncubationParkAssessmentList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editIncubationParkAssessment(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getIncubationParkAssessmentList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createIncubationParkAssessment(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getIncubationParkAssessmentList();
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
                    delIncubationParkAssessment(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getIncubationParkAssessmentList();
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
            this.getIncubationParkAssessmentList()
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
