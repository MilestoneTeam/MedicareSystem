package struts2.junit.mocklearningexample;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;   
	
    public UserServiceImpl() {    
    }  
    
    public void setUserDAO(UserDAO userDAO) {             
    	this.userDAO = userDAO;    
    } 
    
    public User getUser( int id) {             
    	return userDAO.getUser(id);    
    } 
    
    public void saveUser(User user) {
        userDAO.saveUser(user);    
    }

}
