package kosta.model.module.vo;

import java.io.Serializable;

public class Departments implements Serializable{
	private String deptId;
	private String deptNm;
	private String managerId;
	private String regDt;
	private String upDt;
	
	public Departments(){}

	public Departments(String deptId, String deptNm, String managerId, String regDt, String upDt) {
		super();
		this.deptId = deptId;
		this.deptNm = deptNm;
		this.managerId = managerId;
		this.regDt = regDt;
		this.upDt = upDt;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getUpDt() {
		return upDt;
	}

	public void setUpDt(String upDt) {
		this.upDt = upDt;
	}

}