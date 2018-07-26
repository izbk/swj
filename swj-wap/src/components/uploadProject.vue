<template>
    <div style="width:100%">
        <x-header>项目上报</x-header>
        <group>
            <x-input title="项目名称" text-align="right" v-model="subform.projectName" required :min=2 :max=15 placeholder="请输入项目名称" ref="input1">
                <span slot="label" style="color:black"><span style="color:red">*</span>项目名称</span>
            </x-input>

            <v-yvselect title="<span style='color:red'>*</span>项目类型"  v-model="projectTypeFormat" groupName="projectType" placeholder="请选择项目类型" @on-change="projectTypeChange" show-name></v-yvselect>

            <x-input title="项目业主名称" text-align="right" ref="input2" v-model="subform.owner" required :min=2 :max=15>
                <span slot="label" style="color:black"><span style="color:red">*</span>项目业主名称</span>
            </x-input>

            <x-input title="法人姓名" text-align="right" ref="input3" v-model="subform.legalPerson" required :min=2 :max=15>
                <span slot="label" style="color:black"><span style="color:red">*</span>法人姓名</span>
            </x-input>

            <x-input title="联系电话" text-align="right" is-type="china-mobile" ref="input4" v-model="subform.contact" required :min=8 :max=11>
                 <span slot="label" style="color:black"><span style="color:red">*</span>联系电话</span>
            </x-input>

            <x-input title="建设地点" text-align="right" v-model="subform.address" :min=2 :max=15></x-input>

            <x-input title="用地面积(㎡)" text-align="right" v-model="subform.landArea" :max=4></x-input>

            <x-input title="建筑面积(㎡)" text-align="right" v-model="subform.buildingArea" :max=4></x-input>

            <x-input title="营业面积(㎡)" text-align="right" v-model="subform.businessArea" :max=4></x-input>

            <datetime v-model="subform.plannedStartDate" title="计划开工日期"></datetime>

            <datetime v-model="subform.plannedCompletionTime" title="计划完工日期"></datetime>

            <x-input title="计划投资(万元)" text-align="right" v-model="subform.planInvestment" :max=6></x-input>

            <x-input title="项目批复文号" text-align="right" v-model="subform.recordNum" :max=15></x-input>

            <x-input title="批复总投资(万元)" text-align="right" v-model="subform.approveInvestment" :max=6></x-input>

            <x-input title="自筹(万元)" text-align="right" v-model="subform.raise" :max=6></x-input>

            <x-input title="贷款(万元)" text-align="right" v-model="subform.loan" :max=6></x-input>

            <x-input title="其他(万元)" text-align="right" v-model="subform.other" :max=6></x-input>

            <v-yvselect title="是否分期" v-model="isStageFormat" groupName="isNo" placeholder="请选择项目是否分期" @on-change="isStageChange" show-name></v-yvselect>

            <v-yvselect title="是否投入使用" v-model="isUseFormat" groupName="isNo" placeholder="请选择项目是否投入使用" @on-change="isUseChange" show-name></v-yvselect>

            <v-yvselect title="是否跨年度" v-model="isBeyondYearFormat" groupName="isNo" placeholder="请选择项目是否跨年度" @on-change="isBeyondYearChange" show-name></v-yvselect>

            <v-yvselect title="项目状态" v-model="buildStatusFormat" groupName="buildStatus" placeholder="请选择项目状态" @on-change="buildStatusChange"></v-yvselect>

            <x-textarea :max="200" placeholder="建设内容(必填)" v-model="subform.constructionContent"></x-textarea>

            <x-textarea :max="200" placeholder="存在困难及建议" v-model="subform.proposal"></x-textarea>

            <x-textarea :max="200" placeholder="项目建设状态评估" v-model="subform.assessment"></x-textarea>
 
            <x-button :show-loading="formLoading" :disabled="!$refs.input1||!$refs.input1.valid||!$refs.input3.valid||!$refs.input4.valid" text="提交" type="primary" @click.native="formSubmit" style="margin-top:1em"></x-button>
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
// import {
//     XHeader,
//     Group,
//     XButton,
//     XInput,
//     Datetime,
//     XTextarea
// } from 'vux'
import {
    createProject,
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
        projectTypeChange(val) {
            this.subform.projectType = val.toString();
        },
        isStageChange(val) {
            this.subform.isStage = val.toString();
        },
        isUseChange(val) {
            this.subform.isUse = val.toString();
        },
        isBeyondYearChange(val) {
            this.subform.isBeyondYear = val.toString();
        },
        buildStatusChange(val) {
            this.subform.buildStatus = val.toString();
        },
        formSubmit() {
            const self = this;
            this.formLoading = true;
            let param = Object.assign({}, this.subform);

            createProject(param).then((res) => {
                this.formLoading = false;
                if (res.data.code == '000000') {
                    this.$vux.alert.show({
                      title: '上传成功,请妥善保存查询码',
                      content: "查询码:"+res.data.data,
                    })
                    this.formVisible = false;
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
            projectTypeFormat: [{}],
            isStageFormat:[{}],
            isUseFormat:[{}],
            isBeyondYearFormat:[{}],
            buildStatusFormat:[{}],
            subform: {
                id: '',
                    projectName: '',
                    address: '',
                    plannedStartDate: '',
                    plannedCompletionTime: '',
                    landArea: '',
                    buildingArea: '',
                    businessArea: '',
                    isUse: 0,
                    isStage: 0,
                    isBeyondYear: 0,
                    projectType: 0,
                    owner: '',
                    legalPerson: '',
                    contact: '',
                    recordNum: '',
                    approveInvestment: '',
                    programInvestment: '',
                    planInvestment: '',
                    realInvestment: '',
                    raise: '',
                    loan: '',
                    other: '',
                    buildStatus: '',
                    constructionContent: '',
                    proposal: '',
                    assessment: '',
                    status: 0,
                    payStatus: 0,
            },
            formLoading: false,
        }
    }
}
</script>
<style lang="less" scoped>
</style>
