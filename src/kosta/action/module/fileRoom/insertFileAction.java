package kosta.action.module.fileRoom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.FileService;

public class insertFileAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FileService service = FileService.getInstance();
		
		service.setFile(request);// 데이터를 하나만 보내고 있는거 같은데..
		
		ActionForward forward = new ActionForward();
		forward.setPath("/jsp/module/file_room/fileList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
