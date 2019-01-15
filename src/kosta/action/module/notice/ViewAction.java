package kosta.action.module.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.NoticeService;
import kosta.model.module.vo.Notice;

public class ViewAction implements IAction{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		NoticeService service = NoticeService.getInstance();
		
		Notice notice = service.getNotice(request);
		request.setAttribute("notice", notice);
		
		forward.setRedirect(false);
		forward.setPath("/jsp/module/notice/view.jsp");
		
		return forward;
	}

}