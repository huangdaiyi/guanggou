package com.hlhj.guanggou.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.hlhj.guanggou.activity.ActivityRule;
import com.hlhj.guanggou.activity.RuleFilter;
import com.hlhj.guanggou.param.PromotionParam;
import com.hlhj.guanggou.po.OrderDelta;
import com.hlhj.guanggou.po.OrderResult;
import com.hlhj.guanggou.service.PromotionService;
import com.hlhj.guanggou.utils.StringUtil;

/**
 * 类型说明
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class PromotionServiceImpl  implements PromotionService{
	
	private List<ActivityRule> rules;
	
	private List<RuleFilter> ruleFilters;
	
	@Autowired
	private ApplicationContext appContext;
	
	private String activityRuleBeanName;
	
	private String ruleFiltersBeanName;
	
	
	public String getActivityRuleBeanName() {
		return activityRuleBeanName;
	}


	public void setActivityRuleBeanName(String activityRuleBeanName) {
		this.activityRuleBeanName = activityRuleBeanName;
	}


	public String getRuleFiltersBeanName() {
		return ruleFiltersBeanName;
	}


	public void setRuleFiltersBeanName(String ruleFiltersBeanName) {
		this.ruleFiltersBeanName = ruleFiltersBeanName;
	}


	@PostConstruct 
	public void init(){
		
		if (StringUtil.isNotEmpty(activityRuleBeanName)) {
			if (rules == null) {
				rules = new ArrayList<ActivityRule>();
			}
			
			String[] ruleBeans = activityRuleBeanName.split(",");
			for (String beanName : ruleBeans) {
				rules.add((ActivityRule)appContext.getBean(beanName));
			}
		}
		
		if (StringUtil.isNotEmpty(ruleFiltersBeanName)) {
			if (ruleFilters == null) {
				ruleFilters = new ArrayList<RuleFilter>();
			}
			
			String[] ruleBeans = ruleFiltersBeanName.split(",");
			for (String beanName : ruleBeans) {
				ruleFilters.add((RuleFilter)appContext.getBean(beanName));
			}
		}
	}
	
 	
	@Override
	public OrderResult Calculation(PromotionParam params) {
		
		OrderResult orderResult = new OrderResult();
		
		for (RuleFilter ruleFilter : ruleFilters) {
			if(!ruleFilter.filter(params)){
				return orderResult;
			}
		}
		
		for (ActivityRule ruleItem : rules) {
			OrderDelta orderDelta = ruleItem.rule(params);
			orderResult.addResult(orderDelta);
		}
		
		return orderResult;
	}
	
	
}
