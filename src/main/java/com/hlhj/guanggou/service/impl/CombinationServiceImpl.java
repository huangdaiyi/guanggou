package com.hlhj.guanggou.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.hlhj.guanggou.constant.CombinationStatus;
import com.hlhj.guanggou.id.IdGenerator;
import com.hlhj.guanggou.mapper.CombinationMapper;
import com.hlhj.guanggou.mapper.CombinationProductMapper;
import com.hlhj.guanggou.param.CombinationParam;
import com.hlhj.guanggou.param.DelCombinationByIdParam;
import com.hlhj.guanggou.param.ModifyItemMarkParam;
import com.hlhj.guanggou.param.PagingCombinationParam;
import com.hlhj.guanggou.param.UpdateCombinationParam;
import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.po.CombinationProduct;
import com.hlhj.guanggou.po.CombinationProductKey;
import com.hlhj.guanggou.result.CombinationDetailResult;
import com.hlhj.guanggou.result.Response;
import com.hlhj.guanggou.service.CombinationService;
import com.hlhj.guanggou.utils.CollectionUtil;
import com.hlhj.guanggou.utils.DatetUtil;
import com.hlhj.guanggou.utils.StringUtil;

/**
 * 商品组合Service
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class CombinationServiceImpl implements CombinationService{
	
	@Autowired
	private CombinationMapper combinationMapper;
	
	@Autowired
	private CombinationProductMapper combinationProductMapper;
	
	@Autowired
	private IdGenerator idGenerator;
	
	@Override
	@Transactional
	public Response insert(CombinationParam combination) {
		
		Preconditions.checkNotNull(combination);
		Preconditions.checkNotNull(combination.getCombination());
		Preconditions.checkArgument(CollectionUtil.isNotEmpty(combination.getProducts()));
		
		Combination combinationBase = combination.getCombination();
		combinationBase.setId(idGenerator.generateId());
		long now = DatetUtil.getNow();
		combinationBase.setCreateTime(now);
		combinationBase.setLastEditTime(now);
		combinationBase.setCreateUser(combinationBase.getUserId());
		combinationBase.setStatus(CombinationStatus.DRAFT.getStatus());
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
	public List<Combination> getCombinationPaging(PagingCombinationParam param) {
		
		Preconditions.checkNotNull(param);
		Preconditions.checkArgument(param.getPageIndex() >= 0 && param.getPageSize() > 0);
		
		return combinationMapper.selectPaging(param);
	}

	@Override
	public CombinationDetailResult getCombinationDetail(String userId, String combinationId) {
		
		Preconditions.checkArgument(StringUtil.isNotEmpty(userId) 
				&& StringUtil.isNotEmpty(combinationId));
		
		return combinationMapper.getCombinationDetail(userId, combinationId);
	}

	@Override
	public Response deleteCombinationByIds(DelCombinationByIdParam param) {
		Preconditions.checkNotNull(param);
		Preconditions.checkArgument(StringUtil.isNotEmpty(param.getUserId()) &&
				CollectionUtil.isNotEmpty(param.getCombinations()));

		int effect = combinationMapper.deleteByIds(param.getUserId(), param.getCombinations());
		return Response.getResponse(effect);
	}

	@Override
	public Response updateCombination(String combinationId, UpdateCombinationParam combination) {
		Preconditions.checkNotNull(combination);
		Preconditions.checkNotNull(combination.getCombination());
		Preconditions.checkArgument(CollectionUtil.isNotEmpty(combination.getProducts())
				&& StringUtil.isNotEmpty(combinationId));
		
		Combination tempCombination = combination.getCombination();
		tempCombination.setId(combinationId);
		if(combination.isModify()){
			combinationMapper.updateByPrimaryKeySelective(tempCombination);
		}
		
		List<ModifyItemMarkParam> marks = combination.getProducts();
		
		List<CombinationProduct> addList = new ArrayList<CombinationProduct>();
		List<CombinationProductKey>	delList = new ArrayList<CombinationProductKey>();
		
		CombinationProduct tempComProd = null;
		for (ModifyItemMarkParam mark : marks) {
			tempComProd = new CombinationProduct();
			tempComProd.setCombinationId(tempCombination.getId());
			tempComProd.setProductId(mark.getProductId());
			if (mark.getNumber() != 0) {
				tempComProd.setNumber(mark.getNumber());
			}
			
			switch (mark.getMark()) {
				case ADD:
					addList.add(tempComProd);
					break;
				case DEL:
					delList.add(tempComProd);
					break;
				case MOD:
					//TODO: 
					break;
			}
		}
		
		if (CollectionUtil.isNotEmpty(addList)) {
			combinationProductMapper.batchInsert(addList);
		}
		
		if (CollectionUtil.isNotEmpty(delList)) {
			combinationProductMapper.batchDeleteByPrimaryKeys(delList);
		}
		
		return new Response().success();
	}

	@Override
	public Response pulishCombination(String combinationId) {
		
		Preconditions.checkArgument(StringUtil.isNotEmpty(combinationId));
		Combination combination = new Combination();
		combination.setId(combinationId);
		combination.setStatus(CombinationStatus.PUBLISH.getStatus());
		
		int effect = combinationMapper.updateByPrimaryKeySelective(combination);
		return Response.getResponse(effect);
	}

}
