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
          size="small">
          查询搜索
        </el-button>
        <el-button
          style="float:right;margin-right: 15px"
          @click="handleResetSearch()"
          size="small">
          重置
        </el-button>
      </div>
      <div style="margin-top: 15px">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item label="资源路径">
            <el-input v-model="listQuery.param.path" class="input-width" placeholder="资源路径" clearable></el-input>
          </el-form-item>
          <el-form-item label="资源名称：">
            <el-input v-model="listQuery.param.name" class="input-width" placeholder="资源名称" clearable></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets"></i>
      <span>数据列表</span>
      <el-button size="mini" class="btn-add" @click="handleAdd()" style="margin-left: 20px">添加</el-button>
    </el-card>
    <div class="table-container">
      <el-table ref="roleTable"
                :data="list"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column label="ID" width="100" align="center">
          <template slot-scope="scope">{{scope.row.id}}</template>
        </el-table-column>
        <el-table-column label="资源路径" align="center">
          <template slot-scope="scope">{{scope.row.path}}</template>
        </el-table-column>
        <el-table-column label="资源名称" align="center">
          <template slot-scope="scope">{{scope.row.name}}</template>
        </el-table-column>
        <el-table-column label="操作" width="160" align="center">
          <template slot-scope="scope">
            <!--            <el-row>-->
            <!--              <el-button size="mini"-->
            <!--                         type="text"-->
            <!--                         @click="handleSelectMenu(scope.$index, scope.row)">分配菜单-->
            <!--              </el-button>-->
            <!--              <el-button size="mini"-->
            <!--                         type="text"-->
            <!--                         @click="handleSelectResource(scope.$index, scope.row)">分配资源-->
            <!--              </el-button>-->
            <!--            </el-row>-->
            <el-row>
              <el-button size="mini"
                         type="text"
                         @click="handleUpdate( scope.row)">
                编辑
              </el-button>
              <el-button size="mini"
                         type="text"
                         @click="handleDelete( scope.row)">删除
              </el-button>
            </el-row>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="pagination-container">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        layout="total, sizes,prev, pager, next,jumper"
        :current-page.sync="listQuery.pageNum"
        :page-size="listQuery.pageSize"
        :page-sizes="[5,10,15]"
        :total="total">
      </el-pagination>
    </div>
<!--    <el-dialog-->
<!--      :title="isEdit?'编辑角色':'添加角色'"-->
<!--      :visible.sync="dialogVisible"-->
<!--      width="40%">-->
<!--      <el-form :model="role"-->
<!--               ref="roleForm"-->
<!--               label-width="150px" size="small">-->
<!--        <el-form-item label="角色名称：">-->
<!--          <el-input v-model="role.roleName" style="width: 250px"></el-input>-->
<!--        </el-form-item>-->
<!--                <el-form-item label="描述：">-->
<!--                  <el-input v-model="role.description"-->
<!--                            type="textarea"-->
<!--                            :rows="5"-->
<!--                            style="width: 250px"></el-input>-->
<!--                </el-form-item>-->
<!--                <el-form-item label="是否启用：">-->
<!--                  <el-radio-group v-model="role.status">-->
<!--                    <el-radio :label="1">是</el-radio>-->
<!--                    <el-radio :label="0">否</el-radio>-->
<!--                  </el-radio-group>-->
<!--                </el-form-item>-->
<!--      </el-form>-->
<!--      <span slot="footer" class="dialog-footer">-->
<!--        <el-button @click="dialogVisible = false" size="small">取 消</el-button>-->
<!--        <el-button type="primary" @click="handleDialogConfirm()" size="small">确 定</el-button>-->
<!--      </span>-->
<!--    </el-dialog>-->
  </div>
</template>
<script>
  import {getList} from "@/api/resource";

  const defaultListQuery = {
    page: 1,
    pageSize: 10,
    param: {
      path: null,
      name: null
    }
  };
  const defaultResource = {
      id: null,
      name: null,
      name: null
    }
  ;

  export default {
    /* filters: {
       statusFilter(status) {
         const statusMap = {
           published: "success",
           draft: "gray",
           deleted: "danger"
         };
         return statusMap[status];
       }
     },*/
    data() {
      return {
        list: null,
        listQuery: {
          page: 1,
          pageSize: 10,
          param: {
            path: null,
            name: null
          }
        },
        listLoading: true,
        dialogVisible: false,
        isEdit: null,
        resource: Object.assign({}, defaultResource),
        total: 0,
      };
    },
    created() {
      this.getList();
    },
    methods: {
      getList() {
        this.listLoading = true;
        getList(this.listQuery).then(response => {
          this.list = response.data.rows;
          this.total = response.data.rowTotal;
          this.listLoading = false;
        });
       }
       //, handleAdd() {
      //   this.dialogVisible = true;
      //   this.isEdit = false;
      //   this.resource = Object.assign({}, defaultResource);
      // }, handleUpdate(row) {
      //   this.resource = Object.assign({}, row)
      //   this.isEdit = true;
      //   this.dialogVisible = true;
      // }, handleDelete(row) {
      //   this.$confirm('是否要删除该角色?', '提示', {
      //     confirmButtonText: '确定',
      //     cancelButtonText: '取消',
      //     type: 'warning'
      //   }).then(() => {
      //     deleteRole([row.id]).then(response => {
      //       this.$message({
      //         type: 'success',
      //         message: '删除成功!'
      //       });
      //       this.getList();
      //     });
      //   });
      // }
        , handleSizeChange(pageSize) {
        this.listQuery.page = 1;
        this.listQuery.pageSize = pageSize;
        this.getList();
      }, handleCurrentChange(page) {
        this.listQuery.page = page;
        this.getList();
      }, handleSearchList() {
        this.getList()
      }, handleResetSearch() {
        this.listQuery = Object.assign({}, defaultListQuery)
      },
      // handleDialogConfirm() {
      //   if (this.isEdit) {
      //     updateRole(this.role).then(response => {
      //       this.$message({
      //         message: "修改成功！",
      //         type: "success",
      //       });
      //       this.dialogVisible = false;
      //       this.getList();
      //     });
      //   } else {
      //     createRole(this.role).then(response => {
      //       this.$message({
      //         message: "新增成功！",
      //         type: "success",
      //       });
      //       this.dialogVisible = false;
      //       this.getList();
      //     })
      //   }
      // }, handleUpdate(row) {
      //   this.isEdit = true;
      //   this.dialogVisible = true;
      //   this.role = Object.assign({}, row);
      // }, handleDelete(row) {
      //   this.$confirm("是否要删除该用户?", "提示", {
      //     confirmButtonText: "确定",
      //     cancelButtonText: "取消",
      //     type: "warning",
      //   }).then(() => {
      //     removeRole([row.id]).then((response) => {
      //       this.$message({
      //         type: "success",
      //         message: "删除成功!",
      //       });
      //       this.getList();
      //     });
      //   });
      // }
    }
  };
</script>
<style lang=""></style>
