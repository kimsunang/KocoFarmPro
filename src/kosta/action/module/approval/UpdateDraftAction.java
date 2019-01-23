package kosta.action.module.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ApprovalDao;
import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalVacation;

public class UpdateDraftAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApprovalDao dao = ApprovalDao.getInstance();
		request.setCharacterEncoding("utf-8");
		
		int draftId = Integer.parseInt(request.getParameter("draftId"));
		ApprovalDraft draft = dao.getDraft(draftId);
		
		int formId = draft.getFormId();
		
		draft.setDraftTitle(request.getParameter("draftTitle"));
		draft.setDraftYear(Integer.parseInt(request.getParameter("draftYear")));
		
		
		dao.updateDraft(draft);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		if(formId == 2){
			
			forward.setPath("/jsp/module/approval/draftList.jsp");
		}else if(formId == 4){
			ApprovalVacation vacation = dao.getVacation(draftId);
			vacation.setVacationType(request.getParameter("vacationType"));
			vacation.setVacationStartDt(request.getParameter("vacationStartDt"));
			vacation.setVacationEndDt(request.getParameter("vacationEndDt"));
			vacation.setVacationDays(Integer.parseInt(request.getParameter("vacationDays")));
			vacation.setReplacementId(request.getParameter("replacementId"));
			dao.updateVacation(vacation);
			request.setAttribute("vacation", vacation);
		}

		forward.setPath("/jsp/module/approval/list.jsp");
		return forward;
	}

}
