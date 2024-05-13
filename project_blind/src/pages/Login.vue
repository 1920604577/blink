<template>
  <div class="login-wrap">
    <div class="ms-title">hln - 后台管理系统</div>
    <div class="ms-login">
      <el-form
        :model="ruleForm"
        ref="ruleForm"
        class="demo-ruleForm"
      >
        <h2 class="mt-4">登入您的账户</h2>
        <el-form-item prop="username">
          <el-input v-model="userLoginBo.username" placeholder="username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            type="password"
            placeholder="password"
            v-model="userLoginBo.password"
            @keyup.enter.native="submitForm('ruleForm')"
          ></el-input>
        </el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="submitForm" @keyup.enter="submitForm">登录</el-button>
        </div>
        <p style="font-size:12px;line-height:30px;color:#999;">Tips : 用户名和密码要写数据库里的一致。
          <el-button type="primary" @click="goReg">注册</el-button>
        </p>
      </el-form>
    </div>
  </div>
</template>

<script>
import { setToken } from "/static/ZuiBlog/token";
import { setCookie } from "/static/ZuiBlog/ZuiBlog"
import { synRequestPost } from "../../static/request";
import { MessageBox } from 'element-ui';

export default {
  data() {
    return {
      ruleForm: {
        username: '',
        password: ''
      },
      userLoginBo: {
        username: "",
        password: ""
      },
      //按钮开关
      switchButton: false,
    };
  },
  methods: {
    goReg() { 
      this.$router.push("/userReg");
    },
    async submitForm() {
      this.switchButton = true;
      var object = await synRequestPost("/user/login", this.userLoginBo);
      console.log(object);
      if (object.code != "0x200") {
        MessageBox.alert('登录失败', '提示', {
          confirmButtonText: '确定',
          type: 'error'
        });
        alert(object.message);
        this.userLoginBo.username = "";
        this.userLoginBo.password = "";
        this.switchButton = false;
        return;
      }
      setCookie('token', object.data.token);
      console.log(object.data.token);
      localStorage.setItem("user", JSON.stringify(object.data.user));
      localStorage.setItem("role", JSON.stringify(object.data.role));
      localStorage.setItem("ms_username", object.data.user.username);
      alert(object.message);
      this.$router.push("/home");
      MessageBox.alert('登录成功', '提示', {
        confirmButtonText: '确定',
        type: 'success'
      });
      this.switchButton = false;
    }
  }
};
</script>

<style lang="less" scoped>
.login-wrap {
  position: relative; /* 修改 */
  background: url('~@/assets/img/7.jpg'); /* 修改 */
  background-attachment: fixed;
  background-position: center top -200px;
  background-size: cover;
  width: 100vw; /* 修改 */
  height: 100vh; /* 修改 */
  display: flex; /* 添加 */
  justify-content: center; /* 添加 */
  align-items: center; /* 添加 */
}
.ms-title {
  position: absolute;
  top: 50px; /* 负值将标题向上移动 */
  width: 100%;
  text-align: center;
  font-size: 30px;
  font-weight: 600;
  color: #fff;
}
.ms-login {
  width: 350px;
  height: auto; /* 修改 */
  padding: 40px;
  border-radius: 5px;
  background: rgba(255, 255, 255, 0.8); /* 修改 */
}
.login-btn {
  text-align: center;
}
.login-btn button {
  width: 100%;
  height: 36px;
}
.mt-4 {
  text-align: center;
  color: #fff; /* 文字透明 */
  background: transparent; /* 文字背景颜色 */
}
</style>
