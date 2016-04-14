package com.hlhj.guanggou.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hlhj.guanggou.result.Response;

/**
 * 类型说明
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
@RestController("promotion")
public class PromotionController {

	
	
	@RequestMapping(method=RequestMethod.POST)
	public Response promotionCalculation() {
		
		return null;
	}
}
