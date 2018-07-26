<template>
    <div style="width:100%">
        <x-header>社消零数据上报</x-header>
        <group>
            <popup-picker title="<span style='color:red'>*</span>企业" :data="comList" v-model="comFormat" placeholder="请选择上报企业" @on-change="comChange" show-name ref="comPicker"></popup-picker>
            <x-input title="<span style='color:red'>*</span>年度" text-align="right" @on-blur="getTongqi" ref="input1" v-model="subform.year" required :min=4 :max=4 :disabled="formDisabled"></x-input>
            <x-input title="<span style='color:red'>*</span>月份" text-align="right" @on-blur="getTongqi" ref="input2" v-model="subform.month" required :min=1 :max=2 :disabled="formDisabled"></x-input>
            <x-input title="<span style='color:red'>*</span>销售额(千元)" text-align="right" v-model="subform.sales" :disabled="formDisabled"></x-input>
            <x-input title="<span style='color:red'>*</span>零售额(千元)" text-align="right" ref="input3" v-model="subform.retailSales" required :disabled="formDisabled"></x-input>
            <x-input title="同期数(千元)" text-align="right" v-model="subform.sntqRetailSales" disabled></x-input>
            <x-button :show-loading="formLoading" :disabled="!$refs.input1||!$refs.input1.valid||!$refs.input2.valid||!$refs.input3.valid" text="提交" type="primary" @click.native="formSubmit" style="margin-top:1em"></x-button>
        </group>
    </div>
</template>
<script>
import Group from 'vux/src/components/group/index.vue'
import XInput from 'vux/src/components/x-input/index.vue'
import XButton from 'vux/src/components/x-button/index.vue'
import XHeader from 'vux/src/components/x-header/index.vue'
import PopupPicker from 'vux/src/components/popup-picker/index.vue'
// import {
//     PopupPicker,
//     XHeader,
//     Group,
//     XButton,
//     XInput
// } from 'vux'
import {
    createEnterpriseReport,
    getOptions,
    getForecastValue,
    getEnterpriseReportTqs,
    base
} from '../api/api';
export default {
    components: {
        PopupPicker,
        XHeader,
        XButton,
        Group,
        XInput
    },
    computed: {

    },
    methods: {
        checkForcast(val) {
            if (this.$refs.input1.valid && this.$refs.input2.valid) {
                this.getForecast();
            } else {
                this.subform.forecastRetailSales = ''
            }

        },
        getForecast() {
            const self = this;
            let param = Object.assign({}, this.subform);
            getForecastValue(param).then((res) => {
                if (res.data.code == '000000') {
                    this.subform.forecastRetailSales = res.data.data.currRetailSales;
                } else {
                    self.$vux.toast.text(res.data.message);
                }
            });
        },
        getOptions() {
            const self = this;
            let params = {
                tableName: 'enterprise',
                label: 'enterprise_name',
                value: 'enterprise_code',
                dataList: '{user_id:' + JSON.parse(localStorage.user).id + '}',
            }
            getOptions(params).then((res) => {
                if (res.data.code == '000000') {
                    var result = res.data.data;
                    if (result.length != 0) {
                        this.comList[0].splice(0, this.comList[0].length);
                        for (var o in result) {
                            var name = result[o].label;
                            var value = result[o].value;
                            this.comList[0].push({
                                name: name,
                                value: value
                            });
                        }
                    }
                } else {
                    self.$vux.toast.text(res.data.message);
                }
            }).catch(function(error) {
                self.$vux.toast.text('网络故障，请稍后再试');
            });
        },
        comChange(val) {
            this.subform.enterpriseCode = val.toString();
            this.subform.enterpriseName = this.$refs.comPicker.getNameValues();
            if (val.toString() != '0') {
                this.formDisabled = false;
            }
        },
        formSubmit() {
            const self = this;
            this.formLoading = true;
            let param = Object.assign({}, this.subform);

            createEnterpriseReport(param).then((res) => {
                this.formLoading = false;
                if (res.data.code == '000000') {
                    self.$vux.toast.text("上传成功");
                    window.history.go(-1);
                    this.formVisible = false;
                } else {
                    self.$vux.toast.text(res.data.message);
                }
            });
        },

        getTongqi() {
            let param = {
                enterpriseCode: this.subform.enterpriseCode,
                year: this.subform.year,
                month: this.subform.month
            };

            if (this.$refs.input1.valid && this.$refs.input2.valid) {
                getEnterpriseReportTqs(param).then((res) => {
                    if (res.data.code == '000000') {
                        this.subform.sntqRetailSales = res.data.data;
                    } else {
                        this.$vux.toast.text(res.data.message);
                    }
                });
            } else {
                this.subform.sntqRetailSales = ''
            }


        },
    },
    mounted: function() {
        this.getOptions()
    },
    data() {
        return {
            formDisabled: true,
            comList: [
                [{
                    name: '无',
                    value: '0'
                }]
            ],
            comFormat: [{}],
            subform: {
                id: '',
                enterpriseCode: '',
                enterpriseName: '',
                sales: '',
                retailSales: '',
                forecastRetailSales: '',
                sntqRetailSales: '',
                year: 0,
                month: 0,
                createTime: '',
                flag: ''
            },
            formLoading: false,
        }
    }
}
</script>
<style lang="less" scoped>
</style>
