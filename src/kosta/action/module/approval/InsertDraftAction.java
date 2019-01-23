package kosta.action.module.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ApprovalDao;
import kosta.model.module.service.ApprovalService;
import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalExpence;
import kosta.model.module.vo.ApprovalExpenceCont;

public class InsertDraftAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		ApprovalService service = ApprovalService.getInstnace();
		ApprovalDraft draft = new ApprovalDraft();
		ApprovalDao dao = ApprovalDao.getInstance();
		service.insertDraftService(request);
		int draftId = dao.getDraftId();
		draft = dao.getDraft(draftId);
		
		
		int formId = draft.getFormId();

		if (formId == 2) {
			service.insertExpenceService(request);
			service.insertExpenceContService(request);
		} else if (formId == 4) {
			service.insertVacationService(request);
		}

		forward.setRedirect(false);
		forward.setPath("/listDraft.do");

		return forward;
	}

}
