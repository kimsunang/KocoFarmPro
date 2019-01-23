package kosta.model.comm.vo;

import java.io.Serializable;

public class LoginVO implements Serializable{
	private String empId;
	private transient String pw;
	private transient String salt;
	private String korNm;
	private String engNm;
	private String email;
	private String cellPhone;
	private String hireDt;
	private String retirementDt;
	private String state;
	private int annual;
	private String deptId;
	private String jobId;
	private String positionId;
	private String mangerId;
	private int authority;
	private int salary;
	private String regDt;
	private String upDt;
	private String emgImg;
	private int re;
	
	public LoginVO(){}

	public LoginVO(String empId, String pw, String salt, String korNm, String engNm, String email, String cellPhone,
			String hireDt, String retirementDt, String state, int annual, String deptId, String jobId,
			String positionId, String mangerId, int authority, int salary, String regDt, String upDt, String emgImg,
			int re) {
		this.empId = empId;
		this.pw = pw;
		this.salt = salt;
		this.korNm = korNm;
		this.engNm = engNm;
		this.email = email;
		this.cellPhone = cellPhone;
		this.hireDt = hireDt;
		this.retirementDt = retirementDt;
		this.state = state;
		this.annual = annual;
		this.deptId = deptId;
		this.jobId = jobId;
		this.positionId = positionId;
		this.mangerId = mangerId;
		this.authority = authority;
		this.salary = salary;
		this.regDt = regDt;
		this.upDt = upDt;
		this.emgImg = emgImg;
		this.re = re;
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

	public String getMangerId() {
		return mangerId;
	}

	public void setMangerId(String mangerId) {
		this.mangerId = mangerId;
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

	public String getEmgImg() {
		return emgImg;
	}

	public void setEmgImg(String emgImg) {
		this.emgImg = emgImg;
	}

	public int getRe() {
		return re;
	}

	public void setRe(int re) {
		this.re = re;
	}
}