import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Taxi> taxis = new ArrayList<>();
		
		Fleet taxi1 = new Fleet("Ρέθυμνο");
		Fleet taxi2 = new Fleet("Ηράκλειο");
			
		ElectricalTaxi elTaxi1 = new ElectricalTaxi("Ρέθυμνο", "XXX-1234", "Dhmhtrhs", 4);
		ElectricalTaxi elTaxi2 = new ElectricalTaxi("Ηράκλειο", "XXX-4321", "Hraklhs", 5);
		
		GasolineTaxi gTaxi1 = new GasolineTaxi("Ρέθυμνο", "YYY-1234", "Savvas", 55, 1.5);
		GasolineTaxi gTaxi2 = new GasolineTaxi("Ηράκλειο", "YYY-4321", "Vasilis", 60, 2.0);
		
		taxi1.storeTaxi(taxis, elTaxi1);
		taxi2.storeTaxi(taxis, elTaxi2);
		taxi1.storeTaxi(taxis, gTaxi1);
		taxi2.storeTaxi(taxis, gTaxi2);
		
		GUI gui = new GUI(taxis);
		
		
	}

}
