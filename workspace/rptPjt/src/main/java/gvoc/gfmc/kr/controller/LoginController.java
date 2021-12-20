package gvoc.gfmc.kr.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gvoc.gfmc.kr.config.JwtTokenProvider;
import gvoc.gfmc.kr.model.SignVO;
import gvoc.gfmc.kr.model.UserInfoVO;
import gvoc.gfmc.kr.service.CustomUserDetailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/sign")
public class LoginController {

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	// signin, login
	@PostMapping(value = "/login")
	@ResponseBody
	public SignVO signInUser(HttpServletRequest request, @RequestBody UserInfoVO user) {

		UserInfoVO result = (UserInfoVO) customUserDetailService.loadUserByUsername(user.getId());
		SignVO signVO = new SignVO();
		System.out.println("apply: "+ result.getApplyYn());
		
		if (result.getApplyYn().equals("1") ) {
			if (!passwordEncoder.matches(user.getPassword(), result.getPassword())) {
				signVO.setRscode("2");
				signVO.setResult("fail");
				signVO.setMessage("비밀번호 초기화가 필요합니다.");
				return signVO;
			}
			signVO.setRscode("3");
			signVO.setResult("fail");
			signVO.setMessage("비밀번호 초기화 신청 상태 입니다. 시스템관리자에게 문의하세요");
			return signVO;
		} else {
			if (!passwordEncoder.matches(user.getPassword(), result.getPassword())) {
				signVO.setRscode("1");
				signVO.setResult("fail");
				signVO.setMessage("아이디 혹은 비밀번호가 잘못 입력되었습니다.");
				return signVO;
			}
			List<String> roleList = Arrays.asList(result.getUserRoles().split(","));
			signVO.setResult("success");
			signVO.setToken(jwtTokenProvider.createToken(result.getId(), result.getUsername(), roleList));
			return signVO;
		}

	}

	// signup,
	@PostMapping(value = "/signup")
	@ResponseBody
	public SignVO addUser(HttpServletRequest request, @RequestBody UserInfoVO signupUser) {
		UserInfoVO user = signupUser;
		user.setUserRoles("ROLE_USER");
		user.setPw(passwordEncoder.encode(signupUser.getPassword()));
		SignVO signVO = new SignVO();
		int result = customUserDetailService.signInUser(user);
		if (result == 1) {
			signVO.setResult("success");
			signVO.setMessage("SignUp complete");
			return signVO;
		} else if (result == -1) {
			signVO.setResult("fail");
			signVO.setMessage("There is the same name, please change your name.");
			return signVO;
		} else {
			signVO.setResult("fail");
			signVO.setMessage("Ask system admin");
			return signVO;
		}
	}
}
