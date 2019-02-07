package kosta.action.module.schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.ScheduleService;

public class DelProjectAction implements IAction{

	public DelProjectAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ScheduleService service =  ScheduleService.getInstance();			
		if(null == service) {
			return null;
		}

		int re = service.delProject(request);
		if(-1 == re) {
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/jsp/module/schedule/list.jsp");
		
		return forward;
	}
}
