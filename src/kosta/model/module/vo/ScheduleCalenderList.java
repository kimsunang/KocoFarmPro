package kosta.model.module.vo;

import java.io.Serializable;

public class ScheduleCalenderList implements Serializable {

	private int 	categoryId;
	private String 	categoryName;
	private int 	projectId;
	private int 	calenderId;
	private String 	title;
	private String 	startDt;
	private String 	endDt;
	private String 	backgroundColor;
	private int 	completionPer;
	private int 	xPos;				// 일정의 X좌표
	private int 	yPos;				// 일정의 Y좌표
	
	public ScheduleCalenderList() {}

	public ScheduleCalenderList(int categoryId, String categoryName, int projectId, int calenderId, String title,
			String startDt, String endDt, String backgroundColor, int completionPer, int xPos, int yPos) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.projectId = projectId;
		this.calenderId = calenderId;
		this.title = title;
		this.startDt = startDt;
		this.endDt = endDt;
		this.backgroundColor = backgroundColor;
		this.completionPer = completionPer;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getCalenderId() {
		return calenderId;
	}

	public void setCalenderId(int calenderId) {
		this.calenderId = calenderId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public int getCompletionPer() {
		return completionPer;
	}

	public void setCompletionPer(int completionPer) {
		this.completionPer = completionPer;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	@Override
	public String toString() {
		return "ScheduleCategoryAndCalender [categoryId=" + categoryId + ", categoryName=" + categoryName
				+ ", projectId=" + projectId + ", calenderId=" + calenderId + ", title=" + title + ", startDt="
				+ startDt + ", endDt=" + endDt + ", backgroundColor=" + backgroundColor + ", completionPer="
				+ completionPer + ", xPos=" + xPos + ", yPos=" + yPos + "]";
	}
	
	

}
