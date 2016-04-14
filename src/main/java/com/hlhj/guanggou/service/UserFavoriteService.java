package com.hlhj.guanggou.service;

import java.util.List;

import com.hlhj.guanggou.param.BasePagingParam;
import com.hlhj.guanggou.po.UserFavorite;
import com.hlhj.guanggou.result.FavoriteProduct;
import com.hlhj.guanggou.result.Response;

public interface UserFavoriteService {
	
	Response insert(UserFavorite favorite);
	Response delete(int id);
	List<FavoriteProduct> getFavoritePaging(BasePagingParam param);
	Response deleteByUserProductId(String userId, int productId);
}
