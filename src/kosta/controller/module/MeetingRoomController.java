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
import kosta.action.module.meetingroom.DeleteAction;
import kosta.action.module.meetingroom.DetailAction;
import kosta.action.module.meetingroom.InsertAction;
import kosta.action.module.meetingroom.InsertActionForm;
import kosta.action.module.meetingroom.ListAction;
import kosta.action.module.meetingroom.UpdateActionForm;
import kosta.action.module.rentCarDetail.RentListAction;
import kosta.action.module.reservation.ReservInsertAction;
import kosta.action.module.reservation.ReservInsertActionForm;
import kosta.action.module.reservation.ReservListAction;
import kosta.action.module.meetingroom.UpdateAction;

@WebServlet({"/mroomlist.do", "/mroomdetail.do", "/mroomInsertForm.do", "/mroomInsert.do", "/mroomUpdateForm.do",
	"/mroomUpdate.do", "/mroomDelete.do", "/reservInsertForm.do", "/reservInsert.do", "/reservList.do"
	})
public class MeetingRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String requestURI = request.getRequestURI();		
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);

		IAction action = null;
		ActionForward forward = null;
		
		
		if(command.equals("mroomlist.do")){
			 action = new ListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("mroomdetail.do")){
			action = new DetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("mroomInsertForm.do")) {
			action = new InsertActionForm();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("mroomInsert.do")){
			action = new InsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else if (command.equals("mroomUpdateForm.do")) {
			action = new UpdateActionForm();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else if (command.equals("mroomUpdate.do")) {
			action = new UpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("mroomDelete.do")) {
			action = new DeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("reservInsertForm.do")) {
			action = new ReservInsertActionForm();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("reservInsert.do")) {
			action = new ReservInsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("reservList.do")) {
			action = new ReservListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("moduleNm", "rent");

		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}//redirect
		
		
	}//doProcess
}//werservlet