package kosta.controller.module;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.module.rentCarDetail.AjaxAction;

@WebServlet("/getCarAjaxData.do")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
    public AjaxController() {}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doProcess(request, response);
	}
		
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		AjaxAction action = new AjaxAction();
		try {
			action.getAjaxData(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
}
