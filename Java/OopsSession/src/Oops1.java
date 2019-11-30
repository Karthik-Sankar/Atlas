class ManufacturingPlant{
	String name;
	String address;
	int no_of_machinerys;
	double operation_time;
	double enegryusedlastmonth;
	double energyusedthismonth;
	public ManufacturingPlant()
	{
		this.name = new String();
		this.address =  new String();
		this.no_of_machinerys = 0;
		this.operation_time = 0.0;
		this.enegryusedlastmonth = 0.0;
		this.energyusedthismonth = 0.0;
	}
	public ManufacturingPlant(String name,String address,int no_of_machinerys,double operation_time,double enegryusedlastmonth,double energyusedthismonth)
	{
		this.name = name;
		this.address = address;
		this.no_of_machinerys = no_of_machinerys;
		this.operation_time = operation_time;
		this.enegryusedlastmonth = enegryusedlastmonth;
		this.energyusedthismonth = energyusedthismonth;
	}
	
}

public class Oops1 {

	public static void main(String[] args) {
		ManufacturingPlant mp1 = new ManufacturingPlant();
		
		mp1.name = "Karthik";
		mp1.address = "Royapuram Chennai 13";
		mp1.no_of_machinerys = 6;
		mp1.operation_time = 8;
		mp1.enegryusedlastmonth = 250;
		mp1.energyusedthismonth = 340;
		
		ManufacturingPlant m2 = new ManufacturingPlant("Sanjith","Royapuram",6, 8.0,250.0,500.0);
		
	}

}
