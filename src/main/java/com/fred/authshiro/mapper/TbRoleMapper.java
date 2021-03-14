package com.fred.authshiro.mapper;

import com.fred.authshiro.model.TbRole;
import com.fred.authshiro.request.role.QueryRequest;

import java.util.List;

public interface TbRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(Integer[] ids);

    int insert(TbRole record);

    int insertSelective(TbRole record);

    TbRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbRole record);

    int updateByPrimaryKey(TbRole record);

    List<TbRole> select(QueryRequest param);
}