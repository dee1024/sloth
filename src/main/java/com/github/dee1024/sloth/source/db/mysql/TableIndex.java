package com.github.dee1024.sloth.source.db.mysql;

import java.util.List;
import java.util.Map;

public class TableIndex {
	private String indexName;
	private List<String> carrayNames;
	private List<String> carrayNames_d;
	private List<String> carrayNames_x;
	private List<Map<String, String>> carrayNameMaps;
	private String stringCarrayNames1;// append upper columns
	private String stringCarrayNames2;// "," append upper columns
	private String stringCarrayNames3;// type+ ","append upper columns
	private String stringCarrayNames4;// ","append lower columns
	private String stringCarrayNames5;// columns-lower columns
	private boolean unique;

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
