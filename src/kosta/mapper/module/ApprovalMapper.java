package kosta.mapper.module;

import java.util.List;

import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalExpence;
import kosta.model.module.vo.ApprovalForm;
import kosta.model.module.vo.ApprovalFormSearch;
import kosta.model.module.vo.ApprovalVacation;


public interface ApprovalMapper {
	
	/*기안서 입력*/
	int insertDraft(ApprovalDraft draft); 
	/*휴가 정보 입력*/
	int insertVacation(ApprovalVacation vacation);
	/*지출 내역 입력*/
	int insertExpence(ApprovalExpence expence);
	/*양식 출력*/
	List<ApprovalForm> listForm(ApprovalFormSearch search);
	List<ApprovalDraft> listDraft();
}
