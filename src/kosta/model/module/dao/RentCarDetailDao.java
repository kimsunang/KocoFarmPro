package kosta.model.module.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.module.RentCarDetailMapper;
import kosta.model.module.vo.RentCarDetail;
import kosta.model.module.vo.RentCarDetailSearch;
import java.util.List;


public class RentCarDetailDao {
	
	public static RentCarDetailDao rentCarDetailDao = new RentCarDetailDao();
	
	public static RentCarDetailDao getInstance(){
		return rentCarDetailDao;
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
	
	//목록 총 개수
	public int getRentCarDetailListCnt(RentCarDetailSearch search){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		
		try {
			re = sqlSession.getMapper(RentCarDetailMapper.class).getRentCarDetailListCnt(search);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;
	}
	
	//목록
	public List<RentCarDetail> getRentCarDetailList(RentCarDetailSearch search, int startRow){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<RentCarDetail> list = null;
		
		try {
			list = sqlSession.getMapper(RentCarDetailMapper.class).getRentCarDetailList(new RowBounds(startRow, 10),search);	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	
	//상세정보
	public RentCarDetail getRentCarDetail(String car_id){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		RentCarDetail rentCarDetail = null;
		try {
			rentCarDetail = sqlSession.getMapper(RentCarDetailMapper.class).getRentCarDetail(car_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return rentCarDetail;
	}
	
	
	
	//등록
	public int setRentCarDetail(RentCarDetail rentCarDetail){
		
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(RentCarDetailMapper.class).setRentCarDetail(rentCarDetail);
			
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
		
	}//setRentCarDetail
	
	//수정
	public int setUpRentCarDetail(RentCarDetail rentCarDetail){
		
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(RentCarDetailMapper.class).setUpRentCarDetail(rentCarDetail);
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
	
	
	//삭제
	public int delRentCarDetail(String car_id){
		System.out.println("delRentCarDetail에 들어왔습니다.");
		
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(RentCarDetailMapper.class).delRentCarDetail(car_id);
			if(re>0){
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
	}
	
	
	
	
	
}
