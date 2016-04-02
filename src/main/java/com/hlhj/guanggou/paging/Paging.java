package com.hlhj.guanggou.paging;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 类型说明
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class Paging {
	
	private int pageSize = 10;
	private int pageIndex = 0;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	@JsonIgnore
	public int getOffset() {
		return pageSize*pageIndex;
	}
}
