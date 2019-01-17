package kosta.action.module.fileRoom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;

public class FileUploadAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ActionForward forward = new ActionForward();
		forward.setPath("/jsp/module/file_room/fileUpload.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
