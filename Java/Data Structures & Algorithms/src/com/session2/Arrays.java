package com.session2;

//Model or Bean or Pojo (Plain old java object)
class Product{
	int pid;
	String name;
	int price;
	
	public Product(int pid, String name, int price) {
		this.pid = pid;
		this.name = name;
		this.price = price;
	}
	
	public Product(){
		
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + "]";
	}
	
}

class ShoppingCart{
	static int idx = 0;
	int max = 5;
	Product[] products;
	public ShoppingCart() {
		products = new Product[max];
	}
	void addProduct(Product product)
	{
		products[idx] = product;
		idx++;
	}
	void showProducts()
	{
		for(int i=0;i<idx;i++)
		{
			System.out.println(products[i]);
		}
	}
	void resize()
	{
		Product[] temp = products;
		max++;
		products = new Product[max];
		System.arraycopy(temp,0,products,0,temp.length);
	}
}

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = new int[5];
		int[] arr2 = {10,20,30,40,50};
		
		Product p1 = new Product(101,"Hello",32312);
		Product p2 = new Product(102,"World",43223);
		Product p3 = new Product(103,"one",222333);
		Product p4 = new Product(104,"two",55444);
		Product p5 = new Product(105,"three",3231);
		
		ShoppingCart cart = new ShoppingCart();
		cart.addProduct(p1);
		cart.addProduct(p2);
		cart.addProduct(p3);
		cart.addProduct(p4);
		cart.addProduct(p5);
		
		cart.showProducts();
		
		System.out.println();
		
		cart.resize();
		cart.addProduct(p4);
		cart.showProducts();
	}

}
