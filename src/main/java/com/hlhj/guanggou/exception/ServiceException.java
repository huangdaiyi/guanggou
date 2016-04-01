package com.hlhj.guanggou.exception;

/**
 * 服务运行异常
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class ServiceException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
        super(message);
    }
}
