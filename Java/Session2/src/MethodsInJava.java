public class MethodsInJava {

	public static void main(String[] args) {
		MethodsInJava jav = new MethodsInJava();
		jav.display();
		StaticTest.signal();
	}
	int display()
	{
		System.out.println("Static Function");
		return 0;
	}
}
class StaticTest
{
	public static void signal()
	{
		System.out.println("Static function in Static Test!");
	}
}


//Static VS Non-Static

//Execution of non static method.
//Create an object and then call

//Execution of static method.
//Doesn't need to create an object use Class name.
