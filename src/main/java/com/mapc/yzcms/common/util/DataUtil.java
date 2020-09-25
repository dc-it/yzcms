package com.mapc.yzcms.common.util;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 数据工具类
 *
 * @author duchao
 */
@UtilityClass
public class DataUtil {

	/**
	 * 对象转字符串
	 *
	 * @param obj 对象
	 * @return
	 */
	public static <T> void converterBlank2Null(T obj, Class<T> tClass, String... ignoreProperties) {

		List<String> ignorePropertyList = ListUtil.toList(ignoreProperties);
		Field[] fields = tClass.getDeclaredFields();
		for (int i = 0, len = fields.length; i < len; i++) {

			boolean accessFlag = false;
			try {
				// 对于每个属性，获取属性名
				String fieldName = fields[i].getName();
				if (ignorePropertyList.contains(fieldName)) {
					continue;
				}
				// 获取原来的访问控制权限
				accessFlag = fields[i].isAccessible();
				// 修改访问控制权限
				fields[i].setAccessible(true);
				// 获取在对象f中属性fields[i]对应的对象中的变量
				Object value;
				try {
					value = fields[i].get(obj);
					if (String.class.equals(fields[i].getType()) && (ObjectUtil.isNull(value) || StrUtil.isBlank(value.toString()))) {
						fields[i].set(obj, null);
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			} catch (IllegalArgumentException ex) {
				ex.printStackTrace();
			} finally {
				// 恢复访问控制权限
				fields[i].setAccessible(accessFlag);
			}
		}

	}
}
