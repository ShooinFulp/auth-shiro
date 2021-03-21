package com.fred.authshiro.service.impl;

import com.fred.authshiro.converter.RoleConvert;
import com.fred.authshiro.mapper.TbRoleMapper;
import com.fred.authshiro.model.TbRole;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.request.page.Pagination;
import com.fred.authshiro.request.role.AddRequest;
import com.fred.authshiro.request.role.AllocResourceRequest;
import com.fred.authshiro.request.role.QueryRequest;
import com.fred.authshiro.request.role.UpdateRequest;
import com.fred.authshiro.response.base.ResultVo;
import com.fred.authshiro.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈功能概述〉
 *
 * @author: Fred
 * @date: 2021/3/14 9:53 下午
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private TbRoleMapper roleMapper;

    @Override
    public ResultVo add(AddRequest addRequest) {
        TbRole role = RoleConvert.addRequest2Model(addRequest);
        roleMapper.insert(role);
        return ResultVo.success();
    }

    @Override
    public ResultVo remove(Integer[] ids) {
        roleMapper.deleteByPrimaryKeys(ids);
        return ResultVo.success();
    }

    @Override
    public ResultVo update(UpdateRequest updateRequest) {
        TbRole role = RoleConvert.updateRequest2Model(updateRequest);
        roleMapper.updateByPrimaryKeySelective(role);
        return ResultVo.success();
    }

    @Override
    public ResultVo<TbRole> get(Integer id) {
        TbRole role = roleMapper.selectByPrimaryKey(id);
        return ResultVo.success(role);
    }

    @Override
    public Pagination<TbRole> list(GenericBo<QueryRequest> bo) {
        PageHelper.startPage(bo.getPage(), bo.getPageSize());
        List<TbRole> list = roleMapper.select(bo.getParam());
        return Pagination.build(list);
    }

    @Override
    public List<TbRole> getRoleListByUserId(Integer userId) {
        return roleMapper.getRoleListByUserId(userId);
    }

    @Override
    public List<TbRole> getAllRoleList() {
        return roleMapper.select(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void allocResource(AllocResourceRequest allocResourceRequest) {
        roleMapper.removeRoleResourceByRoleId(allocResourceRequest.getRoleId());
        roleMapper.allocRoleResource(allocResourceRequest);
    }
}
