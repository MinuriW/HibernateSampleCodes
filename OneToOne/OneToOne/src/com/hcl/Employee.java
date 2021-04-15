package com.hcl;
import javax.persistence.*;

@Entity
@Table(name="emp1")
public class Employee {
	
	@Id
	@GeneratedValue
	private int eno;
	@Column(length=20)
	private String ename;
	@Column(length=8)
	private int salary;
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn
	private Address address;
	
	public Employee(){}

	public Employee(int eno, String ename, int salary, Address address) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
		this.address = address;
	}
	public Employee(String ename, int salary, Address address) {
		super();
		
		this.ename = ename;
		this.salary = salary;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return eno+"\t"+ename+"\t"+salary+"\t"+address;
	}
	

}
