package rptPjt.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value="/loginPage.do")
	public String loginPage() throws Exception{
		return "sample/loginPage";
	}

	@RequestMapping(value="/userPage/userTest.do")
	public String userPage() throws Exception{
		return "sample/userPage";
	}

}