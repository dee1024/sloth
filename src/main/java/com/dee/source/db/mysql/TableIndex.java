package com.dee.source.db.mysql;

import java.util.List;
import java.util.Map;

/**
 * 表的索引
 */
public class TableIndex {
	private String indexName; // 索引名称
	private List<String> carrayNames;// 原关联字段
	private List<String> carrayNames_d;// 大写关联字段
	private List<String> carrayNames_x;// 小写关联字段
	private List<Map<String, String>> carrayNameMaps;// 原字段+小写字段
	private String stringCarrayNames1;// 直接拼接大写字段
	private String stringCarrayNames2;// ","拼接大写字段
	private String stringCarrayNames3;// 类型+ ","拼接大写字段
	private String stringCarrayNames4;// ","拼接小写字段
	private String stringCarrayNames5;// sqlMap中sql用的 原字段-小写字段
	private boolean unique; // 是否唯一索引

	public TableIndex(String indexName, List<String> carrayNames,
			List<String> carrayNamesD, List<String> carrayNamesX,
			List<Map<String, String>> carrayNameMaps,
			String stringCarrayNames1, String stringCarrayNames2,
			String stringCarrayNames3, String stringCarrayNames4,
			String stringCarrayNames5, boolean unique) {
		super();
		this.indexName = indexName;
		this.carrayNames = carrayNames;
		carrayNames_d = carrayNamesD;
		carrayNames_x = carrayNamesX;
		this.carrayNameMaps = carrayNameMaps;
		this.stringCarrayNames1 = stringCarrayNames1;
		this.stringCarrayNames2 = stringCarrayNames2;
		this.stringCarrayNames3 = stringCarrayNames3;
		this.stringCarrayNames4 = stringCarrayNames4;
		this.stringCarrayNames5 = stringCarrayNames5;
		this.unique = unique;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public List<String> getCarrayNames() {
		return carrayNames;
	}

	public void setCarrayNames(List<String> carrayNames) {
		this.carrayNames = carrayNames;
	}

	public List<String> getCarrayNames_d() {
		return carrayNames_d;
	}

	public void setCarrayNames_d(List<String> carrayNamesD) {
		carrayNames_d = carrayNamesD;
	}

	public List<String> getCarrayNames_x() {
		return carrayNames_x;
	}

	public void setCarrayNames_x(List<String> carrayNamesX) {
		carrayNames_x = carrayNamesX;
	}

	public List<Map<String, String>> getCarrayNameMaps() {
		return carrayNameMaps;
	}

	public void setCarrayNameMaps(List<Map<String, String>> carrayNameMaps) {
		this.carrayNameMaps = carrayNameMaps;
	}

	public String getStringCarrayNames1() {
		return stringCarrayNames1;
	}

	public void setStringCarrayNames1(String stringCarrayNames1) {
		this.stringCarrayNames1 = stringCarrayNames1;
	}

	public String getStringCarrayNames2() {
		return stringCarrayNames2;
	}

	public void setStringCarrayNames2(String stringCarrayNames2) {
		this.stringCarrayNames2 = stringCarrayNames2;
	}

	public String getStringCarrayNames3() {
		return stringCarrayNames3;
	}

	public void setStringCarrayNames3(String stringCarrayNames3) {
		this.stringCarrayNames3 = stringCarrayNames3;
	}

	public String getStringCarrayNames4() {
		return stringCarrayNames4;
	}

	public void setStringCarrayNames4(String stringCarrayNames4) {
		this.stringCarrayNames4 = stringCarrayNames4;
	}

	public String getStringCarrayNames5() {
		return stringCarrayNames5;
	}

	public void setStringCarrayNames5(String stringCarrayNames5) {
		this.stringCarrayNames5 = stringCarrayNames5;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

}
