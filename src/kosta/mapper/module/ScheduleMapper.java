package kosta.mapper.module;

import java.util.List;

import kosta.model.module.vo.ScheduleCalender;
import kosta.model.module.vo.ScheduleCategory;
import kosta.model.module.vo.ScheduleCalenderList;
import kosta.model.module.vo.ScheduleCalenderMove;
import kosta.model.module.vo.ScheduleProject;

public interface ScheduleMapper {
	public List<ScheduleProject> listProject();
	public List<ScheduleCategory> listCategory(int projectId);
	public List<ScheduleCalender> listCalender(int projectId);
	public int insertCelender(ScheduleCalender scheduleCalender);
	public List<ScheduleCalenderList> listProjectCalender(int projectId);
	public int editCalender(ScheduleCalender scheduleCalender);
	public int delCalender(int calenderId);
	public int editCalenderMove(ScheduleCalenderMove calenderMove);
	public int insertCategory(ScheduleCategory category);
	public int editCategoryName(ScheduleCategory category);
	public int insertProject(ScheduleProject project);
	public int deleteProject(int projectId);
	public int editProject(ScheduleProject project);
	public int delCategory(int categoryId);
	public int delCalenderWithCategory(ScheduleCategory category);		// 카테고리 삭제 시 하위 일정 삭제
}
