package kosta.action.module.fileRoom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.vo.Notice;

public class FileViewAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		//FileRoomService service = FileRoomService.getInstance();
		// 파일 서비스 만든 다음에 넣을것
		System.out.println("# 진입 ");
		forward.setPath("/jsp/module/file_room/fileRoomView.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
