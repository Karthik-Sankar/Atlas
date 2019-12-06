/*Relationship between objects
 * 1. Has  A Relationship
 * 1 to 1 - Customer - Product
 * 1 to many - Menu - Dishes
 * many to many
 */
class Manager{
	Employee[] reportees;
	String name;
	final short requiredBandwidth = 240;
	short id;
	String designation;
	String reportingManager;
	short level;
	short bandwidth;
	boolean isManager;
	Manager(int n)
	{
		reportees = new Employee[n];
		for(int i=0; i<n; i++)
		{
			reportees[i] = new Employee();
		}
	}
	
	//Promote Employee to Manager
	void createManager(Employee manager)
	{
		manager.designation = "Program Manager";
		manager.isManager = true;
		manager.level = (short)5;
		name = manager.name;
		id = manager.id;
		designation = manager.designation;
		reportingManager = manager.reportingManager;
		level = manager.level;
		bandwidth = manager.bandwidth;
		isManager = manager.isManager;
	}
	
	
	void addEmployee(Employee[] employee)
	{
		for(int i = 0 ; i < employee.length && i < 10; i++)
		{
			//change reporting manager for person's tagged newly to manager.
			employee[i].reportingManager = this.name;
			reportees[i] = employee[i];
		}
	}
	void showManager()
	{
		System.out.println("Name : "+name);
		System.out.println("ID : "+id);
		System.out.println("Designation : "+designation);
		System.out.println("Reporting To : " + reportingManager);
		System.out.println("Reportees - Bandwidth");
		System.out.println("---------------------");
		for(Employee e : reportees)
		{
			if(e.id!=0)
			{
			System.out.println(e.name+" - "+e.bandwidth);
			}
		}
		System.out.println("---------------------");
	}
}

class Employee{
	short id;
	String name;
	String designation;
	String reportingManager;
	short level;
	short bandwidth;
	boolean isManager;
	Employee(short id, String name, String designation, String reportingManager, short level, short i,
			boolean b) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.reportingManager = reportingManager;
		this.level = level;
		this.bandwidth = i;
		this.isManager = b;
	}
	Employee() {
		this.id = 0;
		this.name = "None";
		this.designation = "None";
		this.reportingManager = "None";
		this.level = 0;
		this.bandwidth = 0;
		this.isManager = false;
	}
	void createEmployee(short id, String name, String designation, String reportingManager, short level, short i,
			boolean b) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.reportingManager = reportingManager;
		this.level = level;
		this.bandwidth = i;
		this.isManager = b;
	}
	void showEmployees()
	{
		System.out.println("------------------------");
		System.out.println("Name : "+name);
		System.out.println("ID : "+id);
		System.out.println("Designation : "+designation);
		System.out.println("Reporting To : " + reportingManager);
		System.out.println("Available Bandwidth : "+bandwidth);
		System.out.println("------------------------");
	}
}
public class MyUseCase {
	//Job allocation with effective bandwidth allocation.
	public static void main(String[] args) {
		Employee[] emp = new Employee[6];
		
		emp[0] = new  Employee((short)1001, "Karthik", "Lead", "John", (short)5, (short)90, false);
		emp[1] = new  Employee((short)1002, "Sachin", "Lead", "John", (short)4, (short)45, false);
		emp[2] = new  Employee((short)1003, "Keerthi", "Lead", "John", (short)4, (short)40, false);
		emp[3] = new  Employee((short)1004, "Sarves", "Analyst", "John", (short)3, (short)80, false);
		emp[4] = new  Employee((short)1005, "Goutham", "Analyst", "John", (short)3, (short)80, false);
		emp[5] = new  Employee((short)1006, "Sam", "Analyst", "John", (short)3, (short)80, false);
		System.out.println("Initial Employee Details");
		System.out.println("------------------------");
		for(Employee e: emp)
		{
			e.showEmployees();
		}
		System.out.println("------------------------");
		System.out.println();
		System.out.println("Promoting Karthik!");
		Manager m = new Manager(5);
		m.createManager(emp[0]);
		System.out.println("------------------------");
		System.out.println("Employee details before tagging employees under karthik");
		for(Employee e: emp)
		{
			e.showEmployees();
		}
		System.out.println("------------------------");
		System.out.println("Lets check the new manager \"Karthik's\" detail : ");
		System.out.println("------------------------");
		m.showManager();
		System.out.println("------------------------");
		System.out.println("Lets check tag \"Sam\" & \"Goutham\" under the new manager \"Karthik's\" and check details : ");
		System.out.println("------------------------");
		Employee[] r  = {emp[4], emp[5]};
		m.addEmployee(r);
		for(Employee e: emp)
		{
			e.showEmployees();
		}
		System.out.println("------------------------");
		System.out.println("Lets check the new manager \"Karthik's\" detail again: ");
		System.out.println("------------------------");
		m.showManager();
		System.out.println("------------------------");
	}

}
