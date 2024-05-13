<template>
  <div>
    <el-table :data="tableDatas" style="width: 100%">
        <el-table-column prop="name" label="用户名" width="150">
        </el-table-column>
        <el-table-column prop="sex" label="性别" width="100">
            <template v-slot="scope">
                {{ getGender(scope.row.sex) }}
            </template>
        </el-table-column>
        <el-table-column prop="img" label="照片" width="150">
        </el-table-column>
        <el-table-column prop="height" label="身高" width="150">
        </el-table-column>
        <el-table-column prop="educationLevel" label="学历" width="150">
        </el-table-column>
        <el-table-column prop="occupation" label="职业" width="150">
        </el-table-column>
        <el-table-column prop="interestsHobbies" label="爱好" width="150">
        </el-table-column>
        <el-table-column prop="selfDescription" label="自我介绍" width="150">
        </el-table-column>
        <el-table-column label="操作" width="150">
            <template v-slot="scope">
                <el-button size="mini" @click="handleEdit(scope.row)">发送邀请</el-button>
            </template>
        </el-table-column>
    </el-table>

    <!-- 编辑弹出框 -->
    <el-dialog title="编辑" :visible.sync="editVisible" width="400px">
        <el-form ref="forms" :model="forms" label-width="70px">
        <el-form-item label="邀请信" size="mini">
            <el-input v-model="forms.message" type="textarea"></el-input>
        </el-form-item>
        <el-form-item label="邀请日期" size="mini">
            <el-date-picker type="date" placeholder="选择日期" v-model="forms.invitationDate" style="width: 100%;"></el-date-picker>
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
    data() {
        return {
            token: '', // 初始化 token 为空字符串
            user: JSON.parse(localStorage.getItem("user")),
            dialogFormVisible: false,
            editVisible: false,
            tableDatas: [],
            forms: {
                id: '',
                senderId: '',
                receiverId: '',
                message: '',
                invitationDate: ''
            },
            form: {
                // 编辑框信息
                id: '',
                userId: '',
                name: '',
                img: '',
                height: '',
                educationLevel: '',
                occupation: '',
                interestsHobbies: '',
                selfDescription: '',
            },
            DatingInvitationsAddBo: {
                token: '',
                senderId: '',
                receiverId: '',
                message: '',
                invitationDate:''
            },
            pageSize: 5, // 页数
            currentPage: 1, // 当前页
            idx: -1
        }
    },
    mounted() {
        // 在 created 钩子中设置 token 和 tokenBo
        this.token = getCookie('token');
        // 加载数据
        this.load();
    },
    computed: {
         // 计算当前表格中的数据
        data () {
            return this.tableDatas.slice((this.currentPage - 1) * this.pageSize, this.currentPage * this.pageSize)
        }
    },
    methods: {
        // 转换性别显示
        getGender(sex) {
            return sex === 0 ? '男' : '女';
        },
        // 获取当前页
        handleCurrentChange(val) {
            this.currentPage = val
        },
        async load() {
            var object = await synRequestPost("/profiles/findAll?token=" + this.token);
            this.tableDatas = object.data.filter(item => item.userId !== this.user.id);
            console.log(object);
        },
       // 编辑
        handleEdit(row) {
            this.editVisible = true;
            this.idx = row.id;
            let datetime = row.invitationDate;
            this.forms = {
                senderId: this.user.id, // 发送者ID为当前用户ID
                receiverId: row.userId, // 接收者ID为所选用户的ID
                message: '', // 初始化邀请消息为空
                invitationDate: datetime,
            };
            console.log(this.forms);
        },
        // 保存编辑
        async saveEdit () {
            let d = new Date(this.forms.invitationDate)
            let datetime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate()
            this.DatingInvitationsAddBo.token = this.token;
            this.DatingInvitationsAddBo.senderId = this.forms.senderId;
            this.DatingInvitationsAddBo.receiverId = this.forms.receiverId;
            this.DatingInvitationsAddBo.message = this.forms.message;
            this.DatingInvitationsAddBo.invitationDate = datetime;
            var object = await synRequestPost("/datingInvitations/addDatingInvitations", this.DatingInvitationsAddBo);
            alert(object.message)
            this.editVisible = false
            this.load();
        },
    }
}
</script>

<style lang="less" scoped>

</style>