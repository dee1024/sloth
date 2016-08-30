package com.dee.utils;

import java.util.Arrays;

/**
 * Created by dee on 16/6/16.
 */
public class StringUtil {

	public static boolean isEmpty(String s){
		return s==null || "".equals(s);
	}
	/**
	 * 首字母大写
	 * 
	 * @param s
	 * @return
	 */
	public static final String upperFirst(String s) {
		if(s==null)
			return "";
		int len = s.length();
		if (len <= 0)
			return "";
		StringBuffer sb = new StringBuffer();
		sb.append(s.substring(0, 1).toUpperCase());
		sb.append(s.substring(1, len));
		return sb.toString();
	}

	/**
	 * 首字母小写
	 * 
	 * @param s
	 * @return
	 */
	public static final String lowerFirst(String s) {
		int len = s.length();
		if (len <= 0)
			return "";
		StringBuffer sb = new StringBuffer();
		sb.append(s.substring(0, 1).toLowerCase());
		sb.append(s.substring(1, len));
		return sb.toString();
	}

	/**
	 * 去掉表名字中间的“_”, 然后根据驼峰规则生成表名
	 * @param tableName
	 * @return
	 */
	public static final String newTableName(String tableName) {
		String strS[] = tableName.split("_");
		String newStr = "";
		for (String st : strS) {
			newStr += StringUtil.upperFirst(st);
		}
		return newStr;
	}

	public static <T> T[] concatAll(T[] first, T[]... rest) {
		int totalLength = first.length;
		for (T[] array : rest) {
			totalLength += array.length;
		}
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}


	public static void main(String[] args) {
		System.out.println("s".toUpperCase());
	}
}
