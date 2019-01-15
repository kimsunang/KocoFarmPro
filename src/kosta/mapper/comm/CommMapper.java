package kosta.mapper.comm;

import kosta.model.comm.vo.LoginVO;

public interface CommMapper {
	/* 로그인 유저 정보 */
	LoginVO getLoginUserInfo(String userId);
}
