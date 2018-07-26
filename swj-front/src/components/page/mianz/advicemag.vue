<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 投诉建议</el-breadcrumb-item>
                <el-breadcrumb-item>投诉建议管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=8 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="标题">
                    <el-input v-model="queryParam.adviceTitle" :maxlength=30 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="意见类型">
                    <el-select clearable v-model="queryParam.adviceType" placeholder="请选择意见类型">
                        <v-yvoption groupName="adviceType"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="处理状态">
                    <el-select clearable v-model="queryParam.isDeal" placeholder="请选择处理状态">
                        <v-yvoption groupName="isNo"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getAdviceList">查询</el-button>
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
            <el-table-column prop="adviceTitle" width="220" label="标题"></el-table-column>
            <el-table-column prop="adviceType" width="150" label="意见类型">
                <template scope="scope">
                    <v-yvtableoption groupName="adviceType" :trueValue="scope.row.adviceType"></v-yvtableoption>
                </template>
            </el-table-column>
             <el-table-column prop="name" width="150" label="姓名"></el-table-column>
             <el-table-column prop="mobile" width="150" label="电话"></el-table-column>
            <el-table-column prop="status" width="180" label="状态">
                <template scope="scope">
                    <v-yvtableoption groupName="auditStatus" :trueValue="scope.row.status"></v-yvtableoption>
                </template>
            </el-table-column>
            
            <el-table-column prop="isDeal" width="150" label="处理状态">
                <template scope="scope">
                    <v-yvtableoption groupName="isNo" :trueValue="scope.row.isDeal"></v-yvtableoption>
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
                        <el-form-item label="姓名" prop="name">
                            <el-input v-model="subform.name" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="电话" prop="mobile">
                            <el-input v-model="subform.mobile" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="邮箱" prop="email">
                            <el-input v-model="subform.email" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 <el-col :span='12'>
                        <el-form-item label="意见类型" prop="adviceType">
                            <el-select v-model="subform.adviceType" placeholder="请选择意见类型">
                                <v-yvoption groupName="adviceType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                 <el-col :span='12'>
                        <el-form-item label="创建时间" prop="createTime">
                            <el-date-picker disabled type="datetime" placeholder="选择日期" v-model="subform.createTime"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='24'>
                        <el-form-item label="标题" prop="adviceTitle">
                            <el-input v-model="subform.adviceTitle" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='24'>
                        <el-form-item label="内容" prop="adviceContent">
                            <el-input  type="textarea" rows=5 v-model="subform.adviceContent" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='24'>
                        <el-form-item label="回复" prop="resContent">
                            <el-input type="textarea" rows=5 v-model="subform.resContent" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='12'>
                        <el-form-item label="状态" prop="status">
                            <el-select v-model="subform.status" placeholder="请选择状态">
                                <v-yvoption groupName="auditStatus"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    
                    <el-col :span='12'>
                        <el-form-item label="处理状态" prop="isDeal">
                            <el-select v-model="subform.isDeal" placeholder="请选择处理状态">
                                <v-yvoption groupName="isNo"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    
                    <el-col :span='12'>
                        <el-form-item label="处理人" prop="dealBy">
                        <el-select disabled v-model="subform.dealBy" placeholder="请选择处理人" filterable>
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select> 
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="处理时间" prop="dealTime">
                            <el-date-picker disabled type="datetime" placeholder="选择日期" v-model="subform.dealTime"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <!-- <el-col :span='12'>
                        <el-form-item label="一级审核人" prop="audit1By" filterable>
                            <el-select v-model="subform.audit1By" placeholder="请选择一级审核人">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>          
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="一级审核时间" prop="audit1Time">
                            <el-date-picker type="datetime" placeholder="选择日期" v-model="subform.audit1Time"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="二级审核人" prop="audit2By" filterable>
                            <el-select v-model="subform.audit2By" placeholder="请选择二级审核人">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>          
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="二级审核时间" prop="audit2Time">
                            <el-date-picker type="datetime" placeholder="选择日期" v-model="subform.audit2Time"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    </el-row>
                    <el-row>
                    <el-col :span='12'>
                        <el-form-item label="三级审核人" prop="audit3By" filterable>
                            <el-select v-model="subform.audit3By" placeholder="请选择三级审核人">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>          
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="三级审核时间" prop="audit3Time">
                            <el-date-picker type="datetime" placeholder="选择日期" v-model="subform.audit3Time"></el-date-picker>
                        </el-form-item>
                    </el-col> -->
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
    createAdvice,
    getAdviceList,
    editAdvice,
    delAdvice,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {checkMoney,checkRequire,checkMonth,validNum} from '../../../utils/validator.js'
export default {
    data() {
            return {
                exportUrl: base+"/advices/export",
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
                    adviceTitle:'',
                    adviceType:'',
                    isDeal:''
                },
                subform:{},
                initform: {
                   id:'',
                   name:'',
                   mobile:'',
                   email:'',
                   adviceTitle:'',
                   adviceContent:'',
				   adviceType:0,
				   status:0,
                   createTime:'',
				   isDeal:0,
                   resContent:'',
				   dealBy:0,
                   dealTime:'',
				   audit1By:0,
                   audit1Time:'',
				   audit2By:0,
                   audit2Time:'',
				   audit3By:0,
                   audit3Time:'',
                },
                formRules: {
                    name: [{
                        validator: checkRequire,
                        required:true,
                        trigger: 'blur'
                    }],
                    mobile: [{
                        validator: checkRequire,
                        required:true,
                        trigger: 'blur'
                    }],
                    adviceType: [{
                        validator: checkRequire,
                        required:true,
                        trigger: 'blur'
                    }],
                    adviceTitle: [{
                        validator: checkRequire,
                        required:true,
                        trigger: 'blur'
                    }],
                    adviceContent: [{
                        validator: checkRequire,
                        required:true,
                        trigger: 'blur'
                    }],
                    status: [{
                        validator: checkRequire,
                        required:true,
                        trigger: 'blur'
                    }],
                    isDeal: [{
                        validator: checkRequire,
                        required:true,
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
        components:{
            vYvoption,
            vYvtableoption
        },        
        methods: {
            getExportUrl(){
                this.exportUrl=base+"/advices/export?id="+this.queryParam.id+"&adviceTitle="+this.queryParam.adviceTitle+"&adviceType="+this.queryParam.adviceType+"&isDeal="+this.queryParam.isDeal;
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
                    delAdvice(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getAdviceList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getAdviceList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            adviceTitle: this.queryParam.adviceTitle,
                            adviceType: this.queryParam.adviceType,
                            isDeal: this.queryParam.isDeal
                        }
                        getAdviceList(params).then((res) => {
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
                this.getAdviceList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editAdvice(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getAdviceList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createAdvice(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getAdviceList();
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
                    delAdvice(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getAdviceList();
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
            this.getAdviceList()
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
