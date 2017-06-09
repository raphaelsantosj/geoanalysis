package api.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WISA")
public class Wisa implements Serializable{
	
	@Id
	@Column(name = "WISA_DATE")
	private Date date; //Data date
	@Id
	@Column(name = "WISA_Hour")
	private Time hour; //Data time
	@Column(name = "WISA_Index")
	private Double value; //Wisa-Dst Index
	
	
	
	
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getHour() {
		return hour;
	}
	public void setHour(Time hour) {
		this.hour = hour;
	}

	
	
}
