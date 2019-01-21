package kosta.action.module.fileRoom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.FileService;


public class FileDeleteAction implements IAction{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		FileService service = FileService.getInstance();
		
		
		/* 성공 여부 */
		int re = service.delFile(request);
		request.setAttribute("re", re);
		request.setAttribute("myPage", "'fileList.do'");
		
		forward.setRedirect(false);
		forward.setPath("/fileLIst.do");
		
		return forward;
	}

}