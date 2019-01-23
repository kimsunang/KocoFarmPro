package kosta.model.module.vo;

import java.io.Serializable;

public class ApprovalExpence implements Serializable {
	private int expenceId;
	private int draftId;
	private int formId;
	private String expenceDt;
	private String expenceType;
	private String sumPrice;
	
	public ApprovalExpence() {
	}

	public ApprovalExpence(int expenceId, int draftId, int formId, String expenceDt, String expenceType,
			String sumPrice) {
		this.expenceId = expenceId;
		this.draftId = draftId;
		this.formId = formId;
		this.expenceDt = expenceDt;
		this.expenceType = expenceType;
		this.sumPrice = sumPrice;
	}


	public int getExpenceId() {
		return expenceId;
	}

	public void setExpenceId(int expenceId) {
		this.expenceId = expenceId;
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

	public String getExpenceDt() {
		return expenceDt;
	}

	public void setExpenceDt(String expenceDt) {
		this.expenceDt = expenceDt;
	}

	public String getExpenceType() {
		return expenceType;
	}

	public void setExpenceType(String expenceType) {
		this.expenceType = expenceType;
	}

	public String getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(String sumPrice) {
		this.sumPrice = sumPrice;
	}
	
}
