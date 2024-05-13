<template>
  <div>
    <el-table :data="tableDatas" style="width: 100%">
        <el-table-column prop="username" label="用户名" width="150">
        </el-table-column>
        <el-table-column prop="sex" label="性别" width="150">
        </el-table-column>
        <el-table-column prop="birthData" label="生日" width="200">
        </el-table-column>
        <el-table-column prop="role" label="权限" width="150">
        </el-table-column>
        <el-table-column label="操作" width="220">
            <template v-slot="scope">
                <el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
                <el-button size="mini" type="warning" @click="handleEdit(scope.row)">修改</el-button>
            </template>
        </el-table-column>
    </el-table>
    <!-- 编辑弹出框 -->
    <el-dialog title="修改权限" :visible.sync="editVisible" width="400px">
        <el-form ref="form" :model="form" label-width="60px">
        <el-form-item label="权限" size="mini">
            <el-input v-model="form.role"></el-input>
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
    name: 'admin',
    mounted () {
        this.idx = this.tableDatas.id;
    },
    data() {
        return {
            token: '', // 初始化 token 为空字符串
            admin: JSON.parse(localStorage.getItem("admin")),
            dialogFormVisible: false,
            editVisible: false,
            addVisible: false,
            tableDatas: [],
            idx: -1,
            DeleteAdminByIdBo: {
                token: '',
                id: -1,
            },
            form: {
                // 编辑框信息
                id: '',
                username: '',
                userId: '',
                role: '',
            },
            AdminAddBo: {
                token: '',
                userId: '',
                role: '',
            },
            AdminUpdateBo: {
                token: '',
                userId: '',
                role: '',
            },
            DeleteAdminByIdBo: {
                token: '',
                userId: ''
            },
            pageSize: 5, // 页数
            currentPage: 1, // 当前页
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
        //删除操作
        async handleDelete(id) {
            this.DeleteAdminByIdBo.userId = id;
            this.DeleteAdminByIdBo.token = this.token;
            var object = await synRequestPost("/admin/deleteAdminById", this.DeleteAdminByIdBo);
            alert(object.message);
            this.load();
        },
        // 获取当前页
        handleCurrentChange (val) {
            this.currentPage = val
        },
        async load() {
            var object = await synRequestPost("/admin/findAll?token=" + this.token);
            this.tableDatas = object.data;
        },
        // 编辑
        handleEdit (row) {
            this.editVisible = true
            this.idx = row.id
            this.form = {
                id: row.id,
                userId: this.idx,
                role: row.role,
            }
        },
        // 保存编辑
        async saveEdit () {
            this.AdminUpdateBo.token = this.token;
            this.AdminUpdateBo.userId = this.form.userId;
            this.AdminUpdateBo.role = this.form.role;
            var object = await synRequestPost("/admin/updateAdminById", this.AdminUpdateBo);
            alert(object.message)
            this.editVisible = false
            this.load();
        },
    }
}
</script>

<style lang="less" scoped>
</style>