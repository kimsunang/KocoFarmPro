package kosta.mapper.module;

import kosta.action.comm.IAction;
import kosta.model.module.vo.CarReservation;
import kosta.model.module.vo.Emp;
import kosta.model.module.vo.RentCarDetail;

import java.util.List;
public interface CarReservationMapper extends IAction {

	//예약등록
	int setCarReservation(CarReservation carReservation);
	
	//차량 관련 내용 불러오기
	RentCarDetail getCarList(String car_id);
	
	
	//사원이름 불러오기
	List<Emp> getEmpName(Emp emp);
	
	
	
}
