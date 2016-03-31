package com.hlhj.guanggou.mapper;

import com.hlhj.guanggou.po.CombinationProduct;
import com.hlhj.guanggou.po.CombinationProductExample;
import com.hlhj.guanggou.po.CombinationProductKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CombinationProductMapper {
    int countByExample(CombinationProductExample example);

    int deleteByExample(CombinationProductExample example);

    int deleteByPrimaryKey(CombinationProductKey key);

    int insert(CombinationProduct record);
    
    int batchInsert(List<CombinationProduct> records);

    int insertSelective(CombinationProduct record);

    List<CombinationProduct> selectByExample(CombinationProductExample example);

    CombinationProduct selectByPrimaryKey(CombinationProductKey key);

    int updateByExampleSelective(@Param("record") CombinationProduct record, @Param("example") CombinationProductExample example);

    int updateByExample(@Param("record") CombinationProduct record, @Param("example") CombinationProductExample example);

    int updateByPrimaryKeySelective(CombinationProduct record);

    int updateByPrimaryKey(CombinationProduct record);
}