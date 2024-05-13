<template>
  <div class="form-container">
    <el-form :data="form" ref="form" :model="form" label-width="60px">
      <el-form-item label="用户名" size="mini">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="图片" size="mini">
        <el-upload
        action="https://jsonplaceholder.typicode.com/posts/"
        list-type="picture-card"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove">
        <i class="el-icon-plus"></i>
      </el-upload>
      <el-dialog :visible.sync="dialogVisible">
        <img width="100%" :src="dialogImageUrl" alt="">
      </el-dialog>
      </el-form-item>
      <el-form-item label="身高" size="mini">
        <el-input v-model="form.height"></el-input>
      </el-form-item>
      <el-form-item label="学历" size="mini">
        <el-input v-model="form.educationLevel"></el-input>
      </el-form-item>
      <el-form-item label="职业" size="mini">
        <el-input v-model="form.occupation"></el-input>
      </el-form-item>
      <el-form-item label="爱好" size="mini">
        <el-input v-model="form.interestsHobbies"></el-input>
      </el-form-item>
      <el-form-item label="自我介绍" size="mini">
        <el-input v-model="form.selfDescription"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button size="mini"  @click="editNo">取 消</el-button>
      <el-button type="primary" size="mini" @click="addOrUpdateProfile">确 定</el-button>
    </span>
    <router-view></router-view>
  </div>
</template>

<script>
import { synRequestPost } from "../../static/request";
import { getCookie } from "/static/ZuiBlog/ZuiBlog";

export default {
  // 组件配置
  data() {
    return {
      // 数据属性
      dialogImageUrl: '',
      dialogVisible: false,
      idx: -1,
      isHave: false,
      token: '',
      tableDatas: [],
      form: {
        id: '',
        name: '',
        img: '',
        height: '',
        educationLevel: '',
        occupation: '',
        interestsHobbies: '',
        selfDescription: ''
      },
      ProfilesAddBo: {
        token: '',
        userId: '',
        name: '',
        img: '',
        height: '',
        educationLevel: '',
        occupation: '',
        interestsHobbies: '',
        selfDescription: ''
      },
      ProfilesUpdateBo: {
        token: '',
        userId: '',
        name: '',
        img: '',
        height: '',
        educationLevel: '',
        occupation: '',
        interestsHobbies: '',
        selfDescription: ''
      },
      ProfilesQueryBo: {
        token: '',
        userId: ''
      }
    }
  },
  // 生命周期钩子
  mounted() {
    const user = JSON.parse(localStorage.getItem('user'));
    this.idx = user.id;
    this.token = getCookie('token');
    this.load();
  },
  // 方法
  methods: {
    // 加载用户信息
    async load() {
      this.ProfilesQueryBo.userId = this.idx;
      var object = await synRequestPost("/profiles/queryProfilesById", this.ProfilesQueryBo);
      console.log("Loaded data from server:", object); // 调试语句
      if (object.data) {
        console.log("Data received from server:", object.data); // 调试语句
        this.form = Object.assign({}, this.form, object.data);
      }
      this.isHave = object.message === '查询成功';
    },
    // 取消编辑
    editNo() { 
      this.$router.push('/index');
    },
    // 添加或更新用户信息
    async addOrUpdateProfile() {
      if (!this.form.name || !this.form.height || !this.form.educationLevel || !this.form.occupation || !this.form.interestsHobbies || !this.form.selfDescription) {
        alert('请填写完整的表单信息');
        return;
      }
      if (this.isHave) {
        await this.updateProfile();
      } else {
        await this.addProfile();
      }
      this.load();
      alert("操作成功");
    },
    // 添加用户信息
    async addProfile() {
      this.ProfilesAddBo = {
        ...this.ProfilesAddBo,
        userId: this.idx,
        name: this.form.name,
        img: this.form.img,
        height: this.form.height,
        educationLevel: this.form.educationLevel,
        occupation: this.form.occupation,
        interestsHobbies: this.form.interestsHobbies,
        selfDescription: this.form.selfDescription
      };
      var object = await synRequestPost("/profiles/add", this.ProfilesAddBo);
      if (object.message === '查询成功') {
        this.$router.push("/home");
      }
    },
    // 更新用户信息
    async updateProfile() {
      this.ProfilesUpdateBo = {
        ...this.ProfilesUpdateBo,
        userId: this.idx,
        name: this.form.name,
        img: this.form.img,
        height: this.form.height,
        educationLevel: this.form.educationLevel,
        occupation: this.form.occupation,
        interestsHobbies: this.form.interestsHobbies,
        selfDescription: this.form.selfDescription
      };
      var object = await synRequestPost("/profiles/updateProfilesById", this.ProfilesUpdateBo);
      if (object.message === '查询成功') {
        this.$router.push("/home");
      }
    },
    // 处理移除图片
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    // 处理预览图片
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    }
  }
};
</script>

<style lang="less" scoped>
.form-container {
  max-width: 400px; /* 根据需要调整宽度 */
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  text-align: center;
}
</style>

  