package com.hlhj.guanggou.mapper;

import com.hlhj.guanggou.po.CombinationTopicExample;
import com.hlhj.guanggou.po.CombinationTopicKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CombinationTopicMapper {
    int countByExample(CombinationTopicExample example);

    int deleteByExample(CombinationTopicExample example);

    int deleteByPrimaryKey(CombinationTopicKey key);

    int insert(CombinationTopicKey record);

    int insertSelective(CombinationTopicKey record);

    List<CombinationTopicKey> selectByExample(CombinationTopicExample example);

    int updateByExampleSelective(@Param("record") CombinationTopicKey record, @Param("example") CombinationTopicExample example);

    int updateByExample(@Param("record") CombinationTopicKey record, @Param("example") CombinationTopicExample example);
}