package kosta.model.module.vo;

import java.io.Serializable;

public class MeetingRoom implements Serializable {
	private int mId;
	private String mName;
	private int pNum;
	private String regDt;
	private String upDt;
	
	public MeetingRoom(){}

	public MeetingRoom(int mId, String mName, int pNum, String regDt, String upDt) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.pNum = pNum;
		this.regDt = regDt;
		this.upDt = upDt;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
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

	@Override
	public String toString() {
		return "MeetingRoom [mId=" + mId + ", mName=" + mName + ", pNum=" + pNum + ", regDt=" + regDt + ", upDt=" + upDt
				+ "]";
	}

}