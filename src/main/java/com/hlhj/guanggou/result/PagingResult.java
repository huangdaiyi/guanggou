package com.hlhj.guanggou.result;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hlhj.guanggou.paging.TotalCountHolder;

/**
 * 分页结果对象
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
@JsonInclude(Include.NON_NULL) 
public class PagingResult<T> {

    private List<T> items;

    private long total;


    public PagingResult(List<T> items) {
    	this.setItems(items);
        this.total = TotalCountHolder.get();
    }


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }


	public List<T> getItems() {
		return items;
	}


	public void setItems(List<T> items) {
		this.items = items;
	}
}
