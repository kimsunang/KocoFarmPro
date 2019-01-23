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
import kosta.action.module.employees.DelProCAction;
import kosta.action.module.employees.EditAction;
import kosta.action.module.employees.EditProCAction;
import kosta.action.module.employees.ListAction;
import kosta.action.module.employees.ViewAction;
import kosta.action.module.employees.WriteAction;
import kosta.action.module.employees.WriteProCAction;

@WebServlet({"/empList.do", "/empView.do", "/empWrite.do", 
	"/empWriteProC.do", "/empEdit.do", "/empEditProC.do", "/empDelProC.do"})
public class EmpController extends HttpServlet {
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
		if(command.equals("empList.do")){
			action = new ListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		/* 상세정보 */
		}else if(command.equals("empView.do")){
			action = new ViewAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		/* 등록 페이지 */
		}else if(command.equals("empWrite.do")){
			action = new WriteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		/* 등록 */
		}else if(command.equals("empWriteProC.do")){
			action = new WriteProCAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		/* 수정 페이지 */
		}else if(command.equals("empEdit.do")){
			action = new EditAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		/* 수정 */
		}else if(command.equals("empEditProC.do")){
			action = new EditProCAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		/* 삭제 */
		}else if(command.equals("empDelProC.do")){
			action = new DelProCAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("moduleNm", "employees");
		
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