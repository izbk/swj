<template>
  <div class="demo-list-box" id="demo_list_box" :style="{height: `${height}px`}">
    <x-header :left-options="{showBack: false}">上报功能</x-header>
      <flexbox :gutter="0">
        <flexbox-item :span="1/3" class="cbox vux-1px-t vux-tap-active" @click.native="go('mianzPro')">
          <div class="vux-1px-r cbox-inner">
            <i class="fa fa-handshake-o fa-3x" aria-hidden="true"></i>
            <br>
            <span>绵竹造</span>
          </div>
        </flexbox-item>
        <flexbox-item :span="1/3" class="cbox vux-1px-t vux-tap-active" @click.native="go('uploadProject')">
          <div class="vux-1px-r cbox-inner">
            <i class="fa fa-rocket fa-3x" aria-hidden="true"></i>
            <br>
            <span>项目</span>
          </div>
        </flexbox-item>
        <flexbox-item :span="1/3" class="cbox vux-1px-t vux-tap-active" @click.native="go('upCompany')">
          <div class="vux-1px-r cbox-inner">
            <i class="fa fa-fax fa-3x" aria-hidden="true"></i>
            <br>
            <span>企业备案</span>
          </div>
        </flexbox-item>
      </flexbox>
      <flexbox :gutter="0">
        <flexbox-item :span="1/3" class="cbox vux-1px-t vux-tap-active" @click.native="go('exhibitionApply')">
          <div class="vux-1px-r cbox-inner">
            <i class="fa fa-telegram fa-3x" aria-hidden="true"></i>
            <br>
            <span>会展活动报名</span>
          </div>
        </flexbox-item>
        <flexbox-item :span="1/3" class="cbox vux-1px-t vux-tap-active" @click.native="go('parkApply')">
          <div class="vux-1px-r cbox-inner">
            <i class="fa fa-eercast fa-3x" aria-hidden="true"></i>
            <br>
            <span>孵化园入园申请</span>
          </div>
        </flexbox-item>
      </flexbox>
    </div>
</template>

<script>
import XHeader from 'vux/src/components/x-header/index.vue'
import Flexbox from 'vux/src/components/flexbox/flexbox.vue'
import FlexboxItem from 'vux/src/components/flexbox/flexbox-item.vue'

export default {
  components: {
    Flexbox,
    FlexboxItem,
    XHeader
  },
  methods: {
    go (name) {
      this.$router.push(`/${name}`)
    }
  },
  data () {
    return {
      height: window.innerHeight - 46 - 53,
    }
  },
}
</script>

<style lang="less" scoped>
.cbox {
  text-align: center;
}
.cbox-inner {
  padding: 15px 0;
  width: 100%;
  height: 100%;
}
.demo-list-box {
  margin-bottom: 10px;
  background-color: #fff;
  width: 100%;
  overflow: scroll;
  -webkit-overflow-scrolling: touch;
}
</style>
