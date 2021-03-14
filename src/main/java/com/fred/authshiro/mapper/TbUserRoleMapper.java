package com.fred.authshiro.mapper;

import com.fred.authshiro.model.TbUserRole;
import com.fred.authshiro.model.TbUserRoleKey;

public interface TbUserRoleMapper {
    int deleteByPrimaryKey(TbUserRoleKey key);

    int insert(TbUserRole record);

    int insertSelective(TbUserRole record);

    TbUserRole selectByPrimaryKey(TbUserRoleKey key);

    int updateByPrimaryKeySelective(TbUserRole record);

    int updateByPrimaryKey(TbUserRole record);
}