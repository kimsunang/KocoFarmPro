package kosta.model.module.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.module.MeetingRoomMapper;
import kosta.model.module.vo.MeetingRoom;
import kosta.model.module.vo.MeetingRoomSearch;

public class MeetingRoomDao {
	private static MeetingRoomDao dao = new MeetingRoomDao();
	
	public static MeetingRoomDao getInstance(){
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}//SqlSessionFactory
	
	public int setMroom(MeetingRoom mroom){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(MeetingRoomMapper.class).setMroom(mroom);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;
	}//insertMroom
	
	public List<MeetingRoom> getMroomList(MeetingRoomSearch search){
		SqlSession seSqlSession = getSqlSessionFactory().openSession();
		List<MeetingRoom> list  = null;
		
		try {
			list = seSqlSession.getMapper(MeetingRoomMapper.class).getMroomList(search);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			seSqlSession.close();
		}
		return list;
	}//list
	
	public MeetingRoom getMroom(int m_id){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		MeetingRoom mroom = null;
		
		try {
			mroom = sqlSession.getMapper(MeetingRoomMapper.class).getMroom(m_id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return mroom;
	}//detail
	
	public int setUpMroom(MeetingRoom mroom){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(MeetingRoomMapper.class).setUpMroom(mroom);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;
	}//update
	
	public int delMroom(int m_id){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(MeetingRoomMapper.class).delMroom(m_id);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;
	}//delete
	
}//MeetingRoomDao
