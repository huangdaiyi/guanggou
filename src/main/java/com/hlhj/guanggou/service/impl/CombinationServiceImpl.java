package com.hlhj.guanggou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.hlhj.guanggou.id.IdGenerator;
import com.hlhj.guanggou.mapper.CombinationMapper;
import com.hlhj.guanggou.mapper.CombinationProductMapper;
import com.hlhj.guanggou.param.CombinationParam;
import com.hlhj.guanggou.param.PagingCombinationParam;
import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.po.CombinationProduct;
import com.hlhj.guanggou.po.Paging;
import com.hlhj.guanggou.po.Response;
import com.hlhj.guanggou.result.CombinationResult;
import com.hlhj.guanggou.service.CombinationService;
import com.hlhj.guanggou.utils.CollectionUtil;

@Service
public class CombinationServiceImpl implements CombinationService{
	
	@Autowired
	private CombinationMapper combinationMapper;
	
	@Autowired
	private CombinationProductMapper combinationProductMapper;
	
	@Autowired
	private IdGenerator idGenerator;
	
	@Override
	public Response insert(CombinationParam combination) {
		
		Preconditions.checkNotNull(combination);
		Preconditions.checkNotNull(combination.getCombination());
		Preconditions.checkArgument(CollectionUtil.isNotEmpty(combination.getProducts()));
		
		Combination combinationBase = combination.getCombination();
		
		combinationBase.setId(idGenerator.generateId());
		List<CombinationProduct> comPorductitems = combination.getProducts();
		
		combinationMapper.insert(combinationBase);
		
		for (CombinationProduct tempItem : comPorductitems) {
			tempItem.setCombinationId(combinationBase.getId());
			//combinationProductMapper.insert(tempItem);
		}
		
		combinationProductMapper.batchInsert(comPorductitems);
		return new Response().success();
	}

	@Override
	public Paging<Combination> getCombinationPaging(PagingCombinationParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CombinationResult getCombinationDetail(String userId,
			String combinationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteCombinationByIds(String userId,
			String[] combinatioinIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateCombination(CombinationParam combination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response pulishCombination(String combinationId) {
		// TODO Auto-generated method stub
		return null;
	}

}
