package com.fred.authshiro.service.impl;

import com.fred.authshiro.converter.UserConvert;
import com.fred.authshiro.mapper.TbUserMapper;
import com.fred.authshiro.model.TbUser;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.request.page.Pagination;
import com.fred.authshiro.request.user.AddRequest;
import com.fred.authshiro.request.user.QueryRequest;
import com.fred.authshiro.request.user.UpdateRequest;
import com.fred.authshiro.response.base.ResultVo;
import com.fred.authshiro.response.user.QueryResponse;
import com.fred.authshiro.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fred
 * @date 2021/3/12 22:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public Pagination<QueryResponse> list(GenericBo<QueryRequest> bo) {
        PageHelper.startPage(bo.getPage(), bo.getPageSize());
        TbUser user = UserConvert.queryRequest2Model(bo.getParam());
        List<QueryResponse> userList = userMapper.select(user);
        return Pagination.build(userList);
    }

    @Override
    public ResultVo<TbUser> getById(Integer id) {
        return ResultVo.success(userMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResultVo add(AddRequest addRequest) {
        TbUser user = UserConvert.addRequest2Model(addRequest);
        userMapper.insert(user);
        return ResultVo.success();
    }

    @Override
    public ResultVo remove(Integer[] ids) {
        userMapper.deleteByPrimaryKeys(ids);
        return ResultVo.success();
    }

    @Override
    public ResultVo update(UpdateRequest updateRequest) {
        TbUser user = UserConvert.updateRequest2Model(updateRequest);
        userMapper.updateByPrimaryKey(user);
        return ResultVo.success();
    }
}