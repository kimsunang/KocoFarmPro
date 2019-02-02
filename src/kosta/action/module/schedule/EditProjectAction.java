package kosta.action.module.schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.ScheduleService;
import kosta.model.module.vo.ScheduleProject;

public class EditProjectAction implements IAction{

	public EditProjectAction() {}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("editProject");
		ScheduleService service = ScheduleService.getInstance();
		
		int re = service.editProject(request);		
		if(-1 == re) {
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/jsp/module/schedule/project.jsp");
		
		return forward;
	}

}
