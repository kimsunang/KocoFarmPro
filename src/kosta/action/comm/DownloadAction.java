package kosta.action.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadAction implements IAction{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
			
		forward.setRedirect(false);
		forward.setPath("/jsp/comm/download.jsp");
		
		return forward;
	}
	
}