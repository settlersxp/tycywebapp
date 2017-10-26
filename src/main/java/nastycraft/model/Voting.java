package nastycraft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="voting")
public class Voting implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String title;
	private String imglink;
	private String votelink;

	
	public Voting(){}


	public Voting(String title, String imglink, String votelink) {
		super();
		this.title = title;
		this.imglink = imglink;
		this.votelink = votelink;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getImglink() {
		return imglink;
	}


	public void setImglink(String imglink) {
		this.imglink = imglink;
	}


	public String getVotelink() {
		return votelink;
	}


	public void setVotelink(String votelink) {
		this.votelink = votelink;
	}


	@Override
	public String toString() {
		return "Voting [id=" + id + ", title=" + title + ", imglink=" + imglink + ", votelink=" + votelink + "]";
	}


	
	
	

	
}	