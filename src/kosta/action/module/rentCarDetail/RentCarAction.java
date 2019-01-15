package kosta.action.module.rentCarDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;

//Main페이지에서 대여 카테고리로 이동
public class RentCarAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
	      
	      forward.setRedirect(false);
	      forward.setPath("/jsp/module/rent/list.jsp");
	      
		return forward;
	}

}
