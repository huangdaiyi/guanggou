package com.hlhj.guanggou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hlhj.guanggou.param.BasePagingParam;
import com.hlhj.guanggou.po.UserFavorite;
import com.hlhj.guanggou.result.FavoriteProduct;

public interface UserFavoriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserFavorite record);

    int insertSelective(UserFavorite record);

    UserFavorite selectByPrimaryKey(Integer id);
    
    UserFavorite selectByUserProductId(@Param("userId")String userId, @Param("productId")int productId);

    int updateByPrimaryKeySelective(UserFavorite record);

    int updateByPrimaryKey(UserFavorite record);
    
    int deleteByUserProductId(@Param("userId")String userId, @Param("productId")int productId);
    
    List<FavoriteProduct> selectPaging(BasePagingParam param);
}