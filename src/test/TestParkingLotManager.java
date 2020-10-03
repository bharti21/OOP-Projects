package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.practice.consumer.Consumer;
import com.practice.consumer.Vehicle;
import com.practice.consumer.VehicleTypeEnum;
import com.practice.parkinglot.ParkingLot;
import com.practice.parkinglot.ParkingLotManager;

import slot.Slot;

public class TestParkingLotManager {

	@InjectMocks
	ParkingLotManager parkingLotManager;

	@Test
	public void testcheckSlotAvailability() {
		ParkingLot parkingLot = this.prepareMockParkingLot();
		Vehicle vehicle = this.prepareMockVehicle();
		assertEquals(parkingLotManager.checkSlotAvailability(parkingLot, vehicle).isPresent(), true);
	}

	@Test
	public void testGenerateReceipt(){
		Consumer consumer =this.prepareConsumer();
		assertNotNull(parkingLotManager.generateReceipt(consumer));
	}

	private ParkingLot prepareMockParkingLot() {
		List<Slot> slots = new ArrayList<>();
		Slot slot = new Slot(1, VehicleTypeEnum.CAR, true);
		slots.add(slot);
		ParkingLot parkingLot = new ParkingLot("0", slots);
		return parkingLot;
	}

	private Vehicle prepareMockVehicle() {
		Vehicle vehicle = new Vehicle("MH13:4747", VehicleTypeEnum.CAR);
		return vehicle;
	}

	private Consumer prepareConsumer() {
		Vehicle vehicle = this.prepareMockVehicle();
		Consumer consumer = new Consumer("Sailee", "7826223590", "Latur", vehicle);
		return consumer;
	}

}
