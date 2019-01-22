package kosta.model.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kosta.model.module.dao.ScheduleDao;
import kosta.model.module.vo.ScheduleCalender;
import kosta.model.module.vo.ScheduleCategory;
import net.sf.json.JSONArray;
import kosta.model.module.vo.ScheduleCalenderList;
import kosta.model.module.vo.ScheduleCalenderMove;

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
	
	public int insertScheduleCategory(HttpServletRequest request) throws Exception {
		if(null == request)
			return -1;
		
		String categoryName = request.getParameter("categoryName");
		String projectId	= request.getParameter("projectId");
		String xPos 		= request.getParameter("xPos");
		
		System.out.println("categoryName:"+categoryName+"projectId:"+projectId+"xPos:"+xPos);
		
		if(null == categoryName || null == projectId || null == xPos)
			return -1;
		
		if(true == categoryName.isEmpty() || true == projectId.isEmpty() || true == xPos.isEmpty())
			return -1;
		
		ScheduleCategory scheduleCategory = new ScheduleCategory();
		if(null == scheduleCategory)
			return -1;
		
		int projectid = Integer.parseInt(projectId);
		int xpos = Integer.parseInt(xPos);

		scheduleCategory.setProjectId(projectid);
		scheduleCategory.setCategoryName(categoryName);
		scheduleCategory.setxPos(xpos);
		
		System.out.println("카테고리 추가");
		int re = dao.insertCategory(scheduleCategory);
		return re;
	}
	
	public List<ScheduleCalenderList> listProjectCalender(HttpServletRequest request) throws Exception {
		String strProjectId = request.getParameter("projectId");
		System.out.println("프로젝트 id값!!!:"+strProjectId);
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
	
	public int editCategoryName(HttpServletRequest request) throws Exception{
		if(null == request)
			return -1;
		
		System.out.println("들어옴???");
		
		String categoryId = request.getParameter("categoryId");
		String categoryName = request.getParameter("categoryName");
		if(null == categoryId || null == categoryName){
			System.out.println("null이다");
			return -1;
		}
		
		if(true == categoryId.isEmpty() || true == categoryName.isEmpty()){
			System.out.println("isEmpty이다");
			return -1;
		}

		System.out.println("들어옴222222???");
		
	 	int categoryid = Integer.parseInt(categoryId);

		ScheduleCategory category = new ScheduleCategory();	
		category.setCategoryId(categoryid);
		category.setCategoryName(categoryName);
		System.out.println(category);
		
		int re = dao.editCategoryName(category);
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
	
	public int editCalenderMove(HttpServletRequest request) throws Exception{
		if(null == request)
			return -1;
		
		String[] data = request.getParameter("data_parameter").split("[|]");	
		int re = -1;
		if(null == data)
			return -1;
		
		List<ScheduleCalenderMove> scheduleCalenderPosList = new ArrayList<ScheduleCalenderMove>();
		for(int i = 0; i < data.length; ++i){
			
			String[] list = data[i].split(",");
			if(null == list[0] || null == list[1] || null == list[2] )
				continue;
						
			int categoryId	= Integer.parseInt(list[0]);
			int calenderId	= Integer.parseInt(list[1]);
			int y 			= Integer.parseInt(list[2]);
			
			ScheduleCalenderMove calenderInfo = new ScheduleCalenderMove(categoryId, calenderId, y);
		
			scheduleCalenderPosList.add(calenderInfo);
		}
		
		int size = scheduleCalenderPosList.size();
		System.out.println(scheduleCalenderPosList);
		re = dao.editCalenderMove(scheduleCalenderPosList);

		return re;
	}
	
	public ScheduleCalender createCalender(HttpServletRequest request) throws Exception{
		ScheduleCalender scheduleCalender = null;
		System.out.println("에러에러에러");
		
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
		System.out.println("category_id:"+category_id);
		int categoryId = Integer.parseInt(category_id);
		int calenderId = 0;										// calender id는 아직 생성되지 않았으므로
		int yPos = 0;
		
		int completionPer = 0;
		if(true != completion_per.isEmpty()) {
			System.out.println("completion_per:"+completion_per);
			completionPer = Integer.parseInt(completion_per);
		}
			
		if(null == color || true == color.isEmpty())
			color = "";
		
		if(null == startDt || true == startDt.isEmpty())
			startDt = "";

		if(null == endDt || true == endDt.isEmpty())
			endDt = "";

		if(null != y || true != y.isEmpty()){
			System.out.println("y:"+y);
			yPos = Integer.parseInt(y);
		}

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
		
		//System.out.println("category_id:"+category_id);
		int categoryId = Integer.parseInt(category_id);
		//System.out.println("calender_id:"+calender_id);
		int calenderId = Integer.parseInt(calender_id);
		
		if(null == startDt|| true == startDt.isEmpty())
			startDt = "";
		
		if(null == endDt|| true == endDt.isEmpty())
			endDt = "";
		
		if(null == color || true == color.isEmpty())
			color = "";
		
		//System.out.println("completionPer :"+completionPer);
		int completion_per = 0;
		if(null == completionPer || true == completionPer.isEmpty()) {
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
		
		System.out.println(scheduleCalender);
		return scheduleCalender;
	}

}
