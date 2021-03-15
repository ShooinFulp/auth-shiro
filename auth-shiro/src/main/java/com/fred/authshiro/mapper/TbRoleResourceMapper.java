package com.fred.authshiro.mapper;

import com.fred.authshiro.model.TbRoleResource;
import com.fred.authshiro.model.TbRoleResourceKey;

public interface TbRoleResourceMapper {
    int deleteByPrimaryKey(TbRoleResourceKey key);

    int insert(TbRoleResource record);

    int insertSelective(TbRoleResource record);

    TbRoleResource selectByPrimaryKey(TbRoleResourceKey key);

    int updateByPrimaryKeySelective(TbRoleResource record);

    int updateByPrimaryKey(TbRoleResource record);
}