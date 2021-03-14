package com.fred.authshiro.mapper;

import com.fred.authshiro.model.TbUser;
import com.fred.authshiro.response.user.QueryResponse;

import java.util.List;

public interface TbUserMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(Integer[] ids);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Integer id);

    List<QueryResponse> select(TbUser user);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}