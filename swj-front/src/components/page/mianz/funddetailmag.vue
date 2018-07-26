<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 资金管理</el-breadcrumb-item>
                <el-breadcrumb-item>项目资金拨付信息管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="所属年度">
                    <el-date-picker type="year" placeholder="选择所属年度" v-model="queryParam.year"></el-date-picker>
                </el-form-item>
                <el-form-item label="拨款去向">
                    <el-input v-model="queryParam.enterpiseName" :maxlength=30 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="资金项">
                    <el-cascader :options="dataTree" clearable :show-all-levels="false" :props="defaultProps" expand-trigger="hover" v-model="queryParam.fundIds"></el-cascader>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getFundDetailList">查询</el-button>
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
            <el-table-column prop="year" label="所属年度" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.year|year }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="fundName" label="资金名称" width="220"></el-table-column>
            <el-table-column prop="enterpiseName" label="拨款去向" width="240"></el-table-column>
            <el-table-column prop="projectName" label="项目名称" width="240"></el-table-column>
            <el-table-column prop="realApproAmount" label="实际拨款金额(千元)" width="220"></el-table-column>
            <el-table-column prop="approDate" label="拨付日期" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.approDate|date }}</span>
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
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="所属年度" prop="year">
                            <el-date-picker type="year" placeholder="选择所属年度" v-model="subform.year"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="资金项" prop="fundIds">
                            <el-cascader :disabled="modFlag" :options="dataTree" clearable :show-all-levels="false" :props="defaultProps" expand-trigger="hover" v-model="subform.fundIds"></el-cascader>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="拨款去向" prop="enterpiseName">
                            <el-input v-model="subform.enterpiseName" maxlength=50 auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="项目名称" prop="projectName">
                            <el-input v-model="subform.projectName" maxlength=50 auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="项目验收时间" prop="acceptanceDate">
                            <el-date-picker type="date" placeholder="选择日期" v-model="subform.acceptanceDate"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="应拨款金额" prop="approAmount">
                            <el-input v-model="subform.approAmount" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="实际拨款金额" prop="realApproAmount">
                            <el-input v-model="subform.realApproAmount" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="拨付时间" prop="approDate">
                            <el-date-picker type="date" placeholder="选择日期" v-model="subform.approDate"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="凭证号" prop="voucherNo">
                            <el-input v-model="subform.voucherNo" maxlength=20 auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="备注" prop="remark">
                            <el-input type="textarea" maxlength=300 v-model="subform.remark" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="创建人" prop="createBy">
                            <el-select disabled v-model="subform.createBy">
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
    createFundDetail,
    getFundDetailList,
    editFundDetail,
    delFundDetail,
    getFundTree,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {
    checkMoney,
    checkRequire,
    checkNum,
    validNum
} from '../../../utils/validator.js';
export default {
    data() {
            return {
                exportUrl: base + "/fundDetails/export",
                dataTree: [],
                defaultProps: {
                    children: 'children',
                    label: 'fundName',
                    value: 'id'
                },
                modFlag: false,
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
                    year: '',
                    enterpiseName: '',
                    fundIds: []
                },
                subform: {},
                initform: {
                    id: '',
                    year: null,
                    fundId: null,
                    fundIds: [],
                    fundName: '',
                    projectName: '',
                    enterpiseName: '',
                    approDate: '',
                    approAmount: '',
                    realApproAmount: '',
                    surplusApproAmount: '',
                    acceptanceDate: '',
                    voucherNo: '',
                    remark: '',
                    createBy: null,
                    createName: '',
                    createTime: '',
                },
                formRules: {
                    year: [{
                        validator: checkRequire,
                        required: true,
                        trigger: 'blur'
                    }],
                    fundIds: [{
                        validator: checkRequire,
                        required: true,
                        trigger: 'blur'
                    }],
                    enterpiseName: [{
                        validator: checkRequire,
                        required: true,
                        trigger: 'blur'
                    }],
                    approAmount: [{
                        validator: checkMoney,
                        required: true,
                        trigger: 'blur'
                    }],
                    realApproAmount: [{
                        validator: checkMoney,
                        required: true,
                        trigger: 'blur'
                    }],
                    approDate: [{
                        validator: checkRequire,
                        required: true,
                        trigger: 'blur'
                    }],
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
        components: {
            vYvoption,
            vYvtableoption
        },
        methods: {
            getExportUrl() {
                this.exportUrl = base + "/fundDetails/export?id=" + this.queryParam.id + "&year=" + this.queryParam.year + "&enterpiseName=" + this.queryParam.enterpiseName + "&fundIds=" + this.queryParam.fundIds;
            },
            getTreeData() {
                let params = {
                    isValid: 1
                };
                getFundTree(params).then((res) => {
                    if (res.data.code == '000000') {
                        this.dataTree = res.data.data;
                    } else {
                        this.$message.error(res.data.message);
                    }
                }).catch(function(error) {
                    self.$message.error('网络故障，请稍后再试');
                });
            },
            handleAdd(index, row) {
                this.formVisible = true;
                this.$nextTick(function() {
                    this.subform = Object.assign({}, this.initform);
                    this.$refs['subform'].resetFields();
                    this.modFlag = false;
                    this.formTittle = "新增"
                })
            },
            handleEdit(index, row) {
                this.formVisible = true;
                this.$nextTick(function() {
                    this.$refs['subform'].resetFields();
                    this.subform = Object.assign({}, row);
                    this.modFlag = true;
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
                    delFundDetail(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getFundDetailList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getFundDetailList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            year: this.queryParam.year,
                            enterpiseName: this.queryParam.enterpiseName,
                            fundIds: this.queryParam.fundIds
                        }
                        getFundDetailList(params).then((res) => {
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
                this.getFundDetailList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editFundDetail(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getFundDetailList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createFundDetail(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getFundDetailList();
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
                    delFundDetail(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getFundDetailList();
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
            this.getFundDetailList()
            this.getTreeData()
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
