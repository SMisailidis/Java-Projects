import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Taxi> taxis = new ArrayList<>();
		
		Fleet taxi1 = new Fleet("�������");
		Fleet taxi2 = new Fleet("��������");
			
		ElectricalTaxi elTaxi1 = new ElectricalTaxi("�������", "XXX-1234", "Dhmhtrhs", 4);
		ElectricalTaxi elTaxi2 = new ElectricalTaxi("��������", "XXX-4321", "Hraklhs", 5);
		
		GasolineTaxi gTaxi1 = new GasolineTaxi("�������", "YYY-1234", "Savvas", 55, 1.5);
		GasolineTaxi gTaxi2 = new GasolineTaxi("��������", "YYY-4321", "Vasilis", 60, 2.0);
		
		taxi1.storeTaxi(taxis, elTaxi1);
		taxi2.storeTaxi(taxis, elTaxi2);
		taxi1.storeTaxi(taxis, gTaxi1);
		taxi2.storeTaxi(taxis, gTaxi2);
		
		GUI gui = new GUI(taxis);
		
		
	}

}
