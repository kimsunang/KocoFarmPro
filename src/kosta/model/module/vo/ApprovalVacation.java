package kosta.model.module.vo;

import java.io.Serializable;

public class ApprovalVacation implements Serializable {
	private int draftId;
	private int formId;
	private String vacationStartDt;
	private String vacationEndDt;
	private String vacationType;
	private int vacationDays;
	private String vacationReason;
	private int replacementId;
	
	
	public ApprovalVacation() {
		super();
	}
	public ApprovalVacation(int draftId, int formId, String vacationStartDt, String vacationEndDt, String vacationType,
			int vacationDays, String vacationReason, int replacementId) {
		super();
		this.draftId = draftId;
		this.formId = formId;
		this.vacationStartDt = vacationStartDt;
		this.vacationEndDt = vacationEndDt;
		this.vacationType = vacationType;
		this.vacationDays = vacationDays;
		this.vacationReason = vacationReason;
		this.replacementId = replacementId;
	}
	public int getDraftId() {
		return draftId;
	}
	public void setDraftId(int draftId) {
		this.draftId = draftId;
	}
	public int getFormId() {
		return formId;
	}
	public void setFormId(int formId) {
		this.formId = formId;
	}
	public String getVacationStartDt() {
		return vacationStartDt;
	}
	public void setVacationStartDt(String vacationStartDt) {
		this.vacationStartDt = vacationStartDt;
	}
	public String getVacationEndDt() {
		return vacationEndDt;
	}
	public void setVacationEndDt(String vacationEndDt) {
		this.vacationEndDt = vacationEndDt;
	}
	public String getVacationType() {
		return vacationType;
	}
	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}
	public int getVacationDays() {
		return vacationDays;
	}
	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}
	public String getVacationReason() {
		return vacationReason;
	}
	public void setVacationReason(String vacationReason) {
		this.vacationReason = vacationReason;
	}
	public int getReplacementId() {
		return replacementId;
	}
	public void setReplacementId(int replacementId) {
		this.replacementId = replacementId;
	}
	
	
	
}