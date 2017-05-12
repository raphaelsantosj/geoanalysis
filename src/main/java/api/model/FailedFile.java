/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

/*This class represents the FTP Failed Files as entity
  When a file is not downloaded by any reason 
  (Failed internet connection, Broken Files) it will be saved
  */

package api.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FAILED_FILE")
public class FailedFile {
	
	
	@Id
	@Column(name = "FAIL_ID")
	private String fName;  //FILE NAME (xxx20151022pmin.min)
	@Column(name = "FAIL_DATE") //FILE DATE
	private Date date;
	@Column(name = "FAIL_PDATE")
	private Date pDate; //PERSISTANCE DATE
	@Column(name = "FAIL_TYPE")
	private String type; //CAN BE "M" or "S"
	
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "FailedFile [fName=" + fName + ", date=" + date + ", pDate=" + pDate + ", type=" + type + "]";
	}

	

}

