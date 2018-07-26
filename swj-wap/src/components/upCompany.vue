<template>
    <div style="width:100%">
        <x-header>企业信息上报</x-header>
        <group>
            <x-input title="企业名称" text-align="right" v-model="subform.companyName" required :min=2 :max=15 placeholder="请输入企业名称" ref="input1">
                <span slot="label" style="color:black"><span style="color:red">*</span>企业名称</span>
            </x-input>

            <v-yvselect title="<span style='color:red'>*</span>企业类型"  v-model="enterpriseTypeFormat" groupName="enterpriseType" placeholder="请选择企业类型" @on-change="enterpriseTypeChange" show-name></v-yvselect>

            <v-yvselect title="<span style='color:red'>*</span>行业类型"  v-model="industryTypeFormat" groupName="industryType" placeholder="请选择行业类型" @on-change="industryTypeChange" show-name></v-yvselect>

            <x-input title="企业负责人" text-align="right" ref="input2" v-model="subform.chargeName" required :min=2 :max=15>
                <span slot="label" style="color:black"><span style="color:red">*</span>企业负责人</span>
            </x-input>

            <x-input title="负责人电话" text-align="right" is-type="china-mobile" ref="input3" v-model="subform.chargeMobile" required :min=8 :max=11>
                <span slot="label" style="color:black"><span style="color:red">*</span>负责人电话</span>
            </x-input>

            <x-input title="近3年营业额均值" placeholder="万元" text-align="right" ref="input4" required v-model="subform.avgTurnover" :min=1 :max=15>
                <span slot="label" style="color:black"><span style="color:red">*</span>近3年营业额均值</span>
            </x-input>

            <x-input title="员工人数" text-align="right" ref="input5" v-model="subform.employees" required :max=7>
                <span slot="label" style="color:black"><span style="color:red">*</span>员工人数</span>
            </x-input>

            <x-textarea :max="200" placeholder="主营业务" v-model="subform.mianBusiness"></x-textarea>
            <x-button :show-loading="formLoading" :disabled="!$refs.input1||!$refs.input1.valid||!$refs.input2.valid||!$refs.input3.valid||!$refs.input4.valid||!$refs.input5.valid" text="提交" type="primary" @click.native="formSubmit" style="margin-top:1em"></x-button>
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
    createCompany,
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
        industryTypeChange(val) {
            this.subform.industryType = val.toString();
        },
        enterpriseTypeChange(val) {
            this.subform.enterpriseType = val.toString();
        },
        formSubmit() {
            const self = this;
            this.formLoading = true;
            let param = Object.assign({}, this.subform);

            createCompany(param).then((res) => {
                this.formLoading = false;
                if (res.data.code == '000000') {
                    this.$vux.alert.show({
                      title: '上传成功,请妥善保存查询码',
                      content: "查询码:"+res.data.data,
                    })
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
            industryTypeFormat: [{}],
            enterpriseTypeFormat:[{}],
            subform: {
                id: '',
                    companyName: '',
                    enterpriseType: '',
                    industryType: '',
                    chargeName: '',
                    chargeMobile: '',
                    mianBusiness: '',
                    avgTurnover: '',
                    employees: '',
            },
            formLoading: false,
        }
    }
}
</script>
<style lang="less" scoped>
</style>
