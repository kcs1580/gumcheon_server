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
		System.out.println("id: "+ id);
		System.out.println(userMapper.findById(id));
		return userMapper.findById(id);
	}

	public UserDetails findByUsername(String userNm) {
		return userMapper.findByUsername(userNm);
	}

	public int signInUser(UserVO user) {
		if (userMapper.findByUsername(user.getUsername()) == null) {
			return userMapper.insertUser(user);
		} else {
			return -1;
		}
	}

	public int deleteUser(String userNm) {
		return userMapper.deleteUser(userNm);
	}

}
