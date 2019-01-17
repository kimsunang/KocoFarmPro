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
import kosta.action.module.rentCarDetail.DelAction;
import kosta.action.module.rentCarDetail.EditAction;
import kosta.action.module.rentCarDetail.EditActionForm;
import kosta.action.module.rentCarDetail.ListAction;
import kosta.action.module.rentCarDetail.RentCarAction;
import kosta.action.module.rentCarDetail.ViewAction;
import kosta.action.module.rentCarDetail.WriteAction;
import kosta.action.module.rentCarDetail.WriteActionForm;


@WebServlet({"/rentCarList.do", "/rentCarDetailWriteForm.do","/rentCarDetailWrite.do",
				"/rentCarDetailList.do", "/rentCarDetailView.do" 
				, "/rentCarDetailEditForm.do","/rentCarDetailEdit.do", "/rentCarDetailDelAction.do"
				,"/rent.do" })
public class RentCarDetailController extends HttpServlet {
    
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
		
		/* 첫시작*/
		if(command.equals("rent.do")){
			action = new RentCarAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		//목록//////////////////////////////////////////////////////여기 설정 모르겠음
		else if (command.equals("rentCarDetailList.do")) {
			action = new ListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/* 등록 페이지 */
		else if(command.equals("rentCarDetailWriteForm.do")){
			action = new WriteActionForm();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		/* 등록 */
		}else if(command.equals("rentCarDetailWrite.do")){
			action = new WriteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		}
		//상세페이지 - DetailAction 넣어주기
		else if(command.equals("rentCarDetailView.do")){
			action = new ViewAction();			
    		try {
    			forward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		 //수정 페이지 
		else if(command.equals("rentCarDetailEditForm.do")){
			action = new EditActionForm();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		  
		}
		//수정
		else if(command.equals("rentCarDetailEdit.do")){
			action = new EditAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		 
		}	
		// 삭제
		else if(command.equals("rentCarDetailDelAction.do")){
			System.out.println("renCarDetailDelAction.do에 들어왔습니다.");
			action = new DelAction();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		//페이지 이동
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
