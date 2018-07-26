<template>
    <div>
        <el-upload
          style="height:16px"
          :action="uploadUrl"
          :before-upload="beforeUpload"
          :on-success="handleSuccess"
          :on-error="handleError"
          :show-file-list='false'>
          <el-button  type="primary" :loading="fileLoading">导入</el-button>
        </el-upload>
    </div>
</template>
<script>
import {
    base
} from '../../api/api';
export default {
    data() {
            return {
                fileLoading:false
            }
        },
        props: {
            uploadUrl: String
        },
        methods: {
            handleSuccess(res, file) {
                this.fileLoading=false;
                console.log(res)
                if(res.code == "000000"){
                    this.$message.success('导入成功!');
                }else{
                    this.$message.error(res.message);
                }
                
            },
            handleError(err, file){
                this.$message.error('导入失败!');
            },
            beforeUpload(file) {
                const fileType = "application/vnd.ms-excel application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
                console.log(file)
                console.log(file.type)
                console.log("取消类型判断")
                // const isExcel = fileType.indexOf(file.type) != '-1';
                const notNULL = file.type != '';
                const isLt20M = file.size / 1024 / 1024 < 20;
                this.fileLoading=true;
                // if (!isExcel || !notNULL) {
                //     this.$message.error('导入文件只能是excel格式!');
                //     this.fileLoading=false;
                // }
                if (!isLt20M) {
                    this.$message.error('导入文件大小不能超过 20MB!');
                    this.fileLoading=false;
                }
                
                // return isExcel && isLt20M && notNULL;
                return isLt20M;
            },

        }
}
</script>
