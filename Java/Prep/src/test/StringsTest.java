package test;

public class StringsTest {
public static void main(String[] args) {
	String s1 = new String("Hello");
	System.out.println(s1.hashCode());
	String s2 = new String("HelloHelloHe");
	System.out.println(s2.substring(s2.lastIndexOf('l')).toUpperCase().replace("O", "L"));
	System.out.println(s2.isBlank());
}
}
