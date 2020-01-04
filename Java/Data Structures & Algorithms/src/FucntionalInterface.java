import java.util.*;
@FunctionalInterface
interface OyoRooms
{
	void message();
}
//google annotation
@FunctionalInterface
interface ZomatoPay{
	void success(int amount);
}
//ERROR
//@FunctionalInterface
//interface Bookings extends OyoRooms, ZomatoPay{
//	
//}
@FunctionalInterface
interface Square
{
	int sqr(int num);
}

class Products{
	int id;
	String name;
	double price;
	Products(int id, String name, double price)
	{
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}

public class FucntionalInterface {

	public static void main(String[] args) {
		int base = 100;
		OyoRooms oyo = ()->{
			System.out.println("You've made a bookings!");
		};
		oyo.message();
		ZomatoPay zpay = (amount)->{
			amount += base;
			System.out.println("We deliver the best food! Pay : "+amount);
		};
		zpay.success(10);
		
		Square square = (num)-> {return num*num;};
		System.out.println("Square of a number : "+square.sqr(30));
		
		Runnable r = ()->{
			System.out.println("This is a thread!");
		};
		Thread t = new Thread(r);
		t.start();
		
		
		new Thread(()->{System.out.println("Thread2");}).start();
		
		
		Products[] p = new Products[5];
		p[0] = new Products(101, "Adidas Shoe", 1200.0);
		p[1] = new Products(105, "Samsung TV", 28000.0);
		p[2] = new Products(103, "MI Band", 2700.0);
		p[3] = new Products(104, "HP Laptop", 56000.0);
		p[4] = new Products(102, "OnePlus 5T", 32444.0);
		
		List<Products> list = new LinkedList<Products>();
		list.add(p[0]);
		list.add(p[1]);
		list.add(p[2]);
		list.add(p[3]);
		list.add(p[4]);
		
		list.sort((o1, o2)->
		{
			if(o1.id>o2.id) return 1;
			else if(o1.id<o2.id) return -1;
			return 0;
		});
		for(Products pr : list) {
			System.out.println(pr);
		}
		//Method Referencing.
		Thread thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("method reference thread");
				
			}
		}); 
		Runnable runnable = thread::run;
		
		
 	}

}
