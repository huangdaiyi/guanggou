package com.hlhj.guanggou.param;

/**
 * 类型说明
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class DelCombinationByIdParam extends BaseParam {
	private String[] combinations;

	public String[] getCombinations() {
		return combinations;
	}

	public void setCombinations(String[] combinationIds) {
		this.combinations = combinationIds;
	}
	
	
}
