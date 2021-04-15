package com.hcl;
import javax.persistence.*;
@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="eno")
	private int eno;
	@Column(name="ename")
	private String ename;
	@Column(name="salary")
	private int salary;
	@Column(name="city")
	private String city;
	
	public Employee() {}

	public Employee(int eno, String ename, int salary, String city) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", salary=" + salary + ", city=" + city + "]";
	}
	

}
