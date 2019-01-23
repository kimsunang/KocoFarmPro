package kosta.action.module.reservation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.DepthTest;
import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ReservationDao;
import kosta.model.module.vo.Departments;
import kosta.model.module.vo.Emp;
import kosta.model.module.vo.MeetingRoom;
import kosta.model.module.vo.MeetingRoomSearch;
import kosta.model.module.vo.Reservation;

public class ReservInsertActionForm implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ReservationDao dao =  ReservationDao.getInstance();
		
		int m_id  = Integer.parseInt(request.getParameter("mId"));
		MeetingRoom mroom = dao.getResList(m_id);
		request.setAttribute("mroom", mroom);
		
		Departments dept = new Departments();
		List<Departments> deptList = dao.getDeptList(dept);
		request.setAttribute("deptList", deptList);
		
		Emp emp = new Emp();
		List<Emp> empList = dao.getEmpName(emp);
		request.setAttribute("empList", empList);		
		
		forward.setRedirect(false);
		forward.setPath("/jsp/module/rent/reservation/reservInsertForm.jsp");
		
		return forward;
	}

}
