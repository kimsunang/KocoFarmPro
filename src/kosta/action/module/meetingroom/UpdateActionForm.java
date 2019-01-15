package kosta.action.module.meetingroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.MeetingRoomDao;
import kosta.model.module.vo.MeetingRoom;

public class UpdateActionForm implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MeetingRoomDao dao = MeetingRoomDao.getInstance();
		int m_id = Integer.parseInt(request.getParameter("m_id"));
		MeetingRoom mroom  = dao.getMroom(m_id);
		
		request.setAttribute("mroom", mroom);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/jsp/module/rent/meetingroom/mroomupdateForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
