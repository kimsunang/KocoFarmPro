package kosta.model.module.vo;

import java.io.Serializable;

public class ScheduleCategoryMove implements Serializable{

	private int projectId;
	private int oriCategoryId;
	private int oriCategoryX;
	private int moveCategoryId;
	private int moveCategoryX;
	
	public ScheduleCategoryMove() {
	}

	public ScheduleCategoryMove(int projectId, int oriCategoryId, int oriCategoryX, int moveCategoryId,
			int moveCategoryX) {
		super();
		this.projectId = projectId;
		this.oriCategoryId = oriCategoryId;
		this.oriCategoryX = oriCategoryX;
		this.moveCategoryId = moveCategoryId;
		this.moveCategoryX = moveCategoryX;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getOriCategoryId() {
		return oriCategoryId;
	}

	public void setOriCategoryId(int oriCategoryId) {
		this.oriCategoryId = oriCategoryId;
	}

	public int getOriCategoryX() {
		return oriCategoryX;
	}

	public void setOriCategoryX(int oriCategoryX) {
		this.oriCategoryX = oriCategoryX;
	}

	public int getMoveCategoryId() {
		return moveCategoryId;
	}

	public void setMoveCategoryId(int moveCategoryId) {
		this.moveCategoryId = moveCategoryId;
	}

	public int getMoveCategoryX() {
		return moveCategoryX;
	}

	public void setMoveCategoryX(int moveCategoryX) {
		this.moveCategoryX = moveCategoryX;
	}

	@Override
	public String toString() {
		return "ScheduleCategoryMove [projectId=" + projectId + ", oriCategoryId=" + oriCategoryId + ", oriCategoryX="
				+ oriCategoryX + ", moveCategoryId=" + moveCategoryId + ", moveCategoryX=" + moveCategoryX + "]";
	}
}
