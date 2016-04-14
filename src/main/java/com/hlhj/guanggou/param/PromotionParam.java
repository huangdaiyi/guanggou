package com.hlhj.guanggou.param;

import java.util.List;

import com.hlhj.guanggou.po.OrderProduct;

/**
 * 类型说明
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class PromotionParam extends BaseParam {
	
	private List<OrderProduct> products;

	public List<OrderProduct> getProducts() {
		return products;
	}

	public void setProducts(List<OrderProduct> products) {
		this.products = products;
	}

}
