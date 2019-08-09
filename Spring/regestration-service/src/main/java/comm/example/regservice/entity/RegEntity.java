package comm.example.regservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reg")
public class RegEntity implements Serializable {
	
	private static final long serialVersionUID = 3999182169079251226L;
	
	@Id
	
	
	
	
	
	@Column(nullable = false , length = 120)
	private String email;
	
	
	@Column(nullable = false ,unique=true,length = 50 )
	private String username;
	
	/*@Column(nullable = false , length = 50 )
	private String dob;
	
	@Column(nullable = false , length = 50 )
	private String password;
	
*/
	public RegEntity() {
		super();
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
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
	
	
	
}
