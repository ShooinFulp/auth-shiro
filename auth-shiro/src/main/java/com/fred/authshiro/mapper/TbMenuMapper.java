package com.fred.authshiro.mapper;

import com.fred.authshiro.model.TbMenu;
import com.fred.authshiro.request.role.AllocMenuRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbMenu record);

    int insertSelective(TbMenu record);

    TbMenu selectByPrimaryKey(Integer id);

    List<TbMenu> select(TbMenu menu);

    List<TbMenu> selectUserMenu(Integer userId);

    int updateByPrimaryKeySelective(TbMenu record);

    int updateByPrimaryKey(TbMenu record);


    int batchDeleteById(@Param("ids") Integer[] ids);


    List<Integer> getMenuIdByRoleId(Integer roleId);
}