package com.hlhj.guanggou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hlhj.guanggou.service.CombinationService;


@RestController
@RequestMapping("/combination/product")
public class CombinationController {
	
	@Autowired
	private CombinationService combinationService;
	
	
	
}
