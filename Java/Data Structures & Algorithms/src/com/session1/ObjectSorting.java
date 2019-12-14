package com.session1;

class Product{
	int pid;
	String title;
	int price;
	public Product(int pid, String title, int price) {
		super();
		this.pid = pid;
		this.title = title;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", title=" + title + ", price=" + price + "]";
	}
}

class ProductsSort
{
	Product[] product;
	public ProductsSort(Product[] p) {
		this.product = p;
	}
	public void sort()
	{
		for(int j=1; j<product.length; j++)
		{
			int key = product[j].pid;
			//System.out.println("Key value : "+key);
			int i = j-1;
			while(i>=0 && product[i].pid>key)
			{
				//System.out.println("a[i+1] : "+a[i+1]+", a[i] : "+a[i]);
				product[i+1].pid=product[i].pid;
				i--;
				//System.out.println("i value : "+i);
			}
			product[i+1].pid=key;
		}
	}
	
	public static int binarySearch(Product a[], int s, int d, int key) {
		int mid = (s+d)/2;
		if(a[mid].pid==key)
		{
			return mid;
		}
		else if(a[mid].pid > key)
		{
			return binarySearch(a, s, mid-1, key);
		}
		else if(a[mid].pid < key)
		{
			return binarySearch(a, mid+1, d, key);
		}
		else
			return -1;
	}
	
}

public class ObjectSorting {

	public static void main(String[] args) {
		Product[] product = new Product[5];
		product[0] = new Product(401,"Abc", 3234234);
		product[1] = new Product(101,"Bcd", 2325344);
		product[2] = new Product(201,"Def", 2224444);
		product[3] = new Product(501,"Efg", 323444);
		product[4] = new Product(301,"Fgh", 1234234);
		for(Product p: product)
		{
			System.out.println(p);
		}
		System.out.println("");
		ProductsSort p = new ProductsSort(product);
		p.sort();
		for(Product p2: product)
		{
			System.out.println(p2);
		}
		System.out.println("");
		System.out.println(product[p.binarySearch(product, 0, product.length, 201)]);
	}

}
