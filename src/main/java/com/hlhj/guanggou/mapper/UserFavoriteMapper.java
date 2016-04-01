package com.hlhj.guanggou.mapper;

import java.util.List;

import com.hlhj.guanggou.po.UserFavorite;

public interface UserFavoriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserFavorite record);

    int insertSelective(UserFavorite record);

    UserFavorite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFavorite record);

    int updateByPrimaryKey(UserFavorite record);
    
    List<UserFavorite> selectPaging(UserFavorite param);
}