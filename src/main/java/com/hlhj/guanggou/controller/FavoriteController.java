package com.hlhj.guanggou.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hlhj.guanggou.param.BasePagingParam;
import com.hlhj.guanggou.po.UserFavorite;
import com.hlhj.guanggou.result.FavoriteProduct;
import com.hlhj.guanggou.result.PagingResult;
import com.hlhj.guanggou.result.Response;
import com.hlhj.guanggou.service.UserFavoriteService;

/**
 * 商品组合控制器
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/favorite")
public class FavoriteController {

	@Autowired
	private UserFavoriteService favoriteService;

	@RequestMapping(method = RequestMethod.POST)
	public Response addFavorite(@Valid @RequestBody UserFavorite favorite) {

		return favoriteService.insert(favorite);
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Response getFavoritesPaging(@Valid @RequestBody BasePagingParam param) {

		List<FavoriteProduct> favList = favoriteService.getFavoritePaging(param);
		return new Response().success(new PagingResult<>(favList));
	}
	
	@RequestMapping(value = "/{userId}/{productId}", method = RequestMethod.DELETE)
	public Response deleteByProductId(@PathVariable("userId") String userId, @PathVariable("productId") int productId) {

		return favoriteService.deleteByUserProductId(userId, productId);
	}
	
}
