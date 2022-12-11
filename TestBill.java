package in.neuron.TestBill;
import java.util.Scanner;

interface RoomBillComponent{
	double tax=12;
	double extraPersonCharge=500.00;
	double foodCharge=800.00;
	float calculateBill();
}

class RoomDetails implements RoomBillComponent{
	int billId;
	String CustomerName;
	String typeOfRoom;
	int noOfDayStay;
	int noOfExtraPerson;
	static int counter=100;
	Scanner sc=new Scanner(System.in);
	
	RoomDetails(String customerName, String typeOfRoom, int noOfExtraPersons, int noOfDaysOfStay){
		this.CustomerName = customerName;
		this.typeOfRoom = typeOfRoom;
		this.noOfExtraPerson = noOfExtraPersons;
		this.noOfDayStay = noOfDaysOfStay;
		}
	
	public int getBillId() {
		counter++;
		billId=counter;
		return billId;
	}
	public String getCustomerName() {
		
		return CustomerName;
	}
	public String getTypeOfRoom() {
		
		return typeOfRoom;
	}
	public int getNoOfDayStay() {
		
		return noOfDayStay;
	}
	public int getNoExtraPerson() {
		
		return noOfExtraPerson;
	}
	public boolean ValidateTypeOfRoom() {
		if(typeOfRoom!="Standard" ||typeOfRoom!="Deluxe" ||typeOfRoom!="Cottage")
			return false;
				return true;
	}
	public boolean ValidateNoOfDayStay() {
		if(noOfDayStay>15)
			return false;
		return true;
	}
	
	public boolean ValidateExtraPersonCharge() {
		if(noOfExtraPerson>2)
			return false;
		return true;	
	}
	
	@Override
	public float calculateBill() {
		int baseRoomFare;
		float totalBill;
		ValidateTypeOfRoom();
		ValidateExtraPersonCharge();
		ValidateNoOfDayStay();
		
		if(typeOfRoom=="Standard")
			baseRoomFare=2500;
		else if(typeOfRoom=="Deluxe")
			baseRoomFare=3500;
		else
			baseRoomFare=5500;
		
		totalBill = (noOfDayStay * baseRoomFare) + (noOfDayStay * (float)foodCharge) + ((float)extraPersonCharge * noOfExtraPerson);
		totalBill = totalBill + (float)tax * totalBill;
		//totalBill = (totalBill);

		
		return totalBill;
	}
	public void disp() {
		boolean flag;
		System.out.println("***************** Billing Details of the Customer ***********************");
		System.out.println("BillId: "+getBillId());
		System.out.println("Customer Name: "+CustomerName);

		flag=ValidateNoOfDayStay();
		if(flag==true) {
			System.out.println("No of Day Stay "+noOfDayStay);
		}
		else {
			System.out.println("Sorry! Not more than 15 days of accomodation is to be provided to the customers");
		}
		
		
		System.out.println("Total Bill: "+calculateBill());
		System.out.println();

	}
	
}


public class TestBill {

	public static void main(String[] args) {
		RoomDetails room1=new RoomDetails("Salam", "Deluxe", 0,13);
		RoomDetails room2=new RoomDetails("rukku", "Cottage", 2,13);
		RoomDetails room3=new RoomDetails("balam", "Standard", 2,17);
		RoomDetails room4=new RoomDetails("Salam Ansari", "Normal", 1,13);
		room1.disp();
		room2.disp();
		room3.disp();
		room4.disp();

	}

}
