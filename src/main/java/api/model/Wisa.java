/**
  author: Raphael dos Santos Jesus
  raphaesantos.j@gmail.com
  National Institute For Space Research
  Version 1.0
 **/


package api.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WISA")
public class Wisa implements Serializable{
	
	@EmbeddedId
	private WisaPk id;
	@Column(name = "DMIN_DOY")
	private Integer DOY; //Data Day of the year
	@Column(name = "WISA_Index")
	private Double value; //Wisa-Dst Index
	
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public WisaPk getId() {
		return id;
	}
	public void setId(WisaPk id) {
		this.id = id;
	}
	public Integer getDOY() {
		return DOY;
	}
	public void setDOY(Integer dOY) {
		DOY = dOY;
	}
	
	@Override
	public String toString() {
		return "Wisa [id=" + id + ", DOY=" + DOY + ", value=" + value + "]";
	}
}
