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
import javax.persistence.Embeddable;

@Embeddable
public class WisaPk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "WISA_DATE")
	private Date date; //Data date
	@Column(name = "WISA_Hour")
	private Time hour; //Data time

	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((hour == null) ? 0 : hour.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WisaPk other = (WisaPk) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (hour == null) {
			if (other.hour != null)
				return false;
		} else if (!hour.equals(other.hour))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WisaPk [date=" + date + ", hour=" + hour + "]";
	}
}
