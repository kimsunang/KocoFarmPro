package kosta.model.comm.service;

import javax.servlet.http.HttpServletRequest;

import kosta.action.comm.SHA256Util;
import kosta.model.comm.dao.SignInOutDao;
import kosta.model.comm.vo.LoginVO;

public class SignInOutService {
	private static SignInOutDao dao;
	private static SignInOutService signInOutService = new SignInOutService();
	private static final int PAGE_SIZE = 10;
	
	public static SignInOutService getInstance(){
		dao = dao.getInstance();
		
		return signInOutService;
	}
	
	/* 로그인 유저 정보 */
	public LoginVO getLoginUserInfo(HttpServletRequest request)throws Exception{
		String userId = request.getParameter("userId");
		
		// 비밀 번호 암호화
		LoginVO loginVO = dao.getLoginUserInfo(userId);
		
		String inputPw = SHA256Util.getEncrypt(request.getParameter("userPw"), loginVO.getSalt());
		
		if(null != loginVO){
			String userPw = loginVO.getPw();
			
			// 비밀 번호 일치 여부 re > -1: 불 일치 / 1: 일치
			if(!inputPw.equals(userPw)){
				loginVO.setRe(-1);
			}else{
				loginVO.setRe(1);
			}
		}
		
		return loginVO;
	}

}