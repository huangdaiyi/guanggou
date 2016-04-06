package com.hlhj.guanggou.mapper;

import java.util.List;

import com.hlhj.guanggou.param.BasePagingParam;
import com.hlhj.guanggou.po.Adornment;

public interface AdornmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Adornment record);

    int insertSelective(Adornment record);

    Adornment selectByPrimaryKey(String id);
    
    List<Adornment> selectPaging(BasePagingParam param);

    int updateByPrimaryKeySelective(Adornment record);

    int updateByPrimaryKey(Adornment record);
}