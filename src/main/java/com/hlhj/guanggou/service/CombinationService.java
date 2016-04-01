package com.hlhj.guanggou.service;

import java.util.List;

import com.hlhj.guanggou.param.CombinationParam;
import com.hlhj.guanggou.param.DelCombinationByIdParam;
import com.hlhj.guanggou.param.GetCombinationDetailParam;
import com.hlhj.guanggou.param.PagingCombinationParam;
import com.hlhj.guanggou.param.UpdateCombinationParam;
import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.po.Response;
import com.hlhj.guanggou.result.CombinationDetailResult;

public interface CombinationService {
	
	Response insert(CombinationParam combination);
	
	List<Combination> getCombinationPaging(PagingCombinationParam param);
	
	CombinationDetailResult getCombinationDetail(GetCombinationDetailParam param);
	
	Response deleteCombinationByIds(DelCombinationByIdParam param);
	
	Response updateCombination(UpdateCombinationParam combination);
	
	Response pulishCombination(String combinationId);

}
