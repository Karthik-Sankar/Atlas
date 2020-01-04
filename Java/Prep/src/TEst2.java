import test.*;
abstract class Parent{
	public static void test()
	{
		System.out.println("Parent");
	}
}
class Child extends WataWow{
	public static void test()
	{
		System.out.println("Child");
	}
}
public class TEst2 {
	public static void main(String args[]) {
		Child child = new Child();
		Parent.test();
		
		Child w = new Child();
		w.sample2();
		try {
		//w.sample3();
		}
		catch(Exception e)
		{
			
		}
	}
}
