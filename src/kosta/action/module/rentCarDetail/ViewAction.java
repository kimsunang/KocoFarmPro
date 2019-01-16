package kosta.action.module.rentCarDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.RentCarDetailDao;
import kosta.model.module.vo.RentCarDetail;

public class ViewAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String str = request.getParameter("car_id");
		String car_id = "";
		if(str != null){
			car_id = str;
		}
		
		RentCarDetailDao dao = RentCarDetailDao.getInstance();
		RentCarDetail rentCarDetail = dao.getRentCarDetail(car_id);
		
		request.setAttribute("rentCarDetail", rentCarDetail);

		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("/jsp/module/rent/car/rentCarDetailView.jsp");

		return forward;
	}

}
