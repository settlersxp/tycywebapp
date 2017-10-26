package nastycraft.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="users")
public class Users implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private int id;
	private String user;
	private String password;
	
	public Users(){}
	
	public Users(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", user=" + user + ", password=" + password + "]";
	}





	
	
	
	
	
}
