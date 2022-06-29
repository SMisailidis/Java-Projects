import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		//Scanner input = new Scanner(System.in);
		//CSVReader csv = new CSVReader("src\\Heroes.csv");
		//Heroes player = null;
		//String name;
		
		HeroSelectGUI w = new HeroSelectGUI();
		
		/*
		do {
			System.out.println("Choose your Hero: \n" + csv.names);
			name = input.nextLine();
		}while(!csv.names.contains(name));
		
		input.close();
		player = select(name);

		if(player instanceof GOTG) {
			//Fights ads = new Fights((GOTG)player);
			//Fights asds = new Fights(player);
		}
		else {
			//Fights asds = new Fights(player);
		} */
		
	}
	
	public static Heroes select(String name) {
		Heroes hero = null;
		
		switch(name) {		
			case "Iron Man": IronMan im = new IronMan(); hero = im; break;
			case "Spider-Man": SpiderMan sp = new SpiderMan(); hero = sp; break;
			case "Captain America": CaptainAmerica ca = new CaptainAmerica(); hero = ca; break;
			case "Thor": Thor t = new Thor(); hero = t; break;
			case "Dr Strange": DoctorStrange ds = new DoctorStrange(); hero = ds; break;
			case "Starlord": StarLord sl = new StarLord(); hero = sl; break;
			case "Gamora": Gamora g = new Gamora(); hero = g; break;
			case "Rocket Raccoon": RocketRaccoon rr = new RocketRaccoon(); hero = rr; break;
			case "Drax": Drax d = new Drax(); hero = d; break;
			case "Groot": Groot gr = new Groot(); hero = gr; break;
			case "Ant-Man": AntMan am = new AntMan(); hero = am; break;
			case "Scarlet Witch": ScarletWitch sw = new ScarletWitch(); hero = sw; break;
			case "Black Panther": BlackPanther bp = new BlackPanther(); hero = bp; break;
		}
		return hero;
	}
}