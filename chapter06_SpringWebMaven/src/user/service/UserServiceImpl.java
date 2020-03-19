package user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;

	@Override
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);
	}

	@Override
	public List<UserDTO> getUserList() {
		return userDAO.getUserList();
	}

	@Override
	public int idcheck(String userid) {
		return userDAO.idCheck(userid);
	}

	@Override
	public UserDTO checkId(String id) {
		return userDAO.checkId(id);
	}

	@Override
	public UserDTO getUser(String id) {
		return userDAO.getUser(id);
	}

	@Override
	public void modify(UserDTO userDTO) {
		userDAO.modify(userDTO);
		
	}

	@Override
	public List<UserDTO> search(Map<String, String> map) {
		return userDAO.search(map);
	}

}
