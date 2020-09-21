package com.mapc.yzcms.common.exception;

import com.mapc.yzcms.common.api.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常切面
 *
 * @author duchao
 */
@Slf4j
@RestControllerAdvice
public class BaseExceptionHandleAdvice {

	/**
	 * Provides handling for standard Spring MVC exceptions.
	 *
	 * @param ex      the target exception
	 * @param request the current request
	 */
	@ExceptionHandler({
			HttpRequestMethodNotSupportedException.class,
			HttpMediaTypeNotSupportedException.class,
			HttpMediaTypeNotAcceptableException.class,
			MissingPathVariableException.class,
			MissingServletRequestParameterException.class,
			ServletRequestBindingException.class,
			ConversionNotSupportedException.class,
			TypeMismatchException.class,
			HttpMessageNotReadableException.class,
			HttpMessageNotWritableException.class,
			MethodArgumentNotValidException.class,
			MissingServletRequestPartException.class,
			BindException.class,
			AsyncRequestTimeoutException.class
	})
	public final Result<Object> handleException(Exception ex, HttpServletRequest request) throws Exception {
		HttpStatus status = null;
		if (ex instanceof HttpRequestMethodNotSupportedException) {
			status = HttpStatus.METHOD_NOT_ALLOWED;
		} else if (ex instanceof HttpMediaTypeNotSupportedException) {
			status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		} else if (ex instanceof HttpMediaTypeNotAcceptableException) {
			status = HttpStatus.NOT_ACCEPTABLE;
		} else if (ex instanceof MissingPathVariableException) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} else if (ex instanceof MissingServletRequestParameterException) {
			status = HttpStatus.BAD_REQUEST;
		} else if (ex instanceof ServletRequestBindingException) {
			status = HttpStatus.BAD_REQUEST;
		} else if (ex instanceof ConversionNotSupportedException) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} else if (ex instanceof TypeMismatchException) {
			status = HttpStatus.BAD_REQUEST;
		} else if (ex instanceof HttpMessageNotReadableException) {
			status = HttpStatus.BAD_REQUEST;
		} else if (ex instanceof HttpMessageNotWritableException) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} else if (ex instanceof MethodArgumentNotValidException) {
			status = HttpStatus.BAD_REQUEST;
		} else if (ex instanceof MissingServletRequestPartException) {
			status = HttpStatus.BAD_REQUEST;
		} else if (ex instanceof BindException) {
			status = HttpStatus.BAD_REQUEST;
		} else if (ex instanceof NoHandlerFoundException) {
			status = HttpStatus.NOT_FOUND;
		} else if (ex instanceof AsyncRequestTimeoutException) {
			status = HttpStatus.SERVICE_UNAVAILABLE;
		}
		log.error("{}请求异常：{}-{}", request.getRequestURI(), status.value(), status.getReasonPhrase());
		return Result.failed(status.value(), String.format("请求有异常：%s", status.getReasonPhrase()));
	}

	/**
	 * 自定义异常
	 *
	 * @param ex      异常对象
	 * @param request 请求对象
	 * @return
	 */
	@ExceptionHandler(BaseException.class)
	public final Result<Object> handleBaseException(BaseException ex, HttpServletRequest request) {
		log.error("{}自定义异常：{}", request.getRequestURI(), ex.getMsg());
		log.error(ex.getMessage());
		return Result.failed(ex.getMessage());
	}

	/**
	 * 404处理
	 *
	 * @param ex      异常对象
	 * @param request 请求对象
	 * @return
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public final Result<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpServletRequest request) {
		String path = request.getRequestURI();
		log.error("{}请求异常：404-接口不存在", path);
		return Result.failed(404, "请求接口" + path + "不存在");
	}

	/**
	 * 404处理
	 *
	 * @param ex      异常对象
	 * @param request 请求对象
	 * @return
	 */
	@ExceptionHandler(AuthenticationException.class)
	public final Result<Object> handleAuthenticationException(NoHandlerFoundException ex, HttpServletRequest request) {
		String path = request.getRequestURI();
		log.error("{}请求异常：404-接口不存在", path);
		return Result.failed(404, "请求接口" + path + "不存在");
	}

	/**
	 * 系统异常
	 *
	 * @param ex 异常对象
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public final Result<Object> handleSysException(Exception ex) {
		log.error("{}系统异常：{}", ex.getMessage());
		return Result.failed("系统异常");
	}
}
