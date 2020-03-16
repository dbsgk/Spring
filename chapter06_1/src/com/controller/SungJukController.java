package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SungJukDTO;

@Controller
public class SungJukController {
	
	@RequestMapping(value = "/sungJuk/input.do",method = RequestMethod.GET)
	public String input() {
		return "/sungJuk/input";
	}
	
//	@RequestMapping(name = "/sungJuk/result.do", method = RequestMethod.POST)
//	public ModelAndView result(
//			@RequestParam String name,
//			@RequestParam int kor,
//			@RequestParam int eng,
//			@RequestParam int math) {
//		int tot = kor+eng+math;
//		double avg = tot/3.0;
//		SungJukDTO dto = new SungJukDTO();
//		dto.setKor(kor);
//		dto.setEng(eng);
//		dto.setMath(math);
//		dto.setTot(tot);
//		dto.setAvg(avg);
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("dto", dto);
//		mav.setViewName("/sungJuk/result");
//		return mav;
//	}
	

	@RequestMapping(name = "/sungJuk/result.do", method = RequestMethod.POST)
	public String result(
			@ModelAttribute SungJukDTO dto, Model model) {
		dto.setTot(dto.getKor()+dto.getEng()+dto.getMath());
		dto.setAvg(dto.getTot()/3.0);
		model.addAttribute("sungJukDTO", dto);
		return "/sungJuk/result";
	}
}
