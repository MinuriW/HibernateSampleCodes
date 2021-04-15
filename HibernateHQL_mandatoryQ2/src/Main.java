import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		
		Logger log = Logger.getLogger("org.hibernate");
    	log.setLevel(Level.OFF);
    	System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
    	ItemBO bo = new ItemBO();
    	Item item =  new Item();
    		do {
			System.out.println("Menu");
			System.out.println("1.Update item price");
			System.out.println("2.Delete item");
			System.out.println("3.Display items");
			System.out.println("4.Exit");
			System.out.println("Enter choice");
			switch(Integer.parseInt(br.readLine())) {
			case 1:
				System.out.println("Enter item id");
				int id = Integer.parseInt(br.readLine());
				
				if(bo.findItemById(id) == null) {
					System.out.println("Item not found");
					break;
				}
				System.out.println("Enter new price");
				Float price = Float.parseFloat(br.readLine());
				item.setId(id);
				item.setPrice(price);
				bo.updateItemPriceById(item);
				break;
			case 2:
				System.out.println("Enter item id");
				int id2 = Integer.parseInt(br.readLine());
				
				if(bo.findItemById(id2) == null) {
					System.out.println("Item not found");
					break;
				}
				item.setId(id2);
				bo.deleteItem(item);
				break;
			case 3:
				List<Item> itemList = bo.listItems();
				System.out.println("Item Details");
				if(itemList.size()==0) {
					System.out.println("Empty list");
					System.exit(0);
				}
				System.out.printf("%-15s %-15s %-15s %-15s %s\n","Id","Name","Category","Number","Price");
				for(Item i:itemList)
					System.out.printf("%-15s %-15s %-15s %-15s %s\n",i.getId(),i.getName(),i.getCategory(),i.getNumber(),i.getPrice());
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
		}while(true);
	}
}