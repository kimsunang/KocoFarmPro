package kosta.model.module.vo;

import java.io.Serializable;
import java.util.List;

public class Reservation implements Serializable {
	private int rvId;
	private String mTitle;
	private String startDt;
	private String endDt;
	private String dept;
	private String rvUser;
	private String rvWriter;
	private String regDt;
	private String upDt;
	private int mId;
	private String rvUserNm;
	private String rvWriterNm;
	private String deptNm;
	
	public Reservation(){}

	public Reservation(int rvId, String mTitle, String startDt, String endDt, String dept, String rvUser,
			String rvWriter, String regDt, String upDt, int mId, String rvUserNm, String rvWriterNm, String deptNm) {
		this.rvId = rvId;
		this.mTitle = mTitle;
		this.startDt = startDt;
		this.endDt = endDt;
		this.dept = dept;
		this.rvUser = rvUser;
		this.rvWriter = rvWriter;
		this.regDt = regDt;
		this.upDt = upDt;
		this.mId = mId;
		this.rvUserNm = rvUserNm;
		this.rvWriterNm = rvWriterNm;
		this.deptNm = deptNm;
	}

	public int getRvId() {
		return rvId;
	}

	public void setRvId(int rvId) {
		this.rvId = rvId;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getRvUser() {
		return rvUser;
	}

	public void setRvUser(String rvUser) {
		this.rvUser = rvUser;
	}

	public String getRvWriter() {
		return rvWriter;
	}

	public void setRvWriter(String rvWriter) {
		this.rvWriter = rvWriter;
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

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getRvUserNm() {
		return rvUserNm;
	}

	public void setRvUserNm(String rvUserNm) {
		this.rvUserNm = rvUserNm;
	}

	public String getRvWriterNm() {
		return rvWriterNm;
	}

	public void setRvWriterNm(String rvWriterNm) {
		this.rvWriterNm = rvWriterNm;
	}

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
		
}
