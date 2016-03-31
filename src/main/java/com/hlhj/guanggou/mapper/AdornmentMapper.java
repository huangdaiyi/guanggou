package com.hlhj.guanggou.mapper;

import com.hlhj.guanggou.po.Adornment;
import com.hlhj.guanggou.po.AdornmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdornmentMapper {
    int countByExample(AdornmentExample example);

    int deleteByExample(AdornmentExample example);

    int deleteByPrimaryKey(String id);

    int insert(Adornment record);

    int insertSelective(Adornment record);

    List<Adornment> selectByExample(AdornmentExample example);

    Adornment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Adornment record, @Param("example") AdornmentExample example);

    int updateByExample(@Param("record") Adornment record, @Param("example") AdornmentExample example);

    int updateByPrimaryKeySelective(Adornment record);

    int updateByPrimaryKey(Adornment record);
}