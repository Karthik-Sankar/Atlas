/* 1. Customer Needs to Login to amazon using amazon account
	Cutomer can here be translates as user then!
	User - Has a Relationship
	* name:string
	* email:string
	* password:string
	* address:string
	* isPrime:boolean
	* orderlist:array(product_id)
	User - can
	* login/logout
	* purchasegiftcard(giftcard_id)
	* cancelorder(product_id)

2. Gift card Interface
   * card_id : int
   * amount : int
   * to_person : Customer
   * from_person : Customer
   * message : String
   * quantity : int
   * deliveryDate : String
   * orderedDate : String
   * imageUrl : String

3. Payment Interface
   * amount : int
   * sucess() : void
   * failure() : void */




abstract class Customer{
	String name;
	String email;
	String passwd;
	String address;
	boolean isPrime;
	int offer;
	int[] product_id = null;
	abstract boolean login(String email, String passwd);
	abstract void logout();
}

abstract class GiftCard{
	int card_id;
	int amount;
	String to_person;
	String from_person;
	String message;
	int quantity;
	String deliveryDate;
	String orderedDate;
	abstract boolean purchaseGiftCard(Customer sender, Customer receiver);
}

interface PaymentInterface {
	int amount=0;
	boolean success(String email, String passwd);
}

class PrimeCustomer extends Customer{
	void Customer(String name,String email,String passwd,String address,boolean isPrime, int offer){
		this.name = name;
		this.email = email;
		this.passwd = passwd;
		this.address = address;
		this.isPrime = isPrime;
	}
	public boolean login(String email, String passwd)
	{
		System.out.println("You are our prime customer! *All prime offers applicable to you!");
		return true;
	}
	public void logout()
	{
		System.out.println("You have been logged out! Please login to continue!");
	}
}

public class AmazonGiftCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
