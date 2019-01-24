package kosta.action.module.rentCarDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.dao.RentCarDetailDao;
import kosta.model.module.vo.RentCarDetail;

public class EditAction implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RentCarDetailDao dao = RentCarDetailDao.getInstance();
		RentCarDetail rentCarDetail = new RentCarDetail();
		
		rentCarDetail.setCarId(request.getParameter("carId"));
		//rentCarDetail.setcarId(request.getParameter("carId"));		
		rentCarDetail.setModelName(request.getParameter("modelName"));
		rentCarDetail.setCarModel(request.getParameter("carModel"));
		rentCarDetail.setCondition(request.getParameter("condition"));
		rentCarDetail.setPrice(Integer.parseInt(request.getParameter("price")));
		rentCarDetail.setYear(Integer.parseInt(request.getParameter("year")));
		//rentCarDetail.setoilType(request.getParameter("oil_Type"));
		rentCarDetail.setOilType(request.getParameter("oil_Type"));
		
		dao.setUpRentCarDetail(rentCarDetail);

		ActionForward forward = new ActionForward();
		
		
		forward.setRedirect(true);
		forward.setPath("rentCarDetailList.do");
		
		return forward;
	}

}