package com.mapc.yzcms.common.exception;

import com.mapc.yzcms.common.api.ICode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 自定义基本的异常
 *
 * @author duchao
 */
@Setter
@Getter
public class BaseException extends RuntimeException {

	private String msg;
	private int code = 500;

	public BaseException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public BaseException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public BaseException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public BaseException(ICode errorCode) {
		Objects.requireNonNull(errorCode);
		this.msg = errorCode.getMessage();
		this.code = errorCode.getCode();
	}

	public BaseException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}
}
