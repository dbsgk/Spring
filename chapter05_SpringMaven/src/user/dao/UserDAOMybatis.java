package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Transactional //class를 받아야해서 이거사용.
public class UserDAOMybatis implements UserDAO {
//	spring이 다 만들어놔서 그냥 setter로 가져오기만 하면 됨.
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void userWrite(UserDTO userDTO) {
		sqlSession.insert("userSQL.userWrite", userDTO);
		
	}

	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.selectOne", id);
	}

	@Override
	public void userUpdate(Map<String, String> map) {
		sqlSession.update("userSQL.userUpdate", map);
		
	}

	@Override
	public int userDelete(String id) {
		// TODO Auto-generated method stub
		return sqlSession.delete("userSQL.userDelete", id);
	}

	@Override
	public int getUserCount(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
