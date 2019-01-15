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
import kosta.action.comm.MainAction;
import kosta.action.module.meetingroom.DeleteAction;
import kosta.action.module.meetingroom.DetailAction;
import kosta.action.module.meetingroom.InsertAction;
import kosta.action.module.meetingroom.InsertActionForm;
import kosta.action.module.meetingroom.ListAction;
import kosta.action.module.meetingroom.RentListAction;
import kosta.action.module.meetingroom.UpdateActionForm;
import kosta.action.module.meetingroom.UpdateAction;

@WebServlet("/rentlist.do")
public class RentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		IAction action = new RentListAction();
		ActionForward forward = null;
		
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}//if redirect
		
		
	}//doProcess
}//werservlet