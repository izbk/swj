<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 系统管理</el-breadcrumb-item>
                <el-breadcrumb-item>文章管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="标题">
                    <el-input v-model="queryParam.title" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="内容类型">
                    <el-select v-model="queryParam.articleType" clearable placeholder="请选择内容类型">
                        <v-yvoption groupName="articleType"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="文章种类">
                    <el-cascader :options="dataTree" clearable :show-all-levels="false" :props="defaultProps" expand-trigger="hover" v-model="queryParam.articleCategorys"></el-cascader>
                </el-form-item>
                <el-form-item label="部门ID">
                    <el-select v-model="queryParam.departIds" clearable placeholder="请选择部门">
                        <v-yvoption tableName="department" label="departname" value='id'></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="状态">
                    <el-select v-model="queryParam.status" clearable placeholder="请选择状态">
                        <v-yvoption groupName="articleStatus"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="创建人">
                    <el-select v-model="queryParam.createBy" filterable clearable placeholder="请选择创建人">
                        <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getArticleList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
            <el-table-column prop="articleType" width="150" label="内容类型">
                <template scope="scope">
                    <v-yvtableoption groupName="articleType" :trueValue="scope.row.articleType"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="articleCategory" width="220" label="文章种类">
                <template scope="scope">
                    <v-yvtableoption tableName="article_category" label="name" value='id' :trueValue="scope.row.articleCategory"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="title" width="300" label="内容标题"></el-table-column>
            <el-table-column prop="author" width="140" label="内容作者"></el-table-column>
            <el-table-column prop="status" width="180" label="状态">
                <template scope="scope">
                    <v-yvtableoption groupName="articleStatus" :trueValue="scope.row.status"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="createTime" label="创建时间" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.createTime|time }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="isPublic" width="130" label="是否公开">
                <template scope="scope">
                    <v-yvtableoption groupName="isNo" :trueValue="scope.row.isPublic"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column label="操作" fixed="right" width="180">
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
        <el-dialog :title="formTittle" v-model="formVisible" :close-on-click-modal="false" size="big">
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
                        <el-form-item label="内容类型" prop="articleType">
                            <el-select v-model="subform.articleType" placeholder="请选择内容类型">
                                <v-yvoption groupName="articleType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="文章种类" prop="articleCategorys">
                            <el-cascader :options="dataTree" :show-all-levels="false" :props="defaultProps" expand-trigger="hover" v-model="subform.articleCategorys"></el-cascader>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="是否公开" prop="isPublic">
                            <el-select v-model="subform.isPublic" placeholder="请选择是否公开">
                                <v-yvoption groupName="isNo"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="部门ID" prop="departIds">
                            <el-select v-model="subform.departIds" placeholder="请选择部门" disabled>
                                <v-yvoption tableName="department" label="departname" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="状态" prop="status">
                            <el-select v-model="subform.status" placeholder="请选择状态 ">
                                <v-yvoption groupName="articleStatus"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="置顶级别" prop="topLevel">
                            <el-input v-model="subform.topLevel" :maxlength=20 auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="创建人" prop="createBy">
                            <el-select v-model="subform.createBy" placeholder="请选择创建人" disabled>
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="创建时间" prop="createTime">
                            <el-date-picker type="datetime" placeholder="选择日期" v-model="subform.createTime" disabled></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="发表日期" prop="publishTime">
                            <el-date-picker type="datetime" placeholder="选择日期" v-model="subform.publishTime" disabled></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="一级审核人" prop="audit1By">
                            <el-select disabled v-model="subform.audit1By" placeholder="请选择一级审核人">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="一级审核时间" prop="audit1Time">
                            <el-date-picker type="datetime" placeholder="选择日期" v-model="subform.audit1Time" disabled></el-date-picker>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="二级审核人" prop="audit2By">
                            <el-select disabled v-model="subform.audit2By" placeholder="请选择二级审核人">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="二级审核时间" prop="audit2Time">
                            <el-date-picker type="datetime" placeholder="选择日期" v-model="subform.audit2Time" disabled></el-date-picker>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="三级审核人" prop="audit3By">
                            <el-select disabled v-model="subform.audit3By" placeholder="请选择三级审核人">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="三级审核时间" prop="audit3Time">
                            <el-date-picker type="datetime" placeholder="选择日期" v-model="subform.audit3Time" disabled></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='24'>
                        <el-form-item label="备注" prop="remark">
                            <el-input type="textarea" :maxlength=200 v-model="subform.remark" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="内容标题" prop="title">
                            <el-input v-model="subform.title" :maxlength=30 auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="内容作者" prop="author">
                            <el-input v-model="subform.author" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='24'>
                        <el-form-item label="简介" prop="breif">
                            <el-input type="textarea" v-model="subform.breif" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span='24'>
                        <el-form-item label="内容" prop="content">
                            <!-- <quill-editor ref="myTextEditor" v-model="subform.content" :config="editorOption"></quill-editor> -->
                            <v-editor v-model="subform.content" :upload-url="uploadUrl" :input-content="inputContent"></v-editor>
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
    createArticle,
    getArticleList,
    editArticle,
    delArticle,
    getArticleCategoryTree,
    getArticleById,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
// import {
//     quillEditor
// } from 'vue-quill-editor';
import vEditor from '../../common/Editor.vue'
import {checkRequire,validNum} from '../../../utils/validator.js'
export default {
    data() {
            return {
                uploadUrl: base + "/upload/uploadEditorPic",
                editorOption: {
                    // something config
                },
                dataTree: [],
                defaultProps: {
                    children: 'children',
                    label: 'name',
                    value: 'id'
                },
                tableData: [],
                pageIndex: 1,
                pageSize: 10,
                totalCount: 0,
                loading: true,
                inputContent:"",
                sels: [],
                //form数据
                formTittle: '',
                formVisible: false,
                queryParam: {
                    id: '',
                    title: '',
                    articleType:'',
                    articleCategorys:[],
                    status:'',
                    departIds:'',
                    createBy:'',
                },
                subform:{},
                initform: {
                    id: '',
                    articleType: 0,
                    articleCategory: 0,
                    articleCategorys:[],
                    content: '',
                    breif: '',
                    source: '',
                    sourceUrl: '',
                    title: '',
                    author: '',
                    pic: '',
                    clickNum: 0,
                    commentNum: 0,
                    contentKeyword: '',
                    topLevel: 0,
                    status: 1,
                    publishTime: '',
                    departIds: '',
                    isPublic: 1,
                    createBy: 0,
                    createTime: '',
                    audit1By: 0,
                    audit1Time: '',
                    audit2By: 0,
                    audit2Time: '',
                    audit3By: 0,
                    audit3Time: '',
                    remark: '',
                },
                formRules: {
                    articleType: [{
                        validator: checkRequire,
                        required: true,
                        trigger: 'change'
                    }],
                    topLevel: [{
                        validator: validNum,
                        trigger: 'change'
                    }],
                    articleCategory: [{
                        validator: checkRequire,
                        required: true,
                        trigger: 'change'
                    }],
                    isPublic: [{
                        validator: checkRequire,
                        required: true,
                        trigger: 'change'
                    }],
                    status: [{
                        validator: checkRequire,
                        required: true,
                        trigger: 'change'
                    }],
                    title: [{
                        message: "该值不能为空",
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
            vYvtableoption,
            // quillEditor,
            vEditor
        },
        methods: {
            getTreeData() {
                let params = {};
                getArticleCategoryTree(params).then((res) => {
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
                    this.inputContent = this.subform.content;
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
                    delArticle(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getArticleList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getArticleList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            title: this.queryParam.title,
                            articleType:this.queryParam.articleType,
                            articleCategorys:this.queryParam.articleCategorys,
                            status:this.queryParam.status,
                            departIds:this.queryParam.departIds,
                            createBy:this.queryParam.createBy,
                        }
                        getArticleList(params).then((res) => {
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
                this.getArticleList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editArticle(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getArticleList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createArticle(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getArticleList();
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
                    delArticle(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getArticleList();
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
            this.getTreeData();
            this.getArticleList();
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
