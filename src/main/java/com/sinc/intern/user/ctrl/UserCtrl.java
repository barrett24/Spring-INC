package com.sinc.intern.user.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinc.intern.user.model.vo.UserDTO;
import com.sinc.intern.user.model.vo.UserVO;
import com.sinc.intern.user.service.UserService;

@Controller
public class UserCtrl {
	
	@Resource(name="userS")
	private UserService service;
	
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		System.out.println("user loginForm");
		return "user/login";
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(UserDTO dto, HttpSession session) { // 객체를 실어보내는 게 모델일 수도 세션일 수도 있다
		System.out.println("user login dto : " +dto);
		Object user = service.login(dto);
		if (user != null) {
			session.setAttribute("loginUser", user);
		}
		return "redirect:/main.do";
	}
	
	/*
	//@RequestMapping(value="/login.do", method=RequestMethod.POST)
	// request 파라미터 없이도 가능, control의 리턴타입은 보통 스트링, void로 할수도 있음
	@RequestMapping("/login.do")
	public String login(UserDTO dto) { 
		System.out.println("ctrl login");
		System.out.println("UserDTO: " +dto);
		return "home";	// 문자열은 페이지 이름 리턴, ViewResolver 가 받음
	}
	
	// void 인 경우 내부적으로 사용자가 치고 들어온 이름의 페이지로 이동시킴 
	@RequestMapping("/logout.do")
	public void logout() {
		System.out.println("ctrl logout");
	}
	
	@RequestMapping("/join.do")
	public ModelAndView join(ModelAndView mv) { // 알아서 객체 생성해줌
		System.out.println("ctrl join");
		mv.addObject("msg", "Hi siyoung");
		mv.setViewName("home");
		return mv;
	}
	
	// 가장 보편적으로 사용하는 형태
	@RequestMapping("/search.do")
	public String search(Model model) {
		System.out.println("ctrl search");
		model.addAttribute("msg", "using model 한글깨져");
		return "home";
	}
	
	// ajax 통신할 때는 어노테이션이 추가로 필요
	@RequestMapping("/ajax.do")
	@ResponseBody
	public UserVO ajax() {
		System.out.println("ctrl ajax");
		return new UserVO("jslim", "jslim", "임정섭", 2000, "SB");
	}*/
}
