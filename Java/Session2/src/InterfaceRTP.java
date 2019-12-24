interface PaymentGatewayListeners{
	void onSuccess(String msg);
	void onFailure(String msg);
}

class Payment{
	PaymentGatewayListeners pref=null;
	void initializeListener(PaymentGatewayListeners pref)
	{
		this.pref = pref;
	}
	void pay(int amt)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pref.onSuccess("You have made a payment of : \u20b9"+amt);
	}
	
}

class LimeRoadPay implements PaymentGatewayListeners{
	public void onSuccess(String msg)
	{
		System.out.println("Success!");
		System.out.println(msg);
	}
	public void onFailure(String msg)
	{
		System.out.println("Failed!");
	}
}
public class InterfaceRTP {

	public static void main(String[] args) {
		PaymentGatewayListeners pref = new LimeRoadPay();
		Payment pay = new Payment();
		pay.initializeListener(pref);
		pay.pay(500);
		pay.pay(1000);
	}
}
