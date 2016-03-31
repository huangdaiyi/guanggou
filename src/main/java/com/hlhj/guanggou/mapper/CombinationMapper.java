package com.hlhj.guanggou.mapper;

import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.po.CombinationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CombinationMapper {
    int countByExample(CombinationExample example);

    int deleteByExample(CombinationExample example);

    int deleteByPrimaryKey(String id);

    int insert(Combination record);

    int insertSelective(Combination record);

    List<Combination> selectByExample(CombinationExample example);

    Combination selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Combination record, @Param("example") CombinationExample example);

    int updateByExample(@Param("record") Combination record, @Param("example") CombinationExample example);

    int updateByPrimaryKeySelective(Combination record);

    int updateByPrimaryKey(Combination record);
}