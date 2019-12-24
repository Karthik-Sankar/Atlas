class PThread extends Thread{
	public void run()
	{
		for(int i=1;i<50;i++)
		{
			System.out.println("Thread# "+i);
		}
	}
}
public class ThreadExample {

	public static void main(String[] args) {
		PThread p =  new PThread();
		p.start();
		for(int i=1;i<=10;i++)
		{
			System.out.println("Main# "+i);
		}
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				for(int i=1;i<=10;i++)
				System.out.println("Anonymous object!# "+i);
			}
		});
		t.start();
	}

}
