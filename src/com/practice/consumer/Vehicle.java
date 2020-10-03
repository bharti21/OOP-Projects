package com.practice.consumer;

public class Vehicle {
	private String vehicleNo;
	private VehicleTypeEnum vehicleType;
	
	
	public Vehicle(String vehicleNo, VehicleTypeEnum vehicleType) {
		this.vehicleNo = vehicleNo;
		this.vehicleType = vehicleType;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public VehicleTypeEnum getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleTypeEnum vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	
}
