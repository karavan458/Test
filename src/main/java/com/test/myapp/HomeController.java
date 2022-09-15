package com.test.myapp;

import java.io.PrintWriter;
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

    @ResponseBody
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public void login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String id = request.getParameter("exampleInputEmail");
		String pw = request.getParameter("exampleInputPassword");

		String name = memberService.getName(id, pw);
		System.out.println(name);


		if (name != null && name != "") {
			PrintWriter out = response.getWriter();
			session.setAttribute("id", "id");
			out.println("<script>alert('환영합니다.'); </script>");
			out.println("<script>self.location ='/file/'; </script>");
			out.flush();
		} else {
			PrintWriter out = response.getWriter();
			response.setStatus(401);
			out.println("<script>alert('계정을 다시 확인해주십시오.'); </script>");
			out.println("<script>self.location ='/'; </script>");
			out.flush();
		}
	}

	@RequestMapping(value ="/error", method = RequestMethod.GET)
	public String error(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setStatus(404);
		return "home/error";
	}
}
