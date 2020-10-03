package com.practice.parkinglot;

import java.util.List;

import slot.Slot;

public class ParkingLot {

	String floorNo;
	List<Slot> slots;
	final int NO_OF_SLOTS = 20;

	public ParkingLot(String floorNo, List<Slot> slots) {
		this.floorNo = floorNo;
		this.slots = slots;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

}
