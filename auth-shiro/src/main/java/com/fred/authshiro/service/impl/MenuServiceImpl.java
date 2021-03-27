package com.fred.authshiro.service.impl;

import com.fred.authshiro.converter.MenuConvert;
import com.fred.authshiro.mapper.TbMenuMapper;
import com.fred.authshiro.model.TbMenu;
import com.fred.authshiro.request.menu.AddRequest;
import com.fred.authshiro.request.menu.QueryRequest;
import com.fred.authshiro.request.menu.UpdateRequest;
import com.fred.authshiro.request.page.GenericBo;
import com.fred.authshiro.response.page.Pagination;
import com.fred.authshiro.service.MenuService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fred
 * @date 2021/3/25 20:02
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private TbMenuMapper menuMapper;

    /**
     * 获取用户菜单
     *
     * @param userId 用户Id
     * @return
     */
    @Override
    public List<TbMenu> getUserMenu(Integer userId) {
        return menuMapper.selectUserMenu(userId);
    }

    @Override
    public Pagination<TbMenu> list(GenericBo<QueryRequest> queryRequest) {
        PageHelper.startPage(queryRequest.getPage(), queryRequest.getPageSize());
        List<TbMenu> list = menuMapper.select(new TbMenu() {{
            setTitle(queryRequest.getParam().getTitle());
        }});
        return Pagination.build(list);
    }

    @Override
    public void add(AddRequest addRequest) {
        TbMenu menu = MenuConvert.addRequest2Model(addRequest);
        menuMapper.insert(menu);
    }

    @Override
    public void delete(Integer[] ids) {
        menuMapper.batchDeleteById(ids);
    }

    @Override
    public void update(UpdateRequest updateRequest) {
        TbMenu menu = MenuConvert.updateRequest2Model(updateRequest);
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public TbMenu get(Integer id) {
        TbMenu menu = menuMapper.selectByPrimaryKey(id);
        return menu;
    }

    @Override
    public List<TbMenu> getMenuByParentId(Integer parentId) {
        List<TbMenu> menuList = menuMapper.select(new TbMenu() {{
            setParentId(parentId);
        }});
        return menuList;
    }
}
