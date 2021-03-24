package com.fred.authshiro.service;

import com.fred.authshiro.model.TbRole;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.response.page.Pagination;
import com.fred.authshiro.request.role.AddRequest;
import com.fred.authshiro.request.role.AllocResourceRequest;
import com.fred.authshiro.request.role.QueryRequest;
import com.fred.authshiro.request.role.UpdateRequest;
import com.fred.authshiro.response.base.ResultVo;

import java.util.List;

/**
 * 〈功能概述〉
 *
 * @author: Fred
 * @date: 2021/3/14 9:50 下午
 */
public interface RoleService {
    ResultVo add(AddRequest addRequest);

    ResultVo remove(Integer[] ids);

    ResultVo update(UpdateRequest updateRequest);

    ResultVo get(Integer id);

    Pagination list(GenericBo<QueryRequest> bo);

    List<TbRole> getRoleListByUserId(Integer userId);

    List<TbRole> getAllRoleList();

    void allocResource(AllocResourceRequest allocResourceRequest);
}
