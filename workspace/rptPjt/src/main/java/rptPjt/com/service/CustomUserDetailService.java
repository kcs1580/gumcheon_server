package rptPjt.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rptPjt.com.mapper.UserMapper;
import rptPjt.com.model.UserVO;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		return userMapper.findById(id);
	}

	public UserDetails findByUsername(String username) {
		return userMapper.findByUsername(username);
	}

	public int signInUser(UserVO user) {
		if (userMapper.findByUsername(user.getUsername()) == null) {
			return userMapper.insertUser(user);
		} else {
			return -1;
		}
	}

	public int deleteUser(String username) {
		return userMapper.deleteUser(username);
	}

}
