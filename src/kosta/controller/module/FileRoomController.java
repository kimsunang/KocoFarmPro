package kosta.controller.module;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.action.module.fileRoom.FileDownloadAction;
import kosta.action.module.fileRoom.FileListAction;
import kosta.action.module.fileRoom.FileUploadAction;
import kosta.action.module.fileRoom.FileViewAction;
import kosta.action.module.fileRoom.insertFileAction;
import kosta.action.module.notice.ViewAction;

@WebServlet({ "/fileList.do", "/fileUpload.do", "/fileDownload.do", "/insertFile.do" })

public class FileRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 전체경로 > context경로 포함 */
		String requestURI = request.getRequestURI();

		/* context경로 */
		String contextPath = request.getContextPath();

		/* 요청 URL 추출 */
		String command = requestURI.substring(contextPath.length() + 1);

		IAction action = null;
		ActionForward forward = null;
		// 파일목록 나오도록
		if (command.equals("fileList.do")) {
			action = new FileListAction();

			try {
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
			// 파일 업로드

		} else if (command.equals("fileUpload.do")) {
			action = new FileUploadAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("fileDownload.do")) {
			action = new FileDownloadAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}

		} else if (command.equals("insertFile.do")) {
			action = new insertFileAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (command.equals("fileList.do")) {
			action = new insertFileAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	

			/* 페이지 이동 */
		}
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}
}