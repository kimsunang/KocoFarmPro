package kosta.action.module.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ReservationDao;
import kosta.model.module.vo.Reservation;

public class ReservInsertAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReservationDao dao = ReservationDao.getInstance();
		request.setCharacterEncoding("utf-8");		

		Reservation reserv = new Reservation();
		reserv.setmTitle(request.getParameter("mTitle"));
		reserv.setDept(request.getParameter("dept"));
		reserv.setStartDt(request.getParameter("startDt"));
		reserv.setEndDt(request.getParameter("endDt"));
		reserv.setRvUser(request.getParameter("rvUser"));
		reserv.setRvWriter(request.getParameter("rvWriter"));
		reserv.setmId(Integer.parseInt(request.getParameter("mId")));
		
		dao.setReserv(reserv);
		
		ActionForward forward = new ActionForward();
		forward.setPath("mroomlist.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
