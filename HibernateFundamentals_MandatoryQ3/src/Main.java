import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		
		
		do {
			System.out.println("Menu\n1.Add item\n2.Change item\n3.Display items\n4.Exit\nEnter choice");
			switch (Integer.parseInt(br.readLine())) {

			case 1:
				ItemDAO dao = new ItemDAO();
				Item item = new Item();
				System.out.println("Enter item id");
				int id = Integer.parseInt(br.readLine());
				item.setId(id);
				
				System.out.println("Enter name");
				String name = br.readLine();
				item.setName(name);
				
				System.out.println("Enter category");
				String cat = br.readLine();
				item.setCategory(cat);
				
				System.out.println("Enter number");
				int num = Integer.parseInt(br.readLine());
				item.setNumber(num);
				
				System.out.println("Enter price");
				float price = Float.parseFloat(br.readLine());
				item.setPrice(price);
				
				//dao.insert(new Item(id, name, cat, num, price));
				dao.insert(item);
				System.out.println("Added to the list successfully");
				break;

			case 2:
				ItemDAO dao1 = new ItemDAO();
				Item item1 = new Item();
				System.out.println("Enter item id");
				int id2 = Integer.parseInt(br.readLine());
				item1.setId(id2);
				if (dao1.find(id2) == null)
					System.out.println("Item not found");
				else {
					System.out.println("Enter name");
					String name2 = br.readLine();
					item1.setName(name2);
					
					System.out.println("Enter category");
					String cat2 = br.readLine();
					item1.setCategory(cat2);
					
					System.out.println("Enter number");
					int num2 = Integer.parseInt(br.readLine());
					item1.setNumber(num2);
					
					System.out.println("Enter price");
					float price2 = Float.parseFloat(br.readLine());
					item1.setPrice(price2);
					
					//dao.update(new Item(id2, name2, cat2, num2, price2));
					dao1.update(item1);
					System.out.println("Changes are updated successfully");
				}
				break;

			case 3:
				ItemDAO dao2 = new ItemDAO();
				List<Item> itemList = dao2.list();
				if (itemList.size() == 0) {
					System.out.println("Empty list");
				} else {
					System.out.printf("%-15s %-15s %-15s %-15s %s\n", "Id", "Name", "Category", "Number", "Price");

					for (Item i : itemList) {
						System.out.printf("%-15s %-15s %-15s %-15s %s\n", i.getId(), i.getName(), i.getCategory(),
								i.getNumber(), i.getPrice());
					}
				}
				break;
			case 4:
				System.out.println("Bye");
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
		} while (true);
	}
}
