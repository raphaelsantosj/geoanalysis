/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

/*This class represents the FTP Data Files as entity
  When a file is downloaded with success it will be saved
  */

package api.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DATA_FILE")
public class DataFile {
	
	@Id
	@Column(name = "FILE_ID")
	private String fName;  //FILE NAME (xxx20151022pmin.min)
	@Column(name = "FILE_DATE") //FILE DATE
	private Date date;
	@Column(name = "FILE_PDATE")
	private Date pDate; //PERSISTANCE DATE
	@Column(name = "FILE_TYPE")
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
		return "DataFile [fName=" + fName + ", date=" + date + ", pDate=" + pDate + ", type=" + type + "]";
	}
	


}
