package kosta.model.module.vo;

import java.io.Serializable;

public class ScheduleEmployee implements Serializable{
	private long empId;
	private String name;
	
	public ScheduleEmployee() {
	}

	public ScheduleEmployee(long empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ScheduleEmployee [empId=" + empId + ", name=" + name + "]";
	}

	

	
}
