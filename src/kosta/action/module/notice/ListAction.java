package kosta.action.module.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.NoticeService;
import kosta.model.module.vo.NoticeListModel;

public class ListAction implements IAction{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		NoticeService service = NoticeService.getInstance();
		
		/* 현재 페이지 */
		String pageNum = request.getParameter("pageNum");
		if(null == pageNum){
			pageNum = "1";
		}
		int requestPage = Integer.parseInt(pageNum);
		
		NoticeListModel listModel = service.getNoticeList(requestPage, request);
		request.setAttribute("noticeList", listModel);
		
		forward.setRedirect(false);
		forward.setPath("/jsp/module/notice/list.jsp");
		
		return forward;
	}

}