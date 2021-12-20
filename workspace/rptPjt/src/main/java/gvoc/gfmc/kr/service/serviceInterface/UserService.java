package gvoc.gfmc.kr.service.serviceInterface;

import java.util.List;

import gvoc.gfmc.kr.model.UserInfoVO;

public interface UserService {
	int selectUserCount() throws Exception;

	List<UserInfoVO> selectUsers() throws Exception;

	UserInfoVO selectUser(String id) throws Exception;

	int insertUser(String id, String pw, String userNm) throws Exception;

	int updateUser(String id, String pw, String userNm) throws Exception;

	int deleteBoard(String id) throws Exception;
}
