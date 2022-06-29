import java.util.*;
import java.util.Random;
public abstract class Heroes extends Characters {

	protected ArrayList<Villains> villians = new ArrayList<Villains>();
	
	public abstract void sAbility();
}
//----------IronMan----------\\
class IronMan extends Heroes{

	public IronMan() {
		
		IronMonger Ironmonger = new IronMonger();
		Whiplash Whiplash = new Whiplash();
		AldrichKillian AldrichKillian = new AldrichKillian();		
		Ultron Ultron = new Ultron();
		Thanos Thanos = new Thanos();
		
		this.name = "Iron Man";
		charStats("src\\Heroes.csv");
		
		this.villians.add(Ironmonger);
		this.villians.add(Whiplash);
		this.villians.add(AldrichKillian);
		this.villians.add(Ultron);
		this.villians.add(Thanos);
	}
	
	
	public void sAbility() {
	
		stats.set(0, stats.get(0)+30);
	}

}
//---------------------------\\

//----------SpiderMan----------\\
class SpiderMan extends Heroes{

	public SpiderMan() {
		
		Vulture Vulture = new Vulture();
		Mysterio Mysterio = new Mysterio();
		DrOctopus DrOctopus = new DrOctopus();		
		Electro Electro = new Electro();
		GreenGoblin GreenGoblin = new GreenGoblin();
		
		this.name = "Spider-Man";
		charStats("src\\Heroes.csv");
		
		this.villians.add(Vulture);
		this.villians.add(Mysterio);
		this.villians.add(DrOctopus);
		this.villians.add(Electro);
		this.villians.add(GreenGoblin);
	}
	
	
	public void sAbility() {
	
		stats.set(3, stats.get(3)+20);
		stats.set(1, stats.get(1)+10);
		
	}

}
//-----------------------------\\

//----------CaptainAmerica----------\\
class CaptainAmerica extends Heroes{

	public CaptainAmerica() {
		
		RedSkull RedSkull = new RedSkull();
		WinterSoldier WinterSoldier = new WinterSoldier();
		Ultron Ultron = new Ultron();		
		Crossbones Crossbones = new Crossbones();
		Thanos Thanos = new Thanos();
		
		this.name = "Captain America";
		charStats("src\\Heroes.csv");
		
		this.villians.add(RedSkull);
		this.villians.add(WinterSoldier);
		this.villians.add(Ultron);
		this.villians.add(Crossbones);
		this.villians.add(Thanos);
	}
	
	
	public void sAbility() {
	
		
	}

}
//----------------------------------\\

//----------Thor----------\\
class Thor extends Heroes{

	public Thor() {
		
		Loki Loki = new Loki();
		Malekith Malekith = new Malekith();
		Ultron Ultron = new Ultron();		
		Hela Hela = new Hela();
		Thanos Thanos = new Thanos();
		
		this.name = "Thor";
		charStats("src\\Heroes.csv");
		
		this.villians.add(Loki);
		this.villians.add(Malekith);
		this.villians.add(Ultron);
		this.villians.add(Hela);
		this.villians.add(Thanos);
	}
	
	
	public void sAbility() {
	
		stats.set(5, stats.get(5)+30);
	}

}
//------------------------\\

//----------DoctorStrange----------\\
class DoctorStrange extends Heroes{

	public DoctorStrange() {
		
		Kaecilius Kaecilius = new Kaecilius();
		Dormammu Dormammu = new Dormammu();
		Thanos Thanos = new Thanos();
		BaronMordo BaronMordo = new BaronMordo();		
		EvilStrange EvilStrange = new EvilStrange();
		
		this.name = "Dr Strange";
		charStats("src\\Heroes.csv");
		
		this.villians.add(Kaecilius);
		this.villians.add(Dormammu);
		this.villians.add(Thanos);
		this.villians.add(BaronMordo);
		this.villians.add(EvilStrange);
		
	}
	
	
	public void sAbility() {
	
		
	}

}
//---------------------------------\\

//----------ScarletWitch----------\\
class ScarletWitch extends Heroes{

	public ScarletWitch() {
			
		Ultron Ultron = new Ultron();
		ProximaMidnight ProximaMidnight = new ProximaMidnight();
		Thanos Thanos = new Thanos();
		AgathaHarkness AgathaHarkness = new AgathaHarkness();		
		EvilStrange EvilStrange = new EvilStrange();
		
		this.name = "Scarlet Witch";
		charStats("src\\Heroes.csv");
		
		this.villians.add(Ultron);
		this.villians.add(ProximaMidnight);
		this.villians.add(Thanos);
		this.villians.add(AgathaHarkness);
		this.villians.add(EvilStrange);
		
	}
	
	
	public void sAbility() {
	
		
		
	}

}
//--------------------------------\\

//----------Ant Man----------\\
class AntMan extends Heroes{
	
	public AntMan() {
		
		YellowJacket YellowJacket = new YellowJacket();
		Ghost Ghost = new Ghost();
		CullObsidian CullObsidian = new CullObsidian();
		Thanos Thanos = new Thanos();
		Kang Kang = new Kang();
		
		this.name = "Ant-Man";
		charStats("src\\Heroes.csv");
		
		this.villians.add(YellowJacket);
		this.villians.add(Ghost);
		this.villians.add(CullObsidian);
		this.villians.add(Thanos);
		this.villians.add(Kang);
				
	}

	public void sAbility() {
		
		
		
	}

}
//---------------------------\\

//----------Black Panther----------\\
class BlackPanther extends Heroes{

	public BlackPanther() {
		
		BaronZemo BaronZemo = new BaronZemo();
		UlyssesKlaue UlyssesKlaue = new UlyssesKlaue();
		Killmonger Killmonger = new Killmonger();		
		Thanos Thanos = new Thanos();
		Namor Namor = new Namor();
		
		this.name = "Black Panther";
		charStats("src\\Heroes.csv");
		
		this.villians.add(BaronZemo);
		this.villians.add(UlyssesKlaue);
		this.villians.add(Killmonger);
		this.villians.add(Thanos);
		this.villians.add(Namor);
	}
	
	public void sAbility() {
	
		
	}

}
//---------------------------------\\

//----------Guardians Of The Galaxy----------\\
class GOTG extends Heroes{

	protected String maxStat;
	protected ArrayList<GOTG> Guardians = new ArrayList<GOTG>();
	
	public GOTG() {
		
		Ronan Ronan = new Ronan();
		Ego Ego = new Ego();
		Thanos Thanos = new Thanos();
		AdamWarlock AdamWarlock = new AdamWarlock();
		
		this.villians.add(Ronan);
		this.villians.add(Ego);
		this.villians.add(Thanos);
		this.villians.add(AdamWarlock);
		
	}
	
	public void sAbility() {
		
		
	}	
	
	public GOTG chooseOp(String name) {
		
		for(int i=0; i<this.Guardians.size();i++) {
			if(name.equals(this.Guardians.get(i).name)) {
				 this.Guardians.remove(i);
			}
		}

		Random random = new Random();
		int opp = random.nextInt(this.Guardians.size());
		
		return this.Guardians.get(opp);
	}
	
	public ArrayList<GOTG> fillAList() {
		
		StarLord StarLord = new StarLord(""); //Second constructor to prevent recursion
		Gamora Gamora = new Gamora("");
		RocketRaccoon RocketRaccoon = new RocketRaccoon("");
		Drax Drax = new Drax("");
		Groot Groot = new Groot("");
		
		Guardians.add(StarLord);
		Guardians.add(Gamora);
		Guardians.add(RocketRaccoon);
		Guardians.add(Drax);
		Guardians.add(Groot);
		
		return this.Guardians;
	}
}

class StarLord extends GOTG{
	
	protected GOTG opp;
	
	public StarLord() {
		
		GOTG gotg = new GOTG();
		this.name = "Starlord";
		this.Guardians = gotg.fillAList();
		charStats("src\\Heroes.csv");
		this.maxStat = "Accuracy";
		
		this.opp = gotg.chooseOp(this.name);
	}
	
	public StarLord(String s) {
		
		this.name = "Starlord";
		charStats("src\\Heroes.csv");
		this.maxStat = "Accuracy";
	}
}

class Gamora extends GOTG{
	
	public Gamora() {
		
		GOTG gotg = new GOTG();
		
		this.name = "Gamora";
		this.Guardians = gotg.fillAList();
		charStats("src\\Heroes.csv");
		this.maxStat = "Evasion";
		//GOTG opp = gotg.chooseOp(this.name);
	}
	
	public Gamora(String s) {

		this.name = "Gamora";
		charStats("src\\Heroes.csv");
		this.maxStat = "Evasion";
	}
}

class RocketRaccoon extends GOTG{
	
	public RocketRaccoon() {
		
		GOTG gotg = new GOTG();
		
		this.name = "Rocket Raccoon";
		this.Guardians = gotg.fillAList();
		charStats("src\\Heroes.csv");
		this.maxStat = "Instinct";
		//GOTG opp = gotg.chooseOp(this.name);
	}
	
	public RocketRaccoon(String s) {

		this.name = "Rocket Raccoon";
		charStats("src\\Heroes.csv");
		this.maxStat = "Instinct";
	}
}

class Drax extends GOTG{
	
	public Drax() {
		
		GOTG gotg = new GOTG();
		
		this.name = "Drax";
		this.Guardians = gotg.fillAList();
		charStats("src\\Heroes.csv");
		this.maxStat = "Strength";
		//GOTG opp = gotg.chooseOp(this.name);
	}
	
	public Drax(String s) {
		
		this.name = "Drax";
		charStats("src\\Heroes.csv");
		this.maxStat = "Strength";
	}
}

class Groot extends GOTG{
	
	public Groot() {
		
		GOTG gotg = new GOTG();
		
		this.name = "Groot";
		this.Guardians = gotg.fillAList();
		charStats("src\\Heroes.csv");
		this.maxStat = "Defence";
		//GOTG opp = gotg.chooseOp(this.name);
		
	}
	
	public Groot(String s) {
		
		this.name = "Groot";
		charStats("src\\Heroes.csv");
		this.maxStat = "Defence";
	}
}
//-------------------------------------------\\

