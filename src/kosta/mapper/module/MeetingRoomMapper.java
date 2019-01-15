package kosta.mapper.module;

import java.util.List;

import kosta.model.module.vo.MeetingRoom;
import kosta.model.module.vo.MeetingRoomSearch;

public interface MeetingRoomMapper {
	int setMroom(MeetingRoom mroom); 
	List<MeetingRoom> getMroomList(MeetingRoomSearch search);
	MeetingRoom getMroom(int m_id);
	int setUpMroom(MeetingRoom mroom);
	int delMroom(int m_id);
}
