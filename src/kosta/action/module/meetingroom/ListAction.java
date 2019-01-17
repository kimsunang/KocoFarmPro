package kosta.action.module.meetingroom;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.MeetingRoomDao;
import kosta.model.module.vo.MeetingRoom;
import kosta.model.module.vo.MeetingRoomSearch;

public class ListAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MeetingRoomDao dao = MeetingRoomDao.getInstance();
		request.setCharacterEncoding("utf-8");
		MeetingRoomSearch search = new MeetingRoomSearch();
		
		List<MeetingRoom> list = dao.getMroomList(search);
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/jsp/module/rent/meetingroom/mroomlist.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
