package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserDAO {
	public void write(UserDTO userDTO);
	public List<UserDTO> getUserList();
	public UserDTO getUser(String id);
	public void userUpdate(Map<String, String> map);
	public int userDelete(String id);
	public int getUserCount(String id);
	public int idCheck(String userid);
	public UserDTO checkId(String id);
	public void modify(UserDTO userDTO);
}
