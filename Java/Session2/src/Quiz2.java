import java.util.Scanner;

public class Quiz2 {

	double getPromoCode(double amount)
	{
		if(amount>=100 && amount <=199) {
			System.out.println("Applying promocode 1");
			return 0.1;}
		else if(amount>=200 && amount <=499) {
			System.out.println("Applying promocode 2");
			return 0.2;}
		else if(amount > 500) {
			System.out.println("Applying promocode 3");
			return 0.5;
		}
		else {
			System.out.println("Sorry No Promocode Matches!");
			return 0;
		}
		
	}
	double priceAfterPromo(double amount, int promocode)
	{
		double price=0;
		if(promocode==1)
		{
			if(amount>=100 && amount <=199)
				price-=(amount*0.1);
			else {
				System.out.println("You've entered a wrong promocode!\nBut We have applied the correct promocode and dicounted you");
				price-=(amount*getPromoCode(amount));
			}
		}
		else if(promocode==2)
		{
			if(amount>=200 && amount <=499)
				price-=(amount*0.2);
			else {
				System.out.println("You've entered a wrong promocode!\nBut We have applied the correct promocode and dicounted you");
				price-=(amount*getPromoCode(amount));
			}
		}
		else
		{
			if(amount>=500)
				price-=(amount*0.5);
			else {
				System.out.println("You've entered a wrong promocode!\nBut We have applied the correct promocode and dicounted you");
				price-=(amount*getPromoCode(amount));
			}
		}
		price = amount+price;
		return price;
	}
	public static void main(String[] args) {
		System.out.println("Enter Amount : ");
		Scanner s = new Scanner(System.in);
		double amount = s.nextDouble();
		System.out.println("Enter promocode val : ");
		int promocode = s.nextInt();
		s.close();
		Quiz2 q = new Quiz2();
		double price = q.priceAfterPromo(amount, promocode);
		System.out.println("Price After Deduction : "+price);
	}

}
