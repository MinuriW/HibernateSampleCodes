import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import domain.*;
import dao.UserDAO;
import util.*;
import org.hibernate.Session;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		UserDAO userDAO = new UserDAO();
		System.out.println("Enter no. of users");
		int no=Integer.parseInt(br.readLine());
		for(int i=0;i<no;i++) {
			User user = new User();
			System.out.println("Enter name of user "+(i+1));
			String name = br.readLine();
			user.setName(name);
			
			System.out.println("Enter phone number of user "+(i+1));
			Long phoneNumber = Long.parseLong(br.readLine());
			user.setPhoneNumber(phoneNumber);

			System.out.println("Enter address of user "+(i+1));
			String line1 = br.readLine();
			String line2 = br.readLine();
			String city = br.readLine();
			Integer pincode = Integer.parseInt(br.readLine());
			
			Address address = new Address();
			address.setLine1(line1);
			address.setLine2(line2);
			address.setCity(city);
			address.setPincode(pincode);
			
			System.out.println("Enter user id of user "+(i+1));
			Integer id = Integer.parseInt(br.readLine());
			user.setId(id);
			System.out.println("Enter password of user "+(i+1));
			String password = br.readLine();
			user.setPassword(password);
			
			user.setAddress(address);
			
			userDAO.insert(user);
		}
		System.out.println("Enter user id to display details");
		Integer id = Integer.parseInt(br.readLine());
		
		User user = userDAO.find(id);
		if(user == null)
			System.out.println("No user found with given id");
		else {
			System.out.println("Name : "+user.getName());
			System.out.println("Phone number : "+user.getPhoneNumber());
			System.out.println("Address :");
			System.out.println(user.getAddress().getLine1()+",");
			System.out.println(user.getAddress().getLine2()+",");
			System.out.println(user.getAddress().getCity()+",");
			System.out.println("Pincode-"+user.getAddress().getPincode()+".");
		}
        HibernateUtil.getSessionFactory().close();
	}
}
