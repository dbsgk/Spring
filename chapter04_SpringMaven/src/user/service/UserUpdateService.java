package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserUpdateService implements UserService{
	@Autowired
	UserDAO userDAO;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 아이디 입력: ");
		String id = scan.next();
		
		UserDTO userDTO = userDAO.getUser(id);
		if(userDTO==null) {
			System.out.println("찾고자 하는 회원이 없습니다.");
			return;
		}
		System.out.print("수정할 이름 입력 : ");
		userDTO.setName(scan.next());
		System.out.print("수정할 비밀번호 입력 : ");
		userDTO.setPwd(scan.next());
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", userDTO.getId());
		map.put("name", userDTO.getName());
		map.put("pwd", userDTO.getPwd());
		userDAO.userUpdate(map);
		System.out.println(userDTO.getId()+"\t"+userDTO.getName()+"\t"+userDTO.getPwd());
		
	}
}
