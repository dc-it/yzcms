package com.mapc.yzcms.common.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Objects;

/**
 * 通用返回对象
 *
 * @author duchao
 */
@Data
@ApiModel(value = "响应结果")
public class Result<T> {

	@ApiModelProperty(name = "code", value = "状态码")
	private int code;

	@ApiModelProperty(name = "message", value = "消息提示")
	private String message;

	@ApiModelProperty(name = "data", value = "响应数据")
	private T data;

	protected Result() {
	}

	protected Result(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	protected Result(ICode code) {
		Objects.requireNonNull(code);
		this.code = code.getCode();
		this.message = code.getMessage();
		this.data = null;
	}

	/**
	 * 成功返回结果
	 */
	public static <T> Result<T> success() {
		return new Result<T>(ResultCode.SUCCESS);
	}

	/**
	 * 成功返回结果
	 *
	 * @param message 提示信息
	 */
	public static <T> Result<T> success(String message) {
		return new Result<T>(ResultCode.SUCCESS.getCode(), message, null);
	}

	/**
	 * 成功返回结果
	 *
	 * @param data 获取的数据
	 */
	public static <T> Result<T> success(T data) {
		return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
	}

	/**
	 * 成功返回结果
	 *
	 * @param data    获取的数据
	 * @param message 提示信息
	 */
	public static <T> Result<T> success(T data, String message) {
		return new Result<T>(ResultCode.SUCCESS.getCode(), message, data);
	}

	/**
	 * 失败返回结果
	 *
	 * @param errorCode 错误码
	 */
	public static <T> Result<T> failed(ICode errorCode) {
		return new Result<T>(errorCode.getCode(), errorCode.getMessage(), null);
	}

	/**
	 * 失败返回结果
	 *
	 * @param message 提示信息
	 */
	public static <T> Result<T> failed(String message) {
		return new Result<T>(ResultCode.FAILED.getCode(), message, null);
	}

	/**
	 * 失败返回结果
	 *
	 * @param code    状态码
	 * @param message 提示信息
	 */
	public static <T> Result<T> failed(int code, String message) {
		return new Result<T>(code, message, null);
	}

	/**
	 * 失败返回结果
	 */
	public static <T> Result<T> failed() {
		return failed(ResultCode.FAILED);
	}

	/**
	 * 参数验证失败返回结果
	 */
	public static <T> Result<T> validateFailed() {
		return failed(ResultCode.VALIDATE_FAILED);
	}

	/**
	 * 参数验证失败返回结果
	 *
	 * @param message 提示信息
	 */
	public static <T> Result<T> validateFailed(String message) {
		return new Result<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
	}

	/**
	 * 未登录返回结果
	 */
	public static <T> Result<T> unauthorized(T data) {
		return new Result<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
	}

	/**
	 * 未授权返回结果
	 */
	public static <T> Result<T> forbidden(T data) {
		return new Result<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
	}
}
