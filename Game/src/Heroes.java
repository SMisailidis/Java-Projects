import java.util.*;
import java.util.Random;

public class Heroes extends Characters {

	protected ArrayList<Villains> villians = new ArrayList<Villains>();

	public Heroes(ArrayList<String[]> results){
		
		for(int i=1;i<7;i++){
			this.stats.add(Integer.parseInt(results.get(0)[i]));
		}

		switch(results.get(0)[0]){
			case "Ant-Man": //Special;
			case "Black Panther": //Special;
			case "Black Widow": //Special;                                                                                                                                                                                                                                                                                                                                   	case "Captain America": //Special;
			case "Dr Strange": //Special;
			case "Drax": //Special;
			case "Gamora": //Special;
			case "Groot": //Special;
			case "Hawkeye": //Special;
			case "Hulk": //Special;
			case "Iron Man": //Special;
			case "Rocket Raccoon": //Special;
			case "Scarlet Witch": //Special;
			case "Spider-Man": //Special;
			case "Starlord": //Special;
			case "Thor": //Special;
			case "Vision": //Special;
			case "Wong": //Special;
		}
	}

}

//----------Guardians Of The Galaxy----------\\
// class GOTG extends Heroes{

// 	protected String maxStat;
// 	protected ArrayList<GOTG> Guardians = new ArrayList<GOTG>();
	
// 	public GOTG() {
		
// 		Ronan Ronan = new Ronan();
// 		Ego Ego = new Ego();
// 		Thanos Thanos = new Thanos();
// 		AdamWarlock AdamWarlock = new AdamWarlock();
		
// 		this.villians.add(Ronan);
// 		this.villians.add(Ego);
// 		this.villians.add(Thanos);
// 		this.villians.add(AdamWarlock);
		
// 	}
	
// 	public void sAbility() {
		
		
// 	}	
	
// 	public GOTG chooseOp(String name) {
		
// 		for(int i=0; i<this.Guardians.size();i++) {
// 			if(name.equals(this.Guardians.get(i).name)) {
// 				 this.Guardians.remove(i);
// 			}
// 		}

// 		Random random = new Random();
// 		int opp = random.nextInt(this.Guardians.size());
		
// 		return this.Guardians.get(opp);
// 	}
	
// 	public ArrayList<GOTG> fillAList() {
		
// 		StarLord StarLord = new StarLord(""); //Second constructor to prevent recursion
// 		Gamora Gamora = new Gamora("");
// 		RocketRaccoon RocketRaccoon = new RocketRaccoon("");
// 		Drax Drax = new Drax("");
// 		Groot Groot = new Groot("");
		
// 		Guardians.add(StarLord);
// 		Guardians.add(Gamora);
// 		Guardians.add(RocketRaccoon);
// 		Guardians.add(Drax);
// 		Guardians.add(Groot);
		
// 		return this.Guardians;
// 	}
// }

// class StarLord extends GOTG{
	
// 	protected GOTG opp;
	
// 	public StarLord() {
		
// 		GOTG gotg = new GOTG();
// 		this.name = "Starlord";
// 		this.Guardians = gotg.fillAList();
		 
// 		this.maxStat = "Accuracy";
		
// 		this.opp = gotg.chooseOp(this.name);
// 	}
	
// 	public StarLord(String s) {
		
// 		this.name = "Starlord";
		 
// 		this.maxStat = "Accuracy";
// 	}
// }

// class Gamora extends GOTG{
	
// 	public Gamora() {
		
// 		GOTG gotg = new GOTG();
		
// 		this.name = "Gamora";
// 		this.Guardians = gotg.fillAList();
		 
// 		this.maxStat = "Evasion";
// 		//GOTG opp = gotg.chooseOp(this.name);
// 	}
	
// 	public Gamora(String s) {

// 		this.name = "Gamora";
		 
// 		this.maxStat = "Evasion";
// 	}
// }

// class RocketRaccoon extends GOTG{
	
// 	public RocketRaccoon() {
		
// 		GOTG gotg = new GOTG();
		
// 		this.name = "Rocket Raccoon";
// 		this.Guardians = gotg.fillAList();
		 
// 		this.maxStat = "Instinct";
// 		//GOTG opp = gotg.chooseOp(this.name);
// 	}
	
// 	public RocketRaccoon(String s) {

// 		this.name = "Rocket Raccoon";
		 
// 		this.maxStat = "Instinct";
// 	}
// }

// class Drax extends GOTG{
	
// 	public Drax() {
		
// 		GOTG gotg = new GOTG();
		
// 		this.name = "Drax";
// 		this.Guardians = gotg.fillAList();
		 
// 		this.maxStat = "Strength";
// 		//GOTG opp = gotg.chooseOp(this.name);
// 	}
	
// 	public Drax(String s) {
		
// 		this.name = "Drax";
		 
// 		this.maxStat = "Strength";
// 	}
// }

// class Groot extends GOTG{
	
// 	public Groot() {
		
// 		GOTG gotg = new GOTG();
		
// 		this.name = "Groot";
// 		this.Guardians = gotg.fillAList();
		 
// 		this.maxStat = "Defence";
// 		//GOTG opp = gotg.chooseOp(this.name);
		
// 	}
	
// 	public Groot(String s) {
		
// 		this.name = "Groot";
		 
// 		this.maxStat = "Defence";
// 	}
// }
//-------------------------------------------\\

