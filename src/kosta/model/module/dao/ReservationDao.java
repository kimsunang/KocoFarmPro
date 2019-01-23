package kosta.model.module.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.module.MeetingRoomMapper;
import kosta.mapper.module.ReservationMapper;
import kosta.model.module.vo.Departments;
import kosta.model.module.vo.Emp;
import kosta.model.module.vo.MeetingRoom;
import kosta.model.module.vo.MeetingRoomSearch;
import kosta.model.module.vo.Reservation;
import kosta.model.module.vo.ReservationSearch;

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

	// 회의실 목록
	public MeetingRoom getResList(int mId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		MeetingRoom reserv = null;
		
		try {
			reserv = sqlSession.getMapper(ReservationMapper.class).getResList(mId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return reserv;	
	}//getResList
	
	public List<Departments> getDeptList(Departments dept) {
		List<Departments> deptList = null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			deptList = sqlSession.getMapper(ReservationMapper.class).getDeptList(dept);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return deptList;
	}//deptList
	
	public List<Emp> getEmpName(Emp emp) {
		List<Emp> empList = null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			empList = sqlSession.getMapper(ReservationMapper.class).getEmpName(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return empList;
	}//empList
	
	public List<Reservation> getReservList(ReservationSearch search){
		SqlSession seSqlSession = getSqlSessionFactory().openSession();
		List<Reservation> list  = null;
		
		try {
			list = seSqlSession.getMapper(ReservationMapper.class).getReservList(search);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			seSqlSession.close();
		}
		return list;
	}//list
	
}//MeetingRoomDao
