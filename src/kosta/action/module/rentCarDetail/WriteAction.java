package kosta.action.module.rentCarDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.RentCarDetailService;

public class WriteAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RentCarDetailService service = RentCarDetailService.getInstance();
		service.setRentCarDetail(request);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(true);
		forward.setPath("rentCarDetailList.do");
		
		return forward;
		
	}
}
