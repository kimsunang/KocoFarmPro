package kosta.action.module.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;

public class InsertDraftFormAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);  //dispatch할꺼야  true면 redirect실행
		forward.setPath("jsp/module/approval/vacationForm.jsp"); //path정보 입력
		return forward;
	}

}
