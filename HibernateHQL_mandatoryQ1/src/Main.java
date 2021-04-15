import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.Session;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		Logger log = Logger.getLogger("org.hibernate");
    	log.setLevel(Level.OFF);
    	System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
    	ItemBO bo = new ItemBO();
		do {
			System.out.println("Menu");
			System.out.println("1.Display items");
			System.out.println("2.Calculate average price for particular category");
			System.out.println("3.Exit");
			System.out.println("Enter choice");
			
			switch(Integer.parseInt(br.readLine())) {
			case 1:
				List<Item> itemList=bo.listItems();
				System.out.println("Item Details");
				if(itemList.size()==0) {
					System.out.println("Empty list");
					System.exit(0);
				}
				System.out.printf("%-15s %-15s %-15s %-15s %s\n","Id","Name","Category","Number","Price");
				for(Item item:itemList)
					System.out.printf("%-15s %-15s %-15s %-15s %s\n",item.getId(),item.getName(),item.getCategory(),item.getQuantity(),item.getPrice());
				break;
			case 2:
				System.out.println("Enter category");
				String category = br.readLine();
				Double result = bo.averagePriceByCategory(category);
				System.out.println("average price of items under "+category+" category "+result);
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Inavlid choice");
			}
		}while(true);
	}
}