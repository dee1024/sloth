package com.github.coolcooldee.sloth.source.db.mysql;

/**
 * 表字段
 *
 */
public class Column {

	private String name;
	private String upperFirstLetterName;
	private String lowerFirstLetterName;
	private String type;
	private String remark;
	private boolean autoIncrement;

	public Column(String name, String upperFirstLetterName, String lowerFirstLetterName, String type, String remark, boolean autoIncrement) {
		super();
		this.name = name;
		this.upperFirstLetterName = upperFirstLetterName;
		this.lowerFirstLetterName = lowerFirstLetterName;
		this.setRemark(remark);
		this.type = type;
		this.autoIncrement = autoIncrement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpperFirstLetterName() {
		return upperFirstLetterName;
	}

	public void setUpperFirstLetterName(String carrayNameD) {
		upperFirstLetterName = carrayNameD;
	}

	public String getLowerFirstLetterName() {
		return lowerFirstLetterName;
	}

	public void setLowerFirstLetterName(String carrayNameX) {
		lowerFirstLetterName = carrayNameX;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isAutoIncrement() {
		return autoIncrement;
	}

	public void setAutoIncrement(boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
	}
}
