package com.hlhj.guanggou.param;


import java.util.List;

import javax.validation.constraints.NotNull;

import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.po.CombinationProduct;

public class CombinationParam extends BaseParam{
	
	@NotNull
	private Combination combination;
	
	@NotNull
	private List<CombinationProduct> products;

	public Combination getCombination() {
		return combination;
	}

	public void setCombination(Combination combination) {
		this.combination = combination;
	}
	
	
	public List<CombinationProduct> getProducts() {
		return products;
	}

	public void setProducts(List<CombinationProduct> products) {
		this.products = products;
	}
	
}
