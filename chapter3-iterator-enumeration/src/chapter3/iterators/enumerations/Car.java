package chapter3.iterators.enumerations;

public class Car extends Vehicle {

	// aracın marka bilgisi
	protected String brand;

	// aracın plaka bilgisi
	protected String plateNumber;

	public Car() {
		
		super();
		
		this.brand = "NO_BRAND";
		this.plateNumber = "NO_PLATE_NUMBER";
	}

	public Car(String brand, String plateNumber) {
		
		this.brand = brand;
		this.plateNumber = plateNumber;
	}
	
	public Car(String brand, String plateNumber, short wheelCount) {
		
		super(wheelCount);
		
		this.brand = brand;
		this.plateNumber = plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public String getPlateNumber() {
		return this.plateNumber;
	}


	// Eğer bu fonksiyon Car sınıfında olmasaydı. Bir üstteki Vehicle'a bakacaktı.
	public void showInfo() {
		
		System.out.println("<< Car Info >>");
		
		System.out.println(this.plateNumber);
		System.out.println(this.brand);
	}
	

}
