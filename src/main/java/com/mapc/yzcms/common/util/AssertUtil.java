package com.mapc.yzcms.common.util;

import cn.hutool.core.util.StrUtil;
import com.mapc.yzcms.common.exception.BaseException;
import lombok.experimental.UtilityClass;

/**
 * Assert工具类
 *
 * @author duchao
 */
@UtilityClass
public class AssertUtil {

	public static String notBlank(String text, String errorMsgTemplate, Object... params) throws BaseException {
		if (StrUtil.isBlank(text)) {
			throw new BaseException(StrUtil.format(errorMsgTemplate, params));
		}
		return text;
	}

	public static <T> T notNull(T object, String errorMsgTemplate, Object... params) throws BaseException {
		if (object == null) {
			throw new BaseException(StrUtil.format(errorMsgTemplate, params));
		}
		return object;
	}

	public static void isNull(Object object, String errorMsgTemplate, Object... params) throws BaseException {
		if (object != null) {
			throw new BaseException(StrUtil.format(errorMsgTemplate, params));
		}
	}

	public static void isFalse(boolean expression, String errorMsgTemplate, Object... params) throws BaseException {
		if (expression) {
			throw new BaseException(StrUtil.format(errorMsgTemplate, params));
		}
	}

	public static void isTrue(boolean expression, String errorMsgTemplate, Object... params) throws BaseException {
		if (false == expression) {
			throw new BaseException(StrUtil.format(errorMsgTemplate, params));
		}
	}
}
