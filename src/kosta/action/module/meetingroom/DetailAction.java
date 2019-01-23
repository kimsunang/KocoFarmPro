package kosta.action.module.meetingroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.MeetingRoomDao;
import kosta.model.module.dao.ReservationDao;
import kosta.model.module.vo.MeetingRoom;
import kosta.model.module.vo.Reservation;

public class DetailAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MeetingRoomDao dao = MeetingRoomDao.getInstance();
		request.setCharacterEncoding("utf-8");
		
	    String str = request.getParameter("mId");
	    int mId = 0;
	    if(str != null){
	    	mId = Integer.parseInt(str);
	    }
	   
	    MeetingRoom mroom = dao.getMroom(mId);
	    request.setAttribute("mroom", mroom);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/jsp/module/rent/meetingroom/mroomdetail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
