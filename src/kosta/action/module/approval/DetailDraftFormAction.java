package kosta.action.module.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.ApprovalService;
import kosta.model.module.vo.ApprovalForm;

public class DetailDraftFormAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		ApprovalForm form = new ApprovalForm();
		ApprovalService service = ApprovalService.getInstnace();
		form = service.getDetailForm(request);

		
		int formId = form.getFormId();
		request.setAttribute("form",form);
		forward.setRedirect(false);
		if(formId == 2){
			forward.setPath("jsp/module/approval/expenceDraft.jsp");
		}else if(formId == 4){
			forward.setPath("jsp/module/approval/vacationDraft.jsp");
		}else{
			forward.setPath("jsp/module/approval/defaultDraft.jsp");
		}
		
		return forward;
	}

}
