package com.mapc.yzcms.common.util;

import cn.hutool.core.util.RandomUtil;
import lombok.experimental.UtilityClass;

/**
 * 验证码工具类
 *
 * @author duchao
 */
@UtilityClass
public class CaptchaUtil {

	/**
	 * 生成验证码
	 * @return
	 */
	public static String generateCaptcha(){
		StringBuilder validateCode = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			validateCode.append(RandomUtil.randomInt(0,10));
		}
		return validateCode.toString();
	}
}
