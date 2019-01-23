package kosta.mapper.module;

import java.util.List;

import kosta.model.module.vo.MeetingRoom;
import kosta.model.module.vo.MeetingRoomSearch;

public interface MeetingRoomMapper {
	//등록
	int setMroom(MeetingRoom mroom); 
	
	//목록
	List<MeetingRoom> getMroomList(MeetingRoomSearch search);
	
	//상세보기
	MeetingRoom getMroom(int mId);
	
	//수정
	int setUpMroom(MeetingRoom mroom);
	
	//삭제
	int delMroom(int mId);
}
