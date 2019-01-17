package kosta.model.module.vo;

import java.io.Serializable;

public class ScheduleCategory implements Serializable {
	private int categoryId;
	private String categoryName;
	private int projectId;
	private int xPos;

	public ScheduleCategory() {
	
	}

	public ScheduleCategory(int categoryId, String categoryName, int projectId, int xPos) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.projectId = projectId;
		this.xPos = xPos;
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

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	@Override
	public String toString() {
		return "ScheduleCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", projectId="
				+ projectId + ", xPos=" + xPos + "]";
	}
		
}
