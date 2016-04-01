package com.hlhj.guanggou.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hlhj.guanggou.param.CombinationParam;
import com.hlhj.guanggou.param.DelCombinationByIdParam;
import com.hlhj.guanggou.param.GetCombinationDetailParam;
import com.hlhj.guanggou.param.PagingCombinationParam;
import com.hlhj.guanggou.param.UpdateCombinationParam;
import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.po.Response;
import com.hlhj.guanggou.result.CombinationDetailResult;
import com.hlhj.guanggou.service.CombinationService;

/**
 * 商品组合控制器
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/combination")
public class CombinationController {

	@Autowired
	private CombinationService combinationService;

	@RequestMapping("/add")
	public Response addCombination(
			@Valid @RequestBody CombinationParam combinationParam) {
		//TODO Validate
		return combinationService.insert(combinationParam);
	}
	
	@RequestMapping("/list")
	public Response getCombinationPaging(@Valid @RequestBody PagingCombinationParam param){
		
		List<Combination> combinations = combinationService.getCombinationPaging(param);
		return new Response().success(combinations);
	}
	
	@RequestMapping("/detail")
	public Response getCombinationDetail(@Valid @RequestBody GetCombinationDetailParam param){
		
		CombinationDetailResult detailResult = combinationService.getCombinationDetail(param);
		return new Response().success(detailResult);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public Response delCombinationById(@Valid @RequestBody DelCombinationByIdParam param){
		return combinationService.deleteCombinationByIds(param);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Response updateCombination(@Valid  @RequestBody UpdateCombinationParam combinationParam){
		return combinationService.updateCombination(combinationParam);
	}

}
