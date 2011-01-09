package struts2.junit.mocklearningexample;

import junit.framework.TestCase;

import org.jmock.Expectations;
import org.jmock.Mockery;

public class UserServiceTest extends TestCase {
	private UserService userService = new UserServiceImpl();
	private Mockery context = new Mockery();
	private UserDAO userDAO = null;
	final User fakeUser = new User("John");

	public UserServiceTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
		userDAO = context.mock(UserDAO.class);
		userService.setUserDAO(userDAO);
	}

	/*
	 * protected void tearDown() throws Exception { }
	 * 
	 * public static Test suite() { TestSuite suite = new
	 * TestSuite(UserServiceTest.class); return suite; }
	 */
	
	public void testGetUser() {

		context.checking(new Expectations() {
			{
				oneOf(userDAO).getUser(13);
				will(returnValue(fakeUser));
			}
		});

		User user = userService.getUser(13);
		assertNotNull(user);
		assertEquals("John", user.getName());
	}

	public void testSaveUser() {

		context.checking(new Expectations() {
			{
				oneOf(userDAO).getUser(13);
				will(returnValue(fakeUser));
			}
		});

		User user = userService.getUser(13);
		assertEquals("John", user.getName());

		user.setName("Mike");
		context.checking(new Expectations() {
			{
				oneOf(userDAO).saveUser(fakeUser);
			}
		});
		userService.saveUser(user);

		context.checking(new Expectations() {
			{
				oneOf(userDAO).getUser(14);
				will(returnValue(fakeUser));
			}
		});
		assertEquals("Mike", user.getName());
	}

}
