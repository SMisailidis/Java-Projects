
abstract public class Taxi extends Fleet{

	 private String number;
	 private String name;
	 
	 
	public Taxi(String town, String number, String name) {
		 
		 super(town);
		 this.number = number;
		 this.name = name;
		 
	}
	 
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public abstract double calcAutonomy();
}
