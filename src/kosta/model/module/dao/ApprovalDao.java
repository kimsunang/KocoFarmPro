package kosta.model.module.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.module.ApprovalMapper;
import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalExpence;
import kosta.model.module.vo.ApprovalExpenceCont;
import kosta.model.module.vo.ApprovalForm;
import kosta.model.module.vo.ApprovalVacation;
import kosta.model.module.vo.DraftComment;

public class ApprovalDao {

	public static ApprovalDao dao = new ApprovalDao();

	public static ApprovalDao getInstance() {
		return dao;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(in);
	}
	
	/*기안서 기본 값 insert*/
	public int insertDraft(ApprovalDraft draft) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			re = sqlSession.getMapper(ApprovalMapper.class).insertDraft(draft);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return re;
	}

	/*휴가신청서 insert*/
	public int insertVacation(ApprovalVacation vacation) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			re = sqlSession.getMapper(ApprovalMapper.class).insertVacation(vacation);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return re;
	}
	
	/* 지출 결의서 insert */
	public int insertExpence(ApprovalExpence expence) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(ApprovalMapper.class).insertExpence(expence);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return re;
	}
	
	/* 지출 양식 insert */
	public int insertExpenceCont(ApprovalExpenceCont expencecont) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(ApprovalMapper.class).insertExpenceCont(expencecont);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return re;
	}
	/*양식 리스트 출력*/
//	public List<ApprovalForm> listForm(ApprovalFormSearch search) {
	public List<ApprovalForm> listForm() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<ApprovalForm> list = null;
		
		try {
//			list = sqlSession.getMapper(ApprovalMapper.class).listForm(search);
			list = sqlSession.getMapper(ApprovalMapper.class).listForm();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}

	/*전체 기안서 출력*/
	public List<ApprovalDraft> listDraft() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<ApprovalDraft> list = null;

		try {
			list = sqlSession.getMapper(ApprovalMapper.class).listDraft();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;

	}
	

	/*각 양식별 기안서 출력*/
	public ApprovalForm getDetailForm(int formId) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		ApprovalForm form = null;

		try {
			form = sqlSession.getMapper(ApprovalMapper.class).getDetailForm(formId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return form;
	}
	
	/*직원 정보 불러오기*/
	/*public Employee getEmployee(int empId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Employee emp = null;

		try {
			emp = sqlSession.getMapper(ApprovalMapper.class).getEmployee(empId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return emp;
	}*/
	
	/* 기안서 번호 받아오기  */
	public int getDraftId(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int draftId = -1;
		
		try {
			draftId = sqlSession.getMapper(ApprovalMapper.class).getDraftId();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return draftId;
	}
	
	/* 지출 결의서 번호 받아오기  */
	public int getExpenceId(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int expenceId = -1;
		
		try {
			expenceId = sqlSession.getMapper(ApprovalMapper.class).getExpenceId();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return expenceId;
	}
	
	/*기본 기안서 정보 가져오기*/
	public ApprovalDraft getDraft(int draftId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		ApprovalDraft draft = null;
		
		try {
			draft = sqlSession.getMapper(ApprovalMapper.class).getDraft(draftId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return draft;
	}
	
	/*휴가 신청서 정보 가져오기*/
	public ApprovalVacation getVacation(int draftId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		ApprovalVacation vacation = null;
		
		try {
			vacation = sqlSession.getMapper(ApprovalMapper.class).getVacation(draftId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return vacation;	
	}
	
	/*지출 결의서 정보 가져오기*/
	public ApprovalExpence getExpence(int draftId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		ApprovalExpence expence = null;
		
		try {
			expence = sqlSession.getMapper(ApprovalMapper.class).getExpence(draftId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return expence;	
	}
	
	/*지출 정보 불러오기 출력*/
	public List<ApprovalExpenceCont> getExpenceCont(int expenceId) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<ApprovalExpenceCont> list = null;

		try {
			list = sqlSession.getMapper(ApprovalMapper.class).getExpenceCont(expenceId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	/* 기본 기안서 수정하기 */
	public int updateDraft(ApprovalDraft draft){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(ApprovalMapper.class).updateDraft(draft);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return re;	
	}
	
	/* 휴가신청서 수정하기 */
	public int updateVacation(ApprovalVacation vacation){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(ApprovalMapper.class).updateVacation(vacation);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return re;	
	}
	
	/* 기본 기안서 정보 삭제 */
	public int deleteDraft(int draftId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(ApprovalMapper.class).deleteDraft(draftId);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return re;	
	}
	
	/* 휴가 신청서 삭제 */
	public int deleteVacation(int draftId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(ApprovalMapper.class).deleteVacation(draftId);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return re;	
	}
	
	/* 지출 결의서 삭제 */
	public int deleteExpence(int draftId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(ApprovalMapper.class).deleteExpence(draftId);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return re;	
	}
	
	/* 댓글 등록 insert */
	public int insertComment(DraftComment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(ApprovalMapper.class).insertComment(comment);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return re;
	}
	/*댓글 목록가져오기*/
	public List<DraftComment> listComment(int draftId) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<DraftComment> list = null;
		
		try {
			list = sqlSession.getMapper(ApprovalMapper.class).listComment(draftId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;

	}	
	public List<DraftComment> getDraftCommentList(Map<String, Object> map) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<DraftComment> list = null;
		try {
			list = sqlSession.getMapper(ApprovalMapper.class).getDraftCommentList(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}	
	
	public int getCommentCount(Map<String, Object> map) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int commentCount = 0;
		try {
			commentCount = sqlSession.getMapper(ApprovalMapper.class).getCommentCount(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return commentCount;
	}
	
	
}
