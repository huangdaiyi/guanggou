package com.hlhj.guanggou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Preconditions;
import com.hlhj.guanggou.id.IdGenerator;
import com.hlhj.guanggou.mapper.AdornmentMapper;
import com.hlhj.guanggou.param.BasePagingParam;
import com.hlhj.guanggou.param.DelAdronmentParam;
import com.hlhj.guanggou.po.Adornment;
import com.hlhj.guanggou.result.Response;
import com.hlhj.guanggou.service.AdornmentService;
import com.hlhj.guanggou.utils.CollectionUtil;
import com.hlhj.guanggou.utils.DatetUtil;
import com.hlhj.guanggou.utils.StringUtil;

/**
 * 商品装饰收藏
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class AdornmentServiceImpl implements AdornmentService {
	
	
	@Autowired
	private AdornmentMapper adornmentMapper;
	
	@Autowired
	private IdGenerator idGenerator;
	
	@Override
	public Response insert(Adornment adornment) {
		Preconditions.checkNotNull(adornment);
		
		adornment.setCreateTime(DatetUtil.getNow());
		adornment.setId(idGenerator.generateId());
		return Response.getResponse(adornmentMapper.insert(adornment), adornment);
	}

	@Override
	public Response delete(String id) {
		
		Preconditions.checkArgument(StringUtil.isNotEmpty(id));
		return Response.getResponse(adornmentMapper.deleteByPrimaryKey(id));
	}

	@Override
	public List<Adornment> getAdornmentPaging(BasePagingParam param) {
		Preconditions.checkNotNull(param);
		Preconditions.checkArgument(StringUtil.isNotEmpty(param.getUserId())&&
				param.getPageIndex() >= 0 &&
				param.getPageSize() > 0);
		
		return adornmentMapper.selectPaging(param);
	}

	@Override
	public Response batchDelete(DelAdronmentParam param) {
		
		Preconditions.checkNotNull(param);
		Preconditions.checkArgument(StringUtil.isNotEmpty(param.getUserId())&&
				CollectionUtil.isNotEmpty(param.getAdornmentIds()));
		
		int effect = adornmentMapper.deleteByIds(param.getUserId(), param.getAdornmentIds());
		
		return Response.getResponse(effect);
	}
	
}
