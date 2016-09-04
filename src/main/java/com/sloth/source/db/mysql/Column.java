package com.sloth.source.db.mysql;

/**
 * 表字段
 *
 */
public class Column {

	private String name;// 原名称
	private String upperFirstLetterName;// 首字母大写
	private String lowerFirstLetterName;// 首字母小写
	private String type;// 字段类型
	private String remark; //字段注释

	public Column(String name, String upperFirstLetterName,
				  String lowerFirstLetterName, String type, String remark) {
		super();
		this.name = name;
		this.upperFirstLetterName = upperFirstLetterName;
		this.lowerFirstLetterName = lowerFirstLetterName;
		this.setRemark(remark);
		this.type = type;
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

}
