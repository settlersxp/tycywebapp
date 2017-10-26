package nastycraft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ranksoptions")
public class RanksOptions implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String helper;
	private String moderator;
	private String admin;
	private String operator;
	
	public RanksOptions() {}

	public RanksOptions(String name, String helper, String moderator, String admin, String operator) {
		super();
		this.name = name;
		this.helper = helper;
		this.moderator = moderator;
		this.admin = admin;
		this.operator = operator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHelper() {
		return helper;
	}

	public void setHelper(String helper) {
		this.helper = helper;
	}

	public String getModerator() {
		return moderator;
	}

	public void setModerator(String moderator) {
		this.moderator = moderator;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "RanksOptions [id=" + id + ", name=" + name + ", helper=" + helper + ", moderator=" + moderator
				+ ", admin=" + admin + ", operator=" + operator + "]";
	}

	
	
	
	

	
	
	
	

	
}	