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
		UserDAO dao = new UserDAO();
		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.OFF);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

		List<User> list = dao.listDetails();

		for (User u : list) {
			System.out.println("UserId: " + u.getuserid());
			System.out.println("UserName: " + u.getUsername());
			System.out.println("Password: " + u.getpassword());
			System.out.println("Email-ID: " + u.getemail());
			System.out.println("Authenticate: " + u.getAuthenticate());

		}

		System.out.println("Enter the id and password to be updated");
		int id = Integer.parseInt(bf.readLine());
		String pw = bf.readLine();
		dao.updateUser(id, pw);
		
		if(list.size() == 0) {
			System.out.println("No such id exists");
		}
		else {
			System.out.println("Password for Id" + id + "is updated");
		}

		for (User u : list) {
			System.out.println("UserId: " + u.getuserid());
			System.out.println("UserName: " + u.getUsername());
			System.out.println("Password: " + u.getpassword());
			System.out.println("Email-ID: " + u.getemail());
			System.out.println("Authenticate: " + u.getAuthenticate());

		}
		System.exit(0);
	}
}
