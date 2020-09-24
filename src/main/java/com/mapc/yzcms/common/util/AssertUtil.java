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
}
