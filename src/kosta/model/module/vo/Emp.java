package kosta.model.module.vo;

import java.io.Serializable;

public class Emp implements Serializable {
	private String empId;
	private String pw;
	private String salt;
	private String korNm;
	private String engNm;
	private String eMail;
	private String cellPhone;
	private String hireDt;
	private String petirment;
	private String state;
	private int annual;
	private String deptId;
	private String jobId;
	private String positionId;
	private String managerId;
	private int authority;
	private int salary;
	private String regDt;
	private String upDt;
	private String startDt;
	private String endDt;
	
	public Emp(){}
	
	public Emp(String empId, String pw, String salt, String korNm, String engNm, String eMail, String cellPhone,
			String hireDt, String petirment, String state, int annual, String deptId, String jobId, String positionId,
			String managerId, int authority, int salary, String regDt, String upDt, String startDt, String endDt) {
		super();
		this.empId = empId;
		this.pw = pw;
		this.salt = salt;
		this.korNm = korNm;
		this.engNm = engNm;
		this.eMail = eMail;
		this.cellPhone = cellPhone;
		this.hireDt = hireDt;
		this.petirment = petirment;
		this.state = state;
		this.annual = annual;
		this.deptId = deptId;
		this.jobId = jobId;
		this.positionId = positionId;
		this.managerId = managerId;
		this.authority = authority;
		this.salary = salary;
		this.regDt = regDt;
		this.upDt = upDt;
		this.startDt = startDt;
		this.endDt = endDt;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
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
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
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
	public String getPetirment() {
		return petirment;
	}
	public void setPetirment(String petirment) {
		this.petirment = petirment;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
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
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", pw=" + pw + ", salt=" + salt + ", korNm=" + korNm + ", engNm=" + engNm
				+ ", eMail=" + eMail + ", cellPhone=" + cellPhone + ", hireDt=" + hireDt + ", petirment=" + petirment
				+ ", state=" + state + ", annual=" + annual + ", deptId=" + deptId + ", jobId=" + jobId
				+ ", positionId=" + positionId + ", managerId=" + managerId + ", authority=" + authority + ", salary="
				+ salary + ", regDt=" + regDt + ", upDt=" + upDt + ", startDt=" + startDt + ", endDt=" + endDt + "]";
	}
	
}
