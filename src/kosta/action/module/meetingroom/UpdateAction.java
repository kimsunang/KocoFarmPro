package kosta.action.module.meetingroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.MeetingRoomDao;
import kosta.model.module.vo.MeetingRoom;

public class UpdateAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MeetingRoomDao dao = MeetingRoomDao.getInstance();
		request.setCharacterEncoding("utf-8");

		MeetingRoom mroom = new MeetingRoom();
		mroom.setM_id(Integer.parseInt(request.getParameter("m_id")));
		mroom.setM_name(request.getParameter("m_name"));
		mroom.setP_num(Integer.parseInt(request.getParameter("p_num")));
		mroom.setUp_dt(request.getParameter("up_dt"));
		
		dao.setUpMroom(mroom);
		
		ActionForward forward = new ActionForward();
		forward.setPath("mroomlist.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
