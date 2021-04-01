package com.fred.authshiro.controller;

import com.fred.authshiro.model.TbMenu;
import com.fred.authshiro.request.menu.AddRequest;
import com.fred.authshiro.request.menu.QueryRequest;
import com.fred.authshiro.request.menu.UpdateRequest;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.response.base.ResultVo;
import com.fred.authshiro.response.menu.QueryMenuResponse;
import com.fred.authshiro.response.page.Pagination;
import com.fred.authshiro.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fred
 * @date 2021/3/25 20:00
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/list")
    public ResultVo<Pagination<TbMenu>> list(@RequestBody GenericBo<QueryRequest> queryRequest) {
        return ResultVo.success(menuService.list(queryRequest));
    }

    @GetMapping("/get/{id}")
    public ResultVo<TbMenu> get(@PathVariable("id") Integer id) {
        TbMenu menu = menuService.get(id);
        return ResultVo.success(menu);
    }

    @PostMapping("/add")
    public ResultVo add(@RequestBody AddRequest addRequest) {
        menuService.add(addRequest);
        return ResultVo.success();
    }

    @PostMapping("/delete")
    public ResultVo delete(@RequestBody Integer[] ids) {
        menuService.delete(ids);
        return ResultVo.success();
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody UpdateRequest updateRequest) {
        menuService.update(updateRequest);
        return ResultVo.success();
    }

    @GetMapping("/getMenuByParentId")
    public ResultVo<TbMenu> getMenuByParentId(@RequestParam(value = "parentId", required = false) Integer parentId) {
        List<TbMenu> menuList = menuService.getMenuByParentId(parentId);
        return ResultVo.success(menuList);
    }

    @GetMapping("/getMenuIdByRoleId/{roleId}")
    public ResultVo<List<Integer>> getMenuIdByRoleId(@PathVariable("roleId") Integer roleId) {
        return ResultVo.success(menuService.getMenuIdByRoleId(roleId));
    }

    @GetMapping("/getMenuTree")
    public ResultVo<List<QueryMenuResponse>> getMenuTree() {
        return ResultVo.success(menuService.getMenuTree());
    }
}
