package com.hlhj.guanggou.po;

public class CombinationProduct extends CombinationProductKey {
	
	private Integer productNum;

    public Integer getProductNum() {
        return productNum;
    }
    
    public CombinationProduct(String combinationId, Integer productId) {
		super(combinationId, productId);
		this.productNum = 1;
	}
   

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }
}