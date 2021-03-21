package com.fred.authshiro.controller;

import com.fred.authshiro.model.TbResource;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.request.page.Pagination;
import com.fred.authshiro.request.resource.QueryRequest;
import com.fred.authshiro.response.base.ResultVo;
import com.fred.authshiro.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈功能概述〉
 *
 * @author: Fred
 * @date: 2021/3/14 10:38 下午
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/list")
    public ResultVo<Pagination<TbResource>> list(@RequestBody GenericBo<QueryRequest> bo) {
        return ResultVo.success(resourceService.list(bo));
    }

    @GetMapping("/getResourceTree")
    public ResultVo<List<TbResource>> getResourceTree() {
        return ResultVo.success(resourceService.getResourceTree());
    }
}
