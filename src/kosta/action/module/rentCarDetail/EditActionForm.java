package kosta.action.module.rentCarDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.RentCarDetailDao;
import kosta.model.module.vo.RentCarDetail;

public class EditActionForm implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		RentCarDetailDao dao = RentCarDetailDao.getInstance();
		String car_id = request.getParameter("car_id");
		RentCarDetail rentCarDetail = dao.getRentCarDetail(car_id);
		
		request.setAttribute("rentCarDetail", rentCarDetail);
		
		ActionForward forward= new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/jsp/module/rent/car/rentCarDetailUpdate.jsp");
		
		return forward;
	}

}
