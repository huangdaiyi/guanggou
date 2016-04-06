package com.hlhj.guanggou.param;


import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.po.CombinationProduct;

public class CombinationParam extends BaseParam{
	
	private Combination combination;
	
	private List<CombinationProduct> products;
	
	@NotNull
	@Valid
	public Combination getCombination() {
		return combination;
	}

	public void setCombination(Combination combination) {
		this.combination = combination;
	}
	
	@NotNull
	public List<CombinationProduct> getProducts() {
		return products;
	}

	public void setProducts(List<CombinationProduct> products) {
		this.products = products;
	}
	
}
