package com.github.dee1024.sloth.utils;

import java.util.Arrays;

/**
 * Created by sloth on 16/6/16.
 */
public class StringUtil {

	public static boolean isEmpty(String s){
		return s==null || "".equals(s);
	}

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

	public static final String lowerFirst(String s) {
		int len = s.length();
		if (len <= 0)
			return "";
		StringBuffer sb = new StringBuffer();
		sb.append(s.substring(0, 1).toLowerCase());
		sb.append(s.substring(1, len));
		return sb.toString();
	}


	public static final String newTableName(String tableName) {
		String strS[] = tableName.split("_");
		String newStr = "";
		for (String st : strS) {
			newStr += StringUtil.upperFirst(st);
		}
		return newStr;
	}


	public static void main(String[] args) {
		System.out.println("s".toUpperCase());
	}
}
