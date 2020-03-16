package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
//	/hello.do메소드가 호출되면 @컨트롤러 타고 여기 와서 @RequestMapping되어서 hello()메소드 실행됨. 
	@RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Hello Spring!!");
//		mav.setViewName("hello"); //파일이름 hello.jsp jsp는 자동으로 붙음.
		mav.setViewName("/view/hello"); 
		return mav;
	}
}
