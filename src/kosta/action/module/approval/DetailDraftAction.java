package kosta.action.module.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ApprovalDao;
import kosta.model.module.service.ApprovalService;
import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalForm;
import kosta.model.module.vo.ApprovalVacation;

public class DetailDraftAction implements IAction {

	@Override
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ApprovalDao dao = ApprovalDao.getInstance();
		ActionForward forward = new ActionForward();
		ApprovalDraft draft = new ApprovalDraft();
		ApprovalVacation vacation = new ApprovalVacation();
		
		ApprovalService service = ApprovalService.getInstnace();
		draft = service.getDraft(request);
		vacation = service.getVacation(request);
		
		request.setAttribute("draft", draft);
		request.setAttribute("vacation",vacation);
		
		forward.setRedirect(false);
		forward.setPath("jsp/module/approval/getVacationDraft.jsp");

		
		return forward;
	}

}
