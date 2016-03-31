package com.hlhj.guanggou.mapper;

import com.hlhj.guanggou.po.UserFavorite;
import com.hlhj.guanggou.po.UserFavoriteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFavoriteMapper {
    int countByExample(UserFavoriteExample example);

    int deleteByExample(UserFavoriteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFavorite record);

    int insertSelective(UserFavorite record);

    List<UserFavorite> selectByExample(UserFavoriteExample example);

    UserFavorite selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFavorite record, @Param("example") UserFavoriteExample example);

    int updateByExample(@Param("record") UserFavorite record, @Param("example") UserFavoriteExample example);

    int updateByPrimaryKeySelective(UserFavorite record);

    int updateByPrimaryKey(UserFavorite record);
}