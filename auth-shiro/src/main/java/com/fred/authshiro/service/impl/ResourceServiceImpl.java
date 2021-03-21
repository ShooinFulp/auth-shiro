package com.fred.authshiro.service.impl;

import com.fred.authshiro.mapper.TbResourceMapper;
import com.fred.authshiro.model.TbResource;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.request.page.Pagination;
import com.fred.authshiro.request.resource.QueryRequest;
import com.fred.authshiro.service.ResourceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈功能概述〉
 *
 * @author: Fred
 * @date: 2021/3/14 10:31 下午
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private TbResourceMapper resourceMapper;

    @Override
    public Pagination list(GenericBo<QueryRequest> bo) {
        PageHelper.startPage(bo.getPage(), bo.getPageSize());
        List<TbResource> list = resourceMapper.select(bo.getParam());
        return Pagination.build(list);
    }

    @Override
    public List<TbResource> getResourceTree() {
        // TODO 后期需要改成树结构
        return resourceMapper.select(null);
    }
}
