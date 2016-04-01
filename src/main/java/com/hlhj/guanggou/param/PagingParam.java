package com.hlhj.guanggou.param;

/**
 * 分页参数
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class PagingParam extends BaseParam {
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
	
//	public PagingParam(int pageIndex, int pageSize){
//		this.pageIndex = pageIndex;
//		this.pageSize = pageSize;
//	}
}
