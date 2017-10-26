package nastycraft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="ranks")
public class Ranks implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String ranktitle;
	private String rankimg;
	private String rankprice;
	private String titlecolor;
	private String titlebg;

	
	public Ranks(){}


	public Ranks(String ranktitle, String rankimg, String rankprice, String titlecolor, String titlebg) {
		super();
		this.ranktitle = ranktitle;
		this.rankimg = rankimg;
		this.rankprice = rankprice;
		this.titlecolor = titlecolor;
		this.titlebg = titlebg;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRanktitle() {
		return ranktitle;
	}


	public void setRanktitle(String ranktitle) {
		this.ranktitle = ranktitle;
	}


	public String getRankimg() {
		return rankimg;
	}


	public void setRankimg(String rankimg) {
		this.rankimg = rankimg;
	}


	public String getRankprice() {
		return rankprice;
	}


	public void setRankprice(String rankprice) {
		this.rankprice = rankprice;
	}


	public String getTitlecolor() {
		return titlecolor;
	}


	public void setTitlecolor(String titlecolor) {
		this.titlecolor = titlecolor;
	}


	public String getTitlebg() {
		return titlebg;
	}


	public void setTitlebg(String titlebg) {
		this.titlebg = titlebg;
	}


	@Override
	public String toString() {
		return "Ranks [id=" + id + ", ranktitle=" + ranktitle + ", rankimg=" + rankimg + ", rankprice=" + rankprice
				+ ", titlecolor=" + titlecolor + ", titlebg=" + titlebg + "]";
	}


	

	
	
	

	
}	