package com.hlhj.guanggou.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CombinationStatus {
	PUBLISH("P"),
	DRAFT("NP");
	
	private String status;
	
	private CombinationStatus(String status){
		this.status = status;
	}
	
	@JsonValue
	public String getStatus() {
		return status;
	}
	
	@JsonCreator
	public static CombinationStatus parse(String status){
		for (CombinationStatus item : CombinationStatus.values()) {
			if(item.getStatus().equals(status)){
				return item;
			}
		}
		throw new RuntimeException("Bad Combination status");
	}
	
}
