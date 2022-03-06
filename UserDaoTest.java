package a01;

import springbook.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링의 테스트 컨텍스트 프레임워크의 JUnit확장기능 지정 
public class UserDaoTest {
	@Autowired UserDao dao;
	@Autowired DataSource dataSource;
	UserDao dao; // @Autowired가 없다. 
	
	@Before
	public void setUp() { // @Before가 붙어있어서 매 테스트 메소드가 실행되기 전에 한번씩 실행된다. 
		dao = new UserDao();
		DataSource dataSource = new SingleConnectionDataSource(
			"jdbc:mysql//localhost/testdb", "spring", "book", true	
			);
		dao.setDataSource(dataSource);
		// 오브젝트 생성, 관계설정 등을 모두 직접 해준다.
		
		this.user1 = new User("gyumee", "박성철", "springno1", Lvl.BASIC, 1, 0);
	    this.user2 = new User("leegw700", "이길원", "springno2", Lvl.SILVER, 55, 10);
	    this.user3 = new User("bumjin", "박범진", "springno3", Lvl.GOLD, 100, 40);
	}
	
	@Test(expected = DataAccessException.class)
	public void duplicateKey() {
		dao.deleteAll();
		dao.add(user1);
		dao.add(user1); //강제로 사용자를 두번 등록한다. 여기서 예외 발생 
	}
	
	private void checkSameUser(User user1, User user2) {
		assertThat(user1.getId(), is(user2.getId()));
		assertThat(user1.getName(), is(user2.getName()));
		assertThat(user1.getPassword(), is(user2.getPassword()));
		assertThat(user1.getLevel(), is(user2.getLevel()));
		assertThat(user1.getLogin(), is(user2.getLogin()));
		assertThat(user1.getRecommend(), is(user2.getRecommend()));
	}

}
