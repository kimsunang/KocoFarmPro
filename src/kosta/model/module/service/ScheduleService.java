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
		
		System.out.println(scheduleCalender);
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
		
		ScheduleCalender scheduleCalender = modifyCalender(request);
		if(null == scheduleCalender)
			return -1;
		
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
		String tag			= request.getParameter("tag");			// tag는 list로 뽑을 것
		String completion_per = request.getParameter("completionPer");
		String y 			= request.getParameter("y");
				
		scheduleCalender = new ScheduleCalender();
		
		int categoryId = Integer.parseInt(category_id);
		int calenderId = 0;										// calender id는 아직 생성되지 않았으므로
		int yPos = 0;
		
		int completionPer = 0;
		if(true != completion_per.isEmpty()) {
			completionPer = Integer.parseInt(completion_per);
		}
			
		if(null == color || true == color.isEmpty())
			color = "";
		
		if(null == startDt || true == startDt.isEmpty())
			startDt = "";

		if(null == endDt || true == endDt.isEmpty())
			endDt = "";

		if(null == y || true == y.isEmpty())
			yPos = Integer.parseInt(y);

		scheduleCalender.setCalenderId(calenderId);
		scheduleCalender.setCategoryId(categoryId);
		scheduleCalender.setTitle(write);
		scheduleCalender.setBackgroundColor(color);
		scheduleCalender.setStartDt(startDt);
		scheduleCalender.setEndDt(endDt);
		scheduleCalender.setCompletionPer(completionPer);
		scheduleCalender.setyPos(yPos);
	
		return scheduleCalender;
	}
	
	public ScheduleCalender modifyCalender(HttpServletRequest request) throws Exception{
		ScheduleCalender scheduleCalender = null;
		
		String project_id 	= request.getParameter("projectId");
		String category_id 	= request.getParameter("categoryId");
		String calender_id 	= request.getParameter("calenderId");
		String write 		= request.getParameter("write");
		String color 		= request.getParameter("color");
		String startDt 		= request.getParameter("startDt");
		String endDt 		= request.getParameter("endDt");
		String completionPer= request.getParameter("completionPer");
		String tag			= request.getParameter("tag");			// tag는 list로 뽑을 것
		
		if(true == category_id.isEmpty() || true == calender_id.isEmpty())
			return null;
		
		if(null == write|| true == write.isEmpty())
			return null;
		
		int categoryId = Integer.parseInt(category_id);
		int calenderId = Integer.parseInt(calender_id);
		
		if(null == startDt|| true == startDt.isEmpty())
			startDt = "";
		
		if(null == endDt|| true == endDt.isEmpty())
			endDt = "";
		
		if(null == color || true == color.isEmpty())
			color = "";
		
		System.out.println("completionPer:"+completionPer);
		int completion_per = 0;
		if(null == completionPer || true == completionPer.isEmpty()) {
			System.out.println("여기들어온다??");
			completionPer = "0";
		}else {
			completion_per = Integer.parseInt(completionPer);
		}
		
		scheduleCalender = new ScheduleCalender();
		scheduleCalender.setCategoryId(categoryId);
		scheduleCalender.setTitle(write);
		scheduleCalender.setBackgroundColor(color);
		scheduleCalender.setStartDt(startDt);
		scheduleCalender.setEndDt(endDt);
		scheduleCalender.setCalenderId(calenderId);
		scheduleCalender.setCompletionPer(completion_per);	
		
		return scheduleCalender;
	}

}
