package kosta.action.module.carReservation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.CarReservationDao;
import kosta.model.module.vo.CarReservation;
import kosta.model.module.vo.Emp;
import kosta.model.module.vo.RentCarDetail;

public class WriteActionForm implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		CarReservationDao dao = CarReservationDao.getInstance();
		
		String car_id = request.getParameter("car_id");
		RentCarDetail rentCar = dao.getCarList(car_id);
		request.setAttribute("rentCar", rentCar);
		
		
		Emp emp = new Emp();
		List<Emp> empList = dao.getEmpName(emp);
		
		request.setAttribute("empList", empList);
		
		forward.setRedirect(false);
		forward.setPath("/jsp/module/rent/carReservation/CarReservationWrite.jsp");
		
		return null;
	}

}
