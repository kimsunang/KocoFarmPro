package kosta.model.module.vo;

import java.io.Serializable;

public class MeetingRoom implements Serializable {
	private int m_id;
	private String m_name;
	private int p_num;
	private String reg_dt;
	private String up_dt;
	
	public MeetingRoom(){}
	
	public MeetingRoom(int m_id, String m_name, int p_num, String reg_dt, String up_dt) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.p_num = p_num;
		this.reg_dt = reg_dt;
		this.up_dt = up_dt;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
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
		return "MeetingRoom [m_id=" + m_id + ", m_name=" + m_name + ", p_num=" + p_num + ", reg_dt=" + reg_dt
				+ ", up_dt=" + up_dt + "]";
	}

}