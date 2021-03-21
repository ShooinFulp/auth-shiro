<template lang="html">
  <div class="app-container">
    <el-card class="filter-container" shadow="never">
      <div>
        <i class="el-icon-search"></i>
        <span>筛选搜索</span>
        <el-button
          style="float:right"
          type="primary"
          @click="handleSearchList()"
          size="small"
        >
          查询搜索
        </el-button>
        <el-button
          style="float:right;margin-right: 15px"
          @click="handleResetSearch()"
          size="small"
        >
          重置
        </el-button>
      </div>
      <div style="margin-top: 15px">
        <el-form
          :inline="true"
          :model="listQuery"
          size="small"
          label-width="140px"
        >
          <el-form-item label="输入搜索：">
            <el-input
              v-model="listQuery.param.username"
              class="input-width"
              placeholder="用户名"
              clearable
            ></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets"></i>
      <span>数据列表</span>
      <el-button
        size="mini"
        class="btn-add"
        @click="handleAdd()"
        style="margin-left: 20px"
      >添加
      </el-button
      >
    </el-card>
    <div class="table-container">
      <el-table
        v-loading="listLoading"
        :data="list"
        element-loading-text="Loading"
        border
        fit
        highlight-current-row
      >
        <el-table-column align="center" label="ID" width="95">
          <template slot-scope="scope">
            {{ scope.$index }}
          </template>
        </el-table-column>
        <el-table-column align="center" label="用户名">
          <template slot-scope="scope">
  <span>
    {{ scope.row.username }}
  </span>

          </template>
        </el-table-column>
        <el-table-column align="center" label="密码" width="110">
          <template slot-scope="scope">
            <span>{{ scope.row.password }}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" label="操作" width="180">
          <template slot-scope="scope">
            <el-button size="mini"
                       type="text"
                       @click="handleSelectRole(scope.row)">分配角色
            </el-button>
            <el-button
              @click="handleUpdate(scope.row)"
              size="mini"
              type="text"
            >
              编辑
            </el-button>
            <el-button
              @click="handleDelete(scope.row)"
              size="mini"
              type="text"
            >
                <span>
              删除
                </span>

            </el-button>
          </template>
        </el-table-column>
      </el-table>

      <div class="pagination-container">
        <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          layout="total, sizes,prev, pager, next,jumper"
          :current-page.sync="listQuery.pageNum"
          :page-size="listQuery.pageSize"
          :page-sizes="[10,15,20]"
          :total="total">
        </el-pagination>
      </div>

    </div>

    <el-dialog
      :title="isEdit?'编辑用户':'添加用户'"
      :visible.sync="dialogVisible"
      width="40%">
      <el-form :model="user"
               label-width="150px"
               ref="adminForm" size="small">
        <el-form-item label="用户名：">
          <el-input style="width: 250px" v-model="user.username"></el-input>
        </el-form-item>
        <el-form-item label="密码：">
          <el-input style="width: 250px" type="password" v-model="user.password"></el-input>
        </el-form-item>
      </el-form>
      <span class="dialog-footer" slot="footer">
        <el-button @click="dialogVisible = false" size="small">取 消</el-button>
        <el-button @click="handleDialogConfirm()" size="small" type="primary">确 定</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="分配角色"
      :visible.sync="allocDialogVisible"
      width="30%">
      <el-select v-model="allocRoleIds" multiple placeholder="请选择" size="small" style="width: 80%">
        <el-option
          v-for="item in allRoleList"
          :key="item.id"
          :label="item.roleName"
          :value="item.id">
        </el-option>
      </el-select>
      <span slot="footer" class="dialog-footer">
        <el-button @click="allocDialogVisible = false" size="small">取 消</el-button>
        <el-button type="primary" @click="handleAllocDialogConfirm()" size="small">确 定</el-button>
      </span>
    </el-dialog>
  </div>

</template>
<script>
  import {getList, createUser, updateUser, removeUser, allocRole} from "@/api/userinfo";
  import {getRoleListByUserId, getAllRoleList} from "../../../api/role";

  const defaultListQuery = {
    page: 1,
    pageSize: 10,
    param: {
      username: "",
    },
  };

  const defaultUser = {
    id: null,
    username: null,
    password: null,
  };

  export default {
    data() {
      return {
        list: null,
        listLoading: true,
        dialogVisible: false,
        allocDialogVisible: false,
        allocUserId: null,
        allocRoleIds: [],
        allRoleList: [],
        total: null,
        listQuery: {
          page: 1,
          pageSize: 10,
          param: {
            username: "",
          },
        },
        user: Object.assign({}, defaultUser),
        isEdit: false,
      };
    },
    created() {
      this.getList();
      this.getAllRoleList();
    },
    methods: {
      getList() {
        console.log(this.listQuery);
        this.listLoading = true;
        getList(this.listQuery).then((response) => {
          this.list = response.data.rows;
          this.total = response.data.rowTotal;
          this.listLoading = false;
        });
      }, getAllRoleList() {
        getAllRoleList().then(response => {
          this.allRoleList = response.data;
        })
      },
      handleResetSearch() {
        this.listQuery = Object.assign({}, defaultListQuery);
      },
      handleSearchList() {
        this.listQuery.pageNum = 1;
        this.getList();
      },
      handleAdd() {
        this.dialogVisible = true;
        this.isEdit = false;
        this.user = Object.assign({}, defaultUser);
      },
      handleDialogConfirm() {
        if (this.isEdit) {
          updateUser(this.user).then((response) => {
            this.$message({
              message: "修改成功！",
              type: "success",
            });
            this.dialogVisible = false;
            this.getList();
          });
        } else {
          createUser(this.user).then((response) => {
            this.$message({
              message: "添加成功！",
              type: "success",
            });
            this.dialogVisible = false;
            this.getList();
          });
        }
      },
      handleUpdate(row) {
        this.dialogVisible = true;
        this.isEdit = true;
        this.user = Object.assign({}, row);
      },
      handleDelete(row) {
        this.$confirm("是否要删除该用户?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }).then(() => {
          removeUser([row.id]).then((response) => {
            this.$message({
              type: "success",
              message: "删除成功!",
            });
            this.getList();
          });
        });
      },
      handleSizeChange(size) {
        this.listQuery.page = 1;
        this.listQuery.pageSize = size;
        this.getList();
      }, handleCurrentChange(page) {
        this.listQuery.page = page;
        this.getList();
      }, handleAllocDialogConfirm() {
        allocRole({userId: this.allocUserId, roleList: this.allocRoleIds}).then(response => {
          this.$message({
            type: "success",
            message: "分配成功!",
          });
        })
      }, handleSelectRole(row) {
        this.allocDialogVisible = true;
        this.allocUserId = row.id;
        this.getRoleListByUserId(row.id);
      },
      getRoleListByUserId(userId) {
        getRoleListByUserId(userId).then(response => {
          let allocRoleList = response.data;
          this.allocRoleIds = [];
          if (allocRoleList != null && allocRoleList.length > 0) {
            for (let i = 0; i < allocRoleList.length; i++) {
              this.allocRoleIds.push(allocRoleList[i].id);
            }
          }
        });
      },
    }
  };
</script>
<style lang=""></style>
