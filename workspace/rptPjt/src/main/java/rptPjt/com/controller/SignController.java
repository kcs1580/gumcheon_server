package rptPjt.com.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rptPjt.com.config.JwtTokenProvider;
import rptPjt.com.model.SignVO;
import rptPjt.com.model.UserVO;
import rptPjt.com.service.CustomUserDetailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/sign")
public class SignController {

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	// signin, login
	@PostMapping(value = "/signin")
	@ResponseBody
	public SignVO signInUser(HttpServletRequest request, @RequestBody UserVO user) {
		UserVO result = (UserVO) customUserDetailService.loadUserByUsername(user.getId());
		SignVO signVO = new SignVO();
		if (!passwordEncoder.matches(user.getPassword(), result.getPassword())) {
			signVO.setResult("fail");
			signVO.setMessage("ID or Password is invalid.");
			return signVO;
		}
		List<String> roleList = Arrays.asList(result.getRoles().split(","));
		signVO.setResult("success");
		signVO.setToken(jwtTokenProvider.createToken(result.getId(), roleList));
		return signVO;
	}

	// signup,
	@PostMapping(value = "/signup")
	@ResponseBody
	public SignVO addUser(HttpServletRequest request, @RequestBody UserVO signupUser) {
		UserVO user = signupUser;
		user.setRoles("ROLE_USER");
		user.setPassword(passwordEncoder.encode(signupUser.getPassword()));
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
