package com.mapc.yzcms.common.util;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

/**
 * 验证工具
 *
 * @author duchao
 */
@UtilityClass
public class ValidateUtil {

	public final static String REGEX_PHONE = "^1[0-9]{10}$";
	public final static String REGEX_EMAIL = "^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";

	/**
	 * 是否是手机号
	 *
	 * @param phone 手机号
	 * @return
	 */
	public static boolean isPhone(String phone) {
		return Pattern.matches(REGEX_PHONE,phone);
	}

	/**
	 * 是否是邮箱
	 *
	 * @param email 邮箱
	 * @return
	 */
	public static boolean isEmail(String email) {
		return Pattern.matches(REGEX_EMAIL,email);
	}
}
