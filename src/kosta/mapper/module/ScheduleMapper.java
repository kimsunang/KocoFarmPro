package kosta.mapper.module;

import java.util.List;

import kosta.model.module.vo.ScheduleCalender;
import kosta.model.module.vo.ScheduleCategory;
import kosta.model.module.vo.ScheduleCategoryMove;
import kosta.model.module.vo.ScheduleCalenderList;
import kosta.model.module.vo.ScheduleCalenderMove;
import kosta.model.module.vo.ScheduleProject;

public interface ScheduleMapper {
	public List<ScheduleProject> getProjectList();
	public List<ScheduleCategory> listCategory(int projectId);
	public List<ScheduleCalender> listCalender(int projectId);
	public int setCalender(ScheduleCalender scheduleCalender);
	public List<ScheduleCalenderList> getProjectCalenderList(int projectId);
	public int setUpCalender(ScheduleCalender scheduleCalender);
	public int delCalender(int calenderId);
	public int setUpCalenderPos(ScheduleCalenderMove calenderMove);
	public int setCategory(ScheduleCategory category);
	public int setUpCategory(ScheduleCategory category);
	public int setProject(ScheduleProject project);
	public int delProject(int projectId);
	public int setUpProject(ScheduleProject project);
	public int delCategory(int categoryId);
	public int delCalenderWithCategory(ScheduleCategory category);		// 카테고리 삭제 시 하위 일정 삭제
	public int setMoveCategoryPosX(ScheduleCategoryMove category);
	public int setOriCategoryPosX(ScheduleCategoryMove category);
	
}
