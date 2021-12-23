package gvoc.gfmc.kr.service.serviceInterface;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import gvoc.gfmc.kr.model.UserInfoVO;

public interface UserService {

	// 이름으로로 사용자 정보 조회
	public UserDetails findByUsername(String userNm);

	// 사용자 삭제
	public int deleteUser(String userNm);

	// 비밀번호 초기화 신청
	public int pwInitApply(UserInfoVO user);

	// 사용자 회원가입
	public int signUpUser(UserInfoVO user);
	
	// 비밀번호 변경 
	public int chPw(UserInfoVO user);
	
	//유저 존재 확인
	public int isUser(UserInfoVO user);

//	int selectUserCount() throws Exception;
//
//	List<UserInfoVO> selectUsers() throws Exception;
//
//	UserInfoVO selectUser(String id) throws Exception;
//
//	int insertUser(String id, String pw, String userNm) throws Exception;
//
//	int updateUser(String id, String pw, String userNm) throws Exception;
//
//	int deleteBoard(String id) throws Exception;
}
