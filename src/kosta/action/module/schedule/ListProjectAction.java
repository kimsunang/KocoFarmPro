package kosta.action.module.schedule;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ScheduleDao;
import kosta.model.module.vo.ScheduleProject;

public class ListProjectAction implements IAction{

	public ListProjectAction() {}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		ScheduleDao dao = ScheduleDao.getInstance();
		
		// ListProjectAction과 ListProjectAjaxAction이 하나로 합쳐야할듯
		List<ScheduleProject> projectList = dao.getProjectList();
		request.setAttribute("projectList", projectList);
	
		forward.setRedirect(false);
		forward.setPath("/jsp/module/schedule/list.jsp");
		return forward;
	}
}
