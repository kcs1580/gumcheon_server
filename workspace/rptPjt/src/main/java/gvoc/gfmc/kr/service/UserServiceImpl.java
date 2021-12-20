package gvoc.gfmc.kr.service;

import java.util.List;

import gvoc.gfmc.kr.model.UserInfoVO;
import gvoc.gfmc.kr.service.serviceInterface.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int selectUserCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserInfoVO> selectUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoVO selectUser(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(String id, String password, String name) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(String id, String password, String name) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	/*
	 * @Autowired private UserMapper userMapper;
	 * 
	 * @Override public int selectUserCount() throws Exception { // TODO
	 * Auto-generated method stub return userMapper.selectUserCount(); }
	 * 
	 * @Override public List<UserVO> selectUsers() throws Exception { // TODO
	 * Auto-generated method stub return userMapper.selectUsers(); }
	 * 
	 * @Override public UserVO selectUser(String id) throws Exception { // TODO
	 * Auto-generated method stub return userMapper.selectUser(id); }
	 * 
	 * @Override public int insertUser(String id, String password, String name)
	 * throws Exception { // TODO Auto-generated method stub return
	 * userMapper.insertUser(id, password, name); }
	 * 
	 * @Override public int updateUser(String id, String password, String name)
	 * throws Exception { // TODO Auto-generated method stub return
	 * userMapper.updateUser(id, password, name); }
	 * 
	 * @Override public int deleteBoard(String id) throws Exception { // TODO
	 * Auto-generated method stub return userMapper.deleteUser(id); }
	 */
}
