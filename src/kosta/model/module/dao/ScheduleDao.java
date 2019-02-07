package kosta.model.module.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.module.ScheduleMapper;
import kosta.model.module.vo.ScheduleCalender;
import kosta.model.module.vo.ScheduleCategory;
import kosta.model.module.vo.ScheduleCategoryMove;
import kosta.model.module.vo.ScheduleCalenderList;
import kosta.model.module.vo.ScheduleCalenderMove;
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
	
	public List<ScheduleProject> getProjectList() {
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		if(null == sqlSession)
			return null;
		
		List<ScheduleProject> list = sqlSession.getMapper(ScheduleMapper.class).getProjectList();
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
	
	public List<ScheduleCalenderList> getProjectCalenderList(int projectId){
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		if(null == sqlSession)
			return null;
		
		List<ScheduleCalenderList> list = sqlSession.getMapper(ScheduleMapper.class).getProjectCalenderList(projectId);
		sqlSession.close();
		return list;
	}
	
	public int setProject(ScheduleProject project) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		try {
			re = sqlSession.getMapper(ScheduleMapper.class).setProject(project);
			if(re > 0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;
	}
	
	public int setCalender(ScheduleCalender scheduleCalender){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		try{
			re = sqlSession.getMapper(ScheduleMapper.class).setCalender(scheduleCalender);
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
	
	public int setCategory(ScheduleCategory category){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		try{
			re = sqlSession.getMapper(ScheduleMapper.class).setCategory(category);
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
	
	
	public int setUpCalender(ScheduleCalender scheduleCalender){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		try{
			re = sqlSession.getMapper(ScheduleMapper.class).setUpCalender(scheduleCalender);
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
	
	public int setUpProject(ScheduleProject project){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		try{
			re = sqlSession.getMapper(ScheduleMapper.class).setUpProject(project);
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
	
	public int setUpCategory(ScheduleCategory category){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		try{
			re = sqlSession.getMapper(ScheduleMapper.class).setUpCategory(category);
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

	public int delProject(int projectId){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		try{
			re = sqlSession.getMapper(ScheduleMapper.class).delProject(projectId);
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
	
	// 카테고리 삭제 시 하위 일정 삭제
	public int delCalenderWithCategory(ScheduleCategory category) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		try{
			re = sqlSession.getMapper(ScheduleMapper.class).delCalenderWithCategory(category);
			re = sqlSession.getMapper(ScheduleMapper.class).delCategory(category.getCategoryId());
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
	
	
	public int setUpCategoryPos(ScheduleCategoryMove categoryMove){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		try{
			re = sqlSession.getMapper(ScheduleMapper.class).setMoveCategoryPosX(categoryMove);
			re = sqlSession.getMapper(ScheduleMapper.class).setOriCategoryPosX(categoryMove);
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
		
	public int setUpCalenderPos(List<ScheduleCalenderMove> list){
		if(null == list)
			return -1;
		
		int size = list.size();
		if(0 >= size)
			return -1;
		
		int re = -1;
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		try{
			for(int i = 0; i < size; ++i){
			
			re = sqlSession.getMapper(ScheduleMapper.class).setUpCalenderPos(list.get(i));
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();				
			}
			}
		}catch (Exception e) {
			e.printStackTrace();
	
		}finally{
			sqlSession.close();
		}
		return re;
	}

}
