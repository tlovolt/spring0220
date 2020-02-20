package com.pk.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pk.springmvc.domain.User;

//Controller 클래스를 만들어주고 Bean을 자동생성해주는 어노테이션
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// / 요청이 GET 방식으로 오면 처리하는 메소드 설정
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//model에 attribute를 저장하면 request 객체에 저장됩니다.
		//문자열을 리턴하면 이 문자열이 view 이름입니다.
		// /(기본 요청)요청이 오면 serverTime이라는 attribute를 request에 저장해서
		// home -> WEB-INF/views/home.jsp 로 포워딩합니다. 
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );		
		return "home";
	}
	
	//display라는 요청이 왔을 때 처리하는 메소드
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public String display(Model model) {
		String msg = "Spring MVC Project";
		//데이터 저장 - request.setAttribute 와 동일
		model.addAttribute("msg", msg);
		
		//출력할 View 이름을 설정
		return "display";
	}
	
	@RequestMapping(value="/param", method=RequestMethod.GET)
	public String param(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		System.out.println(num);
		return "";
	}
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String get(Model model, 
			@RequestParam("keyword") String keyword) {
		System.out.println(keyword);
		return "";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, 
			User user) {
		System.out.println(user);
		return "";
	}
	
	@RequestMapping(value="/article/{num}", method=RequestMethod.GET)
	public String detail(Model model, 
			@PathVariable int num) {
		System.out.println(num);
		return "";
	}
	
}








