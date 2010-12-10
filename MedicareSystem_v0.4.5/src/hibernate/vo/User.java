package hibernate.vo;

/**
 * User entity. 
 * @author MileStone
 */

public class User implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 9112092773174711413L;
	private Integer id;
	private String name;
	private String password;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString()
	{
		return name + " " + password;
	}
	
}