package kosta.model.module.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.module.EmpMapper;
import kosta.model.comm.vo.EmpCategoryVO;
import kosta.model.module.vo.EmpVO;
import kosta.model.module.vo.SearchVO;

public class EmpDao {
	
	public static EmpDao empDao = new EmpDao();
	
	public static EmpDao getInstance(){
		return empDao;
	}
	
	/* MyBatis 연결 */
	public SqlSessionFactory getSqlSessionFactory(){
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}

	/* 목록 총 개 수 */
	public int getEmpListCnt(SearchVO search){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		
		try {
			re = sqlSession.getMapper(EmpMapper.class).getEmpListCnt(search);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return re;
	}
		
	/* 목록 */
	public List<EmpVO> getEmpList(SearchVO search, int startRow){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<EmpVO> list = null;
		
		try {
			list = sqlSession.getMapper(EmpMapper.class).getEmpList(new RowBounds(startRow, 10), search);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return list;
	}
	
	/* 상세 정보 */
	public EmpVO getEmp(String empId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		EmpVO emp = null;
		
		try{
			emp = sqlSession.getMapper(EmpMapper.class).getEmp(empId);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return emp;
	}
	
	/* 등록 */
	public int setEmp(EmpVO emp){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try{
			re = sqlSession.getMapper(EmpMapper.class).setEmp(emp);
			
			if(0 < re){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return re;
	}
	
	/* 수정 */
	public int setUpEmp(EmpVO emp){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try{
			re = sqlSession.getMapper(EmpMapper.class).setUpEmp(emp);
			
			try {
				if(0 < re){
					sqlSession.commit();
				}else{
					sqlSession.rollback();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return re;
	}
	
	/* 삭제 */
	public int delEmp(String empId){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try{
			re = sqlSession.getMapper(EmpMapper.class).delEmp(empId);
			
			try{
				if(0 < re){
					sqlSession.commit();
				}else{
					sqlSession.rollback();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return re;
	}
	
	/* 부서 목록 */
	public List<EmpCategoryVO> getDeptList(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<EmpCategoryVO> list = null;
		
		try {
			list = sqlSession.getMapper(EmpMapper.class).getDeptList();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return list;
	}
	
	/* 직업 목록 */
	public List<EmpCategoryVO> getJobList(String deptId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<EmpCategoryVO> list = null;
		
		try {
			list = sqlSession.getMapper(EmpMapper.class).getJobList(deptId);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return list;
	}
	
	/* 직책 목록 */
	public List<EmpCategoryVO> getPositionList(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<EmpCategoryVO> list = null;
		
		try {
			list = sqlSession.getMapper(EmpMapper.class).getPositionList();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return list;
	}
	
	/* JOB_HISTORY List */
	public List<EmpVO> getJobHistory(String empId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<EmpVO> list = null;
		
		try {
			list = sqlSession.getMapper(EmpMapper.class).getJobHistory(empId);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return list;
	}
	
	/* JOB_HISTORY */
	public int setJobHistory(EmpVO emp){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try{
			re = sqlSession.getMapper(EmpMapper.class).setJobHistory(emp);
			
			try {
				if(0 < re){
					sqlSession.commit();
				}else{
					sqlSession.rollback();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return re;
	}
	
	/* 비밀번호 초기화 */
	public int resetPw(EmpVO emp){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try{
			re = sqlSession.getMapper(EmpMapper.class).resetPw(emp);
			
			try {
				if(0 < re){
					sqlSession.commit();
				}else{
					sqlSession.rollback();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return re;
	}
	
}