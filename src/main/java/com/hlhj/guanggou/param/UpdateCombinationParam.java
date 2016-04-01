package com.hlhj.guanggou.param;


import java.util.List;

import com.hlhj.guanggou.constant.OperateMark;
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
	
	private List<ModifyMark> products;
	
	public Combination getCombination() {
		return combination;
	}
	
	public void setCombination(Combination combination) {
		this.combination = combination;
	}

	public List<ModifyMark> getProducts() {
		return products;
	}

	public void setProducts(List<ModifyMark> products) {
		this.products = products;
	}

	public boolean isModify() {
		return modify;
	}

	public void setModify(boolean modify) {
		this.modify = modify;
	}

	public class ModifyMark{
		private int productId;
		private int number = 0;
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
}
