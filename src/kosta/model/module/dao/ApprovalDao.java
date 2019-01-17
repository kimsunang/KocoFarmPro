package kosta.model.module.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.module.ApprovalMapper;
import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalForm;
import kosta.model.module.vo.ApprovalFormSearch;
import kosta.model.module.vo.ApprovalVacation;
import kosta.model.module.vo.Employee;

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
	
	public int insertExpence(ApprovalExpence expence) {
		
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
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
	
//	public int insertExpenceFormAction(ApprovalExpence expence) {
//		
//		int re = -1;
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		
//		try {
//			re = sqlSession.getMapper(ApprovalMapper.class).insertExpence(expence);
//			if (re > 0) {
//				sqlSession.commit();
//			} else {
//				sqlSession.rollback();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			sqlSession.close();
//		}
//		
//		return re;
//	}
	
	public List<ApprovalForm> listForm(ApprovalFormSearch search){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<ApprovalForm> list = null;
		
		try {
			list = sqlSession.getMapper(ApprovalMapper.class).listForm(search);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	public List<ApprovalDraft> listDraft(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<ApprovalDraft> list = null;
	
		try {
			list = sqlSession.getMapper(ApprovalMapper.class).listDraft();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
		
	}
	
}
