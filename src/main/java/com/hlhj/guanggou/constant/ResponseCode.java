package com.hlhj.guanggou.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseCode {
	SUCCESS(0),
	FAILED(1);
	
	private int code;
	
	private ResponseCode(int code){
		this.code = code;
	}
	
	@JsonCreator
	public static ResponseCode parse(int code){
		for (ResponseCode item : ResponseCode.values()) {
			if(item.getCode() == code){
				return item;
			}
		}
		throw new RuntimeException("Bad Response Code");
	}
	
	@JsonValue
	public int getCode(){
		return this.code;
	}
}
