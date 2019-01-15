package kosta.mapper.module;

import kosta.action.comm.IAction;
import kosta.model.module.vo.RentCarDetail;
import kosta.model.module.vo.RentCarDetailSearch;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
public interface RentCarDetailMapper extends IAction {

	//목록 총개수
	int getRentCarDetailListCnt(RentCarDetailSearch search);
	
	//목록가져오기
	List<RentCarDetail> getRentCarDetailList(RowBounds row, RentCarDetailSearch search);

	//상세정보
	RentCarDetail getRentCarDetail(int car_id);
	
	
	//등록하기
	int setRentCarDetail(RentCarDetail rentCarDetail);
	
	
	//수정
	
	//삭제
		
	
}
