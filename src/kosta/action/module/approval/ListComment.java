package kosta.action.module.approval;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ApprovalDao;
import kosta.model.module.vo.DraftComment;

public class ListComment implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApprovalDao dao = ApprovalDao.getInstance();
		request.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("draftId"));
		
		List<DraftComment> list= dao.listComment(num);
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/jsp/module/approval/comment_list.jsp");
		
		return forward;
	}

}
