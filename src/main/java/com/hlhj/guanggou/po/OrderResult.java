package com.hlhj.guanggou.po;

import java.math.BigDecimal;
import java.util.List;

/**
 * 
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class OrderResult {
	
	// 总价格
	private BigDecimal totalPrice;
	
	// 运费
	private boolean hasfreight;
	
	// 优化价格
	private BigDecimal totalDiscount;
	
	
	private List<OrderItem> orderitems;


	public BigDecimal getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}


	public boolean isHasfreight() {
		return hasfreight;
	}


	public void setHasfreight(boolean hasfreight) {
		this.hasfreight = hasfreight;
	}


	public BigDecimal getTotalDiscount() {
		return totalDiscount;
	}


	public void setTotalDiscount(BigDecimal totalDiscount) {
		this.totalDiscount = totalDiscount;
	}


	public List<OrderItem> getOrderitems() {
		return orderitems;
	}


	public void setOrderitems(List<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}
	
	public OrderResult addResult(OrderDelta orderDelta){
		//TODO :
		return this;
	}

}
