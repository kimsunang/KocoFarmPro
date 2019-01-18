package kosta.model.module.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.module.ScheduleMapper;
import kosta.model.module.vo.ScheduleCalender;
import kosta.model.module.vo.ScheduleCategory;
import kosta.model.module.vo.ScheduleCalenderList;
import kosta.model.module.vo.ScheduleEmployee;
import kosta.model.module.vo.ScheduleProject;

import org.apache.ibatis.io.Resources;

public class ScheduleDao {
	private static ScheduleDao dao;

	static {
		dao = new ScheduleDao();
	}
	
	public static ScheduleDao getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFaction() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public List<ScheduleEmployee> listEmployee() {
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		if(null == sqlSession)
			return null;
		
		List<ScheduleEmployee> list = sqlSession.getMapper(ScheduleMapper.class).listEmployee();
		sqlSession.close();
		return list;
	}

	public List<ScheduleProject> listProject() {
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		if(null == sqlSession)
			return null;
		
		List<ScheduleProject> list = sqlSession.getMapper(ScheduleMapper.class).listProject();
		sqlSession.close();
		return list;	
	}

	public List<ScheduleCategory> listCategory(int projectId){
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		if(null == sqlSession)
			return null;
		
		List<ScheduleCategory> list = sqlSession.getMapper(ScheduleMapper.class).listCategory(projectId);
		sqlSession.close();
		return list;
	}

	public List<ScheduleCalender> listCalender(int projectId) {
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		if(null == sqlSession)
			return null;
		
		List<ScheduleCalender> list = sqlSession.getMapper(ScheduleMapper.class).listCalender(projectId);
		sqlSession.close();
		return list;
	}
	
	public List<ScheduleCalenderList> listProjectCalender(int projectId){
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		if(null == sqlSession)
			return null;
		
		List<ScheduleCalenderList> list = sqlSession.getMapper(ScheduleMapper.class).listProjectCalender(projectId);
		sqlSession.close();
		return list;
	}
	
	public int insertCelender(ScheduleCalender scheduleCalender){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		try{
			re = sqlSession.getMapper(ScheduleMapper.class).insertCelender(scheduleCalender);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();				
			}
		}catch (Exception e) {
			e.printStackTrace();
	
		}finally{
			sqlSession.close();
		}
		
		return re;
	}
	
	public int editCalender(ScheduleCalender scheduleCalender){
		System.out.println("editCalender");
		int re = -1;
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		try{
			re = sqlSession.getMapper(ScheduleMapper.class).editCalender(scheduleCalender);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();				
			}
		}catch (Exception e) {
			e.printStackTrace();
	
		}finally{
			sqlSession.close();
		}
		
		return re;
	}
	
	public int delCalender(int calenderId){
		System.out.println("delCalender");
		int re = -1;
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		try{
			re = sqlSession.getMapper(ScheduleMapper.class).delCalender(calenderId);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();				
			}
		}catch (Exception e) {
			e.printStackTrace();
	
		}finally{
			sqlSession.close();
		}
		
		return re;
	}

}
