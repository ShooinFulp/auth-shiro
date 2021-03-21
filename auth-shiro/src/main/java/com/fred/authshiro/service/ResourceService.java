package com.fred.authshiro.service;

import com.fred.authshiro.model.TbResource;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.request.page.Pagination;
import com.fred.authshiro.request.resource.QueryRequest;

import java.util.List;

/**
 * 〈功能概述〉
 *
 * @author: Fred
 * @date: 2021/3/14 10:28 下午
 */
public interface ResourceService {
    Pagination list(GenericBo<QueryRequest> bo);

    List<TbResource> getResourceTree();
}
