package kosta.action.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.module.service.EmpService;

public class CommAction{
	
	/* 카테고리에 따른 데이터 */
	public void getAjaxData(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ajaxMode = request.getParameter("ajaxMode");
		
		EmpService service = EmpService.getInstance();
		
		service.getAjaxData(request, response);
	}
}