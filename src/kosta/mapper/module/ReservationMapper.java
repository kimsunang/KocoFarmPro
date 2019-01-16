package kosta.mapper.module;

import kosta.model.module.vo.Reservation;

public interface ReservationMapper {
	int setReserv(Reservation reserv);
	Reservation getMname(int m_id);
}
