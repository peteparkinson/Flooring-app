/**************************************************** 
Program Name: Customer.java 
Programmer's Name: Peter Parkinson 
Program Description: This file stores private customer
variables for the Flooring app
***********************************************************/

public class Customer {

	private String name;
	private String address;
	private String floorType;
	private int area;
	private int cost;
	
	//default constructor
	public Customer() {}
	
	//name parameterized constructor
	public Customer(String name){
		this.name = name;
	}
	
	//full parameterized constructor
	public Customer(String name, String address, String floorType, int area, int cost) {
		this.name      = name;
		this.address   = address;
		this.floorType = floorType;
		this.area      = area;
		this.cost      = cost;
	}
	
	//getter
	public String getName()      { return name;    }
	public String getAddress()   { return address; }
	public String getFloorType() { return floorType; }
	public int getArea() 		 { return area; }
	public int getCost() 	     { return cost; }
	
	//setters
	public void setName     (String name)      { this.name    = name; }
	public void setAddress  (String address)   { this.address = address; }
	public void setFloorType(String floorType) { this.floorType = floorType; }
	public void setArea     (int area) 		   { this.area = area; }
	public void setCost     (int cost) 	       { this.cost = cost; }
	
	public String toString() { return name; }
}
