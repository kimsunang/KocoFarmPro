package kosta.action.module.schedule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ScheduleDao;
import kosta.model.module.service.ScheduleService;
import kosta.model.module.vo.ScheduleProject;
import net.sf.json.JSONArray;

public class ListProjectAjaxAction implements IAction{

	public ListProjectAjaxAction() {
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ScheduleService service = ScheduleService.getInstance();
		JSONArray jsonArr = service.getProjectList(request);
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(jsonArr);
	
		return null;
	}
}
