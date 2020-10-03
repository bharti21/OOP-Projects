package com.practice.consumer;

import java.util.Map;
import java.util.stream.Collectors;

import com.practice.parkinglot.ParkingLot;
import com.practice.parkinglot.ParkingLotManager;

import slot.Slot;

public class Consumer {

	private String name;
	private String phoneNo;
	private String address;
	private int parkingToken;
	private Vehicle vehicle;

	public Consumer(String name, String phoneNo, String address, Vehicle vehicle) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.vehicle = vehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getParkingToken() {
		return parkingToken;
	}

	public void setParkingToken(int parkingToken) {
		this.parkingToken = parkingToken;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void parkVehicle(ParkingLot parkingLot) {
		if (ParkingLotManager.checkSlotAvailability(parkingLot, this.vehicle).isPresent()) {
			Slot slot = ParkingLotManager.checkSlotAvailability(parkingLot, this.vehicle).get();
			int slotNo = slot.getSlotNo();
			this.setParkingToken(slotNo);
			slot.setAvailable(false);
			ParkingLotManager.slotDetails.put(this.vehicle.getVehicleNo(), slotNo);
			System.out.println("Welcome: Your vehicle is parked at slot No:  " + slotNo);
			return;
		}
		System.out.println("We are sorry! Empty Slot is not available currently");
	}

	public void unParkVehicle(ParkingLot parkingLot) {
		Integer parkingToken = ParkingLotManager.slotDetails.get(this.vehicle.getVehicleNo());
		if (null != parkingToken && parkingToken == this.parkingToken) {
			ParkingLotManager.generateReceipt(this);
			Slot slot = parkingLot.getSlots().stream().filter(p -> p.getSlotNo() == parkingToken)
					.collect(Collectors.toList()).get(0);
			slot.setAvailable(true);
			System.out.println("Successfully unparked!");
			return;
		}
		System.out.println("We are sorry! Please verify your vehilce no and parking Token");
	}

}
