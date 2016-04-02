package com.hlhj.guanggou.param;

import com.hlhj.guanggou.paging.Paging;

/**
 * 分页参数
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class BasePagingParam extends Paging {
	
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
