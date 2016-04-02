package com.hlhj.guanggou.param;

import java.util.List;

import com.hlhj.guanggou.po.Combination;

/**
 * 类型说明
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class UpdateCombinationParam {
	
	private Combination combination;
	private boolean modify = false;
	
	private List<ModifyItemMarkParam> products;
	
	public Combination getCombination() {
		return combination;
	}
	
	public void setCombination(Combination combination) {
		this.combination = combination;
	}

	public List<ModifyItemMarkParam> getProducts() {
		return products;
	}

	public void setProducts(List<ModifyItemMarkParam> products) {
		this.products = products;
	}

	public boolean isModify() {
		return modify;
	}

	public void setModify(boolean modify) {
		this.modify = modify;
	}
	
}
