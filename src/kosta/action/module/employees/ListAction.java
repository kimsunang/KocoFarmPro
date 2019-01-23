package kosta.action.module.employees;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.comm.vo.EmpCategoryVO;
import kosta.model.module.service.EmpService;
import kosta.model.module.vo.EmpListModelVO;

public class ListAction implements IAction{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmpService service = EmpService.getInstance();
		
		/* 현재 페이지 */
		String pageNum = request.getParameter("pageNum");
		if(null == pageNum){
			pageNum = "1";
		}
		int requestPage = Integer.parseInt(pageNum);
		
		/* 직원 목록 */
		EmpListModelVO listModel = service.getEmpList(requestPage, request);
		request.setAttribute("empList", listModel);
		
		forward.setRedirect(false);
		forward.setPath("/jsp/module/employees/list.jsp");
		
		return forward;
	}

}