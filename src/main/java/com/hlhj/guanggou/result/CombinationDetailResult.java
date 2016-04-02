package com.hlhj.guanggou.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.po.Product;

@JsonInclude(Include.NON_NULL) 
public class CombinationDetailResult {
	private Combination combinationinfo;
	private Product products;
	
	public Combination getCombinationinfo() {
		return combinationinfo;
	}
	public void setCombinationinfo(Combination combinationinfo) {
		this.combinationinfo = combinationinfo;
	}
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
}
