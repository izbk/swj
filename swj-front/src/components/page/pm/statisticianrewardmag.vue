<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 绩效管理</el-breadcrumb-item>
                <el-breadcrumb-item>统计员上报考核</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="年度">
                    <el-date-picker v-model="queryParam.year" align="right" clearable type="year" placeholder="选择年度" @change="queryYearChange">
                    </el-date-picker>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getStatisticianRewardList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleDone">考核</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
            <el-table-column prop="year" label="年度" width="150"></el-table-column>
            <el-table-column prop="amount" label="总金额(元)" width="150"></el-table-column>
            <el-table-column prop="totalPoint" label="总计得分" width="150"></el-table-column>
            <el-table-column prop="perPointValue" label="单位分值金额" width="170"></el-table-column>
            <el-table-column prop="createBy" label="创建人" width="220">
                <template scope="scope">
                    <v-yvtableoption tableName="user" label="nick_name" value='id' :trueValue="scope.row.createBy"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="createTime" label="创建时间" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.createTime|time }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作" width="280">
                <template scope="scope">
                    <el-button type="primary" @click="getExportUrl(scope.$index, scope.row)"><a :href="exportUrl" style="color:#fff" target="_blank">导出明细</a></el-button>
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
        <el-dialog title="统计员考核" v-model="doneVisible" :close-on-click-modal="false" size="small">
            <el-form label-width="90px">
                <el-col :span='12'>
                    <el-form-item label="考核范围">
                        <el-date-picker type="daterange" placeholder="选择日期" v-model="rangeFormat" :picker-options="rangeOption"></el-date-picker>
                    </el-form-item>
                </el-col>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="doneVisible = false">取消</el-button>
                <el-button type="primary" @click.native="doneSubmit" :loading="doneLoading">提交</el-button>
            </div>
        </el-dialog>
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
                        <el-form-item label="年度" prop="year">
                            <el-input readonly v-model="subform.year" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="开始时间" prop="startDate">
                            <el-date-picker readonly type="month" placeholder="选择日期" v-model="subform.startDate"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="结束时间" prop="endDate">
                            <el-date-picker readonly type="month" placeholder="选择日期" v-model="subform.endDate"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="总金额" prop="amount">
                            <el-input placeholder="请输入以奖代补总金额" v-model="subform.amount" auto-complete="off">
                                <template slot="append">元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="总计得分" prop="totalPoint">
                            <el-input readonly v-model="subform.totalPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="单位分值金额" prop="perPointValue">
                            <el-input readonly v-model="subform.perPointValue" auto-complete="off">
                                <template slot="append">元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="创建人" prop="createBy">
                            <el-select disabled v-model="subform.createBy" style="width:90%" clearable>
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="创建时间" prop="createTime">
                            <el-date-picker readonly type="datetime" placeholder="选择日期" v-model="subform.createTime"></el-date-picker>
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
    createStatisticianReward,
    getStatisticianRewardList,
    editStatisticianReward,
    delStatisticianReward,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {
    validNum,
    checkMoney
} from '../../../utils/validator.js';
export default {
    data() {
            return {
                exportUrl: base + "/statisticianRewards/export",
                rangeOption: {
                    shortcuts: [{
                        text: '今年',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date(new Date().getFullYear(), 0, 1);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '去年',
                        onClick(picker) {
                            const end = new Date(new Date().getFullYear() - 1, 11, 31);
                            const start = new Date(new Date().getFullYear() - 1, 0, 1);
                            picker.$emit('pick', [start, end]);
                        }
                    }]
                },
                doneVisible: false,
                doneDate: [],
                doneStart: "",
                doneEnd: "",
                doneLoading: false,
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
                    year: ''
                },
                subform: {},
                initform: {
                    id: '',
                    year: 0,
                    startDate: '',
                    endDate: '',
                    amount: '',
                    totalPoint: 0,
                    perPointValue: '',
                    createTime: '',
                    createBy: 0,
                },
                formRules: {
                    amount: [{
                        validator: checkMoney,
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
        computed: {
            rangeFormat: {
                get: function() {
                    return this.doneDate;
                },
                set: function(newValue) {
                    this.startDate = newValue[0];
                    this.endDate = newValue[1];
                    this.doneDate = newValue;
                }
            }
        },
        methods: {
            getExportUrl(index, row) {
                this.exportUrl = base + "/statisticianRewards/export?rewardId=" + row.id;
            },
            queryYearChange(val) {
                this.queryParam.year = val;
            },
            doneSubmit() {
                const self = this;
                if (this.startDate != null && this.startDate != "") {

                    this.$confirm('确认进行考核吗?', '提示', {
                        type: 'warning'
                    }).then(() => {
                        let param = {
                            startDate: this.startDate,
                            endDate: this.endDate
                        };
                        this.doneLoading = true;
                        createStatisticianReward(param).then((res) => {
                            this.doneLoading = false;
                            if (res.data.code == '000000') {
                                this.doneVisible = false;
                                this.getStatisticianRewardList();
                                this.$message.success("考核成功");
                            } else {
                                this.$message.error(res.data.message);
                            }
                        });
                    }).catch(() => {

                    });
                } else {
                    this.$message.error("请输入考核时间范围");
                }
            },
            handleDone(index, row) {
                this.doneVisible = true;
            },
            handleAdd(index, row) {
                this.formVisible = true;
                this.$nextTick(function() {
                    this.subform = Object.assign({}, this.initform);
                    this.$refs['subform'].resetFields();
                    this.formTittle = "新增"
                })
            },
            handleEdit(index, row) {
                this.formVisible = true;
                this.$nextTick(function() {
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
                    delStatisticianReward(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getStatisticianRewardList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getStatisticianRewardList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                this.loading = true;
                const self = this;
                let params = {
                    page: this.pageIndex,
                    itemcount: this.pageSize,
                    id: this.queryParam.id,
                    year: this.queryParam.year
                }
                getStatisticianRewardList(params).then((res) => {
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
                this.getStatisticianRewardList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editStatisticianReward(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getStatisticianRewardList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createStatisticianReward(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getStatisticianRewardList();
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
                    delStatisticianReward(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getStatisticianRewardList();
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
            this.getStatisticianRewardList()
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
