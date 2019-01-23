package kosta.model.module.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.action.comm.SHA256Util;
import kosta.model.comm.vo.EmpCategoryVO;
import kosta.model.module.dao.EmpDao;
import kosta.model.module.vo.EmpListModelVO;
import kosta.model.module.vo.EmpVO;
import kosta.model.module.vo.SearchVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EmpService {
	private static EmpDao dao;
	private static EmpService empService = new EmpService();
	private static final int PAGE_SIZE = 10;
	
	public static EmpService getInstance(){
		dao = dao.getInstance();
		
		return empService;
	}
	
	/* 목록 */
	public EmpListModelVO getEmpList(int requestPage, HttpServletRequest request)throws Exception{
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
		int totalCount = dao.getEmpListCnt(search);
		
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

		List<EmpVO> list = dao.getEmpList(search, startRow);
		EmpListModelVO listModel = new EmpListModelVO(list, requestPage, totalPageCount, startPage, endPage, totalCount, PAGE_SIZE);
		
		return listModel;
	}
	
	/* 상세정보 */
	public EmpVO getEmp(HttpServletRequest request)throws Exception{
		String empId = request.getParameter("empId") == null ? "" : request.getParameter("empId");
		EmpVO emp = dao.getEmp(empId);
		
		return emp;
	}
	
	/* 등록 */
	public int setEmp(HttpServletRequest request)throws Exception{
		// 파일 업로드(경로, 파일크기, 인코딩, 파일 이름 중첩 정책) 
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024; // 20MB
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		EmpVO emp = new EmpVO();
		emp.setKorNm(multi.getParameter("korNm"));
		emp.setEngNm(multi.getParameter("engNm"));
		emp.setEmail(multi.getParameter("email"));
		emp.setCellPhone(multi.getParameter("cellPhone"));
		emp.setHireDt(multi.getParameter("hireDt"));
		emp.setState("stay");
		emp.setAnnual(12);
		emp.setDeptId(multi.getParameter("deptId"));
		emp.setJobId(multi.getParameter("jobId"));
		emp.setPositionId(multi.getParameter("positionId"));
		emp.setManagerId(multi.getParameter("managerId"));
		emp.setAuthority(Integer.parseInt(multi.getParameter("authority")));
		emp.setSalary(Integer.parseInt(multi.getParameter("salary")));
		
		// 초기 비밀 번호 암호화
		String salt = SHA256Util.generateSalt();
		String pw = SHA256Util.getEncrypt("1234", salt);
		emp.setPw(pw);
		emp.setSalt(salt);
		
		// 파일 업로드
		if(multi.getFilesystemName("fileNm") != null){
			String fileNm = multi.getFilesystemName("fileNm");
			emp.setFileNm(fileNm);
		}else{
			emp.setFileNm("");
		}
		
		int re = dao.setEmp(emp);
		
		return re;
	}
	
	/* 수정 */
	public int setUpEmp(HttpServletRequest request)throws Exception{
		// 파일 업로드(경로, 파일크기, 인코딩, 파일 이름 중첩 정책)
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024; // 20MB
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		String empId = multi.getParameter("empId");
		// 변경 전 정보
		EmpVO empView = dao.getEmp(empId);
		
		String state = multi.getParameter("state");
		String deptId = multi.getParameter("deptId");
		String jobId = multi.getParameter("jobId");
		String positionId = multi.getParameter("positionId");
		
		// JOB_HISTORY
		if(!state.equals(empView.getState()) || !deptId.equals(empView.getDeptId()) 
				 || !jobId.equals(empView.getJobId()) || !positionId.equals(empView.getPositionId())){
			if("retirement".equals(empView.getState())){
				empView.setStartDt(empView.getHireDt());
				empView.setEndDt(empView.getRetirementDt());
			}else if("stay".equals(empView.getState())){
				empView.setStartDt(empView.getHireDt());
			}
			dao.setJobHistory(empView);
		}
		
		EmpVO emp = new EmpVO();
		emp.setEmpId(multi.getParameter("empId"));
		emp.setKorNm(multi.getParameter("korNm"));
		emp.setEngNm(multi.getParameter("engNm"));
		emp.setEmail(multi.getParameter("email"));
		emp.setCellPhone(multi.getParameter("cellPhone"));
		emp.setHireDt(multi.getParameter("hireDt"));
		emp.setDeptId(deptId);
		emp.setJobId(jobId);
		emp.setPositionId(positionId);
		emp.setManagerId(multi.getParameter("managerId"));
		emp.setAuthority(Integer.parseInt(multi.getParameter("authority")));
		emp.setSalary(Integer.parseInt(multi.getParameter("salary")));
		emp.setState(state);
		emp.setStartDt(multi.getParameter("startDt"));
		
		if("retirement".equals(state)){
			emp.setRetirementDt(multi.getParameter("endDt"));
		}else{
			emp.setRetirementDt("");
			emp.setEndDt(multi.getParameter("endDt"));
		}
		
		String fileNm = null;
		
		// 파일 업로드
		if(null != multi.getFilesystemName("fileNm")){
			fileNm = multi.getFilesystemName("fileNm");
		}else{
			fileNm = multi.getParameter("fileYn");
		}
		
		emp.setFileNm(fileNm);
		int re = dao.setUpEmp(emp);
		
		return re;
	}
	
	/* 삭제 */
	public int delEmp(HttpServletRequest request)throws Exception{
		String empId = request.getParameter("empId") == null ? "" : request.getParameter("empId");
		
		int re = dao.delEmp(empId);
		
		return re;
	}
	
	/* 부서 목록 */
	public List<EmpCategoryVO> getDeptList()throws Exception{
		List<EmpCategoryVO> list = dao.getDeptList();
		
		return list;
	}
	
	/* 직책 목록 */
	public List<EmpCategoryVO> getPositionList()throws Exception{
		List<EmpCategoryVO> list = dao.getPositionList();
		
		return list;
	}
	
	/* AjaxMode에 따른 데이터 */
	public void getAjaxData(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String ajaxMode = request.getParameter("ajaxMode");
		String id = request.getParameter("id") == null ? "" : request.getParameter("id");
		
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		
		if("getJobId".equals(ajaxMode)){
			/* 직업 목록 */
			List<EmpCategoryVO> list = dao.getJobList(id);
			jsonArr = JSONArray.fromObject(list);
		}else if("getJobHistory".equals(ajaxMode)){
			/* JOB_HISTORY List */
			List<EmpVO> list = dao.getJobHistory(id);
			jsonArr = JSONArray.fromObject(list);
		}else if("resetPw".equals(ajaxMode)){
			/* 비밀 번호 초기화 */
			String salt = SHA256Util.generateSalt();
			String pw = SHA256Util.getEncrypt("1234", salt);
			
			EmpVO emp = new EmpVO();
			emp.setEmpId(id);
			emp.setPw(pw);
			emp.setSalt(salt);
			
			int re = dao.resetPw(emp);
			
			Map<String, Integer> jsonMap = new HashMap<String, Integer>();
			jsonMap.put("re", re);
			
			jsonArr = JSONArray.fromObject(jsonMap);
			
		}
		
		// UTF-8 설정
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(jsonArr);
	}
}