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
import gvoc.gfmc.kr.service.UserServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/auth")
public class LoginController {

	@Autowired
	private UserServiceImpl customUserDetailService;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	// 로그인
	@PostMapping(value = "/login")
	@ResponseBody
	public SignVO signInUser(HttpServletRequest request, @RequestBody UserInfoVO user) {
		SignVO signVO = new SignVO();

		try {
			UserInfoVO result = (UserInfoVO) customUserDetailService.loadUserByUsername(user.getId());

			if (result.getApplyYn().equals("Y")) {
				if (passwordEncoder.matches(user.getPassword(), result.getPassword())) {
					signVO.setRscode("2");
					signVO.setResult("fail");
					signVO.setMessage("비밀번호 초기화가 필요합니다.");
					return signVO;
				} else {
					signVO.setRscode("3");
					signVO.setResult("fail");
					signVO.setMessage("비밀번호 초기화 신청 상태 입니다. 시스템관리자에게 문의하세요");
					return signVO;
				}
			} else {
				if (!passwordEncoder.matches(user.getPassword(), result.getPassword())) {
					signVO.setRscode("1");
					signVO.setResult("fail");
					signVO.setMessage("아이디 혹은 비밀번호가 잘못 입력되었습니다.");
					return signVO;
				} else {
					List<String> roleList = Arrays.asList(result.getUserRoles().split(","));
					signVO.setRscode("0");
					signVO.setResult("success");
					signVO.setToken(jwtTokenProvider.createToken(result.getId(), result.getUsername(), roleList));
					return signVO;
				}
			}
		} catch (Exception e) {
			signVO.setRscode("1");
			signVO.setResult("fail");
			signVO.setMessage("아이디 혹은 비밀번호가 잘못 입력되었습니다.");
			return signVO;

		}

	}

	// 비밀번호 초기화 신청
	@PostMapping(value = "/pwInitApply")
	@ResponseBody
	public SignVO pwInitApply(HttpServletRequest request, @RequestBody UserInfoVO user) {
		SignVO signVO = new SignVO();

		try {
			UserInfoVO result = (UserInfoVO) customUserDetailService.loadUserByUsername(user.getId());
			System.out.println(result.toString());

			if (!(user.getId().equals(result.getId())) || !(user.getUserOgdp().equals(result.getUserOgdp()))
					|| !(user.getUserTeam().equals(result.getUserTeam()))
					|| !(user.getUserTelno().equals(result.getUserTelno()))) {
				signVO.setRscode("1");
				signVO.setResult("fail");
				signVO.setMessage("일치하는 계정정보가 존재하지 않습니다.");
				return signVO;
			} else {
				customUserDetailService.pwInitApply(result);
				signVO.setRscode("0");
				signVO.setResult("success");
				signVO.setMessage("비밀번호 초기화 신청이 완료 되었습니다. 시스템 관리자에게 초기화 비밀번호를 안내 받은 후 로그인 하세요.");
				return signVO;
			}
		} catch (Exception e) {
			signVO.setRscode("1");
			signVO.setResult("fail");
			signVO.setMessage("일치하는 계정정보가 존재하지 않습니다.");
			return signVO;

		}

	}

	// 비밀번호 변경
	@PostMapping(value = "/chPw")
	@ResponseBody
	public SignVO chPw(HttpServletRequest request, @RequestBody UserInfoVO user) {
		SignVO signVO = new SignVO();

		try {
			customUserDetailService.chPw(user);
			signVO.setRscode("0");
			signVO.setResult("success");
			signVO.setMessage("비밀번호 변경이 완료되었습니다. 로그인 하십시오.");
			return signVO;

		} catch (Exception e) {
			signVO.setRscode("1");
			signVO.setResult("fail");
			signVO.setMessage("기존 비밀번호가 일치하지 않습니다.");
			return signVO;

		}

	}

	// 유저 존재 확인
	@PostMapping(value = "/isUser")
	@ResponseBody
	public SignVO isUser(HttpServletRequest request, @RequestBody UserInfoVO user) {
		SignVO signVO = new SignVO();

		try {
			if (customUserDetailService.isUser(user) == 1) {

				signVO.setRscode("0");
				signVO.setResult("success");
				signVO.setMessage("일치하는 계정정보가 존재합니다.");
				return signVO;
			} else
				signVO.setRscode("1");
			signVO.setResult("fail");
			signVO.setMessage("일치하는 계정정보가 존재하지 않습니다.");
			return signVO;

		} catch (Exception e) {
			signVO.setRscode("1");
			signVO.setResult("fail");
			signVO.setMessage("일치하는 계정정보가 존재하지 않습니다.");
			return signVO;
		}

	}

	// 회원가입,
	@PostMapping(value = "/signup")
	@ResponseBody
	public SignVO addUser(HttpServletRequest request, @RequestBody UserInfoVO signupUser) {
		UserInfoVO user = signupUser;
		user.setUserRoles("ROLE_USER");
		user.setPw(passwordEncoder.encode(signupUser.getPassword()));
		SignVO signVO = new SignVO();
		int result = customUserDetailService.signUpUser(user);
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
