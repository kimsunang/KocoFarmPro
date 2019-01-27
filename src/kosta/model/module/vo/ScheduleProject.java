package kosta.model.module.vo;

import java.io.Serializable;
import java.util.Date;

public class ScheduleProject implements Serializable{

	private long projectId;
	private String title;
	private String projectLeader;
	private String projectStartDt;
	private String projectEndDt;
	private int projectRegDt;
	private int projectCompletion;
	private boolean publicProject;
	
	public ScheduleProject() {
	
	}

	public ScheduleProject(long projectId, String title, String projectLeader, String projectStartDt,
			String projectEndDt, int projectRegDt, int projectCompletion, boolean publicProject) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.projectLeader = projectLeader;
		this.projectStartDt = projectStartDt;
		this.projectEndDt = projectEndDt;
		this.projectRegDt = projectRegDt;
		this.projectCompletion = projectCompletion;
		this.publicProject = publicProject;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader;
	}
	
	public String getProjectStartDt() {
		return projectStartDt;
	}

	public void setProjectStartDt(String projectStartDt) {
		this.projectStartDt = projectStartDt;
	}

	public String getProjectEndDt() {
		return projectEndDt;
	}

	public void setProjectEndDt(String projectEndDt) {
		this.projectEndDt = projectEndDt;
	}

	public int getProjectRegDt() {
		return projectRegDt;
	}

	public void setProjectRegDt(int projectRegDt) {
		this.projectRegDt = projectRegDt;
	}

	public int getProjectCompletion() {
		return projectCompletion;
	}

	public void setProjectCompletion(int projectCompletion) {
		this.projectCompletion = projectCompletion;
	}

	public boolean isPublicProject() {
		return publicProject;
	}

	public void setPublicProject(boolean publicProject) {
		this.publicProject = publicProject;
	}

	@Override
	public String toString() {
		return "ScheduleProject [projectId=" + projectId + ", title=" + title + ", projectLeader=" + projectLeader
				+", projectStartDt=" + projectStartDt + ", projectEndDt=" + projectEndDt
				+ ", projectRegDt=" + projectRegDt + ", projectCompletion=" + projectCompletion + ", publicProject="
				+ publicProject + "]";
	}

	
}
