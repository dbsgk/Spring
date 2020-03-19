package user.service;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserService {

	public void write(UserDTO userDTO);

	public List<UserDTO> getUserList();

	public int idcheck(String userid);

	public UserDTO checkId(String id);

	public UserDTO getUser(String id);

	public void modify(UserDTO userDTO);

	public List<UserDTO> search(Map<String, String> map);
}
