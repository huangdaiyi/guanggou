package com.hlhj.guanggou.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.hlhj.guanggou.constant.CombinationStatus;
import com.hlhj.guanggou.id.IdGenerator;
import com.hlhj.guanggou.mapper.CombinationMapper;
import com.hlhj.guanggou.mapper.CombinationProductMapper;
import com.hlhj.guanggou.param.CombinationParam;
import com.hlhj.guanggou.param.DelCombinationByIdParam;
import com.hlhj.guanggou.param.GetCombinationDetailParam;
import com.hlhj.guanggou.param.PagingCombinationParam;
import com.hlhj.guanggou.param.UpdateCombinationParam;
import com.hlhj.guanggou.param.UpdateCombinationParam.ModifyMark;
import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.po.CombinationProduct;
import com.hlhj.guanggou.po.CombinationProductKey;
import com.hlhj.guanggou.po.Response;
import com.hlhj.guanggou.result.CombinationDetailResult;
import com.hlhj.guanggou.service.CombinationService;
import com.hlhj.guanggou.utils.CollectionUtil;
import com.hlhj.guanggou.utils.StringUtil;

/**
 * 商品组合Service
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
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
	public List<Combination> getCombinationPaging(PagingCombinationParam param) {
		
		Preconditions.checkNotNull(param);
		Preconditions.checkArgument(param.getPageIndex() >= 0 && param.getPageSize() > 0);
		
		return combinationMapper.selectPaging(param);
	}

	@Override
	public CombinationDetailResult getCombinationDetail(GetCombinationDetailParam param) {
		
		Preconditions.checkNotNull(param);
		Preconditions.checkArgument(StringUtil.isNotEmpty(param.getUserId()) 
				&& StringUtil.isNotEmpty(param.getCombinationId()));
		
		return combinationMapper.getCombinationDetail(param.getUserId(), param.getCombinationId());
	}

	@Override
	public Response deleteCombinationByIds(DelCombinationByIdParam param) {
		Preconditions.checkNotNull(param);
		Preconditions.checkArgument(StringUtil.isNotEmpty(param.getUserId()) &&
				CollectionUtil.isNotEmpty(param.getCombinationIds()));

		int effect = combinationMapper.deleteByIds(param.getUserId(), param.getCombinationIds());
		return Response.getResponse(effect);
	}

	@Override
	public Response updateCombination(UpdateCombinationParam combination) {
		Preconditions.checkNotNull(combination);
		Preconditions.checkNotNull(combination.getCombination());
		Preconditions.checkArgument(CollectionUtil.isNotEmpty(combination.getProducts())
				&& StringUtil.isNotEmpty(combination.getCombination().getId()));
		
		Combination tempCombination = combination.getCombination();
		if(combination.isModify()){
			combinationMapper.updateByPrimaryKey(tempCombination);
		}
		
		List<ModifyMark> marks = combination.getProducts();
		
		List<CombinationProduct> addList = new ArrayList<CombinationProduct>();
		List<CombinationProductKey>	delList = new ArrayList<CombinationProductKey>();
		
		CombinationProduct tempComProd = null;
		for (ModifyMark mark : marks) {
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
		
		int effect = combinationMapper.updateByPrimaryKey(combination);
		return Response.getResponse(effect);
	}

}
