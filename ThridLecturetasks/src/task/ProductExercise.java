package task;

import java.util.ArrayList;
import java.util.List;

public class ProductExercise {
	
	// private static Category FOOD;
	// private static Category COSMETICS;
	// private static Category OTHER;
	
	public static void main(String[] args) {
		ArrayList<Product> allProducts = new ArrayList<Product>();
		Product apple = new Product("apple", 1.0, Category.FOOD);
		Product bread = new Product("bread", 2.2, Category.FOOD);
		Product cheese = new Product("cheese", 5.0, Category.FOOD);
		Product shavingFoam = new Product("shaving foam", 12.5, Category.COSMETICS);
		Product toothpaste = new Product("toothpaste", 6.0, Category.COSMETICS);
		Product soap = new Product("soap", 3.5, Category.COSMETICS);
		Product filmBW100 = new Product("film, BW, ISO 100", 25.0, Category.OTHER);
		Product filmColor200 = new Product("film, Col, ISO 200", 20.0, Category.OTHER);
		Product penknife = new Product("penknife", 20.0, Category.OTHER);
		Product pencil = new Product("pencil", 1.0, Category.OTHER);
		allProducts.add(apple);
		allProducts.add(bread);
		allProducts.add(cheese);
		allProducts.add(shavingFoam);
		allProducts.add(toothpaste);
		allProducts.add(soap);
		allProducts.add(filmBW100);
		allProducts.add(filmColor200);
		allProducts.add(pencil);
		allProducts.add(penknife);
		// System.out.println(allProducts.toString());
		displayProducts(allProducts);
		System.out.println(returnSameCategory(allProducts, Category.FOOD));
		
	}
	
	static public void displayProducts(ArrayList<Product> allProducts) {
		for (Product product : allProducts) {
			System.out.println(product.toString());
			
		}
		
	}
	
	static public String returnSameCategory(List<Product> allProducts, Category category) {
		List<Product> returnedProducts = new ArrayList<Product>();
		for (Product product : allProducts) {
			if (product.category == category) {
				returnedProducts.add(product);
			}
		}
		return returnedProducts.toString();
	}
}
