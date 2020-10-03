package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.practice.consumer.Consumer;
import com.practice.consumer.VehicleTypeEnum;
import com.practice.parkinglot.ParkingLot;
import com.practice.parkinglot.ParkingLotManager;

import slot.Slot;

public class TestConsumer {

	@InjectMocks
	private Consumer consumer;
	
	@Mock 
	private ParkingLotManager parkingLotManager;
	
	@Test
	public void testParkVehicle(){
		Slot slot = new Slot(1, VehicleTypeEnum.CAR, true);
		ParkingLot parkingLot = this.prepareMockParkingLot();
		Mockito.when(ParkingLotManager.checkSlotAvailability(Mockito.any(),Mockito.any())).thenReturn(Optional.of(slot));
		consumer.parkVehicle(parkingLot);
		assertEquals(1,consumer.getParkingToken());
	}
	
	@Test
	public void testUnParkVehicle(){
		ParkingLot parkingLot = this.prepareMockParkingLot();
		consumer.unParkVehicle(parkingLot);
	}
	
	private ParkingLot prepareMockParkingLot() {
		List<Slot> slots = new ArrayList<>();
		Slot slot = new Slot(1, VehicleTypeEnum.CAR, true);
		slots.add(slot);
		ParkingLot parkingLot = new ParkingLot("0", slots);
		return parkingLot;
	}
}
