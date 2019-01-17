package kosta.action.module.rentCarDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.RentCarDetailService;

public class WriteAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*
		//성공여부
		int re = service.setRentCarDetail(request);
		request.setAttribute("re", re);
		*/
		
		/*forward.setRedirect(false);
		forward.setPath("/jsp/comm/proC.jsp");
		*/
		/*
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("/jsp/module/rent/car/write.jsp");
		
		return forward;*/
		
		
		RentCarDetailService service = RentCarDetailService.getInstance();
		service.setRentCarDetail(request);
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(true);
		forward.setPath("rentCarDetailList.do");
		
		return forward;
		
	}
}
