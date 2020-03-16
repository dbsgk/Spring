package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.SumDTO;

@Controller
public class SumController {
	
//	@RequestMapping(value = "/input.do",method = RequestMethod.GET)
//	public ModelAndView input() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/sum/input");
//		return mav;
//	}
	
	//리턴타입이 String이면 단순 문자열이 아니라, 뷰(view)의 이름으로 사용된다(항상) *jsp파일
	//뷰이름이 아니라 진짜 (String)문자열을 넘기고 싶을 땐(return), @ResponseBody 어노테이션 붙이면 된다.
	//public @ResponseBody String input(){}
	@RequestMapping(value = "/sum/input.do",method = RequestMethod.GET)
	public String input() {
		return "/sum/input";
	}
	
//	@RequestMapping(value = "/sum.do")
//	public ModelAndView sum(@RequestParam("x") int x, @RequestParam("y") int y) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x", x);
//		mav.addObject("y", y);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value = "/sum.do")
//	public ModelAndView sum() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/sum/result");
//		return mav;
//	} //jsp파일에서 param.x param.y로 받으면 이렇게 사용
	
//	@RequestMapping(value = "/sum.do")
//	public ModelAndView sum(@RequestParam int x, @RequestParam int y) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x", x);
//		mav.addObject("y", y);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	//false데이터가 안들어와도 좋다. 안들어오면 default=0
//	@RequestMapping(value = "/sum.do")
//	public ModelAndView sum(
//			@RequestParam(required=false, defaultValue="0") String x,	//String으로 해도 숫자 계산됨. 
//			@RequestParam(required=false, defaultValue="0") String y) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x", x);
//		mav.addObject("y", y);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value = "/sum.do" ,method = RequestMethod.GET)
//	public String sum(
//			@RequestParam java.util.Map<String,Integer> map, ModelMap modelMap) {
//		modelMap.put("x", map.get("x"));
//		modelMap.put("x", map.get("y"));
//		return "/sum/result";
//	}
	
	@RequestMapping(value = "/sum.do" ,method = RequestMethod.GET)
	public String sum(
			@ModelAttribute SumDTO sumDTO, Model model) {
		model.addAttribute("sumDTO", sumDTO);
		return "/sum/result";
	}
}
