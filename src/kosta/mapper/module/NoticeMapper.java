package kosta.mapper.module;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.model.module.vo.NoticeVO;
import kosta.model.module.vo.SearchVO;

public interface NoticeMapper {
	/* 목록 총 개 수*/
	int getNoticeListCnt(SearchVO search);
	
	/* 목록 */
	List<NoticeVO> getNoticeList(RowBounds row, SearchVO search);
	
	/* 상세정보 */
	NoticeVO getNotice(String noticeId);
	
	/* 조회 수 증가 */
	int setUpHitCnt(NoticeVO notice);
	
	/* 등록 */
	int setNotice(NoticeVO notice);
	
	/* 수정 */
	int setUpNotice(NoticeVO notice);
	
	/* 삭제 */
	int delNotice(String noticeId);
}
