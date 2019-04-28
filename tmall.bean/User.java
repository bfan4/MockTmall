/* @ By: Bo Fan  
 * Date: 04/25/2019
 * MockTmall Project
 * User Class
 * */

package tmall.bean;

public class User {
	// User's password
	private String password;
	// User's user name
	private String name;
	// Primary Key id
	private int id;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// Business function
	public String getAnonymousName() {
		if (null == name)
			return null;
		
		if (name.length() <= 1)
			return "****";
		
		if (name.length() == 2)
			return name.substring(0,1) + "*";
		
		char[] cs = name.toCharArray();
		for (int i = 1; i < cs.length - 1; i++ ) {
			cs[i] = '*';
		}
		
		return new String(cs);
	}

}












