
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "stallLicense")
public class StallLicense implements Serializable {

	@Id
	@Column(length=10)
	Integer licenseId;
	@Temporal(TemporalType.DATE)
	Date expiryDate;
	Stall stall;

	public StallLicense() {
		super();
	}

	public StallLicense(Integer licenseId, Date expiryDate, Stall stall) {
		super();
		this.licenseId = licenseId;
		this.expiryDate = expiryDate;
		this.stall = stall;
	}

	public Integer getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(Integer licenseId) {
		this.licenseId = licenseId;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Stall getStall() {
		return stall;
	}

	public void setStall(Stall stall) {
		this.stall = stall;
	}
}
