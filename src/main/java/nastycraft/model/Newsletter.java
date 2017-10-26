package nastycraft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="newsletter")
public class Newsletter implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String email;
	private String ip;

	
	public Newsletter(){}


	public Newsletter(String email, String ip) {
		super();
		this.email = email;
		this.ip = ip;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	@Override
	public String toString() {
		return "Newsletter [id=" + id + ", email=" + email + ", ip=" + ip + "]";
	}
	
	


  
	

	
}	