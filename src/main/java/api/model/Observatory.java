/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

/*This class represents observatories as entity */


package api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OBSERVATORY")
public class Observatory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "OBS_IAGA")
	private String IAGA; //IAGA CODE
	@Column(name = "OBS_NAME", nullable = true)
	private String name; //Observatory name
	@Column(name = "OBS_COUNTRY", nullable = true)
	private String country; //Observatory country
	@Column(name = "OBS_COLATITUTE", nullable = true)
	private Double colatitute; //Observatory geographic colatitute
	@Column(name = "OBS_EAST_LONG", nullable = true)
	private Double eastLong; //Observatory geographic east longitude
	@Column(name = "OBS_INSTITUTE", nullable = true)
	private String institute; //Observatory Institute
	@Column(name = "OBS_GIN", nullable = true)
	private String GIN; 
	
	public String getIAGA() {
		return IAGA;
	}
	public void setIAGA(String iAGA) {
		IAGA = iAGA;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getColatitute() {
		return colatitute;
	}
	public void setColatitute(double colatitute) {
		this.colatitute = colatitute;
	}
	public double getEastLong() {
		return eastLong;
	}
	public void setEastLong(double eastLong) {
		this.eastLong = eastLong;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getGIN() {
		return GIN;
	}
	public void setGIN(String gIN) {
		GIN = gIN;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((GIN == null) ? 0 : GIN.hashCode());
		result = prime * result + ((IAGA == null) ? 0 : IAGA.hashCode());
		result = prime * result + ((colatitute == null) ? 0 : colatitute.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((eastLong == null) ? 0 : eastLong.hashCode());
		result = prime * result + ((institute == null) ? 0 : institute.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Observatory other = (Observatory) obj;
		if (GIN == null) {
			if (other.GIN != null)
				return false;
		} else if (!GIN.equals(other.GIN))
			return false;
		if (IAGA == null) {
			if (other.IAGA != null)
				return false;
		} else if (!IAGA.equals(other.IAGA))
			return false;
		if (colatitute == null) {
			if (other.colatitute != null)
				return false;
		} else if (!colatitute.equals(other.colatitute))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (eastLong == null) {
			if (other.eastLong != null)
				return false;
		} else if (!eastLong.equals(other.eastLong))
			return false;
		if (institute == null) {
			if (other.institute != null)
				return false;
		} else if (!institute.equals(other.institute))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Observatory [IAGA=" + IAGA + ", name=" + name + ", country=" + country + ", colatitute=" + colatitute
				+ ", eastLong=" + eastLong + ", institute=" + institute + ", GIN=" + GIN + "]";
	}
	
	
	


}
