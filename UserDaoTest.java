package a01;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링의 테스트 컨텍스트 프레임워크의 JUnit확장기능 지정 
@ContextConfiguration(locations="/applicataion.xml") // 테스트 컨텍스트가 자동으로 만들어줄 애플리케이션 컨텍스트의 위치 지정
public class UserDaoTest {
	@Autowired
	UserDao dao; // UserDao 타입 빈을 직접 DI(의존성 주입) 받는다 
	
	@Before
	public void setUp() { // @Before가 붙어있어서 매 테스트 메소드가 실행되기 전에 한번씩 실행된다. 
		this.dao = this.context.getBean("userDao", UserDao.class);
		System.out.println(this.context);
		System.out.println(this);
	}

}
