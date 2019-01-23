package kosta.action.module.employees;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.comm.vo.EmpCategoryVO;
import kosta.model.module.service.EmpService;

public class WriteAction implements IAction{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmpService service = EmpService.getInstance();
		
		/* 부서 목록 */
		List<EmpCategoryVO> deptList = service.getDeptList();
		request.setAttribute("deptList", deptList);
		
		/* 직책 목록 */
		List<EmpCategoryVO> positionList = service.getPositionList();
		request.setAttribute("positionList", positionList);
		
		forward.setRedirect(false);
		forward.setPath("/jsp/module/employees/write.jsp");
		
		return forward;
	}

}