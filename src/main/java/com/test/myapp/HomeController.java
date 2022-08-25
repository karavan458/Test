package com.test.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
//계속해서 서블릿을 만들어 웹을 구현하는 것은 매우 비 효율적이기 때문에 
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) throws Exception{
		
		return "home/home";
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
