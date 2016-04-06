package com.hlhj.guanggou.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hlhj.guanggou.param.CombinationParam;
import com.hlhj.guanggou.param.DelCombinationByIdParam;
import com.hlhj.guanggou.param.PagingCombinationParam;
import com.hlhj.guanggou.param.UpdateCombinationParam;
import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.result.CombinationDetailResult;
import com.hlhj.guanggou.result.PagingResult;
import com.hlhj.guanggou.result.Response;
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

	@RequestMapping(method=RequestMethod.POST)
	public Response addCombination(
			@Valid @RequestBody CombinationParam combinationParam) {
		
		return combinationService.insert(combinationParam);
	}
	
	@RequestMapping("/list")
	public Response getCombinationPaging(@Valid @RequestBody PagingCombinationParam param){
		
		List<Combination> combinations = combinationService.getCombinationPaging(param);
		return new Response().success(new PagingResult<>(combinations));
	}
	
	@RequestMapping(value="/{userId}/{combinationId}", method = RequestMethod.GET)
	public Response getCombinationDetail(@PathVariable("userId") String userId,
			@PathVariable("combinationId") String combinationId){
		
		CombinationDetailResult detailResult = combinationService.getCombinationDetail(userId, combinationId);
		return new Response().success(detailResult);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public Response delCombinationById(@Valid @RequestBody DelCombinationByIdParam param){
		return combinationService.deleteCombinationByIds(param);
	}
	
	@RequestMapping(value="/{combinationId}", method=RequestMethod.POST)
	public Response updateCombination(@PathVariable("combinationId") String combinationId,
			@Valid  @RequestBody UpdateCombinationParam combinationParam){
		return combinationService.updateCombination(combinationId, combinationParam);
	}
	
	@RequestMapping(value="/{combinationId}", method=RequestMethod.PUT)
	public Response pulishCombination(@PathVariable("combinationId") String combinationId ){
		
		return combinationService.pulishCombination(combinationId);
	}
	
	@RequestMapping(value="/topic/{userId}/{topicId}", method=RequestMethod.GET)
	public Response getCombinationByTopic(@PathVariable("userId") String userId,
			@PathVariable("topicId")String topicId ){
		
		List<Combination> combinations = combinationService.getCombinationByTopic(userId, topicId);
		
		return new Response().success(combinations);
	}
	

}
