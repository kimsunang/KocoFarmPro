package kosta.mapper.module;

import java.util.List;

import kosta.model.module.vo.ScheduleCalender;
import kosta.model.module.vo.ScheduleCategory;
import kosta.model.module.vo.ScheduleCalenderList;
import kosta.model.module.vo.ScheduleEmployee;
import kosta.model.module.vo.ScheduleProject;

public interface ScheduleMapper {
	public List<ScheduleEmployee> listEmployee();
	public List<ScheduleProject> listProject();
	public List<ScheduleCategory> listCategory(int projectId);
	public List<ScheduleCalender> listCalender(int projectId);
	public int insertCelender(ScheduleCalender cheduleCalender);
	public List<ScheduleCalenderList> listCategoryAndCalender(int projectId);

}
