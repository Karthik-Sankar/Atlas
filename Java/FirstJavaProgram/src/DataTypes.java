
public class DataTypes {
	public static void main(String[] args)
	{
		int amt = 1000; //32 bits - 4 bytes
		byte age = 20; //8 bits - 1 byte 
		age += 10;
		char p='a';
		int tc = (int)p;
		tc += 5;
		p=(char)tc;
		char rupee='\u20b9';
		System.out.println("Jacks Age is : "+age);
		System.out.println("Amt : "+age+" "+rupee);
		System.out.println("p : "+(char)((int)p+2));
	}
}
