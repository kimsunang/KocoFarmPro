package kosta.mapper.module;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.model.module.vo.Notice;
import kosta.model.module.vo.NoticeSearch;

public interface NoticeMapper {
	/* 목록 총 개 수*/
	int getNoticeListCnt(NoticeSearch search);
	
	/* 목록 가져오기 */
	List<Notice> getNoticeList(RowBounds row, NoticeSearch search);
	
	/* 상세정보 가져오기 */
	Notice getNotice(String noticeId);
	
	/* 조회 수 증가 */
	int setUpHitCnt(Notice notice);
	
	/* 등록 */
	int setNotice(Notice notice);
	
	/* 수정 */
	int setUpNotice(Notice notice);
	
	/* 삭제 */
	int delNotice(String noticeId);
}
