package a01;

import java.sql.SQLException;

public class Exception4 {
	public void add(User user) throws DuplicateUserIdException, SQLException {
		try {
			// JDBC를 이용해 USER 정보를 DB에 추가하는 코드 또는 
			// 그런 기능을 가진 다른 SQL Exception을 던지는 메소드를 호출하는 코드 
		} 
		catch(SQLException e) {
			// ErrorCode가 MySQL의 "Duplicate Entry(1062)"이면 예외 전환 
			if(e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
				throw DuplicateUserIdException();
			} else {
				throw e; // 그 외의 경우는 SQL Exception 그대로 
			}
		}
	
	}
	
}
