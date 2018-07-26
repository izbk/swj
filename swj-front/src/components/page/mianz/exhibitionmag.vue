<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 会展活动</el-breadcrumb-item>
                <el-breadcrumb-item>会展活动信息管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="会展名称">
                    <el-input v-model="queryParam.exhibitionName" :maxlength=30 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="会展类别">
                <el-select v-model="queryParam.exhibitionType" clearable placeholder="请选择会展类别">
                                <v-yvoption groupName="exhibitionType"></v-yvoption>
                            </el-select>
                </el-form-item>
                </br>
                <el-form-item label="开始时间">
                    <el-date-picker type="date" placeholder="选择日期" v-model="queryParam.startDate"></el-date-picker>
                </el-form-item>
                <el-form-item label="结束时间">
                    <el-date-picker type="date" placeholder="选择日期" v-model="queryParam.endDate"></el-date-picker>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getExhibitionList">查询</el-button>
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
            <el-table-column prop="exhibitionType" label="会展类别" width="220">
                <template scope="scope">
                    <v-yvtableoption groupName="exhibitionType" :trueValue="scope.row.exhibitionType"></v-yvtableoption>
                </template>
            </el-table-column>
             <el-table-column prop="exhibitionName" label="会展名称" width="240"></el-table-column>
            <el-table-column prop="startDate" label="开始时间" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.startDate|date }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="endDate" label="结束时间" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.endDate|date }}</span>
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
                     <el-col :span='12'>
                        <el-form-item label="会展类别" prop="exhibitionType">
                            <el-select v-model="subform.exhibitionType" placeholder="请选择会展类别">
                                <v-yvoption groupName="exhibitionType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="会展名称" prop="exhibitionName">
                            <el-input v-model="subform.exhibitionName" maxlength=50 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="会展地点" prop="address">
                            <el-input v-model="subform.address" maxlength=50 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="开始时间" prop="startDate">
                            <el-date-picker type="date" placeholder="选择日期" v-model="subform.startDate"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="结束时间" prop="endDate">
                            <el-date-picker type="date" placeholder="选择日期" v-model="subform.endDate"></el-date-picker>
                        </el-form-item>
                    </el-col>
                   <el-col :span='12'>
                        <el-form-item label="是否有效" prop="isValid">
                            <el-select v-model="subform.isValid">
                                <v-yvoption groupName="isNo"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="会展介绍" prop="introduction">
                            <el-input type="textarea" maxlength=300 v-model="subform.introduction" auto-complete="off"></el-input>
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
    createExhibition,
    getExhibitionList,
    editExhibition,
    delExhibition,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {checkMoney,checkRequire,checkNum,validNum} from '../../../utils/validator.js';
export default {
    data() {
            return {
                exportUrl: base+"/exhibitions/export",
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
                    exhibitionName: '',
                    startDate:'',
                    endDate:'',
                    exhibitionType:''
                },
                subform: {},
                initform: {
                   id:'',
                   exhibitionName:'',
                   address:'',
                   startDate:'',
                   endDate:'',
				   exhibitionType:null,
                   introduction:'',
                   isValid:1,
				   createBy:null,
                   createTime:'',
                },
                formRules: {
                    exhibitionType:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    exhibitionName:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    address:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    startDate:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    endDate:[{validator:checkRequire, required: true,trigger: 'blur'}],
					isValid:[{validator:checkRequire, required: true,trigger: 'blur'}],
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
                this.exportUrl=base+"/exhibitions/export?id="+this.queryParam.id+"&exhibitionName="+this.queryParam.exhibitionName+"&exhibitionType="+this.queryParam.exhibitionType+"&startDate="+this.queryParam.startDate+"&endDate="+this.queryParam.endDate;
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
                    delExhibition(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getExhibitionList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getExhibitionList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                this.loading = true;
                const self = this;
                let params = {
                    page: this.pageIndex,
                    itemcount: this.pageSize,
                    id: this.queryParam.id,
                    exhibitionName: this.queryParam.exhibitionName,
                    startDate: this.queryParam.startDate,
                    endDate: this.queryParam.endDate,
                    exhibitionType: this.queryParam.exhibitionType,
                }
                getExhibitionList(params).then((res) => {
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
                this.getExhibitionList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editExhibition(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getExhibitionList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createExhibition(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getExhibitionList();
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
                    delExhibition(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getExhibitionList();
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
            this.getExhibitionList()
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
