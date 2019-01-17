package kosta.model.module.vo;

public class Employee {
	private int empId;
	private String korNm;
	private String deptId;
	private String positionId;
	private String cellphone;
	public Employee(int empId, String korNm, String deptId, String positionId, String cellphone) {
		super();
		this.empId = empId;
		this.korNm = korNm;
		this.deptId = deptId;
		this.positionId = positionId;
		this.cellphone = cellphone;
	}
	public Employee() {
		super();
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getKorNm() {
		return korNm;
	}
	public void setKorNm(String korNm) {
		this.korNm = korNm;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	

}
