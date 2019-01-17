package kosta.model.module.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kosta.model.module.dao.ScheduleDao;
import kosta.model.module.vo.ScheduleCalender;
import kosta.model.module.vo.ScheduleCategory;
import kosta.model.module.vo.ScheduleCalenderList;

public class ScheduleService {
	private static ScheduleDao dao;
	private static ScheduleService scheduleService = new ScheduleService();

	public static ScheduleService getInstance(){
		dao = ScheduleDao.getInstance();
		return scheduleService;
	}
	
	public int getAttributeProjectId(HttpServletRequest request) throws Exception{
		String project_id = request.getParameter("projectId");

		int projectId = Integer.parseInt(project_id);
		return projectId;
	}
	
	
	public int insertScheduleCalender(HttpServletRequest request) throws Exception {
		
		ScheduleCalender scheduleCalender = new ScheduleCalender();
	
		String project_id = request.getParameter("projectId");
		String category_id = request.getParameter("categoryId");
		String write =  request.getParameter("write");
		String color = request.getParameter("color");
		String completion_per = request.getParameter("completionPer");
		String y = request.getParameter("y");
		
		System.out.println("y:"+y+"projectid:"+project_id+"categoryId:"+category_id+"completion_per:"+completion_per);
		
		int projectId = Integer.parseInt(project_id);
		int categoryId = Integer.parseInt(category_id);
		int completionPer = Integer.parseInt(completion_per);
		int yPos = Integer.parseInt(y);
		
		scheduleCalender.setCategoryId(categoryId);
		scheduleCalender.setTitle(write);
		scheduleCalender.setBackgroundColor(color);
		scheduleCalender.setCompletionPer(completionPer);
		scheduleCalender.setStartDt("");
		scheduleCalender.setEndDt("");
		scheduleCalender.setyPos(yPos);
			
		int re = dao.insertCelender(scheduleCalender);
		if(-1 == re)
			return re;
		
		List<ScheduleCategory> listCategory = dao.listCategory(projectId);
		List<ScheduleCalender> listCalender = dao.listCalender(projectId);
		
		request.setAttribute("categoryList", listCategory);		
		request.setAttribute("calenderList", listCalender);		
		
		return re;
	}
	
	public List<ScheduleCalenderList> listProjectCalender(HttpServletRequest request) throws Exception {
		String strProjectId = request.getParameter("projectId");
		int projectId = Integer.parseInt(strProjectId);
		
		ScheduleDao dao = ScheduleDao.getInstance();
		List<ScheduleCalenderList> calenderList = dao.listProjectCalender(projectId);
		request.setAttribute("calenderList", calenderList);

		return calenderList;
	}
}
