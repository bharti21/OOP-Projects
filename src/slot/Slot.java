package slot;

import com.practice.consumer.VehicleTypeEnum;

public class Slot  {
	private int slotNo;
	private VehicleTypeEnum slotType;
	boolean isAvailable;
	
	
	public Slot(int slotNo, VehicleTypeEnum type, boolean isAvailable) {
		this.slotNo = slotNo;
		this.slotType = type;
		this.isAvailable = isAvailable;
	}


	public int getSlotNo() {
		return slotNo;
	}


	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}


	public VehicleTypeEnum getType() {
		return slotType;
	}


	public void setType(VehicleTypeEnum type) {
		this.slotType = type;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
}
