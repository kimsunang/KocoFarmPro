package kosta.model.comm.vo;

import java.io.Serializable;

public class EmpCategoryVO implements Serializable{
	private String deptId;
	private String deptNm;
	private String managerId;
	private String managerNm;
	private String jobId;
	private String jobNm;
	private String positionId;
	private String positionNm;
	
	public EmpCategoryVO(){}

	public EmpCategoryVO(String deptId, String deptNm, String managerId, String managerNm, String jobId, String jobNm,
			String positionId, String positionNm) {
		super();
		this.deptId = deptId;
		this.deptNm = deptNm;
		this.managerId = managerId;
		this.managerNm = managerNm;
		this.jobId = jobId;
		this.jobNm = jobNm;
		this.positionId = positionId;
		this.positionNm = positionNm;
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

	public String getManagerNm() {
		return managerNm;
	}

	public void setManagerNm(String managerNm) {
		this.managerNm = managerNm;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobNm() {
		return jobNm;
	}

	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getPositionNm() {
		return positionNm;
	}

	public void setPositionNm(String positionNm) {
		this.positionNm = positionNm;
	}
}