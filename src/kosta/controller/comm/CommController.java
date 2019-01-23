package kosta.controller.comm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.CommAction;

@WebServlet({"/getAjaxData.do", "/setAjaxData.do"})
public class CommController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
		
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CommAction action = new CommAction();
		
		try {
			action.getAjaxData(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}