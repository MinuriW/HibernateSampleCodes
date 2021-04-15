import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="stall")
public class Stall implements Serializable{
	
	@Id
	@Column(length=10)
	Integer stallId;
	@Column(length=255)
	String name;
	@Column(length=255)
	String type;
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn
	StallLicense license;
	
	public Stall() {
		super();
	}
	
	public Stall(Integer stallId, String name, String type, StallLicense license) {
		super();
		this.stallId = stallId;
		this.name = name;
		this.type = type;
		this.license = license;
	}

	

	public Stall(Integer stallId, String name, String type) {
		super();
		this.stallId = stallId;
		this.name = name;
		this.type = type;
	}

	public Integer getStallId() {
		return stallId;
	}
	public void setStallId(Integer stallId) {
		this.stallId = stallId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public StallLicense getLicense() {
		return license;
	}
	public void setLicense(StallLicense license) {
		this.license = license;
	}
	
	}

