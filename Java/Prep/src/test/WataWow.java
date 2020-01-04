package test;

public class WataWow {
//	public static long arsum(int[] A)
//	{
//		
//	}
	
	public int area(int a)
	{
		return a*a;
	}
	public int area(int l, int b)
	{
		return l*b;
	}
	
	public static void main(String[] args) {
		/*
		 * int[] arr = {4,1,3,2}; long n = (arr.length*(arr.length+1))/2; long sum=0;
		 * int max = 0; for(int i=0;i<arr.length;i++) { if(max < arr[i]) max = arr[i];
		 * sum += arr[i]; } System.out.println(max); System.out.println(arr.length);
		 * if(sum==n && max < arr.length) System.out.println("Permutation"); else
		 * System.out.println("Not permutation");
		 */
		
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		
		String str = "Hello";
		String st = "Hello";
		String str2 = new String("Hello");
		if(str.equals(st))System.out.println("Matches");  else System.out.println("Not matched");
		if(str.equals(str2))System.out.println("Matches"); else System.out.println("Not matched");
		System.out.println(str.hashCode());
		System.out.println(st.hashCode());
		System.out.println(str2.hashCode());
		str = str + " World";
		str = "asdlbjasldjbndasl 932438942 asdhasjdakd";
		System.out.println(str.split(" ")[1]);
		
		
	}
}
