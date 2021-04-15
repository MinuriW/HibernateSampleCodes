package src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		UserDAO dao = new UserDAO();
		
		System.out.println("Enter no. of users");
		int num = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=num; i++) {
			System.out.println("Enter name of user "+ i);
			String name = br.readLine();
			
			System.out.println("Enter phone number of user "+i);
			long phone = Long.parseLong(br.readLine());
			
			System.out.println("Enter user id of user "+i);
			String id = br.readLine();
			
			System.out.println("Enter password of user "+i);
			String pw = br.readLine();
			
			dao.insert(new User(id,name,phone,pw));
		}
		
		List<User> list = dao.list();
		
		System.out.println("User Details");
		System.out.printf("%-15s %-15s %s \n","Name","Phone number","User id");
		
		for(User u:list) {
			System.out.format("%-15s %-15s %s \n",u.getName(),u.getPhoneNumber(),u.getUserId()); 
		}
		
	}
}

