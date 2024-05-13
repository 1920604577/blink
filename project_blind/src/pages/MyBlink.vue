<template>
    <div>
      <el-table :data="tableDatas" style="width: 100%">
          <el-table-column prop="name" label="约会对象" width="150">
          </el-table-column>
          <el-table-column prop="eventDate" label="约会时间" width="200">
          </el-table-column>
          <el-table-column prop="location" label="约会地点" width="150">
        </el-table-column>
          <el-table-column label="操作" width="300">
              <template v-slot="scope">
                  <el-button type="primary" size="mini" @click="handleEdit(scope.row)">修改</el-button>
                  <el-button type="danger" size="mini" @click="handleEdit(scope.row)">删除</el-button>
              </template>
          </el-table-column>
      </el-table>

      <!-- 编辑弹出框 -->
      <el-dialog title="约会信息" :visible.sync="editVisible" width="400px">
        <el-form ref="form" :model="form" label-width="70px">
        <el-form-item label="约会内容" size="mini">
            <el-input v-model="form.message" type="textarea"></el-input>
        </el-form-item>
        <el-form-item label="约会地点" size="mini">
            <el-input v-model="form.location"></el-input>
        </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
        <el-button size="mini"  @click="editVisible = false">取 消</el-button>
        <el-button type="primary" size="mini" @click="saveEdit">确 定</el-button>
        </span>
      </el-dialog>
  
      <!-- 分页 -->
      <div class="pagination">
          <el-pagination
            @current-change="handleCurrentChange"
            background
            layout="total, prev, pager, next"
            :current-page="currentPage"
            :page-size="pageSize"
            :total="tableDatas.length">
          </el-pagination>
      </div>
    </div>
  </template>
  
  <script>
  import { getCookie } from "/static/ZuiBlog/ZuiBlog"
  import { synRequestPost } from "../../static/request";
  import { MessageBox } from 'element-ui';
  
  export default {
      computed: {
          // 计算当前表格中的数据
          data() {
              return this.tableDatas.slice((this.currentPage - 1) * this.pageSize, this.currentPage * this.pageSize)
          }
      },
      mounted() {
          // 在 created 钩子中设置 token 和 tokenBo
          this.token = getCookie('token');
          // 加载数据
          this.load();
      },
      data() {
          return {
              token: '', // 初始化 token 为空字符串
              user: JSON.parse(localStorage.getItem("user")),
              dialogFormVisible: false,
              editVisible: false,
              tableDatas: [],
              form: {
                  // 编辑框信息
                  id: '',
                  name: '',
                  sex: '',
                  message:'',
                  location:'',
                  eventDate: ''
              },
              DatingEventsAddBo: {
                  token: '',
                  eventDate: '',
                  message: '',
                  location: '',
                  participant1Id: '',
                  participant2Id:''
              },
              QueryAllDataByUserIdBo: {
                token: '',
                userId: ''
              },
              pageSize: 5, // 页数
              currentPage: 1, // 当前页
              idx: -1
          }
      },
      methods: {
          // 获取当前页
          handleCurrentChange(val) {
              this.currentPage = val
          },
          async load() {
              this.QueryAllDataByUserIdBo.token = this.token;
              this.QueryAllDataByUserIdBo.userId = this.user.id;
              try {
                var object = await synRequestPost("/datingEvents/queryAllByUserId", this.QueryAllDataByUserIdBo);
                this.tableDatas = object.data;
                console.log(object);
              } catch (error) {
                console.error("Error loading data:", error);
              }
          },
          // 编辑
        handleEdit (row) {
            this.editVisible = true
            this.idx = row.id
            this.form = {
                id: row.receiverId,
                message: row.message,
                location: row.location,
                eventDate: row.invitationDate
            }
        },
        // 保存编辑
        async saveEdit () {
            let d = new Date(this.form.eventDate)
            let datetime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate()
            this.DatingEventsAddBo.token = this.token;
            this.DatingEventsAddBo.eventDate = datetime;
            this.DatingEventsAddBo.message = this.form.message;
            this.DatingEventsAddBo.location = this.form.location;
            this.DatingEventsAddBo.participant1Id = this.user.id;
            this.DatingEventsAddBo.participant2Id = this.form.id;
            var object = await synRequestPost("/datingEvents/add", this.DatingEventsAddBo);
            alert(object.message)
            this.editVisible = false
            this.load();
        },
      }
  }
  </script>
  
  <style lang="less" scoped>
  </style>
  