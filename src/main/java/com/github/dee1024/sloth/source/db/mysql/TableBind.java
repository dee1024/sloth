package com.github.dee1024.sloth.source.db.mysql;


public class TableBind {
	private String keyName;
	private String keyType;
	private String tableName_d;
	private String tableName_x;
	private String carrayName_d;
	private String carrayName_x;

	public TableBind(String keyName, String keyType, String tableNameD,
			String tableNameX, String carrayNameD, String carrayNameX) {
		super();
		this.keyName = keyName;
		this.keyType = keyType;
		tableName_d = tableNameD;
		tableName_x = tableNameX;
		carrayName_d = carrayNameD;
		carrayName_x = carrayNameX;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getKeyType() {
		return keyType;
	}

	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}

	public String getTableName_d() {
		return tableName_d;
	}

	public void setTableName_d(String tableNameD) {
		tableName_d = tableNameD;
	}

	public String getTableName_x() {
		return tableName_x;
	}

	public void setTableName_x(String tableNameX) {
		tableName_x = tableNameX;
	}

	public String getCarrayName_d() {
		return carrayName_d;
	}

	public void setCarrayName_d(String carrayNameD) {
		carrayName_d = carrayNameD;
	}

	public String getCarrayName_x() {
		return carrayName_x;
	}

	public void setCarrayName_x(String carrayNameX) {
		carrayName_x = carrayNameX;
	}

}
