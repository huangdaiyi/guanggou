package com.hlhj.guanggou.exception;

/**
 * 令牌异常
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class TokenException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TokenException(String message) {
        super(message);
    }
}
