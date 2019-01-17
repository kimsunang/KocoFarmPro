package kosta.action.module.schedule;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.sun.xml.internal.ws.wsdl.writer.document.Service;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.ScheduleDao;
import kosta.model.module.service.ScheduleService;
import kosta.model.module.vo.ScheduleCalender;
import kosta.model.module.vo.ScheduleCategory;

public class ListCalenderAction implements IAction{

	public ListCalenderAction() {}
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ScheduleService service = ScheduleService.getInstance();
		if(null != service) {
			service.listProjectCalender(request);
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/jsp/module/schedule/calenderListJsonParse.jsp");
		
		return forward;
	}

}
