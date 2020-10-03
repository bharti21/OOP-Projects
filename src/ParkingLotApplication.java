import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.practice.consumer.Consumer;
import com.practice.consumer.Vehicle;
import com.practice.consumer.VehicleTypeEnum;
import com.practice.parkinglot.ParkingLot;
import com.practice.parkinglot.ParkingLotManager;

import slot.Slot;

public class ParkingLotApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Vehicle vehicle = new Vehicle("MH13:5353", VehicleTypeEnum.CAR);
		Consumer consumer = new Consumer("Bharti", "7826223590", "Mohol", vehicle);
		List<Slot> slots = new ArrayList<>();
		Slot slot = new Slot(1, VehicleTypeEnum.CAR, true);
		slots.add(slot);
		ParkingLot parkingLot = new ParkingLot("0", slots);
		while(true){
			System.out.println("Welcome  " +consumer.getName()+": Which service are you interested in?" + "\n" + "1.Parking" + "\n"
					+ "2.Valet Parking" + "\n" + "3.Unpark" + "\n" + "4.Payment"+"\n"+"5.Exit");
			int option = sc.nextInt();
			if (option > 4)
				break;
			ParkingLotManager.provideSerivce(parkingLot,consumer, option);
		}
		

	}

}
