package com.fred.authshiro.controller;

import com.fred.authshiro.model.TbUser;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.request.page.Pagination;
import com.fred.authshiro.request.user.AddRequest;
import com.fred.authshiro.request.user.AllocRoleRequest;
import com.fred.authshiro.request.user.QueryRequest;
import com.fred.authshiro.request.user.UpdateRequest;
import com.fred.authshiro.response.user.QueryResponse;
import com.fred.authshiro.service.UserService;
import com.fred.authshiro.response.base.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Fred
 * @date 2021/3/12 22:11
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResultVo<Pagination<QueryResponse>> list(@RequestBody GenericBo<QueryRequest> bo) {
        return ResultVo.success(userService.list(bo));
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResultVo<TbUser> get(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultVo add(@RequestBody AddRequest addRequest) {
        return userService.add(addRequest);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultVo update(@RequestBody UpdateRequest updateRequest) {
        return userService.update(updateRequest);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ResultVo remove(@RequestBody Integer[] ids) {
        return userService.remove(ids);
    }

    @PostMapping("/allocRole")
    public ResultVo allocRole(@RequestBody AllocRoleRequest allocRoleRequest) {
        userService.allocRole(allocRoleRequest);
        return ResultVo.success();
    }
}
