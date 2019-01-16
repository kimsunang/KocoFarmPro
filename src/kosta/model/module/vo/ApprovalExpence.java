package kosta.model.module.vo;

import java.io.Serializable;

public class ApprovalExpence implements Serializable {
	private int draftId;
	private int formId;
	private String expenceDt;
	private String expenceType;
	private String customerName;
	private String expencePrice;
	private String commissionOption;
	private String commissionPrice;
	private String sumPrice;
	
	public ApprovalExpence() {
		super();
	}
	
	public ApprovalExpence(int draftId, int formId, String expenceDt, String expenceType, String customerName,
			String expencePrice, String commissionOption, String commissionPrice, String sumPrice) {
		super();
		this.draftId = draftId;
		this.formId = formId;
		this.expenceDt = expenceDt;
		this.expenceType = expenceType;
		this.customerName = customerName;
		this.expencePrice = expencePrice;
		this.commissionOption = commissionOption;
		this.commissionPrice = commissionPrice;
		this.sumPrice = sumPrice;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getExpencePrice() {
		return expencePrice;
	}

	public void setExpencePrice(String expencePrice) {
		this.expencePrice = expencePrice;
	}

	public String getCommissionOption() {
		return commissionOption;
	}

	public void setCommissionOption(String commissionOption) {
		this.commissionOption = commissionOption;
	}

	public String getCommissionPrice() {
		return commissionPrice;
	}

	public void setCommissionPrice(String commissionPrice) {
		this.commissionPrice = commissionPrice;
	}

	public String getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(String sumPrice) {
		this.sumPrice = sumPrice;
	}
	
	
}
