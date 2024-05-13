<template>
  <div>
    <el-table :data="tableDatas" style="width: 100%">
        <el-table-column prop="name" label="姓名" width="150">
        </el-table-column>
        <el-table-column prop="message" label="邀请内容" width="150">
        </el-table-column>
        <el-table-column prop="invitationDate" label="邀请日期" width="150">
        </el-table-column>
        <el-table-column label="操作" width="300">
            <template v-slot="scope">
                <el-button type="success" size="mini" @click="handleYes(scope.row)">同意</el-button>
                <el-button type="danger" size="mini" @click="handleNo(scope.row)">拒绝</el-button>
            </template>
        </el-table-column>
    </el-table>

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
                username: '',
                sex: '',
                birthData: '',
            },
            HandleYesBo: {
                token: '',
                id: ''
            },
            HandleNoBo: {
                token: '',
                id: ''
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
            var object = await synRequestPost("/datingInvitations/findAll?token=" + this.token);
            this.tableDatas = object.data;
            console.log(object);
        },
        async handleYes(row) { 
            this.HandleYesBo.token = this.token;
            this.HandleYesBo.id = row.id;
            var object = await synRequestPost("/datingInvitations/handleYes", this.HandleYesBo);
            console.log(object);
            if (object.message === '操作成功') {
                alert('操作成功')
            } else { 
                alert('操作失败')
            }
            this.load();
        },
        async handleNo(row) { 
            this.HandleNoBo.token = this.token;
            this.HandleNoBo.id = row.id;
            var object = await synRequestPost("/datingInvitations/handleNo", this.HandleNoBo);
            console.log(object);
            if (object.message === '操作成功') {
                alert('操作成功')
            } else { 
                alert('操作失败')
            }
            this.load();
        }
    }
}
</script>

<style lang="less" scoped>
</style>
