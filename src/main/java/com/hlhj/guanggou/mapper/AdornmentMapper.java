package com.hlhj.guanggou.mapper;

import com.hlhj.guanggou.po.Adornment;

public interface AdornmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Adornment record);

    int insertSelective(Adornment record);

    Adornment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Adornment record);

    int updateByPrimaryKey(Adornment record);
}