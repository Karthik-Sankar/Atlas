class Employees{
	int id;
	int name;
	public Employees() {
		System.out.println("Default contructor in Employee class, \nThis points to : "+this);
	}
	public Employees(int id, int name)
	{
		System.out.println("Parametrized constructor in Employee class, \n This points to :"+this);
	}
}

class A1<T>{
	T amount;
	A1(T a)
	{
		this.amount = a;
	}
}
public class ThisAndSuper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i = 10;
		System.out.println(i.hashCode());
		int a  = i;
		System.out.println(a);
		
		A1 b = new A1(1);
		System.out.println(b);
		
		Runtime r = Runtime.getRuntime();
		System.out.println("Processor : "+r.availableProcessors());
		
	}

}
