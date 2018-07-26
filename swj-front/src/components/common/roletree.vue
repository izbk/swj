<template>
    <div>
        <el-dialog title="分配权限" v-model="myMenuFormVisible" :close-on-click-modal="false" size="tiny">
            <el-tree :data="treedata" default-expand-all show-checkbox node-key="id" :default-expanded-keys="expandedIds" :default-checked-keys="checkedIds" :props="defaultProps" ref="tree">
            </el-tree>
            <div slot="footer" style="padding: 0px 20px 15px;text-align: right;box-sizing: border-box;">
                <el-button @click.native="myMenuFormVisible = false">取消</el-button>
                <el-button type="primary" @click.native="treeSubmit" :loading="treeLoading">提交</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script>
import {
    getRoleMenu,saveRoleMenu
} from '../../api/api';
export default {
    data() {
            return {
                myMenuFormVisible: this.menuFormVisible,
                treeLoading:false,
                treedata: [],
                loading: false,
                expandedIds: [],
                checkedIds: [],
                defaultProps: {
                    children: 'children',
                    label: 'menuName'
                },

            }
        },
        props: {
            roleId: String,
            menuFormVisible: Boolean
        },
        methods: {
            getRoleMenu() {
                let params = {
                    role: this.roleId
                }
                getRoleMenu(params).then((res) => {
                    this.loading = false;
                    if (res.data.code == '000000') {
                        this.treedata = res.data.data.menuData;
                        this.expandedIds = res.data.data.expandedIds;
                        this.checkedIds = res.data.data.checkedIds;
                    } else {
                        this.$message.error(res.data.message);
                    }
                }).catch(function(error) {
                    self.loading = false;
                    self.$message.error('网络故障，请稍后再试');
                });
            },
            treeSubmit() {
                this.treeLoading = true;
                var ids =this.$refs.tree.getCheckedKeys();
                // var ids = this.$refs.tree.getCheckedNodes().map(item => item.menuId).toString();
         
                let param = {roleId:this.roleId,ids:ids};
                 saveRoleMenu(param).then((res) => {
                    this.treeLoading = false;
                    if (res.data.code == '000000') {
                        this.$message.success("保存成功");
                        this.myMenuFormVisible=false;
                    } else {
                        this.treeLoading = false;
                        this.$message.error(res.data.message);
                    }
                }).catch(function(error) {
                    self.treeLoading = false;
                    self.$message.error('网络故障，请稍后再试');
                });
            },

        },
        watch: {
            roleId: 'getRoleMenu',
            menuFormVisible(val) {
                this.myMenuFormVisible = val;
            },
            myMenuFormVisible(val) {
                this.$emit("on-visible-change", val)
            }
        },

        mounted: function() {
            this.getRoleMenu()
        }
}
</script>
