package kosta.action.module.schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.ScheduleService;

public class EditCalenderAction  implements IAction{
	public EditCalenderAction(){}
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ScheduleService service =  ScheduleService.getInstance();
		int re = -1;
		if(null == service)
			return null;
		
		re = service.editCalender(request);
		
		ActionForward forward = null;
		if(-1 == re)
			return null;

		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/jsp/module/schedule/project.jsp");
		
		return forward;	
	}
}
