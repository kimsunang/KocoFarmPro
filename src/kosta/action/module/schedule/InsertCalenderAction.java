package kosta.action.module.schedule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ScheduleDao;
import kosta.model.module.service.ScheduleService;
import kosta.model.module.vo.ScheduleCalender;
import kosta.model.module.vo.ScheduleProject;

public class InsertCalenderAction implements IAction{

	public InsertCalenderAction(){}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		

		ActionForward forward = new ActionForward();
		
		ScheduleService service =  ScheduleService.getInstance();		
		
		int projectId = 0;
		if(null != service){
			service.insertScheduleCalender(request);
			projectId = service.getAttributeProjectId(request);

		}
		
		forward.setRedirect(false);
		forward.setPath("/jsp/module/schedule/project.jsp");

		return forward;
	}	
}
