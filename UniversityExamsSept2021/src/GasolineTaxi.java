
public class GasolineTaxi extends Taxi{


	private int capacity;
	private double aConsume;

	public GasolineTaxi(String town, String number, String name, int capacity,double aConsume) {
		
		super(town, number, name);
		this.capacity = capacity;
		this.aConsume = aConsume;
		
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getaConsume() {
		return aConsume;
	}

	public void setaConsume(double aConsume) {
		this.aConsume = aConsume;
	}
	
	public double calcAutonomy() {
		double atonomy;
		
		return atonomy = 90 * (this.capacity/this.aConsume);
	}
	
}
