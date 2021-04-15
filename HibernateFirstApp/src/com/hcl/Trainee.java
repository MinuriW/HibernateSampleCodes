package com.hcl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trainee_details")
public class Trainee {
	@Id
	@Column (name="trainee_id",length=4)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int traineeId;
	@Column (name="trainee_name",length=15)
	private String name;
	@Column (name="course",length=15)
	private String course;
	@Column (name="mobile_number",length=10)
	private String mobileNumber;
	
	public Trainee() {}
	
	public Trainee(String name, String course, String mobileNumber) {
		super();
//		this.traineeId = traineeId;
		this.name = name;
		this.course = course;
		this.mobileNumber = mobileNumber;
	}
	public int getTraineeId() {
		return traineeId;
	}
//	public void setTraineeId(int traineeId) {
//		this.traineeId = traineeId;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", name=" + name + ", course=" + course + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
	
}
