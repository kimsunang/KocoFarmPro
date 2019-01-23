package kosta.model.module.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.model.module.dao.NoticeDao;
import kosta.model.module.vo.NoticeVO;
import kosta.model.module.vo.NoticeListModelVO;
import kosta.model.module.vo.SearchVO;

public class NoticeService {
	private static NoticeDao dao;
	private static NoticeService noticeService = new NoticeService();
	private static final int PAGE_SIZE = 10;
	
	public static NoticeService getInstance(){
		dao = dao.getInstance();
		
		return noticeService;
	}
	
	/* 목록 */
	public NoticeListModelVO getNoticeList(int requestPage, HttpServletRequest request)throws Exception{
		// 검색
		String schType = request.getParameter("schType");
		String schWord = request.getParameter("schWord");
		
		HttpSession session = request.getSession();
		SearchVO search = new SearchVO();
		
		if(schType != null && schWord != null){
			session.removeAttribute("search");
			search.setSchType(schType);
			search.setSchWord(schWord);
			session.setAttribute("search", search);
		}else if(null != (SearchVO)session.getAttribute("search")){
			search = (SearchVO)session.getAttribute("search");
		}
		
		/* 페이지 네이션 */
		// 총 글 개 수
		int totalCount = dao.getNoticeListCnt(search);
		
		// 총 페이지 수
		int totalPageCount = totalCount/PAGE_SIZE;
		
		// 게시 글 나머지
		if(totalCount%PAGE_SIZE > 0){
			totalPageCount++;
		}
		
		// 시작 페이지, 마지막 페이지
		int startPage = requestPage - (requestPage-1)%PAGE_SIZE;
		int endPage = startPage+(PAGE_SIZE-1);
		
		if(endPage > totalPageCount){
			endPage = totalPageCount;
		}
		
		// 시작 행 구하기 : (현재페이지 -1) * 페이지 당 글 개 수
		int startRow = (requestPage-1)*PAGE_SIZE;

		List<NoticeVO> list = dao.getNoticeList(search, startRow);
		NoticeListModelVO listModel = new NoticeListModelVO(list, requestPage, totalPageCount, startPage, endPage, totalCount, PAGE_SIZE);
		
		return listModel;
	}
	
	/* 상세정보 */
	public NoticeVO getNotice(HttpServletRequest request)throws Exception{
		String noticeId = request.getParameter("noticeId") == null ? "" : request.getParameter("noticeId");
		NoticeVO notice = dao.getNotice(noticeId);
		
		if("view".equals(request.getParameter("mode"))){
			// 조회 수 증가
			int hitCnt = notice.getHitCnt()+1;
			notice.setHitCnt(hitCnt);
			dao.setUpHitCnt(notice);
			
			// 치환
			String contentsVw = notice.getContents().replaceAll("\r\n", "<br/>");
			notice.setContents(contentsVw);
		}
		
		return notice;
	}
	
	/* 등록 */
	public int setNotice(HttpServletRequest request)throws Exception{
		// 파일 업로드(경로, 파일크기, 인코딩, 파일 이름 중첩 정책)
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024; // 20MB
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		NoticeVO notice = new NoticeVO();
		notice.setTitle(multi.getParameter("title"));
		notice.setContents(multi.getParameter("contents"));
		
		// 파일 업로드
		if(multi.getFilesystemName("fileNm") != null){
			String fileNm = multi.getFilesystemName("fileNm");
			notice.setFileNm(fileNm);
		}else{
			notice.setFileNm("");
		}
		
		int re = dao.setNotice(notice);
		
		return re;
	}
	
	/* 수정 */
	public int setUpNotice(HttpServletRequest request)throws Exception{
		// 파일 업로드(경로, 파일크기, 인코딩, 파일 이름 중첩 정책)
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024; // 20MB
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		NoticeVO notice = new NoticeVO();
		notice.setTitle(multi.getParameter("title"));
		notice.setContents(multi.getParameter("contents"));
		notice.setNoticeId(multi.getParameter("noticeId"));
		
		String fileNm = null;
		
		// 파일 업로드
		if(null != multi.getFilesystemName("fileNm")){
			fileNm = multi.getFilesystemName("fileNm");
		}else{
			fileNm = multi.getParameter("fileYn");
		}
		
		notice.setFileNm(fileNm);
		int re = dao.setUpNotice(notice);
		
		return re;
	}
	
	/* 삭제 */
	public int delNotice(HttpServletRequest request)throws Exception{
		String noticeId = request.getParameter("noticeId") == null ? "" : request.getParameter("noticeId");
		
		int re = dao.delNotice(noticeId);
		
		return re;
	}
}