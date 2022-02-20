package a01;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링의 테스트 컨텍스트 프레임워크의 JUnit확장기능 지정 
public class UserDaoTest {
	UserDao dao; // @Autowired가 없다. 
	
	@Before
	public void setUp() { // @Before가 붙어있어서 매 테스트 메소드가 실행되기 전에 한번씩 실행된다. 
		dao = new UserDao();
		DataSource dataSource = new SingleConnectionDataSource(
			"jdbc:mysql//localhost/testdb", "spring", "book", true	
			);
		dao.setDataSource(dataSource);
		// 오브젝트 생성, 관계설정 등을 모두 직접 해준다. 
	}

}
