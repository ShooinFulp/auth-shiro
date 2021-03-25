package com.fred.authshiro.controller;

import com.fred.authshiro.model.TbMenu;
import com.fred.authshiro.request.menu.QueryRequest;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.response.base.ResultVo;
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
}
