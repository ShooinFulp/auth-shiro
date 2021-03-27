package com.fred.authshiro.service;

import com.fred.authshiro.model.TbMenu;
import com.fred.authshiro.request.menu.AddRequest;
import com.fred.authshiro.request.menu.QueryRequest;
import com.fred.authshiro.request.menu.UpdateRequest;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.response.page.Pagination;

import java.util.List;

/**
 * @author Fred
 * @date 2021/3/25 20:01
 */
public interface MenuService {
    /**
     * 获取用户菜单
     *
     * @param userId 用户Id
     * @return
     */
    List<TbMenu> getUserMenu(Integer userId);

    Pagination<TbMenu> list(GenericBo<QueryRequest> queryRequest);

    void add(AddRequest addRequest);

    void delete(Integer[] ids);

    void update(UpdateRequest updateRequest);

    TbMenu get(Integer id);

    List<TbMenu> getMenuByParentId(Integer parentId);
}
