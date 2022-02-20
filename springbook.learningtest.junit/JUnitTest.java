package springbook.learningtest.junit;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.junit.matchers.JUnitMatchers.either;

import java.util.Set;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class JUnitTest {
	@Autowired ApplicataionContext context; // 테스트 컨텍스트가 매번 주입해주는 애플리케이션 컨텍스트는 항상 같은 오브젝트인지 테스트로 확인해본다. 
	static Set<JUnitTest> testObjects = new HashSet<JUnitTest>();
	static ApplicationContext contextObject = null;
	
	// 테스트 메소드에서 매번 동일한 애플리케이션 컨텍스트가 context 변수에 주입 됐는지 확인
	@Test public void test1() {
		assertThat(testObejects, not(hasItem(this)));
		testObjects.add(this);
		
		//먼저 context를 저장해둘 스태틱 변 수인 contextObject가 null인지 확인한다. null이라면 첫 번째 테스트일 테니까 통과.
		assertThat(contextObject == null || contextObject == this.context, is(true));
		//contextObject에 현재 context를 저장해둔다. 다음부터는 저장된 contextObject가 null이 아닐 테니 현재의 context가 같은지 비교할 수 있다.
		contextObject = this.context;
	}
	
	@Test public void test2() {
		assertThat(testObejects, not(hasItem(this)));
		testObjects.add(this);
		
		assertThat(contextObject == null || contextObject == this.context);
		contextObject = this.context;
	}
	
	@Test public void test3() {
		assertThat(testObejects, not(hasItem(this)));
		testObjects.add(this);
		
		//either() : 뒤에 이어서 나오는 or()와 함께 두 개의 매처의 결과를 OR 조건으로 비교해준다.
		//nullValue() : 오브젝트가 null인지를 확인해준다. 
		assertThat(contextObject, either(is(nullValue())).or(is(this.context)));
		contextObject = this.context;
	}
}
