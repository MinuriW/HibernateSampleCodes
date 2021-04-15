package com.hcl;
import javax.persistence.*;
@Entity
@Table(name="emptemp")
public class EmpTemp {
	
	@Id
	@Column(name="eno")
	private int eno;
	@Column(name="ename")
	private String ename;
	@Column(name="city")
	private String city;
	
	public EmpTemp() {}

	public EmpTemp(int eno, String ename, String city) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.city = city;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", city=" + city + "]";
	}
	

}
