package user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;
import user.bean.UserDTO;
//service : 일처리하는 애들
//DB : db처리하는 애들
//controller: 제어하는 애들
//그러니까
import user.service.UserService;

@Controller
@RequestMapping("/user") //이렇게 적으면 @Controller 없애고, 아래있는메소드들 value ="/user/write" 이거를 /write로 쓸수 있음
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/writeForm",method = RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	@RequestMapping(name = "/write", method = RequestMethod.POST)
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String list() {
		return "/user/list";
	}
//	
//	@RequestMapping(value = "/user/getUserList",method = RequestMethod.POST)
//	@ResponseBody //못가게 막아야 함.
//	public JSONObject getUserList() {
//		List<UserDTO> list = userService.getUserList();
//		JSONObject json = new JSONObject();
//
//		if(list!=null) {
//			JSONArray array = new JSONArray();
//			JSONObject temp = new JSONObject();
//			
//			for( UserDTO userDTO : list) {
//				temp.put("name", userDTO.getName());
//				temp.put("id", userDTO.getId());
//				temp.put("pwd", userDTO.getPwd());
//				
//				array.add(0, temp);
//				json.put("list", array);
//			}//for
//		}
//		System.out.println(json);
//		return json;
//	}

//	@RequestMapping(value = "/user/getUserList",method = RequestMethod.POST)
//	@ResponseBody //못가게 막아야 함.
//	public Map getUserList() {
//		List<UserDTO> list = userService.getUserList();
//		JSONArray array = JSONArray.fromObject(list);
//		Map map = new HashMap(); 
//		map.put("list", array);
//		return map;
//	}
	
	@RequestMapping(value = "/getUserList",method = RequestMethod.POST)
	@ResponseBody //못가게 막아야 함.
	public ModelAndView getUserList() {
		List<UserDTO> list = userService.getUserList();

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value = "/idCheck",method = RequestMethod.POST)
	@ResponseBody //못가게 막아야 함.
	public Map<Object, Object> idcheck(@RequestBody String userid) {
        
        int count = 0;
        Map<Object, Object> map = new HashMap<Object, Object>();
 
        count = userService.idcheck(userid);
        map.put("cnt", count);
 
        return map;
    }
	
	@RequestMapping(value = "/checkId",method = RequestMethod.POST)
	//@ResponseBody 이거 안쓰면 "exist.jsp / non_exist"로 가니까 못가게 막아야 함.
	public @ResponseBody String checkId(@RequestParam String id) {
        UserDTO userDTO = userService.checkId(id);
        if(userDTO==null)
        	return "non_exist";
        else
        	return "exist";
    }
	
	@RequestMapping(value = "/modifyForm",method = RequestMethod.GET)
	public String modifyForm() {
        return "/user/modifyForm";
    }
	
	@RequestMapping(value = "/getUser",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getUser(@RequestParam String id) {
        UserDTO userDTO = userService.getUser(id);
        JSONObject json = new JSONObject();
        if(userDTO!=null) {
        	json.put("name", userDTO.getName());
        	json.put("id", userDTO.getId());
        }
        return json;
    }
	
	@RequestMapping(value = "/modify",method = RequestMethod.POST)
	@ResponseBody
	public void modify(@ModelAttribute UserDTO userDTO) {
        userService.modify(userDTO);
    }
	
	@RequestMapping(value = "/search",method = RequestMethod.POST)
	@ResponseBody
	//public void search(@RequestParam String searchOption,@RequestParam String searchText) {
	public ModelAndView search(@RequestBody Map<String, String> map) {
		System.out.println(map);
        List<UserDTO> list = userService.search(map);
        ModelAndView mav = new ModelAndView();
        mav.addObject(list);
        mav.setViewName("jsonView");//json따라가라고 이렇게 이름 붙임.
        return mav;
    }
}
