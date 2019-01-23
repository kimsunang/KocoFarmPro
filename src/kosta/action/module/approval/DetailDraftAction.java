package kosta.action.module.approval;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ApprovalDao;
import kosta.model.module.service.ApprovalService;
import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalExpence;
import kosta.model.module.vo.ApprovalExpenceCont;
import kosta.model.module.vo.ApprovalVacation;
import kosta.model.module.vo.DraftComment;

public class DetailDraftAction implements IAction {

	@Override
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ApprovalDao dao = ApprovalDao.getInstance();
		ActionForward forward = new ActionForward();
		ApprovalDraft draft = new ApprovalDraft();
		ApprovalVacation vacation = new ApprovalVacation();
		ApprovalExpence expence = new ApprovalExpence();
		int expenceId = 0;
		List<ApprovalExpenceCont> list = null;
		ApprovalService service = ApprovalService.getInstnace();
		draft = service.getDraft(request);
		vacation = service.getVacation(request);
		expence = service.getExpence(request);
		
		request.setAttribute("draft", draft);
		request.setAttribute("vacation",vacation);
		request.setAttribute("expence", expence);
		
		int formId = draft.getFormId();
		
		List<DraftComment> draftList = new ArrayList<DraftComment>();
		draftList = service.getDraftCommentList(request);
		int commentCount = service.getCommentCount(request);
		
		request.setAttribute("draftList", draftList);
		request.setAttribute("commentCount", commentCount);
		forward.setRedirect(false);
		
		if(formId == 4){
			forward.setPath("jsp/module/approval/getVacationDraft.jsp");
		}else if(formId == 2){
			expenceId = expence.getExpenceId();
			list = dao.getExpenceCont(expenceId);
			request.setAttribute("list", list);
			forward.setPath("jsp/module/approval/getExpenceDraft.jsp");
		}
		return forward;
	}

}
