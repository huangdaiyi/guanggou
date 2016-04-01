package com.hlhj.guanggou.mapper;

import com.hlhj.guanggou.po.CombinationTopicKey;

public interface CombinationTopicMapper {
    int deleteByPrimaryKey(CombinationTopicKey key);

    int insert(CombinationTopicKey record);

    int insertSelective(CombinationTopicKey record);
}