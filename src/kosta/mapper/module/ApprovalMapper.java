package kosta.mapper.module;

import java.util.List;

import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalExpence;
import kosta.model.module.vo.ApprovalForm;
import kosta.model.module.vo.ApprovalFormSearch;
import kosta.model.module.vo.ApprovalVacation;
import kosta.model.module.vo.Employee;


public interface ApprovalMapper {
	
	/*기안서 입력*/
	int insertDraft(ApprovalDraft draft); 
	/*휴가 정보 입력*/
	int insertVacation(ApprovalVacation vacation);
	/*지출 내역 입력*/
	int insertExpence(ApprovalExpence expence);
	/*양식 출력*/
	List<ApprovalForm> listForm(ApprovalFormSearch search);
	/*전체 기안서 출력*/ 
	List<ApprovalDraft> listDraft();
	/*기안서 상세 입력 폼 이동*/
	ApprovalForm getDetailForm(int formId);
	/*emp정보 불러오기*/
	Employee getEmployee(int empId); 
	/*기안서 번호 불러오기*/
	int getDraftId();
	/*기본 기안서 정보 불러오기*/
	ApprovalDraft getDraft(int draftId);
	/*휴가 신청서 불러오기*/
	ApprovalVacation getVacation(int draftId);
}
