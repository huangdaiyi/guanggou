package com.hlhj.guanggou.result;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hlhj.guanggou.po.Combination;
import com.hlhj.guanggou.po.Product;

@JsonInclude(Include.NON_NULL) 
public class CombinationDetailResult {
	private Combination combinationinfo;
	private List<Product> products;
	
	public Combination getCombinationinfo() {
		return combinationinfo;
	}
	public void setCombinationinfo(Combination combinationinfo) {
		this.combinationinfo = combinationinfo;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
