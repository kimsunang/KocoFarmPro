package kosta.action.module.schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;

public class SendProjectIdAction implements IAction{
	public SendProjectIdAction() {}
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String projectId = request.getParameter("project_id");
		int project_id = Integer.parseInt(projectId);

		request.setAttribute("projectId", project_id);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/jsp/module/schedule/project.jsp");
		return forward;
		
	}
}
