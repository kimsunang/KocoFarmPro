package kosta.controller.module;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.IAction;
import kosta.action.comm.ActionForward;
import kosta.action.module.approval.DetailDraftAction;
import kosta.action.module.approval.DetailDraftFormAction;
import kosta.action.module.approval.InsertDraftAction;
import kosta.action.module.approval.InsertDraftFormAction;
import kosta.action.module.approval.ListDraftAction;
import kosta.action.module.approval.ListDraftFormAction;


@WebServlet({"/insertDraft.do","/listDraft.do","/insertDraftForm.do","/listForm.do","/detailDraft.do","/DetailDraft.do"})
public class ApprovalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ApprovalController() {
        super();
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length()+1);
    	
    	IAction action = null;
    	ActionForward forward = null;
    	
    	/* 기안서 입력 */
    	if(command.equals("insertDraft.do")){
    		action = new InsertDraftAction(); 
    		try {
				forward = action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
    	/* 기안서 양식 리스트 */
    	}else if(command.equals("listForm.do")){
    		action = new ListDraftFormAction();
    		try {
				forward = action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("insertDraftForm.do")){
    		action = new InsertDraftFormAction();
    		try {
				forward = action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("listDraft.do")){
    		action = new ListDraftAction();
    		try {
				forward = action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("detailDraft.do")){
    		action = new DetailDraftFormAction();
    		try {
				forward = action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
    		}
    		
    	}else if(command.equals("DetailDraft.do")){
    		action = new DetailDraftAction();
    		try {
				forward = action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
    		}
    	}
    
    	
    	if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doProcess(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
