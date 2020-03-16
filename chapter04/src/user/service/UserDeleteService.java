package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserDeleteService implements UserService{
	UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 아이디 입력 : ");
		String id = scan.next();
		UserDTO userDTO = userDAO.getUser(id);
		if(userDTO==null) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		int result = userDAO.userDelete(id);
		if(result!=0)
			System.out.println("데이터를 삭제하였습니다.");
		else
			System.out.println("삭제실패");
	}

}
