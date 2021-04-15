import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		UserDAO dao = new UserDAO();

		while (true) {

			System.out.println("Menu");
			System.out.println("1.Sign up");
			System.out.println("2.Login");
			System.out.println("3.Exit");

			System.out.println("Enter choice");
			int ch = Integer.parseInt(br.readLine());

			if (ch == 1) {
				System.out.println("Enter name");
				String name = br.readLine();

				System.out.println("Enter phone number");
				Long phone = Long.parseLong(br.readLine());

				System.out.println("Enter user id");
				String id = br.readLine();

				System.out.println("Enter password");
				String pw = br.readLine();

				dao.insert(new User(id, name, phone, pw));
			}

			else if (ch == 2) {
				System.out.println("Enter user id");
				String id2 = br.readLine();

				if (dao.find(id2) == null) {
					System.out.println("No such user. Please sign up before login.");
				} else {
					System.out.println("Enter password");
					String password2 = br.readLine();

					if (dao.find(id2).getPassword().equals(password2)) {
						System.out.println("Wrong password. Please try again");
					} else {
						System.out.println("Welcome " + dao.find(id2).getName()
								+ ". This is secret only accessible to authenticated user");
					}

				}
			}

			else if (ch == 3) {
				System.out.println("Bye");
				break;
			}

			else {
				System.out.println("Invalid choice");

			}
		}
	}
}
