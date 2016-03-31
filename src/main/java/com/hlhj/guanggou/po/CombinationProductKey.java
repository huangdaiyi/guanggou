package com.hlhj.guanggou.po;

public class CombinationProductKey {
    private String combinationId;

    private Integer productId;
    
    
    
    public CombinationProductKey(String combinationId, Integer productId) {
		super();
		this.combinationId = combinationId;
		this.productId = productId;
	}

	public String getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(String combinationId) {
        this.combinationId = combinationId == null ? null : combinationId.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}