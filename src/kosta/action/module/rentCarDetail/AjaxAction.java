package kosta.action.module.rentCarDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.module.service.RentCarDetailService;

public class AjaxAction {
	public void getAjaxData(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ajaxMode = request.getParameter("ajaxMode");
		
		RentCarDetailService service = RentCarDetailService.getInstance();
		service.getAjaxData(request, response);
		
		
	}

}
