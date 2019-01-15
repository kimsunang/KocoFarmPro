package kosta.action.module.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.MeetingRoomDao;
import kosta.model.module.dao.ReservationDao;
import kosta.model.module.vo.MeetingRoom;
import kosta.model.module.vo.Notice;
import kosta.model.module.vo.Reservation;

public class ReservInsertAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReservationDao dao = ReservationDao.getInstance();
		request.setCharacterEncoding("utf-8");

		Reservation reserv = new Reservation();
		reserv.setM_title(request.getParameter("m_title"));
		reserv.setStart_dt(request.getParameter("start_dt"));
		reserv.setEnd_dt(request.getParameter("end_dt"));
		reserv.setDept(request.getParameter("dept"));
		reserv.setRv_user(request.getParameter("rv_user"));
		reserv.setRv_writer(request.getParameter("rv_writer"));
		
		dao.setReserv(reserv);
		
		ActionForward forward = new ActionForward();
		forward.setPath("mroomlist.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
