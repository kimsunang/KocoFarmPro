package kosta.action.module.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.ApprovalService;

public class InsertDraftAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		
		ApprovalService service = ApprovalService.getInstnace();
		service.insertDraftService(request);
		service.insertExpenceService(request);
		
		//service.insertVacationService(request);
		
		
		System.out.println("What?");
		forward.setRedirect(false);
		forward.setPath("/listDraft.do");
		
		return forward;
	}

}
