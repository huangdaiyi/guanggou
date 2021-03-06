package com.hlhj.guanggou.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hlhj.guanggou.constant.ResponseCode;

/**
 * 响应对象
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
@JsonInclude(Include.NON_NULL) 
public class Response {

    private static final String OK = "ok";
    private static final String ERROR = "error";

    private ResponseCode code;
    private String message;
    private Object data;

    public Response success() {
    	this.setCode(ResponseCode.SUCCESS);
    	this.setMessage(OK);
        return this;
    }

    public Response success(Object data) {
    	success();
        this.data = data;
        return this;
    }

    public Response failure() {
    	this.setCode(ResponseCode.FAILED);
    	this.setMessage(ERROR);
        return this;
    }

    public Response failure(String message) {
    	this.setCode(ResponseCode.FAILED);
    	this.setMessage(message);
        return this;
    }

   

    public Object getData() {
        return data;
    }

	public ResponseCode getCode() {
		return code;
	}

	public void setCode(ResponseCode code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static Response getResponse(int effect, Object data) {
		Response response = new Response();
		return effect > 0 ? response.success(data) : response.failure();
	}
	
	public static Response getResponse(int effect){
		return getResponse(effect, null);
	}

}
