import java.util.Scanner;

class Temp
{
	static int x=10;
	int length;
	Temp(int data)
	{
		length = data;
	}
//	public String toString()
//	{
//		return ""+this.data;
//	}
	
	public void length()
	{
		System.out.println(this.length);
	}
	
	public int[] methods(int a[])
	{
		System.out.println("Length from method : "+a.length);
		for(int i=0; i<a.length; i++)
		{
			a[i] = i;
		}
		return a;
	}
	
	
	public void methods(int a[], int b[])
	{
		
	}
}
class TestingClass{
	void whatawow()
	{
		
	}
}

class _T extends TestingClass{
	void whatawow()
	{
		
	}
}
public class ArraysPrepr {
	public static void main(String[] args){
		int a = 10;
		float b = 22.3f;
		double d = 22.3;
		boolean x = true;
		char c = 'a';
		byte v = 123;
		short s = 324;
		long l = 123543646;
		int a5[] = new int[5];
		int size = 5;
		short ssize = 5;
		float[] arr = new float[ssize];
		System.out.println(a);
		System.out.println(c);
		String str = new String("Hello");
		System.out.println(str.hashCode());
		Temp t = new Temp(10);
		Temp t5 = null;
		System.out.println(t5);
		Temp t2;
		System.out.println(t.length);
		t.length();
		System.out.println(a5.length);
		t.methods(a5);
		
		
		int b4[] = {1,2,3,4,5,6};
		System.out.println(b4[4]);
		System.out.println(b4.length);
		
		Scanner scan = new Scanner(System.in);
		System.out.println(scan);
		
		
		//int arr[4];
		int arr1[] = new int[4];
		int[] arr2;
		arr2 = new int[3]; 
		arr2[0] = 40;
		
		int[] arr3 = {1,2,3};
		
		int[] a24 = new int [] {1,2,3,4,5};
				
				
		for(int i = 0;i<a5.length;i++)
			System.out.println(a5[i]);
		
		t.methods(a5);
		
		for(int i = 0;i<a5.length;i++)
			System.out.println(a5[i]);
		
		int[] a6 = t.methods(a5);
				
		for(int i = 0;i<a6.length;i++)
			System.out.println(a6[i]);
		
		
		
	}
}