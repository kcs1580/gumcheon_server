package rptPjt.com.service.serviceInterface;

import java.util.List;

import rptPjt.com.model.UserVO;

public interface UserService {
	int selectUserCount() throws Exception;

	List<UserVO> selectUsers() throws Exception;

	UserVO selectUser(String id) throws Exception;

	int insertUser(String id, String pw, String userNm) throws Exception;

	int updateUser(String id, String pw, String userNm) throws Exception;

	int deleteBoard(String id) throws Exception;
}
