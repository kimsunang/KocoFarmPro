package kosta.model.module.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kosta.model.module.dao.ApprovalDao;
import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalExpence;
import kosta.model.module.vo.ApprovalExpenceCont;
import kosta.model.module.vo.ApprovalForm;
import kosta.model.module.vo.ApprovalVacation;
import kosta.model.module.vo.DraftComment;

public class ApprovalService {
	private static ApprovalDao dao;
	private static ApprovalService service = new ApprovalService();
	int draftId;
	int formId = 0;
	int a = 0;
	public static ApprovalService getInstnace(){
		dao = ApprovalDao.getInstance();
		return service;
	}
	ApprovalDraft draft = new ApprovalDraft();
	
	/* 기본 기안서 정보 입력*/
	public int insertDraftService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		draft.setFormId(formId);
		draft.setDraftTitle(request.getParameter("draftTitle"));
		draft.setDraftName(request.getParameter("draftName"));
		draft.setDraftYear(Integer.parseInt(request.getParameter("draftYear")));
		
		
		return dao.insertDraft(draft);
	}
	
	/* 휴가신청서 정보 입력*/
	public int insertVacationService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");		
		ApprovalVacation vacation = new ApprovalVacation();
		
		draftId = dao.getDraftId();
		vacation.setFormId(formId);
		vacation.setDraftId(draftId);
		vacation.setVacationEndDt(request.getParameter("vacationStartDt"));
		vacation.setVacationStartDt(request.getParameter("vacationEndDt"));
		vacation.setVacationDays(Integer.parseInt(request.getParameter("vacationDays")));
		vacation.setVacationReason(request.getParameter("vacationReason"));
		vacation.setVacationType(request.getParameter("vacationType"));
		vacation.setReplacementId(request.getParameter("replacementId"));

		return dao.insertVacation(vacation);
	}
	
	/*지출 결의서 정보 입력*/
	public int insertExpenceService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		ApprovalExpence expence = new ApprovalExpence();
		
		draftId = dao.getDraftId();
		
		expence.setFormId(formId);
		expence.setDraftId(draftId);
		expence.setExpenceDt(request.getParameter("expenceDt"));
		expence.setExpenceType(request.getParameter("expenceType"));
		expence.setSumPrice(request.getParameter("sumPrice"));
		
		return dao.insertExpence(expence);
		
	}
	
	/*지출 양식 정보 입력 */
	public int insertExpenceContService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		ApprovalExpenceCont expenceCont = new ApprovalExpenceCont();
		String op = "yes";
		String[] arr = request.getParameterValues("expence");
		for (int i = 0; i < arr.length; i += 4) {
				int expenceId = dao.getExpenceId();
				expenceCont.setExpenceId(expenceId);
				expenceCont.setContSeq(Integer.parseInt(arr[i]));
				expenceCont.setCustomerName(arr[i + 1]);
				expenceCont.setExpencePrice(arr[i + 2]);
				expenceCont.setCommissionPrice(arr[i + 3]);
				op = request.getParameter("vacationType" + (i/4 + 1));
				expenceCont.setCommissionOption(op);

				dao.insertExpenceCont(expenceCont);
			}
		
		return 1;
	}
	
	/* form 양식 출력 */
	public ApprovalForm getDetailForm(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");		

		formId = Integer.parseInt(request.getParameter("formId"));
		return dao.getDetailForm(formId);
	}
	
	/* 기안서 기본 정보 출력*/
	public ApprovalDraft getDraft(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		
		draftId = Integer.parseInt(request.getParameter("draftId"));
		
		return dao.getDraft(draftId);
		
	}
	
	/* 휴가 신청서 정보 가져오기 */
	public ApprovalVacation getVacation(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		draftId = Integer.parseInt(request.getParameter("draftId"));
		
		return dao.getVacation(draftId);
	}
	
	/* 지출 명세서 정보 가져오기*/
	public ApprovalExpence getExpence(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		draftId = Integer.parseInt(request.getParameter("draftId"));
		return dao.getExpence(draftId);
		
	}
	
	/* 댓글 정보 입력 */
	public int insertCommentService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");

		DraftComment comment = new DraftComment();

		comment.setDraftId(Integer.parseInt(request.getParameter("draftId")));
		// comment.setEmpId(Integer.parseInt(request.getParameter("empId")));
		comment.setCommentContents(request.getParameter("commentContents"));

		return dao.insertComment(comment);

	}
	
	public List<DraftComment> listComment(HttpServletRequest request) throws Exception {
		List<DraftComment> draftList = new ArrayList<DraftComment>();
		request.setCharacterEncoding("UTF-8");
		draftId = Integer.parseInt(request.getParameter("draftId"));

		draftList = dao.listComment(draftId);
		return draftList;
	}

	public List<DraftComment> getDraftCommentList(HttpServletRequest request) throws Exception {
		List<DraftComment> draftList = new ArrayList<DraftComment>();
		request.setCharacterEncoding("UTF-8");
		draftId = Integer.parseInt(request.getParameter("draftId"));
		int rownum = 0;
		try {
			rownum = Integer.parseInt(request.getParameter("rownum"));
		} catch (Exception e) {
			rownum = 5;
		}
		int pageNum = 2;
		int startNum = (pageNum * rownum) / 2 + 1;
		int endNum = (pageNum * rownum);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("draftId", draftId);
		map.put("rownum", rownum);
		map.put("endNum", endNum);
		map.put("startNum", startNum);
		draftList = dao.getDraftCommentList(map);
		return draftList;
	}

	public int getCommentCount(HttpServletRequest request) throws Exception {
		int commentCount = 0;
		request.setCharacterEncoding("UTF-8");
		draftId = Integer.parseInt(request.getParameter("draftId"));
		int rownum = 0;
		try {
			rownum = Integer.parseInt(request.getParameter("rownum"));
		} catch (Exception e) {
			rownum = 5;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("draftId", draftId);
		map.put("rownum", rownum);
		commentCount = dao.getCommentCount(map);
		return commentCount;
	}
	
}
