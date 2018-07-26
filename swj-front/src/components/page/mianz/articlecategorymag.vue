<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 文章</el-breadcrumb-item>
                <el-breadcrumb-item>文章类别管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true">
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增父节点</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        
        <el-col :span="24">
        <el-tree :data="dataTree" default-expand-all :render-content='renderContent' :expand-on-click-node='false' :highlight-current='true' node-key="id" :props="defaultProps" ref="tree">
            </el-tree>
            </el-col>

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
                        <el-form-item label="父级id" prop="pid">
                            <el-input v-model="subform.pid" auto-complete="off" disabled></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="名称" prop="name">
                            <el-input v-model="subform.name" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="索引位" prop="indexId">
                            <el-input v-model="subform.indexId" auto-complete="off" disabled></el-input>
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
    createArticleCategory,
    getArticleCategoryList,
    editArticleCategory,
    delArticleCategory,
    getArticleCategoryTree,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
export default {
    data() {
            return {
                dataTree: [],
                defaultProps: {
                  children: 'children',
                  label: 'name'
                },
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
                    name: ''
                },
                subform: {
                   id:'',
				   pid:0,
                   name:'',
                   indexId:'',
                },
                formRules: {

                },
                formLoading: false
            }
        },
        components:{
            vYvoption,
            vYvtableoption
        },        
        methods: {
            renderContent(h,{node}){
                let _data=Object.assign({},node.data);
                let _tag=h("el-tag",{props:{type:"success"},domProps:{innerHTML:"菜单显示"}})
                let _bt1=h("el-button",{props:{size:"mini",type:"info"},domProps:{innerHTML:"新增下级"},on:{click:()=>(this.handleAdd(_data))}});
                let _bt2=h("el-button",{props:{size:"mini",type:"info"},domProps:{innerHTML:"编辑"},on:{click:()=>(this.handleEdit(_data))}});
                let _bt3="";
                if(node.isLeaf){
                    _bt3=h("el-button",{props:{size:"mini",type:"danger"},domProps:{innerHTML:"删除"},on:{click:()=>(this.handleDelete(_data))}});
                }
                
                let _btns=h("span",{class:'pull-right'},[_bt1,_bt2,_bt3]);
                return h('span',[_data.name,_btns]);
            },
            getTreeData(){
                let params = {};
                getArticleCategoryTree(params).then((res) => {
                    if (res.data.code == '000000') {
                        this.dataTree=res.data.data;
                    } else {
                   this.$message.error(res.data.message);
                    }
                }).catch(function(error) {
                    self.$message.error('网络故障，请稍后再试');
                });
            },
            handleAdd(row) {
                this.formVisible = true;
                this.upPercentage = 0;
                this.upFlag = '';
                this.subform={
                   id:'',
				   pid:0,
                   name:'',
                   indexId:'',
                };
				this.subform.pid=row.id;
                this.formTittle = "新增"
            },
            handleEdit(row) {
                this.formVisible = true;
                this.subform = Object.assign({}, row);
                this.$refs['subform'].resetFields();
                this.formTittle = "编辑"
            },
            handleDelete( row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: row.id
                    };
                    delArticleCategory(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getTreeData();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getArticleCategoryList() {
                this.loading = true;
                const self = this;
                let params = {
                    page: this.pageIndex,
                    itemcount: this.pageSize,
                    id: this.queryParam.id,
                    name: this.queryParam.name
                }
                getArticleCategoryList(params).then((res) => {
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
            },
            handleCurrentChange(val) {
                this.pageIndex = val;
                this.getTreeData();
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editArticleCategory(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getTreeData();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createArticleCategory(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getTreeData();
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
                    delArticleCategory(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getTreeData();
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
.pull-right{
    float:right;
    margin-right: 15px;
}
</style>
