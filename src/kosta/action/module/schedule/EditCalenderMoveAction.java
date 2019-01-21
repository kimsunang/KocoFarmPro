package kosta.action.module.schedule;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.beans.property.IntegerProperty;
import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ScheduleDao;
import kosta.model.module.service.ScheduleService;
import kosta.model.module.vo.ScheduleCalenderMove;

public class EditCalenderMoveAction implements IAction {
	public EditCalenderMoveAction(){}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] data = request.getParameter("data_parameter").split("[|]");
		if(null == data)
			return null;
		
		ScheduleService service = ScheduleService.getInstance();
		int re = service.editCalenderMove(request);
		if(-1 == re)
			return null;
			
		ActionForward forward = null;
		if(-1 != re) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/jsp/module/schedule/project.jsp");
		}		
		return forward;
	}
}
