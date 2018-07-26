<template>
    <div style="width:100%">
        <x-header>重点服务业数据上报</x-header>
        <group>
            <x-input title="<span style='color:red'>*</span>年度" text-align="right" v-model="subform.year" required :min=4 :max=4 placeholder="请输入年度例如:2016" ref="input1" :disabled="formDisabled"></x-input>

            <x-input title="<span style='color:red'>*</span>月份" placeholder="请输入月份例如:2" text-align="right" ref="input2" v-model="subform.month" required :min=1 :max=2 :disabled="formDisabled"></x-input>

            <x-input title="<span style='color:red'>*</span>本月(千元)" text-align="right" ref="input3" v-model="subform.currMonth" required :min=1 :max=8 :disabled="formDisabled"></x-input>

            <x-input title="<span style='color:red'>*</span>1至本月(千元)" text-align="right" ref="input4" required v-model="subform.currMonthAmount" :min=1 :max=8 :disabled="formDisabled"></x-input>

             <x-input title="<span style='color:red'>*</span>上年同期(千元)" text-align="right" ref="input5" v-model="subform.lastMonth" required :max=7 :disabled="formDisabled"></x-input>

              <x-input title="<span style='color:red'>*</span>上年1至本月(千元)" text-align="right" ref="input6" v-model="subform.lastMonthAmount" required :max=7 :disabled="formDisabled"></x-input>

            <x-button :show-loading="formLoading" :disabled="!$refs.input1||!$refs.input1.valid||!$refs.input2.valid||!$refs.input3.valid||!$refs.input4.valid||!$refs.input5.valid||!$refs.input6.valid" text="提交" type="primary" @click.native="formSubmit" style="margin-top:1em"></x-button>
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
    createSubServiceData,
    base
} from '../api/api';
export default {
    components: {
        XHeader,
        XButton,
        Group,
        XInput,
        Datetime,
        XTextarea,
    },
    methods: {
        formSubmit() {
            const self = this;
            this.formLoading = true;
            let param = Object.assign({}, this.subform);

            createSubServiceData(param).then((res) => {
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
            formDisabled: false,
            defineIdFormat: [{}],
            subform: {
                id: '',
                year: '',
                month: '',
                currMonth: '',
                currMonthAmount: '',
                lastMonth:'',
                lastMonthAmount: '',
            },
            formLoading: false,
        }
    },
}
</script>
<style lang="less" scoped>
</style>
