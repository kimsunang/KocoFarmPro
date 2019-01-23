package kosta.action.module.reservation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ReservationDao;
import kosta.model.module.vo.Reservation;
import kosta.model.module.vo.ReservationSearch;

public class ReservListAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReservationDao dao = ReservationDao.getInstance();
		request.setCharacterEncoding("utf-8");
		
		ReservationSearch search = new ReservationSearch(); 
		List<Reservation> list = dao.getReservList(search);
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/jsp/module/rent/reservation/reservlist.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
