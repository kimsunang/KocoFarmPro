package kosta.action.module.schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.ScheduleService;

public class DelCalenderAction implements IAction{
	public DelCalenderAction(){}
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ScheduleService service =  ScheduleService.getInstance();			
		if(null != service){
			service.delCalender(request);
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/jsp/module/schedule/project.jsp");
		return forward;
	}
}
