import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
    @Id
	@Column(name="id")
	Integer id;
	@Column(name="name")
	String name;
	@Column(name="category")
	String category;
	@Column(name="quantity")
	Integer number;
	@Column(name="price")
	Float price;
	
	public Item() {
		super();
	}
	
	
	public Item(Integer id, String name, String category, Integer number, Float price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.number = number;
		this.price = price;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
}
