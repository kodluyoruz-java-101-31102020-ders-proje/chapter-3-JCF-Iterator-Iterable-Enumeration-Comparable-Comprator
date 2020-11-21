package chapter3.iterators.hospital;

import java.util.Comparator;

public class MaintanenceDayComparator implements Comparator<Patient> {

	@Override
	public int compare(Patient o1, Patient o2) {
		
		if(o1.getMaintanenceDay() > o2.getMaintanenceDay()) {
			return -1;
		}
		else if(o1.getMaintanenceDay() < o2.getMaintanenceDay()) {
			return 1;
		}
		
		return 0;
	}

}
