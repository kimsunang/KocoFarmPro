package kosta.model.comm.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.comm.CommMapper;
import kosta.model.comm.vo.LoginVO;

public class SignInOutDao {
	
	public static SignInOutDao signInOutDao = new SignInOutDao();
	
	public static SignInOutDao getInstance(){
		return signInOutDao;
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
	
	/* 로그인 유저 정보 */
	public LoginVO getLoginUserInfo(String userId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		LoginVO loginVO = null;
		
		try{
			loginVO = sqlSession.getMapper(CommMapper.class).getLoginUserInfo(userId);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return loginVO;
	}

}