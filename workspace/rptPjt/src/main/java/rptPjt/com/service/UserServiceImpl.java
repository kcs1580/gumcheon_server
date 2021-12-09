package rptPjt.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rptPjt.com.mapper.UserMapper;
import rptPjt.com.model.UserVO;
import rptPjt.com.service.serviceInterface.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserMapper userMapper;

	@Override
	public int selectUserCount() throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectUserCount();
	}

	@Override
	public List<UserVO> selectUsers() throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectUsers();
	}

	@Override
	public UserVO selectUser(String id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectUser(id);
	}

	@Override
	public int insertUser(String id, String password, String name) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.insertUser(id, password, name);
	}

	@Override
	public int updateUser(String id, String password, String name) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updateUser(id, password, name);
	}

	@Override
	public int deleteBoard(String id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(id);
	}

}
