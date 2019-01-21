package kosta.model.module.vo;

import java.io.Serializable;

public class ScheduleCalenderMove implements Serializable{
	private int 	categoryId;
	private int 	calenderId;
	private int 	yPos;				// 일정의 Y좌표
	
	public ScheduleCalenderMove(){
		
	}
	
	public ScheduleCalenderMove(int categoryId, int calenderId, int yPos) {
		super();
		this.categoryId = categoryId;
		this.calenderId = calenderId;
		this.yPos = yPos;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCalenderId() {
		return calenderId;
	}

	public void setCalenderId(int calenderId) {
		this.calenderId = calenderId;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	@Override
	public String toString() {
		return "ScheduleCalenderMove [categoryId=" + categoryId + ", calenderId=" + calenderId + ", yPos=" + yPos + "]";
	}
}
