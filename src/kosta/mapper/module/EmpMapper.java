package kosta.mapper.module;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.model.comm.vo.EmpCategoryVO;
import kosta.model.module.vo.EmpVO;
import kosta.model.module.vo.SearchVO;

public interface EmpMapper {
	/* 목록 총 개 수*/
	int getEmpListCnt(SearchVO search);
	
	/* 목록 */
	List<EmpVO> getEmpList(RowBounds row, SearchVO search);
	
	/* 상세정보 */
	EmpVO getEmp(String empId);
	
	/* 등록 */
	int setEmp(EmpVO emp);
	
	/* 수정 */
	int setUpEmp(EmpVO emp);
	
	/* 삭제 */
	int delEmp(String empId);
	
	/* 부서 목록 */
	List<EmpCategoryVO> getDeptList();
	
	/* 직업 목록 */
	List<EmpCategoryVO> getJobList(String deptId);
	
	/* 직책 목록 */
	List<EmpCategoryVO> getPositionList();
	
	/* JOB_HISTORY List */
	List<EmpVO> getJobHistory(String empId);
	
	/* JOB_HISTORY */
	int setJobHistory(EmpVO emp);
	
	/* 비밀 번호 초기화 */
	int resetPw(EmpVO emp);
}
