package com.hlhj.guanggou.service;

import java.util.List;

import com.hlhj.guanggou.param.BasePagingParam;
import com.hlhj.guanggou.po.Adornment;
import com.hlhj.guanggou.result.Response;

public interface AdornmentService {
	Response insert(Adornment adornment);
	Response delete(String id);
	List<Adornment> getAdornmentPaging(BasePagingParam param);
}
