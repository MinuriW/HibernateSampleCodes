package com.hcl;
import javax.persistence.*;
@Entity
@Table(name="address1")
public class Address {
	
	@Id
	@GeneratedValue
	@Column(name="add_id")
	private int addId;
	@Column(length=20)
    private String line1;
	@Column(length=20)
	private String city;
	@Column(length=10)
	private String zip;
	public Address() {}
	public Address(int addId, String line1, String city, String zip) {
		super();
		this.addId = addId;
		this.line1 = line1;
		this.city = city;
		this.zip = zip;
	}
	public Address(String line1, String city, String zip) {
		super();
		
		this.line1 = line1;
		this.city = city;
		this.zip = zip;
	}
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return addId+"\t"+line1+"\t"+city+"\t"+zip;
	}
	
	

}
