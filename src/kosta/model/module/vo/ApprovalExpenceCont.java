package kosta.model.module.vo;

import java.io.Serializable;

public class ApprovalExpenceCont implements Serializable {
	private int expenceId;
	private int contSeq;
	private String customerName;
	private String expencePrice;
	private String commissionOption;
	private String commissionPrice;
	
	public ApprovalExpenceCont(int expenceId, int contSeq, String customerName, String expencePrice,
			String commissionOption, String commissionPrice) {
		this.expenceId = expenceId;
		this.contSeq = contSeq;
		this.customerName = customerName;
		this.expencePrice = expencePrice;
		this.commissionOption = commissionOption;
		this.commissionPrice = commissionPrice;
	}
	public ApprovalExpenceCont() {
	}
	public int getExpenceId() {
		return expenceId;
	}
	public void setExpenceId(int expenceId) {
		this.expenceId = expenceId;
	}
	public int getContSeq() {
		return contSeq;
	}
	public void setContSeq(int contSeq) {
		this.contSeq = contSeq;
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
	
	
}
