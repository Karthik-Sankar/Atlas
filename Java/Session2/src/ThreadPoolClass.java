import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Ticket{
	static int ticketCount = 0;
	String fname;
	String lname;
	String pnr;
	int seat;
	boolean checkedIn = false;
	public Ticket(String fname, String lname, String pnr, int seat) {
		this.fname = fname;
		this.lname = lname;
		this.pnr = pnr;
		this.seat = seat;
	}
	public Ticket() {
		
	}
	@Override
	public String toString() {
		return "Ticket [fname=" + fname + ", lname=" + lname + ", pnr=" + pnr + ", seat=" + seat + ", checkedIn="+ checkedIn +"]";
	}
	
}

class CheckInTask extends Thread{
	Ticket ticket;
	public CheckInTask(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public void run()
	{
		ticket.checkedIn=true;
		ticket.seat = ++Ticket.ticketCount;
		System.out.println(ticket.fname+" has been assigned seat no : "+ticket.seat);
	}
}
public class ThreadPoolClass {

	public static void main(String[] args) {
		Ticket t1 = new Ticket("Karthik", "Sankar", "ABC123Q",0);
		Ticket t2 = new Ticket("Sarves", "Sankar", "ER2312D",0);
		Ticket t3 = new Ticket("Thilak", "Sankar", "EW453FF",0);
		Ticket t4 = new Ticket("Sam", "Elvin", "ERE343R",0);
		Ticket t5 = new Ticket("Karthik", "Suresh", "SSD2342",0);
		System.out.println("t1 : "+t1);
		System.out.println("t2 : "+t2);
		System.out.println("t3 : "+t3);
		System.out.println("t4 : "+t4);
		System.out.println("t5 : "+t5);
		
		/*Thread tr1 = new CheckInTask(t1);
		tr1.start();
		Thread tr2 = new CheckInTask(t2);
		tr2.start();
		Thread tr3 = new CheckInTask(t3);
		tr3.start();
		Thread tr4 = new CheckInTask(t4);
		tr4.start();
		Thread tr5 = new CheckInTask(t5);
		tr5.start();*/
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new CheckInTask(t1));
		service.execute(new CheckInTask(t2));
		service.execute(new CheckInTask(t3));
		service.execute(new CheckInTask(t4));
		service.execute(new CheckInTask(t5));
		service.shutdown();
	}

}
