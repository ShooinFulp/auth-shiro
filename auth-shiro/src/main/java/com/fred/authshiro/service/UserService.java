package com.fred.authshiro.service;

import cn.hutool.json.JSONObject;
import com.fred.authshiro.model.TbUser;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.response.page.Pagination;
import com.fred.authshiro.request.user.AddRequest;
import com.fred.authshiro.request.user.AllocRoleRequest;
import com.fred.authshiro.request.user.QueryRequest;
import com.fred.authshiro.request.user.UpdateRequest;
import com.fred.authshiro.response.base.ResultVo;
import com.fred.authshiro.response.user.QueryResponse;
import com.fred.authshiro.response.user.UserInfoResponse;


/**
 * @author Fred
 * @date 2021/3/12 22:12
 */
public interface UserService {
    Pagination<QueryResponse> list(GenericBo<QueryRequest> bo);

    ResultVo<TbUser> getById(Integer id);

    ResultVo add(AddRequest addRequest);

    ResultVo remove(Integer[] ids);

    ResultVo update(UpdateRequest updateRequest);

    void allocRole(AllocRoleRequest allocRoleRequest);

    TbUser findUserByUsername(String username);

    UserInfoResponse info(Integer userId);
}
