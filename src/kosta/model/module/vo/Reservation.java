package kosta.model.module.vo;

import java.io.Serializable;

public class Reservation implements Serializable {
	private int rv_id;
	private String m_title;
	private String start_dt;
	private String end_dt;
	private String dept;
	private String rv_user;
	private String rv_writer;
	private String m_id;
	private String reg_dt;
	private String up_dt;
	
	public Reservation(){}

	public Reservation(int rv_id, String m_title, String start_dt, String end_dt, String dept, String rv_user,
			String rv_writer, String m_id, String reg_dt, String up_dt) {
		super();
		this.rv_id = rv_id;
		this.m_title = m_title;
		this.start_dt = start_dt;
		this.end_dt = end_dt;
		this.dept = dept;
		this.rv_user = rv_user;
		this.rv_writer = rv_writer;
		this.m_id = m_id;
		this.reg_dt = reg_dt;
		this.up_dt = up_dt;
	}

	public int getRv_id() {
		return rv_id;
	}

	public void setRv_id(int rv_id) {
		this.rv_id = rv_id;
	}

	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}

	public String getStart_dt() {
		return start_dt;
	}

	public void setStart_dt(String start_dt) {
		this.start_dt = start_dt;
	}

	public String getEnd_dt() {
		return end_dt;
	}

	public void setEnd_dt(String end_dt) {
		this.end_dt = end_dt;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getRv_user() {
		return rv_user;
	}

	public void setRv_user(String rv_user) {
		this.rv_user = rv_user;
	}

	public String getRv_writer() {
		return rv_writer;
	}

	public void setRv_writer(String rv_writer) {
		this.rv_writer = rv_writer;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getUp_dt() {
		return up_dt;
	}

	public void setUp_dt(String up_dt) {
		this.up_dt = up_dt;
	}

	@Override
	public String toString() {
		return "Reservation [rv_id=" + rv_id + ", m_title=" + m_title + ", start_dt=" + start_dt + ", end_dt=" + end_dt
				+ ", dept=" + dept + ", rv_user=" + rv_user + ", rv_writer=" + rv_writer + ", m_id=" + m_id
				+ ", reg_dt=" + reg_dt + ", up_dt=" + up_dt + "]";
	}
	
	
}
