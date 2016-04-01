package com.hlhj.guanggou.service;

import com.hlhj.guanggou.po.Paging;
import com.hlhj.guanggou.po.Response;
import com.hlhj.guanggou.po.UserFavorite;

public interface UserFavoriteService {
	
	Response insert(UserFavorite favorite);
	Response delete(int id);
	Paging<UserFavorite> getFavoritePaging(String userId);
}
