package com.fred.authshiro.controller;

import com.fred.authshiro.model.TbRole;
import com.fred.authshiro.model.TbUser;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.request.page.Pagination;
import com.fred.authshiro.request.role.AddRequest;
import com.fred.authshiro.request.role.QueryRequest;
import com.fred.authshiro.request.role.UpdateRequest;
import com.fred.authshiro.response.base.ResultVo;
import com.fred.authshiro.service.RoleService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 〈功能概述〉
 *
 * @author: Fred
 * @date: 2021/3/14 10:09 下午
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public ResultVo add(@RequestBody @Validated AddRequest addRequest) {
        return roleService.add(addRequest);
    }

    @PostMapping("/remove")
    @Validated
    public ResultVo remove(@RequestBody @Length(message = "请选择要删除的角色") Integer[] ids) {
        return roleService.remove(ids);
    }

    @PostMapping("/update")
    public ResultVo update(UpdateRequest updateRequest) {
        return roleService.update(updateRequest);
    }

    @GetMapping("/get/{id}")
    public ResultVo<TbRole> get(@PathVariable("id") Integer id) {
        return roleService.get(id);
    }

    @PostMapping("/list")
    public Pagination<TbUser> list(@RequestBody GenericBo<QueryRequest> bo) {
        return roleService.list(bo);
    }
}
