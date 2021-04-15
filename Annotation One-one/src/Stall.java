import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="stall")
public class Stall implements Serializable{

    @Id
	@Column
	Integer stallId;
	@Column
	String name;
	@Column
	String type;
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn
	StallLicense license;
	public Stall() {
		super();
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

