package com.hlhj.guanggou.mapper;

import java.util.List;

import com.hlhj.guanggou.po.CombinationProduct;
import com.hlhj.guanggou.po.CombinationProductKey;

public interface CombinationProductMapper {
    int deleteByPrimaryKey(CombinationProductKey key);

    int insert(CombinationProduct record);

    int insertSelective(CombinationProduct record);

    CombinationProduct selectByPrimaryKey(CombinationProductKey key);
    
    int batchInsert(List<CombinationProduct> records);
    
    int batchDeleteByPrimaryKeys(List<CombinationProductKey> keys);

    int updateByPrimaryKeySelective(CombinationProduct record);

    int updateByPrimaryKey(CombinationProduct record);
}