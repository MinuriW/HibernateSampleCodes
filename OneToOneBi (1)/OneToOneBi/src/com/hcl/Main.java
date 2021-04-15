
package com.hcl;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AddressDAO dao=new AddressDAO();
		
		Employee e1=new Employee();
		Address a1=new Address();
		
		a1.setLine1("11,Coppernicus Marg");
		a1.setCity("New Delhi");
		a1.setZip("1100901");
		a1.setEmployee(e1);
		
		e1.setEname("Kapil Kumar");
		e1.setSalary(75000);
		e1.setAddress(a1);
		
		dao.addAddress(a1);
		
		
		System.out.println("\n************Address Details***************");
		List<Address> list=dao.getAllAddress();
		for(Address a:list) {
			//System.out.println(a);
			System.out.println(a+"\t"+a.getEmployee().getEno()+"\t"+a.getEmployee().getEname());
		}
		
		System.out.println("\n************End of Report***************\n");
		
		
	}

}
