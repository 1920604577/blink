<template>
    <div>
        <el-table :data="tableDatas" style="width: 100%">
            <el-table-column prop="id" label="ID" width="150">
            </el-table-column>
            <el-table-column prop="username" label="用户名" width="150">
            </el-table-column>
            <el-table-column prop="sex" label="性别" width="150">
            </el-table-column>
            <el-table-column prop="birthData" label="生日" width="150">
            </el-table-column>
            <el-table-column label="操作" width="150">
                <template v-slot="scope">
                    <el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
                    <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" :visible.sync="editVisible" width="400px">
            <el-form ref="form" :model="form" label-width="60px">
            <el-form-item label="用户名" size="mini">
                <el-input v-model="form.username"></el-input>
            </el-form-item>
            <el-form-item label="性别" size="mini">
                <el-radio-group v-model="form.sex">
                <el-radio :label="0">男</el-radio>
                <el-radio :label="1">女</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="生日" size="mini">
                <el-date-picker type="date" placeholder="选择日期" v-model="form.birthData" style="width: 100%;"></el-date-picker>
            </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
            <el-button size="mini"  @click="editVisible = false">取 消</el-button>
            <el-button type="primary" size="mini" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>

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
    name: 'User',
    data() {
        return {
            token: '', // 初始化 token 为空字符串
            user: JSON.parse(localStorage.getItem("user")),
            dialogFormVisible: false,
            editVisible: false,
            tableDatas: [],
            DeleteUserByIdBo: {
                token: '',
                id: -1,
            },
            form: {
                // 编辑框信息
                id: '',
                username: '',
                sex: '',
                birthData: '',
            },
            UserUpdateBo: {
                token: '',
                id: '',
                username: '',
                sex: '',
                birthData: '',
            },
            pageSize: 5, // 页数
            currentPage: 1, // 当前页
            idx: -1
        }
    },
    computed: {
         // 计算当前表格中的数据
        data () {
            return this.tableDatas.slice((this.currentPage - 1) * this.pageSize, this.currentPage * this.pageSize)
        }
    },
    mounted(){
        // 在 created 钩子中设置 token 和 tokenBo
        this.token = getCookie('token');
        // console.log(this.token);
        this.tokenBo = {
            token: this.token
        };
        // console.log(this.token);
        // 加载数据
        this.load();
    },
    methods: {
        // 获取当前页
        handleCurrentChange (val) {
            this.currentPage = val
        },
        async load() {
            var object = await synRequestPost("/user/findAll?token=" + this.token);
            this.tableDatas = object.data;
            console.log(object);
        },
        async handleDelete(id) {
            this.DeleteUserByIdBo.id = id;
            this.DeleteUserByIdBo.token = this.token;
            var object = await synRequestPost("/user/deleteUserById", this.DeleteUserByIdBo);
            alert(object.message);
            this.load();
        },
        // 编辑
        handleEdit (row) {
            this.editVisible = true
            this.idx = row.id
            let datetime = row.birthData
            this.form = {
                id: row.id,
                username: row.username,
                sex: row.sex,
                birthData: datetime,
            }
        },
        // 保存编辑
        async saveEdit () {
            let d = new Date(this.form.birthData)
            let datetime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate()
            this.UserUpdateBo.token = this.token;
            this.UserUpdateBo.id = this.form.id;
            this.UserUpdateBo.username = this.form.username;
            this.UserUpdateBo.sex = this.form.sex;
            this.UserUpdateBo.birthData = datetime;
            var object = await synRequestPost("/user/updateUserById", this.UserUpdateBo);
            alert(object.message)
            this.editVisible = false
            this.load();
        },
    }
}
</script>

<style lang="less" scoped>
</style>
