package kosta.model.module.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.module.CarReservationMapper;
import kosta.model.module.vo.CarReservation;
import kosta.model.module.vo.Emp;
import kosta.model.module.vo.RentCarDetail;

public class CarReservationDao {
	
	public static CarReservationDao carReservationDao = new CarReservationDao();
	
	public static CarReservationDao getInstance(){
		return carReservationDao;
	}

	//MyBatis 연결
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
	
	//등록
	public int setCarReservation(CarReservation carReservation){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(CarReservationMapper.class).setCarReservation(carReservation);
			
			if(re>0){
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;		
	}
	
	//차량목록
	public RentCarDetail getCarList(String carId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		RentCarDetail reserve = null;
		
		try {
			reserve = sqlSession.getMapper(CarReservationMapper.class).getCarList(carId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return reserve;
	}
	
	//사원목록
	public List<Emp> getEmpName(Emp emp){
		List<Emp> empList = null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			empList = sqlSession.getMapper(CarReservationMapper.class).getEmpName(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return empList;
	}
	
	
	
}
