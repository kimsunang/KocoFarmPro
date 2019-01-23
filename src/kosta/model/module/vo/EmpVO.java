package kosta.model.module.vo;

import java.io.Serializable;

public class EmpVO implements Serializable{
	private String empId;
	private String korNm;
	private String engNm;
	private String email;
	private String cellPhone;
	private String hireDt;
	private String retirementDt;
	private String state;
	private String stateNm;
	private int annual;
	private String deptId;
	private String jobId;
	private String positionId;
	private String deptNm;
	private String jobNm;
	private String positionNm;
	private String managerId;
	private String managerNm;
	private int authority;
	private int salary;
	private String regDt;
	private String upDt;
	private String empImg;
	private String fileNm;
	private transient String pw;
	private String startDt;
	private String endDt;
	private String salt;
	
	public EmpVO(){}

	public EmpVO(String empId, String korNm, String engNm, String email, String cellPhone, String hireDt,
			String retirementDt, String state, String stateNm, int annual, String deptId, String jobId,
			String positionId, String deptNm, String jobNm, String positionNm, String managerId, String managerNm,
			int authority, int salary, String regDt, String upDt, String empImg, String fileNm, String pw,
			String startDt, String endDt, String salt) {
		super();
		this.empId = empId;
		this.korNm = korNm;
		this.engNm = engNm;
		this.email = email;
		this.cellPhone = cellPhone;
		this.hireDt = hireDt;
		this.retirementDt = retirementDt;
		this.state = state;
		this.stateNm = stateNm;
		this.annual = annual;
		this.deptId = deptId;
		this.jobId = jobId;
		this.positionId = positionId;
		this.deptNm = deptNm;
		this.jobNm = jobNm;
		this.positionNm = positionNm;
		this.managerId = managerId;
		this.managerNm = managerNm;
		this.authority = authority;
		this.salary = salary;
		this.regDt = regDt;
		this.upDt = upDt;
		this.empImg = empImg;
		this.fileNm = fileNm;
		this.pw = pw;
		this.startDt = startDt;
		this.endDt = endDt;
		this.salt = salt;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getKorNm() {
		return korNm;
	}

	public void setKorNm(String korNm) {
		this.korNm = korNm;
	}

	public String getEngNm() {
		return engNm;
	}

	public void setEngNm(String engNm) {
		this.engNm = engNm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getHireDt() {
		return hireDt;
	}

	public void setHireDt(String hireDt) {
		this.hireDt = hireDt;
	}

	public String getRetirementDt() {
		return retirementDt;
	}

	public void setRetirementDt(String retirementDt) {
		this.retirementDt = retirementDt;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateNm() {
		return stateNm;
	}

	public void setStateNm(String stateNm) {
		this.stateNm = stateNm;
	}

	public int getAnnual() {
		return annual;
	}

	public void setAnnual(int annual) {
		this.annual = annual;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getJobNm() {
		return jobNm;
	}

	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}

	public String getPositionNm() {
		return positionNm;
	}

	public void setPositionNm(String positionNm) {
		this.positionNm = positionNm;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerNm() {
		return managerNm;
	}

	public void setManagerNm(String managerNm) {
		this.managerNm = managerNm;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
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

	public String getEmpImg() {
		return empImg;
	}

	public void setEmpImg(String empImg) {
		this.empImg = empImg;
	}

	public String getFileNm() {
		return fileNm;
	}

	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}