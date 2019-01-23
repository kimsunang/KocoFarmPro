package kosta.action.module.employees;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.EmpService;

public class EditProCAction implements IAction{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmpService service = EmpService.getInstance();
		
		/* 성공 여부 */
		int re = service.setUpEmp(request);
		request.setAttribute("re", re);
		request.setAttribute("myPage", "'empList.do'");
		
		forward.setRedirect(false);
		forward.setPath("/jsp/comm/proC.jsp");
		
		return forward;
	}

}