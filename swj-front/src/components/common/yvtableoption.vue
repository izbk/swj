<template>
    <div class="cell">
        {{divLabel}}
    </div>
</template>
<script>
import {
    getOptions
} from '../../api/api';
export default {
    data() {
            return {
                options: [],
                divLabel:''
            }
        },
        props: {
            tableName: String,
            label: String,
            value: String,
            groupName: String,
            trueValue:Number
        },
        methods: {
            getOptions() {
                let params = {
                    tableName: this.tableName,
                    label: this.label,
                    value: this.value,
                    groupName: this.groupName
                }
                getOptions(params).then((res) => {
                    if (res.data.code == '000000') {
                        this.options = res.data.data;
                        for(let j in this.options){
                            if(this.options[j].value==this.trueValue){
                                this.divLabel=this.options[j].label;
                                break;
                            }
                            this.divLabel="";
                        }
                    } else {
                        this.$message.error(res.data.message);
                    }
                }).catch(function(error) {
                    self.$message.error('网络故障，请稍后再试');
                });
            },

        },
        watch: {
            trueValue: 'getOptions',
        },

        mounted: function() {
            this.getOptions()
        }
}
</script>
