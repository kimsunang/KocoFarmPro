package kosta.mapper.module;

import java.util.List;

import kosta.model.module.vo.Departments;
import kosta.model.module.vo.Emp;
import kosta.model.module.vo.MeetingRoom;
import kosta.model.module.vo.Reservation;
import kosta.model.module.vo.ReservationSearch;

public interface ReservationMapper {
	//예약 등록
	int setReserv(Reservation reserv);
	
	//회의실 이름 불러오기
	MeetingRoom getResList(int mId);
	
	//부서 불러오기
	List<Departments> getDeptList(Departments dept);
	
	//사원이름 불러오기
	List<Emp> getEmpName(Emp emp);
	
	//예약 목록
	List<Reservation> getReservList(ReservationSearch search);

}
