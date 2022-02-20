package a01;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링의 테스트 컨텍스트 프레임워크의 JUnit확장기능 지정 
@ContextConfiguration(locations="/applicataion.xml") // 테스트 컨텍스트가 자동으로 만들어줄 애플리케이션 컨텍스트의 위치 지정
@DirtiesContext // 테스트 메소드에서 애플리케이션 컨텍스트의 구성이나 사태를 변경한다는 것을 테스트 컨텍스트 프레임워크에 알려준다 
public class UserDaoTest {
	@Autowired
	private ApplicationContext context;//테스트 오브젝트가 만들어지고 나면 스프링 테스트 컨텍스트에 의해 자동으로 값이 주입된다. 
	
	@Before
	public void setUp() { // @Before가 붙어있어서 매 테스트 메소드가 실행되기 전에 한번씩 실행된다. 
		this.dao = this.context.getBean("userDao", UserDao.class);
		System.out.println(this.context);
		System.out.println(this);
		
		DataSource dataSource = new SingleConnectionDataSource(// 테스트에서 UserDao가 사용할 DataSource 오브젝트를 직접 생성한다. 
			"jdbc:mysql://localhost/testdb", "spring", "book", true	
				);
		dao.setDataSource(dataSource); // 코드에 의한 수동 DI
		
	}

}
