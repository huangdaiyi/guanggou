//package com.hlhj.guanggou.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.hlhj.guanggou.mapper.ItemsMapper;
//import com.hlhj.guanggou.po.Items;
//
//
//@RestController
//@RequestMapping("/item")
//public class ItemController {
//	
//	@Autowired
//	ItemsMapper itemMapper;
//	
//	@RequestMapping("/{id}")
//	public Items getItems(@PathVariable("id") int id){
//		
//		Items item = itemMapper.selectByPrimaryKey(1);
//		
//		return item;
//		
//	}
//	
//	@RequestMapping("/update")
//	public String updateItems(@RequestBody Items item){
//		
//		itemMapper.updateByPrimaryKey(item);
//		return "ok!";
//		
//	}
//
//}
