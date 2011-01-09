package struts2.junit.mocklearningexample;

public interface UserService {
	public void setUserDAO(UserDAO userDAO);       
    public void saveUser(User user);    
    public User getUser( int id);
}
