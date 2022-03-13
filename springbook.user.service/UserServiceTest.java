package springbook.user.service;

public class UserServiceTest {
	@RunWith(SpringJUnitClassRunner.class)
	@ContextConfiguration(locations = "/test-applicationContext.xml")
	public class UserServiceTest {
		@Autowired
		UserService userService;
	}
	
  // userService 빈의 주입을 확인하는 
	@Test
	public void bean() {
		assertThat(this.userService, is(notNullValue()));	
	}
	
}
