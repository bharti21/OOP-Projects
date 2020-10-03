package slot;
import java.util.Comparator;

import slot.Slot;

public class SortSlotBySlotNo implements Comparator<Slot>{

	public int compare(Slot s1,Slot s2){
		return s1.getSlotNo() - s2.getSlotNo();
	}
	

}
