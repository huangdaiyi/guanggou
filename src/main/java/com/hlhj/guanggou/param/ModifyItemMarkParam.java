package com.hlhj.guanggou.param;

import com.hlhj.guanggou.constant.OperateMark;

public class ModifyItemMarkParam {
	private int productId;
	private int number;
	private OperateMark mark;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public OperateMark getMark() {
		return mark;
	}

	public void setMark(OperateMark mark) {
		this.mark = mark;
	}

}