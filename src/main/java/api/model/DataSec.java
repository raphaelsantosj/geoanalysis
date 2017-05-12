/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

/*This class represents Seconds Data as entity */

package api.model;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="DATA_SEC")
@Cacheable
public class DataSec implements Data, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private DataSecPk id;
	@Column(name = "DSEC_DOY")
	private Integer DOY;//Data Day of the year
	@Column(name = "DSEC_COMP_X")
	private Double x; //Data component x
	@Column(name = "DSEC_COMP_Y")
	private Double y; //Data component y
	@Column(name = "DSEC_COMP_Z")
	private Double z; //Data component z
	@Column(name = "DSEC_COMP_H")
	private Double h; //Data component h
	@Column(name = "DSEC_COMP_D")
	private Double d; //Data component d
	@Column(name = "DSEC_COMP_F")
	private Double f; //Data component f
	@Column(name = "DSEC_COMP_I")
	private Double i; //Data component I
	
	
	
		
	public DataSecPk getId() {
		return id;
	}


	public void setId(DataSecPk id) {
		this.id = id;
	}


	public Double getX() {
		return x;
	}


	public void setX(Double x) {
		this.x = x;
	}


	public Double getY() {
		return y;
	}


	public void setY(Double y) {
		this.y = y;
	}


	public Double getZ() {
		return z;
	}


	public void setZ(Double z) {
		this.z = z;
	}


	public Double getH() {
		return h;
	}


	public void setH(Double h) {
		this.h = h;
	}


	public Double getD() {
		return d;
	}


	public void setD(Double d) {
		this.d = d;
	}


	public Double getF() {
		return f;
	}


	public void setF(Double f) {
		this.f = f;
	}


	public Double getI() {
		return i;
	}


	public void setI(Double i) {
		this.i = i;
	}


	public Integer getDOY() {
		return DOY;
	}

	public void setDOY(Integer dOY) {
		DOY = dOY;
	}


	@Override
	public String toString() {
		return "DataSec [id=" + id + ", DOY=" + DOY + ", x=" + x + ", y=" + y + ", z=" + z + ", h=" + h + ", d=" + d
				+ ", f=" + f + ", i=" + i + "]";
	}

}
