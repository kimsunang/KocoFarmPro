package kosta.model.module.vo;

import java.io.Serializable;

public class ApprovalExpence implements Serializable {
	private int draft_id;
	private int form_id;
	private String expence_dt;
	private String expence_type;
	private String customer_name;
	private String expence_price;
	private String commission_option;
	private String commission_price;
	private String sum_price;

	public ApprovalExpence() {
		super();
	}

	public ApprovalExpence(int draft_id, int form_id, String expence_dt, String expence_type, String customer_name,
			String expence_price, String commission_option, String commission_price, String sum_price) {
		super();
		this.draft_id = draft_id;
		this.form_id = form_id;
		this.expence_dt = expence_dt;
		this.expence_type = expence_type;
		this.customer_name = customer_name;
		this.expence_price = expence_price;
		this.commission_option = commission_option;
		this.commission_price = commission_price;
		this.sum_price = sum_price;
	}

	public int getDraft_id() {
		return draft_id;
	}

	public void setDraft_id(int draft_id) {
		this.draft_id = draft_id;
	}

	public int getForm_id() {
		return form_id;
	}

	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}

	public String getExpence_dt() {
		return expence_dt;
	}

	public void setExpence_dt(String expence_dt) {
		this.expence_dt = expence_dt;
	}

	public String getExpence_type() {
		return expence_type;
	}

	public void setExpence_type(String expence_type) {
		this.expence_type = expence_type;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getExpence_price() {
		return expence_price;
	}

	public void setExpence_price(String expence_price) {
		this.expence_price = expence_price;
	}

	public String getCommission_option() {
		return commission_option;
	}

	public void setCommission_option(String commission_option) {
		this.commission_option = commission_option;
	}

	public String getCommission_price() {
		return commission_price;
	}

	public void setCommission_price(String commission_price) {
		this.commission_price = commission_price;
	}

	public String getSum_price() {
		return sum_price;
	}

	public void setSum_price(String sum_price) {
		this.sum_price = sum_price;
	}

}
