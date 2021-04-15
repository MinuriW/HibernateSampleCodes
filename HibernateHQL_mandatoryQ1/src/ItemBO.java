import java.util.List;

public class ItemBO {
	ItemDAO itemDAO = new ItemDAO();

	public List<Item> listItems() {
		
		return itemDAO.list();

	}

	public Double averagePriceByCategory(String category) {
		
		return itemDAO.averagePriceByCategory(category);
	}
}
