package com.hlhj.guanggou.service;

import java.util.List;

import com.hlhj.guanggou.param.CombinationParam;
import com.hlhj.guanggou.param.DelCombinationByIdParam;
import com.hlhj.guanggou.param.PagingCombinationParam;
import com.hlhj.guanggou.param.UpdateCombinationParam;
import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.result.CombinationDetailResult;
import com.hlhj.guanggou.result.Response;

public interface CombinationService {
	
	Response insert(CombinationParam combination);
	
	List<Combination> getCombinationPaging(PagingCombinationParam param);
	
	CombinationDetailResult getCombinationDetail(String userId, String combinationId);
	
	Response deleteCombinationByIds(DelCombinationByIdParam param);
	
	Response updateCombination(String combinationId, UpdateCombinationParam combination);
	
	Response pulishCombination(String combinationId);
	
	List<Combination> getCombinationByTopic(String userId, String topicId);

}
