package springbook.user.dao;

import java.sql.ResultSet;

import springbook.user.domain.Level;
import springbook.user.domain.User;

public class UserDaoJdbc implements UserDao{

	private RowMapper<User> userMapper = new RowMapper<User>() {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setLevel(Level.valueOf(rs.getInt("level")));
			user.setLogin(rs.getInt("login"));
			user.getRecommend(rs.getInt("recommend"));
			return user;
		}
	}
	
	public void add(User user) {
		this.jdbcTemplate.update(
			"insert into users(id, name, password, level, login, recommend)" 
			+ "values(? ,? ,? ,? ,? ,?)"
			, user.getId()
			, user.getName()
			, user.getPassword()
			, user.getLevel().intValue() // Level 이늄은 object이므로 DB에 저장될 수 있는 SQL타입이 아니다.
			// 따라서 DB에 저장가능한 정수형 값으로 변환해줘야 한다. 
			, user.getLogin()
			, user.getRecommend()
		);
	}
	
	public void update(User user) {
		this.jdbcTemplate.update(
			"update users set name = ?, password = ?, level = ?, login = ?, "
				+ "recommend = ? where id = ?"
				, user.getName()
				, user.getPassword()
				, user.getLevel().intValue()
				, user.getLogin()
				, user.getRecommend()
				, user.getId()
		);
	}
}
