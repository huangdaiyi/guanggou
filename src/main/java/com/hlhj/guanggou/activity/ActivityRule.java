package com.hlhj.guanggou.activity;

import com.hlhj.guanggou.param.PromotionParam;
import com.hlhj.guanggou.po.OrderDelta;

/**
 * 类型说明
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public interface ActivityRule {
	OrderDelta rule(PromotionParam params);
}
