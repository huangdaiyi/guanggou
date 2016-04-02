package com.hlhj.guanggou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Preconditions;
import com.hlhj.guanggou.mapper.UserFavoriteMapper;
import com.hlhj.guanggou.po.UserFavorite;
import com.hlhj.guanggou.result.Response;
import com.hlhj.guanggou.service.UserFavoriteService;
import com.hlhj.guanggou.utils.StringUtil;

/**
 * 导购收藏
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class UserFavoriteServiceImpl implements UserFavoriteService {
	
	@Autowired
	UserFavoriteMapper userFavoriteMapper;
	
	@Override
	public Response insert(UserFavorite favorite) {
		Preconditions.checkNotNull(favorite);
		Preconditions.checkArgument(StringUtil.isNotEmpty(favorite.getUserId()) &&
				favorite.getProductId() > 0);
		
		int effect = userFavoriteMapper.insert(favorite);
		return Response.getResponse(effect);
	}

	@Override
	public Response delete(int id) {
		Preconditions.checkArgument(id > 0);
		
		int effect = userFavoriteMapper.deleteByPrimaryKey(id);
		return Response.getResponse(effect);
	}

	@Override
	public List<UserFavorite> getFavoritePaging(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
