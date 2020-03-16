package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Repository
@Transactional //자동으로 콜백
public class UserDAOMybatis implements UserDAO {
//	spring이 다 만들어놔서 그냥 setter로 가져오기만 하면 됨.
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
		
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
	public int idCheck(String userid) {
		return sqlSession.selectOne("userSQL.selectOne", userid);
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

	@Override
	public UserDTO checkId(String id) {
		return sqlSession.selectOne("userSQL.checkId", id);
	}

	@Override
	public void modify(UserDTO userDTO) {
		sqlSession.update("userSQL.modify", userDTO);
		
	}



}
