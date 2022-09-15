package com.test.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.myapp.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
//����ؼ� ������ ����� ���� �����ϴ� ���� �ſ� �� ȿ�����̱� ������ 
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) throws Exception{

		return "home/home";
	}

	@RequestMapping(value="/")
	public ModelAndView main(ModelAndView mv) throws Exception{
		mv.setViewName("/home/file-upload");
		System.out.println(memberService.getName("user1"));
		return mv;
	}


	@ResponseBody
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public void login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
		 boolean login = true;
		if(login) {
			session.setAttribute("id", "id");
		}else {
			response.setStatus(401);
		}
		
	}
	
	@RequestMapping(value ="/error", method = RequestMethod.GET)
	public String error(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setStatus(404);
		return "home/error";
	}
}
