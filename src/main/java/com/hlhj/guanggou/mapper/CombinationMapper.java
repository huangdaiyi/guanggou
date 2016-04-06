package com.hlhj.guanggou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hlhj.guanggou.param.PagingCombinationParam;
import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.result.CombinationDetailResult;

public interface CombinationMapper {
    int deleteByPrimaryKey(String id);

    int insert(Combination record);

    int insertSelective(Combination record);

    Combination selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Combination record);

    int updateByPrimaryKey(Combination record);
    
    List<Combination> selectPaging(PagingCombinationParam param);
    
    int deleteByIds(@Param("userId") String userId, @Param("combinationIds") String[] ids);
    
    CombinationDetailResult getCombinationDetail(@Param("userId") String userId, @Param("combinationId")String combinationId);
    
    List<Combination> selectByTopicId(@Param("userId") String userId, @Param("topicId") String topicId);
}