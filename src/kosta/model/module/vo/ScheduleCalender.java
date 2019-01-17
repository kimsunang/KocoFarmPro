package kosta.model.module.vo;

import java.io.Serializable;
import java.util.Date;

public class ScheduleCalender implements Serializable{

	private int calenderId;
	private String title;
	private String startDt;
	private String endDt;
	private String backgroundColor;
	private int completionPer;
	private int xPos;
	private int yPos;
	private int categoryId;
		
	public ScheduleCalender() {
	}

	public ScheduleCalender(int calenderId, String title, String startDt, String endDt, String backgroundColor,
			int completionPer, int xPos, int yPos, int categoryId) {
		super();
		this.calenderId = calenderId;
		this.title = title;
		this.startDt = startDt;
		this.endDt = endDt;
		this.backgroundColor = backgroundColor;
		this.completionPer = completionPer;
		this.xPos = xPos;
		this.yPos = yPos;
		this.categoryId = categoryId;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "ScheduleCalender [calenderId=" + calenderId + ", title=" + title + ", startDt=" + startDt + ", endDt="
				+ endDt + ", backgroundColor=" + backgroundColor + ", completionPer=" + completionPer + ", xPos=" + xPos
				+ ", yPos=" + yPos + ", categoryId=" + categoryId + "]";
	}

	
	
}
