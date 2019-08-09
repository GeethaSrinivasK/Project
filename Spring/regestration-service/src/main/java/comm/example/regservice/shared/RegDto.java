package comm.example.regservice.shared;

import java.io.Serializable;

public class RegDto implements Serializable {

	private static final long serialVersionUID = 2148301679678484834L;

private String email;

	
	private String username;
	
	
	/*private String dob;
	
	
	private String password;*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/*public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
*/
	
		
	
}
