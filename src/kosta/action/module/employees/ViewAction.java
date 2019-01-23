package kosta.action.module.employees;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.EmpService;
import kosta.model.module.vo.EmpVO;

public class ViewAction implements IAction{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmpService service = EmpService.getInstance();
		
		EmpVO emp = service.getEmp(request);
		request.setAttribute("emp", emp);
		
		forward.setRedirect(false);
		forward.setPath("/jsp/module/employees/view.jsp");
		
		return forward;
	}

}