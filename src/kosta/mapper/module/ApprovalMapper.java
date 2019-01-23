package kosta.mapper.module;

import java.util.List;
import java.util.Map;

import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalExpence;
import kosta.model.module.vo.ApprovalExpenceCont;
import kosta.model.module.vo.ApprovalForm;
import kosta.model.module.vo.ApprovalVacation;
import kosta.model.module.vo.DraftComment;


public interface ApprovalMapper {
	
	/*기안서 입력*/
	int insertDraft(ApprovalDraft draft); 
	/*휴가 정보 입력*/
	int insertVacation(ApprovalVacation vacation);
	/*지출 내역 입력*/
	int insertExpence(ApprovalExpence expence);
	/*지출 양식 입력*/
	int insertExpenceCont(ApprovalExpenceCont expenceCont);
	/*양식 출력*/
//	List<ApprovalForm> listForm(ApprovalFormSearch search);
	List<ApprovalForm> listForm();
	/*전체 기안서 출력*/ 
	List<ApprovalDraft> listDraft();
	/*분류된 기안서 출력*/ 
	List<ApprovalDraft> listStateDraft();
	/*기안서 상세 입력 폼 이동*/
	ApprovalForm getDetailForm(int formId);
	/*emp정보 불러오기*/
//	Employee getEmployee(int empId); 
	/*기안서 번호 불러오기*/
	int getDraftId();
	/*지출결의서 번호 불러오기*/
	int getExpenceId();
	/*기본 기안서 정보 불러오기*/
	ApprovalDraft getDraft(int draftId);
	/*휴가 신청서 불러오기*/
	ApprovalVacation getVacation(int draftId);
	/*지출 결의서 불러오기 */
	ApprovalExpence getExpence(int draftId);
	/*지출 내용 정보 불러오기*/
	List<ApprovalExpenceCont> getExpenceCont(int expenceId);
	/*기본 기안서 정보 수정*/
	int updateDraft(ApprovalDraft draft);
	/*휴가 신청서 정보 수정*/
	int updateVacation(ApprovalVacation vacation);
	/*기본 기안서 정보 삭제*/
	int deleteDraft(int draftId);
	/*휴가 신청서 삭제*/
	int deleteVacation(int draftId);
	/*지출 결의서 삭제*/
	int deleteExpence(int draftId);
	/*댓글 등록*/
	int insertComment(DraftComment comment);
	/*댓글 목록*/
	List<DraftComment> listComment(int draftId);
	
	List<DraftComment> getDraftCommentList(Map<String, Object> map);
	
	int getCommentCount(Map<String, Object> map);
}
