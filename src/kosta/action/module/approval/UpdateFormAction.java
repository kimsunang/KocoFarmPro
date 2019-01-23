package kosta.action.module.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ApprovalDao;
import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalExpence;
import kosta.model.module.vo.ApprovalVacation;

public class UpdateFormAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApprovalDao dao = ApprovalDao.getInstance();
		request.setCharacterEncoding("utf-8");
		
		int draftId = Integer.parseInt(request.getParameter("draftId"));
		ApprovalDraft draft = dao.getDraft(draftId);
		int formId = draft.getFormId();
		
		request.setAttribute("draft", draft);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		if(formId == 2){
			ApprovalExpence expence = dao.getExpence(draftId);
			request.setAttribute("expence", expence);	
			forward.setPath("/jsp/module/approval/ApprovalUpdateExp.jsp");
		}else if(formId == 4){
			ApprovalVacation vacation = dao.getVacation(draftId);
			request.setAttribute("vacation", vacation);
			forward.setPath("/jsp/module/approval/ApprovalUpdateVac.jsp");
		}

		
		return forward;
	}

}
