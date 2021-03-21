<template>
  <div class="table-layout">
    <el-card shadow="never">
      <el-tree
        ref="tree"
        :props="props"
        :data="treeData"
        nodeKey="id"
        show-checkbox
        default-expand-all
        @check-change="handleCheckChange">
      </el-tree>
    </el-card>
    <div style="margin-top: 20px" align="center">
      <el-button type="primary" @click="handleSave()">保存</el-button>
      <el-button @click="handleClear">清空</el-button>
    </div>

  </div>

</template>

<script>
  import {getResourceTree} from '@/api/resource';
  import {allocResource} from '@/api/role';

  export default {
    name: "allocResource",
    data() {
      return {
        props: {
          label: 'name',
          children: 'zones'
        },
        roleId: null,
        treeData: null
      };
    },
    created() {
      this.roleId = this.$route.query.roleId;
      this.initData();
    },
    methods: {
      initData() {
        getResourceTree().then(response => {
          this.treeData = response.data;
        })
      },
      handleCheckChange(data, checked, indeterminate) {
        console.log(data, checked, indeterminate);
      },
      handleNodeClick(data) {
        console.log(data);
      }, handleClear() {
        this.$refs.tree.setCheckedKeys([]);
      }, handleSave() {
        const resourceIds = this.$refs.tree.getCheckedKeys();
        console.log({roleId: this.roleId, resourceIds: resourceIds})
        allocResource({roleId: this.roleId, resourceIds: resourceIds}).then(response => {
          this.$message({
            message: "新增成功！",
            type: "success",
          });
          this.$router.back();
        })
      }
    }
  }
</script>

<style scoped>
  .table-layout {
    padding: 20px;
    border-left: 1px solid #DCDFE6;
    border-right: 1px solid #DCDFE6;
    border-bottom: 1px solid #DCDFE6;
  }
</style>
