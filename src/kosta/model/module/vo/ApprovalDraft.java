package kosta.model.module.vo;

import java.io.Serializable;

public class ApprovalDraft implements Serializable {

	private int draftId;
	private String draftName;
	private String draftDt;
	private String draftTitle;
	private int empId;
	private int draftYear;
	private int formId;
	private String approveState;
	
	
	
	public ApprovalDraft() {
		super();
	}
	public ApprovalDraft(int draftId, String draftName, String draftDt, String draftTitle, int empId, int draftYear,
			int formId, String approveState) {
		super();
		this.draftId = draftId;
		this.draftName = draftName;
		this.draftDt = draftDt;
		this.draftTitle = draftTitle;
		this.empId = empId;
		this.draftYear = draftYear;
		this.formId = formId;
		this.approveState = approveState;
	}
	public int getDraftId() {
		return draftId;
	}
	public void setDraftId(int draftId) {
		this.draftId = draftId;
	}
	public String getDraftName() {
		return draftName;
	}
	public void setDraftName(String draftName) {
		this.draftName = draftName;
	}
	public String getDraftDt() {
		return draftDt;
	}
	public void setDraftDt(String draftDt) {
		this.draftDt = draftDt;
	}
	public String getDraftTitle() {
		return draftTitle;
	}
	public void setDraftTitle(String draftTitle) {
		this.draftTitle = draftTitle;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getDraftYear() {
		return draftYear;
	}
	public void setDraftYear(int draftYear) {
		this.draftYear = draftYear;
	}
	public int getFormId() {
		return formId;
	}
	public void setFormId(int formId) {
		this.formId = formId;
	}
	public String getApproveState() {
		return approveState;
	}
	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}
		
}
