package task;

public class Product {
	String		name;
	double		price;
	Category	category;
	
	public Product() {
		
	}
	
	public Product(String name, double price, Category category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", category=" + category + "]";
	}
	
}
