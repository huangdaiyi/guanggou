package com.hlhj.guanggou.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hlhj.guanggou.param.BasePagingParam;
import com.hlhj.guanggou.po.Adornment;
import com.hlhj.guanggou.result.PagingResult;
import com.hlhj.guanggou.result.Response;
import com.hlhj.guanggou.service.AdornmentService;


/**
 * 商品装饰控制器
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/adornment")
public class AdornmentController {
	
	@Autowired
	private AdornmentService adornmentService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Response addAdornment(@Valid @RequestBody Adornment adornment){
		
		return adornmentService.insert(adornment);
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Response getAdornmentsPaging(@Valid @RequestBody BasePagingParam param) {
		
		List<Adornment> adornmentlist = adornmentService.getAdornmentPaging(param);
		return new Response().success(new PagingResult<>(adornmentlist));
	}
}
