package kosta.action.module.rentCarDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.RentCarDetailService;
import kosta.model.module.vo.RentCarDetailListModel;

//rentCarDetail - ListAction입니다.
public class ListAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String URI = request.getRequestURI();
		
		RentCarDetailService service = RentCarDetailService.getInstance();	
		//현재페이지
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum ="1";
		}
		
		int requestPage = Integer.parseInt(pageNum);

		//여기서 안들어가ㅠ
		RentCarDetailListModel rentCarDetailListModel = service.getRentCarDetailList(requestPage, request);
		
		
		request.setAttribute("rentCarDetailListModel", rentCarDetailListModel);
	
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/jsp/module/rent/car/rentCarDetailList.jsp");
		//forward.setPath("rentCarDetailList.do");
		
		
		return forward;
	}

}
