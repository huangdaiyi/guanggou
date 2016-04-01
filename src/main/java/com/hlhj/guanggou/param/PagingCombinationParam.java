package com.hlhj.guanggou.param;

import com.hlhj.guanggou.constant.CombinationStatus;

public class PagingCombinationParam extends PagingParam {
	
	private CombinationStatus status;

	public CombinationStatus getStatus() {
		return status;
	}

	public void setStatus(CombinationStatus status) {
		this.status = status;
	}
}
