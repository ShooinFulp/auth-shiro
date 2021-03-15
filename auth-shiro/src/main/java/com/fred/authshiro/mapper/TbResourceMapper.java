package com.fred.authshiro.mapper;

import com.fred.authshiro.model.TbResource;
import com.fred.authshiro.request.resource.QueryRequest;

import java.util.List;

public interface TbResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbResource record);

    int insertSelective(TbResource record);

    TbResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbResource record);

    int updateByPrimaryKey(TbResource record);

    List<TbResource> select(QueryRequest param);
}