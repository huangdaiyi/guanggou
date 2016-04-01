package com.hlhj.guanggou.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 操作类型枚举
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public enum OperateMark {

	ADD(0), DEL(1), MOD(2);

	private int mark;

	private OperateMark(int mark) {
		this.mark = mark;
	}

	@JsonCreator
	public static OperateMark parse(int mark) {
		for (OperateMark item : OperateMark.values()) {
			if (item.getMark() == mark) {
				return item;
			}
		}
		throw new RuntimeException("Bad Operation Code");
	}

	@JsonValue
	public int getMark() {
		return mark;
	}

}
