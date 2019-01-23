package kosta.action.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.model.comm.service.SignInOutService;
import kosta.model.comm.vo.LoginVO;

public class SignInOutAction implements IAction{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		SignInOutService signInService = SignInOutService.getInstance();
		
		String mode = request.getParameter("mode");
		HttpSession session = request.getSession();
		
		/* 로그인 페이지 */
		if("signInPage".equals(mode)){
			forward.setRedirect(false);
			forward.setPath("/jsp/comm/sign_in.jsp");
			
		/* 로그아웃 */
		}else if("signOut".equals(mode)){
			session.invalidate();
			
			request.setAttribute("module", "signIn");
			request.setAttribute("myPage", "'main.do'");
			request.setAttribute("re", 1);
			
			forward.setRedirect(false);
			forward.setPath("/jsp/comm/proC.jsp");
		
		/* 로그인 */
		}else if("signIn".equals(mode)){
			LoginVO loginVO = signInService.getLoginUserInfo(request);
			request.setAttribute("module", "signIn");
			
			/* re > -2:비밀번호 불 일치 / -1:아이디 없음 / 1: 로그인 성공 */
			if(null != loginVO){
				if(-1 == loginVO.getRe()){
					request.setAttribute("re", -2);
					request.setAttribute("myPage", "'signIn.do?mode=signInPage'");
				}else{
					request.setAttribute("re", 1);
					request.setAttribute("myPage", "'main.do'");
					session.setAttribute("loginVO", loginVO);
				}
			}else{
				request.setAttribute("re", -1);
				request.setAttribute("myPage", "'signIn.do?mode=signInPage'");
			}
			
			forward.setRedirect(false);
			forward.setPath("/jsp/comm/proC.jsp");
		}
		
		return forward;
	}
	
}