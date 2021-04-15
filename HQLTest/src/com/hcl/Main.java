package com.hcl;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args)throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		EmployeeDAO dao=new EmployeeDAO();
		System.out.println("Enter city to search:");
		String city=br.readLine();
		List<Employee> list=dao.searchByCity(city);
		
		System.out.println("***************Employee Details***************");
		for(Employee e:list) {
			System.out.println(e);
		}
		
		//dao.copyFromTable();
		System.out.println("***************Update Employee City***************");
		System.out.println("Enter Eno :");
		int eno=Integer.parseInt(br.readLine());
		System.out.println("Enter new City:");
		String city1=br.readLine();
		dao.updateEmployee(eno, city1);
		
		
	}

}
