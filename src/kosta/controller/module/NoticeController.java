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
import kosta.action.module.notice.DelProCAction;
import kosta.action.module.notice.EditAction;
import kosta.action.module.notice.EditProCAction;
import kosta.action.module.notice.ListAction;
import kosta.action.module.notice.ViewAction;
import kosta.action.module.notice.WriteAction;
import kosta.action.module.notice.WriteProCAction;

@WebServlet({"/noticeList.do", "/noticeView.do", "/noticeWrite.do", 
	"/noticeWriteProC.do", "/noticeEdit.do", "/noticeEditProC.do", "/noticeDelProC.do"})
public class NoticeController extends HttpServlet {
private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		/* 전체경로 > context경로 포함 */
		String requestURI = request.getRequestURI();
		
		/* context경로 */
		String contextPath = request.getContextPath();
		
		/* 요청 URL 추출 */
		String command = requestURI.substring(contextPath.length()+1);
		
		IAction action = null;
		ActionForward forward = null;
		
		/* 목록 */
		if(command.equals("noticeList.do")){
			action = new ListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		/* 상세정보 */
		}else if(command.equals("noticeView.do")){
			action = new ViewAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		/* 등록 페이지 */
		}else if(command.equals("noticeWrite.do")){
			action = new WriteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		/* 등록 */
		}else if(command.equals("noticeWriteProC.do")){
			action = new WriteProCAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		/* 수정 페이지 */
		}else if(command.equals("noticeEdit.do")){
			action = new EditAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		/* 수정 */
		}else if(command.equals("noticeEditProC.do")){
			action = new EditProCAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		/* 삭제 */
		}else if(command.equals("noticeDelProC.do")){
			action = new DelProCAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/* 페이지 이동 */
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}