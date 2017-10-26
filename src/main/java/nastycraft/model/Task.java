package nastycraft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="t_task")
public class Task implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String names;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_created;
	private boolean finished;
	
	public Task(){}

	public Task(String name, String description, Date dateCreated, boolean finished) {
		super();
		this.names = name;
		this.description = description;
		this.date_created = dateCreated;
		this.finished = finished;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return names;
	}
	public void setName(String name) {
		this.names = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateCreated() {
		return date_created;
	}
	public void setDateCreated(Date dateCreated) {
		this.date_created = dateCreated;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + names + ", description=" + description + ", dateCreated=" + date_created
				+ ", finished=" + finished + "]";
	}
}