import java.util.StringTokenizer;


public class StringSession {

	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = "Hello";
		
		String str3 = new String("Hello");
		String str4 = new String("Hello");
		
		int[] a = {1,2,3,4,5};
		
//		System.out.println(str1.hashCode());
//		System.out.println(str2.hashCode());
//		System.out.println(str3.hashCode());
//		System.out.println(str4.hashCode());
		
		
		String str = "198.121.10.21";
		System.out.println(str.split("\\.")[1]);
		
		StringBuilder sBuffer = new StringBuilder("Hello");
		
		String sBuffer2 = new String("Hello");
		sBuffer2.concat(" Test");
		
		StringTokenizer s = new StringTokenizer("Hello World, How are you!");
		System.out.println(s.nextElement());
		System.out.println(s.nextElement());
		System.out.println(s.nextElement());
		System.out.println(s.nextElement());
		System.out.println(s.nextElement());
	}
	//contains()
	//endsWith()
}
