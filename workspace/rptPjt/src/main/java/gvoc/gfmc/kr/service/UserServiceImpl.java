package gvoc.gfmc.kr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gvoc.gfmc.kr.mapper.UserMapper;
import gvoc.gfmc.kr.model.UserInfoVO;
import gvoc.gfmc.kr.service.serviceInterface.UserService;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


	@Autowired
	UserMapper userMapper;

	// 아이디로 사용자 정보 조회
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

		return userMapper.findById(id);
	}

	// 이름으로로 사용자 정보 조회
	public UserDetails findByUsername(String userNm) {
		return userMapper.findByUsername(userNm);
	}

	// 사용자 회원가입
	public int signUpUser(UserInfoVO user) {
		if (userMapper.findByUsername(user.getUsername()) == null) {
			return userMapper.insertUser(user);
		} else {
			return -1;
		}
	}

	// 사용자 삭제
	public int deleteUser(String userNm) {
		return userMapper.deleteUser(userNm);
	}

	// 비밀번호 초기화 신청
	public int pwInitApply(UserInfoVO user) {
		return userMapper.pwInitApply(user);
	}

	//비밀번호 변경
	@Override
	public int chPw(UserInfoVO user) {
		// TODO Auto-generated method stub
		user.setPw(passwordEncoder.encode(user.getPassword()));
		
		return userMapper.chPw(user);
	}

	//유저 존재 확인
	@Override
	public int isUser(UserInfoVO user) {
		// TODO Auto-generated method stub
		
	
		if(userMapper.findById(user.getId())!=null)
		{
			return 1;
		}
		else {
			return 0;
		}


		
	}

}
