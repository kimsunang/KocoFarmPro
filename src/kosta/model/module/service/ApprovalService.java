package kosta.model.module.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.module.dao.ApprovalDao;
import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalForm;
import kosta.model.module.vo.ApprovalVacation;

public class ApprovalService {
	private static ApprovalDao dao;
	private static ApprovalService service = new ApprovalService();
	int draftId;
	public static ApprovalService getInstnace(){
		dao = ApprovalDao.getInstance();
		return service;
	}
	ApprovalDraft draft = new ApprovalDraft();
	
	public int insertDraftService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");

		draft.setDraftTitle(request.getParameter("draftTitle"));
		draft.setDraftName(request.getParameter("draftName"));
		draft.setDraftYear(Integer.parseInt(request.getParameter("draftYear")));
		
		return dao.insertDraft(draft);
	}
	
	public int insertVacationService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");		
		ApprovalVacation vacation = new ApprovalVacation();
		
		draftId = dao.getDraftId();
		
		vacation.setDraftId(draftId);
		vacation.setVacationEndDt(request.getParameter("vacationStartDt"));
		vacation.setVacationStartDt(request.getParameter("vacationEndDt"));
		vacation.setVacationDays(Integer.parseInt(request.getParameter("vacationDays")));
		vacation.setVacationReason(request.getParameter("vacationReason"));
		vacation.setVacationType(request.getParameter("vacationType"));

		return dao.insertVacation(vacation);
	}
	
	public int insertExpenceService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");		
		ApprovalVacation vacation = new ApprovalVacation();
		
		draftId = dao.getDraftId();
		
		vacation.setDraftId(draftId);
		vacation.setVacationEndDt(request.getParameter("vacationStartDt"));
		vacation.setVacationStartDt(request.getParameter("vacationEndDt"));
		vacation.setVacationDays(Integer.parseInt(request.getParameter("vacationDays")));
		vacation.setVacationReason(request.getParameter("vacationReason"));
		vacation.setVacationType(request.getParameter("vacationType"));
		
		return dao.insertVacation(vacation);
	}
	
	public ApprovalForm getDetailForm(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");		

		int formId = Integer.parseInt(request.getParameter("formId"));
		
		return dao.getDetailForm(formId);
	}
	
	public ApprovalDraft getDraft(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		draftId = Integer.parseInt(request.getParameter("draftId"));
		return dao.getDraft(draftId);
		
	}
	
	public ApprovalVacation getVacation(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		draftId = Integer.parseInt(request.getParameter("draftId"));
		
		return dao.getVacation(draftId);
		
	}

}
