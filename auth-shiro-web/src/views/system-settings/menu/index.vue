<template>
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
              placeholder="菜单名"
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
        <el-table-column align="center" label="菜单名">
          <template slot-scope="scope">
  <span>
    {{ scope.row.title }}
  </span>

          </template>
        </el-table-column>
        <el-table-column align="center" label="菜单等级">
          <template slot-scope="scope">
  <span>
    {{ scope.row.level }}
  </span>

          </template>
        </el-table-column>
        <el-table-column align="center" label="排序" width="110">
          <template slot-scope="scope">
            <span>{{ scope.row.sort }}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" label="操作" width="180">
          <template slot-scope="scope">
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
          :total="total"
        >
        </el-pagination>
      </div>

    </div>

    <el-dialog
      :title="isEdit?'编辑菜单':'添加菜单'"
      :visible.sync="dialogVisible"
      width="40%"
    >
      <el-form :model="menu"
               label-width="150px"
               ref="adminForm" size="small"
      >
        <el-form-item label="上级菜单：">
          <el-select style="width: 250px" v-model="menu.parentId" filterable placeholder="请选择">
            <el-option
              v-for="item in parentMenu"
              :key="item.id"
              :label="item.title"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="菜单名称：">
          <el-input style="width: 250px" v-model="menu.title"></el-input>
        </el-form-item>
        <el-form-item label="菜单排序：">
          <el-input style="width: 250px" v-model="menu.sort"></el-input>
        </el-form-item>
        <el-form-item label="菜单图标：">
          <el-input style="width: 250px" v-model="menu.icon"></el-input>
        </el-form-item>
        <el-form-item label="是否显示：">
          <el-switch
            v-model="menu.hidden"
            active-color="#13ce66"
            inactive-color="#ff4949"
          >
          </el-switch>
        </el-form-item>
      </el-form>
      <span class="dialog-footer" slot="footer">
        <el-button @click="dialogVisible = false" size="small">取 消</el-button>
        <el-button @click="handleDialogConfirm()" size="small" type="primary">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>

<script>
import {getList, createMenu, updateMenu, removeMenu, getMenu, getMenuByParentId} from "@/api/menu";

const defaultListQuery = {
  page: 1,
  pageSize: 10,
  param: {
    title: "",
  },
};

const defaultMenu = {
  id: null
};

export default {
  data() {
    return {
      list: null,
      listLoading: true,
      dialogVisible: false,
      total: null,
      listQuery: {
        page: 1,
        pageSize: 10,
        param: {
          title: "",
        },
      },
      menu: Object.assign({}, defaultMenu),
      isEdit: false,
      parentMenu: []
    };
  },
  created() {
    this.getList();
  },
  methods: {
    getList() {
      console.log(this.listQuery);
      this.listLoading = true;
      console.log(this.listQuery)
      getList(this.listQuery).then((response) => {
        this.list = response.data.rows;
        this.total = response.data.rowTotal;
        this.listLoading = false;
      });
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
      this.getMenuByParentId(null);
      this.menu = Object.assign({}, defaultMenu);
    },
    handleDialogConfirm() {
      if (this.isEdit) {
        updateMenu(this.menu).then((response) => {
          this.$message({
            message: "修改成功！",
            type: "success",
          });
          this.dialogVisible = false;
          this.getList();
        });
      } else {
        createMenu(this.menu).then((response) => {
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
      this.menu = Object.assign({}, row);
    },
    handleDelete(row) {
      this.$confirm("是否要删除该菜单?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        removeMenu([row.id]).then((response) => {
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
    },
    getMenuByParentId(parentId) {
      getMenuByParentId(parentId).then(response => {
        this.parentMenu = response.data;
      })
    }
  }
};
</script>

<style scoped>

</style>
