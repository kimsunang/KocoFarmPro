package kosta.action.module.rentCarDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.RentCarDetailDao;

public class DelAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("DelAction에 들어왔습니다. - 1");
		
		request.setCharacterEncoding("utf-8");
		
		RentCarDetailDao dao = RentCarDetailDao.getInstance();
		
		System.out.println("DelAction에 들어왔습니다. - 2");
		
		String car_id = request.getParameter("car_id");
		dao.delRentCarDetail(car_id);
		System.out.println("DelAction에 들어왔습니다. - 3");
		
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(true);
		forward.setPath("rentCarDetailList.do");
		
		
		return forward;
	}

}
