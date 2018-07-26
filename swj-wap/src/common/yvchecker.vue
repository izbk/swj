<template>
    <div>
        <checker v-model="currentValue" type="checkbox" default-item-class="item" selected-item-class="item-selected">
            <checker-item v-for="item in options" :value="item.value" :key="item.value">{{item.name}}</checker-item>
          </checker>
    </div>
</template>
<script>
import {
    getOptions
} from '../api/api';
import Checker from 'vux/src/components/checker/checker.vue'
import CheckerItem from 'vux/src/components/checker/checker-item.vue'
export default {
    components: {
        Checker,
        CheckerItem,
    },
    data() {
        return {
            options: [],

        }
    },
    props: {
        placeholder: String,
        value: Array,
        title: String,
        tableName: String,
        label: String,
        groupName: String,
        dataList: String,
        labelValue:String,
    },
    methods: {
        onPickerChange (val) {
          this.$emit('on-change', val)
        },
        getOptions() {
            const self = this;
            let params = {
                tableName: this.tableName,
                label: this.label,
                value: this.labelValue,
                groupName: this.groupName,
                dataList: this.dataList,
            }
            getOptions(params).then((res) => {
                if (res.data.code == '000000') {
                    var result = res.data.data;
                    if (result.length != 0) {
                        for (var o in result) {
                            var name = result[o].label;
                            var value = result[o].value;
                            this.options.push({
                                name: name,
                                value: value.toString()
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

    },
    computed:{
        currentValue:{
            get:function(){
                return this.value;
            },
            set:function(val){
                this.$emit('input', val)
            }
        }
    },
    
    watch: {
        groupName: 'getOptions',
        dataList: 'getOptions',
    },

    mounted: function() {
        this.getOptions()
    }
}
</script>

<style scoped>
    .item {
  border: 1px solid #ececec;
  padding: 5px 15px;
}
.item-selected {
  border: 2px solid green;
}
</style>
