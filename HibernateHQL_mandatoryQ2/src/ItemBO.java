import java.util.List;

public class ItemBO {
    ItemDAO itemDAO=new ItemDAO();
    public List<Item> listItems(){
		return itemDAO.list();
	}
	public void updateItemPriceById(Item item) {
		itemDAO.updateItemPriceById(item);
	}
	public void deleteItem(Item item) {
		itemDAO.delete(item);
	}
	public Item findItemById(int id) {
		return itemDAO.find(id);
	}
}
