package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;

@Service
public class UserInsertService implements UserService{
	@Autowired
	private UserDTO userDTO;
	@Autowired
	private UserDAO userDAO;

//	public void setUserDTO(UserDTO userDTO) {
//		this.userDTO = userDTO;
//	} @Setter하면 이렇게 set메소드 안만들어도 됨.

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력: ");
		String name = scan.next();
		System.out.print("아이디 입력: ");
		String id = scan.next();
		System.out.print("비밀번호 입력: ");
		String pwd = scan.next();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		//DB(setter injection)
		userDAO.userWrite(userDTO);
		
		//응답(user.bean.UserDTO)
		System.out.println("데이터가 입력되었습니다.");
	}

}
