package kosta.model.module.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.module.MeetingRoomMapper;
import kosta.mapper.module.ReservationMapper;
import kosta.model.module.vo.MeetingRoom;
import kosta.model.module.vo.MeetingRoomSearch;
import kosta.model.module.vo.Reservation;

public class ReservationDao {
	private static ReservationDao dao = new ReservationDao();
	
	public static ReservationDao getInstance(){
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

	public int setReserv(Reservation reserv){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(ReservationMapper.class).setReserv(reserv);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;
	}//insertReserv
	
	public Reservation getMname(int m_id){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Reservation reserv = null;
		
		try {
			reserv = sqlSession.getMapper(ReservationMapper.class).getMname(m_id);
			System.out.println(reserv);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return reserv;
	}//getMname
	
	
}//MeetingRoomDao
