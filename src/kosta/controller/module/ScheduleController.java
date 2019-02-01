package kosta.controller.module;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUpload;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.action.module.fileRoom.FileDeleteAction;
import kosta.action.module.fileRoom.FileDownload;
import kosta.action.module.fileRoom.FileDownloadAction;
import kosta.action.module.fileRoom.FileListAction;
import kosta.action.module.fileRoom.FileUploadAction;
import kosta.action.module.fileRoom.insertFileAction;
import kosta.action.module.schedule.DelCalenderAction;
import kosta.action.module.schedule.DeleteProjectAction;
import kosta.action.module.schedule.EditCalenderAction;
import kosta.action.module.schedule.EditCalenderMoveAction;
import kosta.action.module.schedule.EditCategoryName;
import kosta.action.module.schedule.InsertCalenderAction;
import kosta.action.module.schedule.InsertCategoryAction;
import kosta.action.module.schedule.InsertProjectAction;
import kosta.action.module.schedule.ListProjectAction;
import kosta.action.module.schedule.ListProjectAjaxAction;
import kosta.action.module.schedule.ListCalenderAction;
import kosta.action.module.schedule.SendProjectIdAction;


@WebServlet({"/schedule.do", "/listCalender.do", "/insertCalender.do","/sendProjectId.do", "/editCalender.do", "/delCalender.do",
	"/editCalenderPos.do", "/insertCategory.do", "/editCategoryName.do","/insertProject.do", "/deleteProject.do", "/listProjectAjax.do",
	"/fileList.do", "/fileUpload.do", "/fileDownload.do", "/insertFile.do","/deleteFile.do"})

public class ScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
    Map<String, IAction> scheduleActionList;
    public ScheduleController() {
    	super();
    	scheduleActionList = new HashMap<String, IAction>();
    	
    	// 일정 관리
		scheduleActionList.put("schedule.do", new ListProjectAction());
		scheduleActionList.put("listCalender.do", new ListCalenderAction());
		scheduleActionList.put("insertCalender.do", new InsertCalenderAction());
		scheduleActionList.put("sendProjectId.do", new SendProjectIdAction());
		scheduleActionList.put("editCalender.do", new EditCalenderAction());
		scheduleActionList.put("delCalender.do", new DelCalenderAction());
		scheduleActionList.put("editCalenderPos.do", new EditCalenderMoveAction());
		scheduleActionList.put("insertCategory.do", new InsertCategoryAction());
		scheduleActionList.put("editCategoryName.do", new EditCategoryName());
		scheduleActionList.put("insertProject.do", new InsertProjectAction());
		scheduleActionList.put("deleteProject.do", new DeleteProjectAction());
		scheduleActionList.put("listProjectAjax.do", new ListProjectAjaxAction());
		

		// 파일 관리
		scheduleActionList.put("fileList.do", new FileListAction());
		scheduleActionList.put("fileUpload.do", new FileUploadAction());
		scheduleActionList.put("fileDownload.do", new FileDownloadAction());
		scheduleActionList.put("insertFile.do", new insertFileAction());
		scheduleActionList.put("deleteFile.do", new FileDeleteAction());

	}
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);

		IAction action = null;
		ActionForward forward = null;
		action = getScheduleManager(command);

		try {
			if(null != action)
				forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("moduleNm", "schedule");
		
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public IAction getScheduleManager(String url){
		return scheduleActionList.get(url);
	}


}
