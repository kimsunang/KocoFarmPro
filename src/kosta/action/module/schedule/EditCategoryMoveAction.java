package kosta.action.module.schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.ScheduleService;

public class EditCategoryMoveAction implements IAction {

	public EditCategoryMoveAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ScheduleService service = ScheduleService.getInstance();
		service.setMoveCategoryPosX(request);
		
		return null;
	}

}
