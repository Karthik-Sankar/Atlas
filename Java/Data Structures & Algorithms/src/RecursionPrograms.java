
public class RecursionPrograms {

	public static void recFun(int n)
	{
		if(n<1)
			return;
		else
			recFun(n-1);
		System.out.println(n);
	}
	public static void main(String[] args) {
		recFun(5);
	}

}
