package com.hlhj.guanggou.service;

import com.hlhj.guanggou.param.PromotionParam;
import com.hlhj.guanggou.po.OrderResult;

/**
 * 类型说明
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public interface PromotionService {
	
	OrderResult Calculation(PromotionParam params);
	
}
