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
				// add()메소드를 사용하는 쪽에서 아이디 중복 예외를 처리하고 싶은 경우 활용할 수 있음을 알려주도록 
				// DuplicateUserIdException을 메소드의 throws 선언에 포함시킨다 
				throw new DuplicateUserIdException(e); // 예외 전환
			} else {
				// 언체크 예외
				throw new RuntimeException(e); // 예외 포장
			}
		}
	
	}
	
	// 사용자 아이디가 중복됐을때 사용 
	public class DuplicateUserIdException extends RuntimeException {
		public DuplicateUserIdException(Throwable cause) {
			super(cause);
		}
	}
