package com.practice.consumer;

public enum VehicleTypeEnum {

	CAR("car"), BIKE("bike"), TRUCK("truck"), AUTORICKSHAW("autorickshaw");

	private String vehicleType;

	private VehicleTypeEnum(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	
}
