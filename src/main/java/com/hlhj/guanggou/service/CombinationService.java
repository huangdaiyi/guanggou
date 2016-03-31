package com.hlhj.guanggou.service;

import com.hlhj.guanggou.param.CombinationParam;
import com.hlhj.guanggou.param.PagingCombinationParam;
import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.po.Paging;
import com.hlhj.guanggou.po.Response;
import com.hlhj.guanggou.result.CombinationResult;

public interface CombinationService {
	
	Response insert(CombinationParam combination);
	
	Paging<Combination> getCombinationPaging(PagingCombinationParam param);
	
	CombinationResult getCombinationDetail(String userId, String combinationId);
	
	Response deleteCombinationByIds(String userId, String[] combinatioinIds);
	
	Response updateCombination(CombinationParam combination);
	
	Response pulishCombination(String combinationId);

}
