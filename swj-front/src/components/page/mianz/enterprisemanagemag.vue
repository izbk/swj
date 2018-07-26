<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 数据上报</el-breadcrumb-item>
                <el-breadcrumb-item>企业进退库记录</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="企业编号">
                    <el-input v-model="queryParam.enterpriseCode" :maxlength=20 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="企业名称">
                    <el-input v-model="queryParam.enterpriseName" :maxlength=30 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getEnterpriseManageList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <!-- <el-button type="primary" @click="handleAdd">新增</el-button> -->
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
             <el-table-column prop="enterpriseCode" width="150" label="企业编号" ></el-table-column>
             <el-table-column prop="enterpriseName" width="240" label="企业名称" ></el-table-column>
             <el-table-column prop="inDate" width="170" label="入库时间" >
                 <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.inDate|date }}</span>
                </template>
             </el-table-column>
             <el-table-column prop="outDate" width="170" label="出库时间" >
                 <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.outDate|date }}</span>
                </template>
             </el-table-column>
             <el-table-column prop="inWay" width="170" label="入库方式">
                 <template scope="scope">
                    <v-yvtableoption groupName="inWay" :trueValue="scope.row.inWay"></v-yvtableoption>
                </template>
             </el-table-column>
             <el-table-column prop="outWay" width="170" label="出库方式">
                 <template scope="scope">
                    <v-yvtableoption groupName="outWay" :trueValue="scope.row.outWay"></v-yvtableoption>
                </template>
             </el-table-column>
            <el-table-column label="操作" width="180">
                <template scope="scope">
                    <el-button size="small" type="primary" @click="handleEdit(scope.$index, scope.row)">查看</el-button>
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
                            <el-input readonly v-model="subform.id" auto-complete="off" disabled></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="企业编号" prop="enterpriseCode">
                            <el-input readonly v-model="subform.enterpriseCode" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="企业名称" prop="enterpriseName">
                            <el-input readonly v-model="subform.enterpriseName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="入库时间" prop="inDate">
                            <el-date-picker type="date" placeholder="选择日期" readonly v-model="subform.inDate" disabled></el-date-picker>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="出库事件" prop="outDate">
                        <el-date-picker type="date" placeholder="选择日期" readonly v-model="subform.outDate" disabled></el-date-picker>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="入库方式" prop="inWay">
                            <el-select readonly v-model="subform.inWay">
                                <v-yvoption groupName="inWay"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="出库方式" prop="outWay">
                            <el-select readonly v-model="subform.outWay">
                                <v-yvoption groupName="outWay"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                
            </el-row>
            <el-row>
                <el-col :span='24'>
                        <el-form-item label="备注" prop="remark">
                            <el-input type="textarea" readonly v-model="subform.remark" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
            </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="formVisible = false">取消</el-button>
                <!-- <el-button type="primary" @click.native="formSubmit" :loading="formLoading">提交</el-button> -->
            </div>
        </el-dialog>
    </div>
</template>
<script>
import {
    createEnterpriseManage,
    getEnterpriseManageList,
    editEnterpriseManage,
    delEnterpriseManage,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {checkMonth,checkMoney,checkRequire,checkPersent,validNum} from '../../../utils/validator.js'
export default {
    data() {
            return {
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
                    enterpriseCode:'',
                    enterpriseName: ''
                },
                subform: {
                   id:'0',
                   enterpriseCode:'',
                   enterpriseName:'',
                   inDate:'',
                   outDate:'',
                   inWay:'0',
                   outWay:'0',
                   remark:'',
                },
                formRules: {

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
            inWayFormatter(row, column) {
                return row.inWay == 0 ? '年审入库' :  '未知';
            },
            outWayFormatter(row, column) {
                return row.outWay == 0 ? '正常出库' : row.outWay == 1 ? '破产吊销' : '未知';
            },
            handleAdd(index, row) {
                this.formVisible = true;
                this.upPercentage = 0;
                this.upFlag = '';
                this.subform = {
                    id:'0',
                    enterpriseCode:'',
                    enterpriseName:'',
                    inDate:'',
                    outDate:'',
                    inWay:'0',
                    outWay:'0',
                    remark:'',
                };
                this.formTittle = "新增"
            },
            handleEdit(index, row) {
                this.formVisible = true;
                //this.$refs['subform'].resetFields();
                this.subform = Object.assign({}, row);
                this.formTittle = "编辑"
            },
            handleDelete(index, row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: row.id
                    };
                    delEnterpriseManage(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getEnterpriseManageList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getEnterpriseManageList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            enterpriseName: this.queryParam.enterpriseName,
                            enterpriseCode: this.queryParam.enterpriseCode
                        }
                        getEnterpriseManageList(params).then((res) => {
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
                this.getEnterpriseManageList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editEnterpriseManage(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getEnterpriseManageList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createEnterpriseManage(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getEnterpriseManageList();
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
                    delEnterpriseManage(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getEnterpriseManageList();
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
            this.getEnterpriseManageList()
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
