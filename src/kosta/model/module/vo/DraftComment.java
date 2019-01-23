package kosta.model.module.vo;

import java.io.Serializable;

public class DraftComment implements Serializable{
	private int commentId;
	private int draftId;
	private String empId;
	private String commentContents;
	private String commentDt;
	
	public DraftComment(){

	}

	public DraftComment(int commentId, int draftId, String empId, String commentContents, String commentDt) {
		super();
		this.commentId = commentId;
		this.draftId = draftId;
		this.empId = empId;
		this.commentContents = commentContents;
		this.commentDt = commentDt;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getDraftId() {
		return draftId;
	}

	public void setDraftId(int draftId) {
		this.draftId = draftId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getCommentContents() {
		return commentContents;
	}

	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}

	public String getCommentDt() {
		return commentDt;
	}

	public void setCommentDt(String commentDt) {
		this.commentDt = commentDt;
	}
	
}
