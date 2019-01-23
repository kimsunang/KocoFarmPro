package kosta.action.module.rentCarDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.RentCarDetailDao;

public class DelAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		RentCarDetailDao dao = RentCarDetailDao.getInstance();
		
		String carId = request.getParameter("carId");
		
		dao.delRentCarDetail(carId);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(true);
		forward.setPath("rentCarDetailList.do");
		
		
		return forward;
	}

}
