import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException, ParseException {
		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.OFF);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		UserDAO dao = new UserDAO();
	
		
		System.out.println("Enter the number of users going to register");
		int num = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<num; i++) {
        User user = new User();
		System.out.println("Enter the Username");
		String uname = bf.readLine();
		user.setUsername(uname);
		
		System.out.println("Enter the Password");
		String pw = bf.readLine();
		user.setPassword(pw);
		
		System.out.println("Enter the Name");
		String name = bf.readLine();
		user.setName(name);
		
		System.out.println("Enter the Email-Id");
		String email = bf.readLine();
		user.setEmail(email);
		
		System.out.println("Enter the your Authentication number");
		int auth = Integer.parseInt(bf.readLine());
		user.setAuthenticate(auth);
		
		dao.addUser(user);
		}
		List<User> itemList = dao.listDetails();
		
		for(User u:itemList) {
			System.out.println("Name: " + u.getName());
			System.out.println("UserId: " + u.getUserid());
			System.out.println("UserName: " +u.getUsername());
			System.out.println("Password: " + u.getPassword());
			System.out.println("Email-ID: " + u.getEmail());
			System.out.println("Authenticate: " + u.getAuthenticate());
		}
	}
}
