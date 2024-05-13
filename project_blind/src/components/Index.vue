<template>
  <div class="swiper-demo">
    <h2>大榜前十：</h2>
    
    <!-- 如果需要前进后退按钮 -->
    <div class="swiper-button-prev" @click="swiper.slidePrev()"></div>
    <div class="swiper-button-next" @click="swiper.slideNext()"></div>

    <div v-if="banner.length" class="swiper-container">
      <div class="swiper-wrapper">
        <div v-for="item in banner" :key="item.id" class="swiper-slide">
          <img :src="item.imgUrl" class="banner-image">
        </div>
      </div>
      <!-- 如果需要分页器 -->
      <div class="swiper-pagination"></div>
    </div>
  </div>
</template>

<script>
import Swiper from 'swiper';
import 'swiper/css/swiper.min.css'
export default {
  name: 'HelloWorld',
  mounted() {
    this.swiper = new Swiper('.swiper-container', {
      // direction: 'vertical', // 垂直切换选项
      loop: true, // 循环模式选项

      // 如果需要分页器
      // pagination: {
      //   el: '.swiper-pagination',
      // },
    })
    
    // 定时任务：每隔2秒切换到下一张图片
    setInterval(() => {
      this.swiper.slideNext();
    }, 2000);
  },
  data() {
    return {
      banner: [
        { id: "1", imgUrl: require("@/assets/img/hln.jpg") },
        { id: "2", imgUrl: require("@/assets/img/crz.jpg") },
        { id: "3", imgUrl: require("@/assets/img/tbw.jpg") },
        { id: "4", imgUrl: require("@/assets/img/wyr.jpg") },
        { id: "5", imgUrl: require("@/assets/img/wzx.jpg") },
        { id: "6", imgUrl: require("@/assets/img/lpy.jpg") },
      ],
      swiper: null,
    }
  },
}
</script>

<style>
.swiper-demo {
  width: 100%;
  margin: 0 auto;
}

.swiper-container {
  width: 20%; /* 设置宽度为20% */
  height: 50%; /* 设置高度为50% */
  position: relative; /* 让内部元素可以相对于此元素定位 */
}

.banner-image {
  width: 100%;
  height: 100%;
}

.swiper-button-prev,
.swiper-button-next {
  position: absolute; /* 绝对定位 */
  top: 50%; /* 垂直居中 */
  transform: translateY(-50%); /* 垂直居中 */
  z-index: 10; /* 使其显示在轮播图上方 */
  cursor: pointer;
}

.swiper-button-prev {
  left: 10px; /* 左边距10px */
}

.swiper-button-next {
  right: 10px; /* 右边距10px */
}
</style>
