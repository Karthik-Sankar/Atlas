import java.util.Scanner;

public class ConditionExamples {
	public static void main(String args[])
	{
		double amount;
		System.out.println("Enter your amount : ");
		Scanner s =  new Scanner(System.in);
		amount = s.nextDouble();
		if(amount>500)
		{
			amount-=(amount*0.5);
		}
		else if(amount > 300 && amount < 500)
		{
			amount-=(amount*0.3);
		}
		else 
		{
			amount-=(amount*0.1);
		}
		System.out.println("Amount after Discount : \u20b9"+amount);
		int netBanking=1;
		int payTm=2;
		int amazonPay=3;
		int payopt = 3;
		switch(payopt)
		{
		case netBanking:
			System.out.println("Net Banking!");
		
		}
		
	}
}
