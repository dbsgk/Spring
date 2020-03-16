package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import lombok.Setter;
import lombok.val;
import user.bean.UserDTO;

/*public class UserDAOImpl implements UserDAO {
	@Setter
	private JdbcTemplate jdbcTemplate; //dataSource 얘가 알아서 다 가져옴.
	
	@Override
	public void userWrite(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		//connection, statement, resultset 
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
	}

}*/

//JdbcDaoSupport 상속받으면 JdbcTemplate 가져올 수 있다.
//NamedParameterJdbcDaoSupport 상속받으면 JdbcTemplate + NamedParameterJdbcTemplate 가져올 수 있다.
//@PropertySource("classpath:spring/db.properties")
@Repository("userDAO")
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {

	@Autowired
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	@Override
	public void userWrite(UserDTO userDTO) {
		String sql = "insert into usertable values(:name,:id,:pwd)";
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		
		//list생성&담아주기 query가 알아서 함.
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userUpdate(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		int result = getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id= ?";
		try {
//			return  (UserDTO) getJdbcTemplate().queryForObject(
//					sql, 
//					new Object[]{id}, 
//					new BeanPropertyRowMapper(UserDTO.class));
			return  getJdbcTemplate().queryForObject(
					sql, 
					new BeanPropertyRowMapper<UserDTO>(UserDTO.class)
					,id);
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}//getUser

	@Override
	public int userDelete(String id) {
		String sql = "delete usertable where id = ?";
		int result = getJdbcTemplate().update(sql, id);
		return result;
	}
	
	
}