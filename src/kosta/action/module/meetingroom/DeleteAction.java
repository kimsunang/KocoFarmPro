package kosta.action.module.meetingroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.MeetingRoomDao;

public class DeleteAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MeetingRoomDao dao = MeetingRoomDao.getInstance();
		
		int mId = Integer.parseInt(request.getParameter("mId"));
		dao.delMroom(mId);
		
		ActionForward forward = new ActionForward();
		forward.setPath("mroomlist.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
