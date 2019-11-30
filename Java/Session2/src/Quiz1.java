import java.util.*;

public class Quiz1 {

	double calDiscount(double amount)
	{
		if(amount>=500) {
			return 0.5;
		}else if(amount>=300 && amount < 500) {
			return 0.3;
		}else {
			return 0.1;
		}
	}
	
	public static void main(String[] args) {
		Quiz1 q = new Quiz1();
		System.out.println("Enter amount : ");
		Scanner s = new Scanner(System.in);
		double amount = s.nextDouble();
		s.close();
		double discount = q.calDiscount(amount);
		double discountedPrice = amount - (discount * amount);
		System.out.println(">> Please Pay: \u20b9"+discountedPrice);
		System.out.println(">> You Saved \u20b9"+ (amount - discountedPrice));
		
	}
	
}
