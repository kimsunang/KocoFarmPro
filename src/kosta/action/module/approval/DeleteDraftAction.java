package kosta.action.module.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ApprovalDao;
import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalExpence;
import kosta.model.module.vo.ApprovalVacation;

public class DeleteDraftAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApprovalDao dao = ApprovalDao.getInstance();
		request.setCharacterEncoding("utf-8");
		
		int draftId = Integer.parseInt(request.getParameter("draftId"));
		ApprovalDraft draft = dao.getDraft(draftId);
		int formId = draft.getFormId();

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		if(formId == 2){
			dao.deleteExpence(draftId);
		}else if(formId == 4){
			dao.deleteVacation(draftId);
		}
		dao.deleteDraft(draftId);
		
		forward.setPath("/jsp/module/approval/list.jsp");
		return forward;
	}

}
