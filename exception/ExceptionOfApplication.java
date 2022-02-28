package exception;

public class ExceptionOfApplication {
	public void ApplicationExceptionTest() {
		try {
			BigDecimal balance = account.withdraw(amount);
			// 정상적인 처리 결과를 출력하도록 진행
		} catch(InsufficientBalanceException e) { // 체크예외
			// InsufficientBalanceException에 담긴 인출 가능한 잔고금액 정보를 가져옴
			BigDecimal availFunds = e.getAvailFunds();
			// 잔고 부족 안내 메시지를 준비하고 이를 출력하도록 진행
			
		}
	}
}
