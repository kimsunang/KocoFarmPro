package kosta.model.module.vo;

import java.io.Serializable;

public class Notice implements Serializable{
	private String noticeId;
	private String title;
	private String contents;
	private int hitCnt;
	private String fileNm;
	private String regDt;
	private String upDt;
	
	public Notice(){}

	public Notice(String noticeId, String title, String contents, int hitCnt, String fileNm, String regDt, String upDt) {
		super();
		this.noticeId = noticeId;
		this.title = title;
		this.contents = contents;
		this.hitCnt = hitCnt;
		this.fileNm = fileNm;
		this.regDt = regDt;
		this.upDt = upDt;
	}

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getHitCnt() {
		return hitCnt;
	}

	public void setHitCnt(int hitCnt) {
		this.hitCnt = hitCnt;
	}

	public String getFileNm() {
		return fileNm;
	}

	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
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
		return "Notice [noticeId=" + noticeId + ", title=" + title + ", contents=" + contents + ", hitCnt=" + hitCnt
				+ ", fileNm=" + fileNm + ", regDt=" + regDt + ", upDt=" + upDt;
	}
	
}