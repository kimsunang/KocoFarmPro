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
		
		ScheduleCalender scheduleCalender = createCalender(request);
		if(null == scheduleCalender)
			return -1;
		
		String y = request.getParameter("y");
		int yPos = Integer.parseInt(y);		
		
		if(null == scheduleCalender.getStartDt())
			scheduleCalender.setStartDt("");

		if(null == scheduleCalender.getEndDt())
			scheduleCalender.setEndDt("");

		scheduleCalender.setyPos(yPos);
		System.out.println(scheduleCalender.toString());
		int re = dao.insertCelender(scheduleCalender);
		return re;
	}
	
	public List<ScheduleCalenderList> listProjectCalender(HttpServletRequest request) throws Exception {
		String strProjectId = request.getParameter("projectId");
		System.out.println("strProjectId:"+strProjectId);
		int projectId = Integer.parseInt(strProjectId);
		
		ScheduleDao dao = ScheduleDao.getInstance();
		List<ScheduleCalenderList> calenderList = dao.listProjectCalender(projectId);
		request.setAttribute("calenderList", calenderList);

		return calenderList;
	}
	
	public int editCalender(HttpServletRequest request) throws Exception {
		if(null == request)
			return -1;
		
		ScheduleCalender scheduleCalender = createCalender(request);
		if(null == scheduleCalender)
			return -1;
	
		
		String calender_id = request.getParameter("calenderId");
		if(null != calender_id){
			int calenderId = Integer.parseInt(calender_id);
			scheduleCalender.setCalenderId(calenderId);
		}else {
			return -1;
		}
		
		int re = dao.editCalender(scheduleCalender);
		return re;
	}
	
	public int delCalender(HttpServletRequest request) throws Exception {
		if(null == request)
			return -1;
		
		String strCalenderId = request.getParameter("calenderId");
		int calenderId = Integer.parseInt(strCalenderId);
	
		int re = dao.delCalender(calenderId);
		return re;		
	}
	
	public ScheduleCalender createCalender(HttpServletRequest request) throws Exception{
		ScheduleCalender scheduleCalender = null;
		
		String project_id 	= request.getParameter("projectId");
		String category_id 	= request.getParameter("categoryId");
		String write 		= request.getParameter("write");
		String color 		= request.getParameter("color");
		String startDt 		= request.getParameter("startDt");
		String endDt 		= request.getParameter("endDt");
		String completion_per = request.getParameter("completionPer");
		String tag			= request.getParameter("tag");			// tag는 list로 뽑을 것
		
		System.out.println("category_id:"+category_id+"write:"+write);
		//System.out.println("y:"+y+"projectid:"+project_id+"categoryId:"+category_id+"completion_per:"+completion_per+"write:"+write);		
		if("" == category_id || "" == write) {			
			return null;
		}
		
		if("" == completion_per)
			completion_per = "0";
		
		int categoryId = Integer.parseInt(category_id);
		int completionPer = Integer.parseInt(completion_per);
		if(0 >= categoryId) {
			return null;
		}
		
		scheduleCalender = new ScheduleCalender();
	
		scheduleCalender.setCategoryId(categoryId);
		scheduleCalender.setTitle(write);
		scheduleCalender.setBackgroundColor(color);
		scheduleCalender.setStartDt(startDt);
		scheduleCalender.setEndDt(endDt);
		scheduleCalender.setCompletionPer(completionPer);
		
		return scheduleCalender;
	}

}
