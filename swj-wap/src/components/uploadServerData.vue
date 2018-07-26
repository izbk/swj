<template>
    <div style="width:100%">
        <x-header>服务业数据上报</x-header>
        <group>
            <v-yvselect title="<span style='color:red'>*</span>数据类型"  v-model="defineIdFormat" tableName="service_define" label="index_name" labelValue='id' :dataList="dataCon" placeholder="请选择服务业数据类型" @on-change="defineIdChange" show-name></v-yvselect>

            <x-input title="<span style='color:red'>*</span>年度" text-align="right" v-model="subform.year" required :min=4 :max=4 placeholder="请输入年度例如:2016" ref="input1" :disabled="formDisabled"></x-input>

            <x-input title="<span style='color:red'>*</span>月份" placeholder="请输入月份例如:2" text-align="right" ref="input2" v-model="subform.month" required :min=1 :max=2 :disabled="formDisabled"></x-input>

            <x-input title="<span style='color:red'>*</span>本月金额(千元)" text-align="right" ref="input3" v-model="subform.currMonth" required :min=1 :max=8 :disabled="formDisabled"></x-input>

            <x-input title="<span style='color:red'>*</span>1至本月累计金额(千元)" text-align="right" ref="input4" required v-model="subform.currAmount" :min=1 :max=8 :disabled="formDisabled"></x-input>

            <x-input title="<span style='color:red'>*</span>1至本月增速(%)" text-align="right" ref="input5" v-model="subform.currAmountRise" required :max=7 :disabled="formDisabled"></x-input>

             <x-input title="<span style='color:red'>*</span>上年同期金额(千元)" text-align="right" ref="input6" v-model="subform.lastMonth" required :max=7 :disabled="formDisabled"></x-input>

              <x-input title="<span style='color:red'>*</span>上年同期1至本月金额(千元)" text-align="right" ref="input7" v-model="subform.lastAmount" required :max=7 :disabled="formDisabled"></x-input>

               <x-input title="<span style='color:red'>*</span>上年同期1至本月增速(%)" text-align="right" ref="input8" v-model="subform.lastAmountRise" required :max=7 :disabled="formDisabled"></x-input>

            <x-textarea :max="200" placeholder="当前主要问题" v-model="subform.problem" :disabled="formDisabled"></x-textarea>

            <x-textarea :max="200" placeholder="拟采取措施" v-model="subform.solution" :disabled="formDisabled"></x-textarea>


            <x-button :show-loading="formLoading" :disabled="!$refs.input1||!$refs.input1.valid||!$refs.input2.valid||!$refs.input3.valid||!$refs.input4.valid||!$refs.input5.valid||!$refs.input6.valid||!$refs.input7.valid||!$refs.input8.valid" text="提交" type="primary" @click.native="formSubmit" style="margin-top:1em"></x-button>
        </group>
    </div>
</template>
<script>
import Group from 'vux/src/components/group/index.vue'
import XInput from 'vux/src/components/x-input/index.vue'
import XButton from 'vux/src/components/x-button/index.vue'
import XHeader from 'vux/src/components/x-header/index.vue'
import Datetime from 'vux/src/components/datetime/index.vue'
import XTextarea from 'vux/src/components/x-textarea/index.vue'
import {
    createServiceForecast,
    base
} from '../api/api';
import vYvselect from '../common/yvselect.vue';
export default {
    components: {
        XHeader,
        XButton,
        Group,
        XInput,
        Datetime,
        XTextarea,
        vYvselect
    },
    computed: {

    },
    methods: {
        defineIdChange(val) {
            if (val.toString() != '0') {
                this.formDisabled = false;
            }
            this.subform.defineId = val.toString();
        },
        formSubmit() {
            const self = this;
            this.formLoading = true;
            let param = Object.assign({}, this.subform);

            createServiceForecast(param).then((res) => {
                this.formLoading = false;
                if (res.data.code == '000000') {
                    self.$vux.toast.text("上传成功");
                    window.history.go(-1);
                } else {
                    self.$vux.toast.text(res.data.message);
                }
            });
        },
    },
    mounted: function() {
    },
    data() {
        return {
            formDisabled: true,
            defineIdFormat: [{}],
            subform: {
                id: '',
                defineId: '',
                year: '',
                month: '',
                currMonth: '',
                currAmount: '',
                currAmountRise: '',
                lastMonth:'',
                lastAmount: '',
                lastAmountRise: '',
                problem:'',
                solution: ''
            },
            formLoading: false,
        }
    },
    computed: {
        dataCon() {
            let userStr = localStorage.getItem('user');
            let user = JSON.parse(userStr);
            let departId=0;
            if(user.departId){
                departId=user.departId;
            }
            return "{depart_id:"+departId+"}";
        }
    },
}
</script>
<style lang="less" scoped>
</style>
