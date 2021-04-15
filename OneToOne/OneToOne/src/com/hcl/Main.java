
package com.hcl;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeDAO dao=new EmployeeDAO();
		
		
		Address ad3=new Address("8976,J APpts","Delhi","200001");
		Employee e3=new Employee("Nikita Bhasin",120000,ad3);
		
		
		dao.addEmployee(e3);
		System.out.println("\n************Employee Details***************");
		List<Employee> list=dao.getAllEmployees();
		for(Employee e:list) {
			System.out.println(e);
		}
		
		System.out.println("\n************End of Report***************\n");
		System.out.print("Enter employee number to delete :");
		int eno=sc.nextInt();
		dao.deleteEmployeeById(eno);
		System.out.println("\n************Employee Details***************");
		list=dao.getAllEmployees();
		for(Employee e:list) {
			System.out.println(e);
		}
		
		System.out.println("\n************End of Report***************\n");
		
		
	}

}
