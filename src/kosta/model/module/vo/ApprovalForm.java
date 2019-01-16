package kosta.model.module.vo;

import java.io.Serializable;

public class ApprovalForm  implements Serializable {
	private int formId;
	private int sortId;
	private int modeId;
	private String sortName;
	private String modeName;
	public ApprovalForm(int formId, int sortId, int modeId, String sortName, String modeName) {
		super();
		this.formId = formId;
		this.sortId = sortId;
		this.modeId = modeId;
		this.sortName = sortName;
		this.modeName = modeName;
	}
	public ApprovalForm() {
		super();
	}
	public int getFormId() {
		return formId;
	}
	public void setFormId(int formId) {
		this.formId = formId;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public int getModeId() {
		return modeId;
	}
	public void setModeId(int modeId) {
		this.modeId = modeId;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getModeName() {
		return modeName;
	}
	public void setModeName(String modeName) {
		this.modeName = modeName;
	}
	
	
	
}
