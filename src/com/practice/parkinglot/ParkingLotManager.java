package com.practice.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.practice.consumer.Consumer;
import com.practice.consumer.Receipt;
import com.practice.consumer.Vehicle;
import com.practice.consumer.VehicleTypeEnum;

import java.util.Comparator;
import java.util.HashMap;

import slot.Slot;
import slot.SortSlotBySlotNo;

public class ParkingLotManager {

	private String name;
	public static Map<String, Integer> slotDetails = new HashMap<>();

	public static Receipt generateReceipt(Consumer consumer) {
		Receipt receipt = new Receipt(consumer);
		return receipt;
	}

	public Map<String, Integer> getSlotDetails() {
		return slotDetails;
	}

	public String getName() {
		return name;
	}

	public static Optional<Slot> checkSlotAvailability(ParkingLot parkingLot, Vehicle vehicle) {
		String vehicleType = vehicle.getVehicleType().getVehicleType();
		if (isSlotAvailable(parkingLot, vehicleType).isPresent()) {
			return Optional.ofNullable(isSlotAvailable(parkingLot, vehicleType).get().get(0));
		}
		return Optional.empty();
	}

	private static Optional<List<Slot>> isSlotAvailable(ParkingLot parkingLot, String type) {
		List<Slot> slots = parkingLot.getSlots();
		List<Slot> availableSlots = slots.stream()
				.filter(s -> s.isAvailable() == true && s.getType().getVehicleType().equalsIgnoreCase(type))
				.collect(Collectors.toList());
		if (!availableSlots.isEmpty()) {
			Collections.sort(availableSlots, new SortSlotBySlotNo());
			return Optional.ofNullable(availableSlots);
		}
		return Optional.empty();
	}

	public static void provideSerivce(ParkingLot parkingLot,Consumer consumer, int option) {
		
			switch (option) {
			case 1:
				consumer.parkVehicle(parkingLot);
				break;
			case 2:
				// TODO: valet parking
			case 3:
				consumer.unParkVehicle(parkingLot);
				break;
		}

	}
}
