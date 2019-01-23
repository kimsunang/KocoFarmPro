package kosta.action.module.approval;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ApprovalDao;
import kosta.model.module.vo.ApprovalForm;

public class ListDraftFormAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApprovalDao dao = ApprovalDao.getInstance();
		request.setCharacterEncoding("utf-8");
		
		/*String schType = request.getParameter("schType");
		String schWord = request.getParameter("schWord");
		
		HttpSession session = request.getSession();
		ApprovalFormSearch search = new ApprovalFormSearch();
		
		if(schType != null && schWord != null){
			session.removeAttribute("search");
			search.setSchType(schType);
			search.setSchWord(schWord);
			session.setAttribute("search", search);
		}else if(null != (ApprovalFormSearch)session.getAttribute("search")){
			search = (ApprovalFormSearch)session.getAttribute("search");
		}*/
		
//		List<ApprovalForm> list = dao.listForm(search);
		List<ApprovalForm> list = dao.listForm();
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/jsp/module/approval/list.jsp");
		
		return forward;
	}

}
