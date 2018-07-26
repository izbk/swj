<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 绩效管理</el-breadcrumb-item>
                <el-breadcrumb-item>镇乡年度考核</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="乡镇">
                    <el-select v-model="queryParam.townshipId" style="width:90%" clearable>
                        <v-yvoption tableName="township" label="name" value='id'></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="年度">
                    <el-date-picker v-model="queryParam.year" align="right" clearable type="year" placeholder="选择年度" @change="queryYearChange">
                    </el-date-picker>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getTownshipAnnualDoneList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleDone">考核</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getExportUrl"><a :href="exportUrl" style="color:#fff" target="_blank">导出</a></el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
            <el-table-column prop="townshipName" label="所属镇乡" width="220"></el-table-column>
            <el-table-column prop="year" label="年度" width="150"></el-table-column>
            <el-table-column prop="totalPoint" sortable label="综合得分" width="150"></el-table-column>
            <el-table-column prop="addPoint" sortable label="限上入库排位得分" width="220"></el-table-column>
            <el-table-column prop="grossPoint" sortable label="总量排位得分" width="220"></el-table-column>
            <el-table-column prop="growthPoint" sortable label="增速排位得分" width="220"></el-table-column>
            <el-table-column prop="taskPoint" sortable label="完成任务排位得分" width="220"></el-table-column>
            <el-table-column prop="createBy" label="考核人" width="170">
                <template scope="scope">
                    <v-yvtableoption tableName="user" label="nick_name" value='id' :trueValue="scope.row.createBy"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="createTime" label="考核时间" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.createTime|time }}</span>
                </template>
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="180">
                <template scope="scope">
                    <el-button size="small" @click="handleEdit(scope.$index, scope.row)">查看</el-button>
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
        <!--考核-->
        <el-dialog title="乡镇年度考核" v-model="doneVisible" :close-on-click-modal="false" size="tiny">
            <el-form label-width="90px">
                <el-form-item label="年度">
                    <el-date-picker :editable=false :clearable=false v-model="yearFormat" align="right" type="year" placeholder="选择年度" @change="doneYearChange">
                    </el-date-picker>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="doneVisible = false">取消</el-button>
                <el-button type="primary" @click.native="doneSubmit" :loading="doneLoading">考核</el-button>
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
                        <el-form-item label="乡镇ID" prop="townshipId">
                            <el-select disabled v-model="subform.townshipId" style="width:90%">
                                <v-yvoption tableName="township" label="name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="镇乡名称" prop="townshipName">
                            <el-input readonly v-model="subform.townshipName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="年度" prop="year">
                            <el-input readonly v-model="subform.year" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="零售额完成总量" prop="retailSalesDone">
                            <el-input readonly v-model="subform.retailSalesDone" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="销售额总量" prop="salesDone">
                            <el-input readonly v-model="subform.salesDone" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="完成总量" prop="grossDone">
                            <el-input readonly v-model="subform.grossDone" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="完成进度" prop="doneRatio">
                            <el-input readonly v-model="subform.doneRatio" auto-complete="off">
                                <template slot="append">%</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="零售额增速" prop="retailSalesGrowth">
                            <el-input readonly v-model="subform.retailSalesGrowth" auto-complete="off">
                                <template slot="append">%</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="销售额增速" prop="salesGrowth">
                            <el-input readonly v-model="subform.salesGrowth" auto-complete="off">
                                <template slot="append">%</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="综合增速" prop="overallGrowth">
                            <el-input readonly v-model="subform.overallGrowth" auto-complete="off">
                                <template slot="append">%</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="总申报数" prop="totalApply">
                            <el-input readonly v-model="subform.totalApply" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="总入库数" prop="realAdd">
                            <el-input readonly v-model="subform.realAdd" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="超额完成数" prop="overfulfilledAdd">
                            <el-input readonly v-model="subform.overfulfilledAdd" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="入库得分" prop="addScore">
                            <el-input readonly v-model="subform.addScore" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="完成总量排位" prop="grossQualifying">
                            <el-input readonly v-model="subform.grossQualifying" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="完成进度排位" prop="progressQualifying">
                            <el-input readonly v-model="subform.progressQualifying" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="综合增速排位" prop="growthQualifying">
                            <el-input readonly v-model="subform.growthQualifying" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="入库得分排位" prop="addQualifying">
                            <el-input readonly v-model="subform.addQualifying" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="总量排位得分" prop="grossPoint">
                            <el-input readonly v-model="subform.grossPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="增速排位得分" prop="growthPoint">
                            <el-input readonly v-model="subform.growthPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="完成任务排位得分" prop="taskPoint">
                            <el-input readonly v-model="subform.taskPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <!--   <el-col :span='12'>
                      <el-form-item label="单位分值金额" prop="perPointValue">
                          <el-input readonly v-model="subform.perPointValue" auto-complete="off"></el-input>
                      </el-form-item>
                                   </el-col>
                  <el-col :span='12'>
                      <el-form-item label="以奖代补金额" prop="allowance">
                          <el-input readonly v-model="subform.allowance" auto-complete="off"></el-input>
                      </el-form-item>
                                   </el-col> -->
                    <el-col :span='12'>
                        <el-form-item label="完成新增限上入库排位得分" prop="addPoint">
                            <el-input readonly v-model="subform.addPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="综合得分" prop="totalPoint">
                            <el-input readonly v-model="subform.totalPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="考核人" prop="createBy">
                            <el-select disabled v-model="subform.createBy" style="width:90%" clearable>
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="考核时间" prop="createTime">
                            <el-date-picker readonly type="datetime" placeholder="选择日期" v-model="subform.createTime"></el-date-picker>
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
    createTownshipAnnualDone,
    getTownshipAnnualDoneList,
    editTownshipAnnualDone,
    delTownshipAnnualDone,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {
    validNum
} from '../../../utils/validator.js';
export default {
    data() {
            return {
                exportUrl: base + "/townshipAnnualDones/export",
                doneVisible: false,
                doneYear: "",
                doneLoading: false,
                tableData: [],
                pageIndex: 1,
                pageSize: 25,
                totalCount: 0,
                loading: true,
                sels: [],
                //form数据
                formTittle: '',
                formVisible: false,
                queryParam: {
                    id: '',
                    townshipId: '',
                    year: ''
                },
                subform: {},
                initform: {
                    id: '',
                    townshipId: 0,
                    townshipName: '',
                    year: 0,
                    retailSalesDone: '',
                    salesDone: '',
                    grossDone: '',
                    doneRatio: '',
                    retailSalesGrowth: '',
                    salesGrowth: '',
                    overallGrowth: '',
                    totalApply: 0,
                    realAdd: 0,
                    overfulfilledAdd: 0,
                    addScore: 0,
                    grossQualifying: 0,
                    progressQualifying: 0,
                    growthQualifying: 0,
                    addQualifying: 0,
                    grossPoint: 0,
                    growthPoint: 0,
                    taskPoint: 0,
                    perPointValue: '',
                    allowance: '',
                    addPoint: 0,
                    totalPoint: 0,
                    createBy: 0,
                    createTime: '',
                },
                formRules: {
                    // id:[{validator:checkRequire, required: true,trigger: 'blur'}],
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
            yearFormat: {
                get: function() {
                    if (this.doneYear != null && this.doneYear != "") {
                        return new Date(this.doneYear.toString());
                    }
                },
                set: function(newValue) {
                    this.doneYear = newValue;
                }
            }
        },
        methods: {
            getExportUrl() {
                this.exportUrl = base + "/townshipAnnualDones/export?id=" + this.queryParam.id + "&townshipId=" + this.queryParam.townshipId + "&year=" + this.queryParam.year;
            },
            doneYearChange(val) {
                this.doneYear = val;
            },
            queryYearChange(val) {
                this.queryParam.year = val;
            },
            handleDone(index, row) {
                this.yearFormat = new Date().Format('yyyy');
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
                    delTownshipAnnualDone(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getTownshipAnnualDoneList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getTownshipAnnualDoneList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            townshipId: this.queryParam.townshipId,
                            year: this.queryParam.year
                        }
                        getTownshipAnnualDoneList(params).then((res) => {
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
                this.getTownshipAnnualDoneList()
            },
            doneSubmit() {
                const self = this;
                this.$confirm('重新考核会覆盖之前同年考核记录，确认进行考核吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        year: this.doneYear
                    };
                    this.doneLoading = true;
                    createTownshipAnnualDone(param).then((res) => {
                        this.doneLoading = false;
                        if (res.data.code == '000000') {
                            this.doneVisible = false;
                            this.getTownshipAnnualDoneList();
                            this.$message.success("考核成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editTownshipAnnualDone(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getTownshipAnnualDoneList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createTownshipAnnualDone(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getTownshipAnnualDoneList();
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
                    delTownshipAnnualDone(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getTownshipAnnualDoneList();
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
            this.getTownshipAnnualDoneList()
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
