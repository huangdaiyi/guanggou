package com.hlhj.guanggou.po;

import java.math.BigDecimal;
import java.util.List;

/**
 * 优惠结果
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class OrderDelta {

	private List<OrderProduct> products;

	private BigDecimal price;

	// 赠品
	private List<ActiviryGift> gifts;
	
	private int points;

	public List<OrderProduct> getProducts() {
		return products;
	}

	public void setProducts(List<OrderProduct> products) {
		this.products = products;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<ActiviryGift> getGifts() {
		return gifts;
	}

	public void setGifts(List<ActiviryGift> gifts) {
		this.gifts = gifts;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
