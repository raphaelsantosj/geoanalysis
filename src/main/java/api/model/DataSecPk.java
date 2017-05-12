package api.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class DataSecPk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JoinColumn(name = "DSEC_IAGA", insertable = false, updatable = false)
	@ManyToOne(cascade=CascadeType.ALL)
	private Observatory observatory; //IAGA CODE (Observatory)
	@Column(name = "DSEC_DATE")
	private Date date; //Data date
	@Column(name = "DSEC_Hour")
	private Time hour; //Data time

	public Observatory getObservatory(){
		return this.observatory;
	}
	public void setObservatory(Observatory obs){
		this.observatory = obs;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((hour == null) ? 0 : hour.hashCode());
		result = prime * result + ((observatory == null) ? 0 : observatory.hashCode());
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
		DataSecPk other = (DataSecPk) obj;
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
		if (observatory == null) {
			if (other.observatory != null)
				return false;
		} else if (!observatory.equals(other.observatory))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DataSecPk [observatory=" + observatory + ", date=" + date + ", hour=" + hour + "]";
	}
	
	
}
