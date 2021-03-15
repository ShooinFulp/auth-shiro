package com.fred.authshiro.controller;

import com.fred.authshiro.model.TbResource;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.request.page.Pagination;
import com.fred.authshiro.request.resource.QueryRequest;
import com.fred.authshiro.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Pagination<TbResource> list(@RequestBody GenericBo<QueryRequest> bo) {
        return resourceService.list(bo);
    }
}
