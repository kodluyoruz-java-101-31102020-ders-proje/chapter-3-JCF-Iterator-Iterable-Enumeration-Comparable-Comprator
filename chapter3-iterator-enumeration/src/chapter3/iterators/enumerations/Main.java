package chapter3.iterators.enumerations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import chapter3.iterators.hospital.MaintanenceDayComparator;
import chapter3.iterators.hospital.Patient;

public class Main {

	public static void main(String[] args) {

		runIteratorSample();
		runEnumerationSample();
	}

	public static void extraSamples() {

		// TreeSet ve TreeMap için Comparator verebilirsiniz.
		/*
		 * Set<Patient> patientSet = new TreeSet<Patient>(new
		 * MaintanenceDayComparator()); patientSet.add(new Patient("Batuhan", "Duzgun",
		 * "Karın ağrısı", 2)); patientSet.add(new Patient("Hatice", "Yurt",
		 * "Kemik kırığı", 30)); patientSet.add(new Patient("Ali", "Yurt", "Baş kırığı",
		 * 30)); patientSet.add(new Patient("Ayşe", "Fatma", "Baş ağrısı", 1));
		 * 
		 * for(Patient p : patientSet) { System.out.println(p.hashCode());
		 * System.out.println(p); }
		 */

		List<Patient> patientList = new ArrayList<Patient>();
		patientList.add(new Patient("Batuhan", "Duzgun", "Karın ağrısı", 2));
		patientList.add(new Patient("Hatice", "Yurt", "Kemik kırığı", 30));
		patientList.add(new Patient("Ali", "Yurt", "Baş kırığı", 30));
		patientList.add(new Patient("Ayşe", "Fatma", "Baş ağrısı", 1));

		Collections.sort(patientList, new MaintanenceDayComparator());

		for (Patient p : patientList) {
			System.out.println(p);
		}

		/*
		 * System.out.println(new Patient("Hatice", "Yurt", "Kemik kırığı",
		 * 30).hashCode()); System.out.println(new Patient("Hatice", "Yurt",
		 * "Kemik kırığı", 30).hashCode());
		 * 
		 * 
		 * Map<Patient, String> patientMap = new HashMap<Patient, String>();
		 * patientMap.put(new Patient("Batuhan", "Duzgun", "Karın ağrısı", 2),
		 * "hasta1"); patientMap.put(new Patient("Ali", "Duzgun", "Karın ağrısı", 4),
		 * "hasta2"); patientMap.put(new Patient("Ali", "Duzgun", "Karın ağrısı", 4),
		 * "hasta3"); patientMap.put(new Patient("Mehmet", "Yırca", "baş ağrısı", 19),
		 * "hasta4");
		 * 
		 * for(Patient p : patientMap.keySet()) {
		 * 
		 * String description = patientMap.get(p); System.out.println(description);
		 * 
		 * }
		 */

	}

	public static void runEnumerationSample() {

		List<ElectricCar> electricalCars = new ArrayList<ElectricCar>();
		electricalCars.add(new ElectricCar("BMW", "34 AL 377", 100));
		electricalCars.add(new ElectricCar("Mercedes", "35 Aa 547", 200));
		electricalCars.add(new ElectricCar("BMW", "45 AB 547", 200));

		electricalCars.iterator();

		Enumeration<ElectricCar> enumerationObject = Collections.enumeration(electricalCars);

		while (enumerationObject.hasMoreElements()) {
			ElectricCar electricCar = enumerationObject.nextElement();
			electricCar.showInfo();
		}

		Vector<ElectricCar> electricCarVector = new Vector<ElectricCar>();
		electricCarVector.add(new ElectricCar("BMW", "34 AL 377", 100));
		electricCarVector.add(new ElectricCar("Mercedes", "35 Aa 547", 200));
		electricCarVector.add(new ElectricCar("BMW", "45 AB 547", 200));

		electricCarVector.iterator();

		// Vector veri yapısında "elements" isimli fonksiyon Enumeration tipinde bir
		// nesneyi oluşturup döndürür.
		Enumeration<ElectricCar> enumerationObject1 = electricCarVector.elements();

		// Ya da Collections sınıfı içindeki static "enumeration" fonksiyonu ile
		// Enumeration nesnesi oluşturabiliriz.
		Enumeration<ElectricCar> enumerationObject2 = Collections.enumeration(electricCarVector);

		while (enumerationObject1.hasMoreElements()) {
			ElectricCar electricCar = enumerationObject1.nextElement();
			electricCar.showInfo();
		}

		List<String> linkedList = new LinkedList<String>();
		linkedList.add("Merhaba");

		linkedList.iterator();

	}

	public static void runIteratorSample() {

		List<Patient> patientList = new ArrayList<Patient>();
		patientList.add(new Patient("Batuhan", "Duzgun", "Karın ağrısı", 2));
		patientList.add(new Patient("Hatice", "Yurt", "Kemik kırığı", 30));
		patientList.add(new Patient("Mehmet", "Yurt", "Kemik kırığı", 30));
		patientList.add(new Patient("Ayşe", "Fatma", "Baş ağrısı", 1));

		/*
		 * java.util.ConcurrentModificationException hatası verecektir. for(Patient
		 * patient : patientList) { if(patient.getMaintanenceDay() > 20) {
		 * patientList.remove(patient); } }
		 */

		Iterator<Patient> doctor = patientList.iterator();

		// Iterator oluşturulduktan sonra veri kaynağı üzerinde değişim yapılmaz!
		// patientList.add(new Patient("Özkan", "Ulusoy", "Karın ağrısı", 1));

		while (doctor.hasNext()) {
			Patient patient = doctor.next();
			System.out.println(patient);

			if (patient.getMaintanenceDay() > 20) {
				doctor.remove();
			}
		}

		// iterator elemanları gezdikten sonra veri kümesi üzerinde değişiklik
		// yapabiliriz.
		patientList.add(new Patient("Özkan", "Ulusoy", "Karın ağrısı", 1));

		System.out.println(patientList);

		List<ElectricCar> electricalCars = new ArrayList<ElectricCar>();

		electricalCars.add(new ElectricCar("BMW", "34 AL 377", 100));
		electricalCars.add(new ElectricCar("Mercedes", "35 Aa 547", 200));
		electricalCars.add(new ElectricCar("BMW", "45 AB 547", 200));

		/*
		 * java.util.ConcurrentModificationException hatası verecektir. for(ElectricCar
		 * electricCar : electricalCars) {
		 * 
		 * if(electricCar.getBrand().equals("BMW")) {
		 * 
		 * electricalCars.remove(electricCar); }
		 * 
		 * }
		 */

		Iterator<ElectricCar> iteratorObject = electricalCars.iterator();

		while (iteratorObject.hasNext()) {
			ElectricCar electricCar = iteratorObject.next();

			if (electricCar.getBrand().equals("BMW")) {
				iteratorObject.remove();
			}
			/*
			 * Eeğer ıterator ile döngüde eleman eklemeye çalışırsanız
			 * java.util.ConcurrentModificationException hatası alınır. else {
			 * electricalCars.add(new ElectricCar()); }
			 */
		}

		// Iterator dolaşımı bittikten sonra eleman eklenebilir.
		electricalCars.add(new ElectricCar());

		for (ElectricCar car : electricalCars) {

			car.showInfo();
		}

	}

}
