import java.util.Random;

public class Fights {
	
	protected Heroes hero;
	protected Villains villain;
	protected Heroes hero2;
	
	protected int heroHp;
	protected int oppHp;
	
	// public Fights(Heroes hero) {
		
	// 	this.hero = hero; 	
		
	// 	if(!this.hero.villians.isEmpty()) {
	// 		this.villain = this.hero.villians.get(0); //Take the villain
	// 		Fights fight = new Fights(this.hero, this.villain); //Fight the villain
	// 	}
	// 	else {
	// 		System.out.println("GGWP");
	// 	}

	// }
	
	// public Fights(Heroes hero, Villains villain) {
		
	// 	this.hero = hero;
	// 	this.villain = villain;
	// 	this.heroHp = 3;
	// 	this.oppHp = 3;
		
	// 	do {
	// 		FightVillain(); //Calculates who wins and who loses each round
	// 	}while(this.heroHp != 0 && this.oppHp != 0);
		
	// 	if(this.heroHp == 0) {
	// 		System.out.println(this.villain.name + " Wins!");
	// 	}
	// 	else {
	// 		System.out.println(this.hero.name + " Wins!");
			
	// 		this.hero.villians.remove(0); //Remove the defeated villain
	// 		Fights fight = new Fights(this.hero);
	// 	}
		
	// }
	
	// // public Fights(GOTG hero) {
		
	// // 	this.hero = hero;
	// // 	this.heroHp = 3;
	// // 	this.oppHp = 3;
		
	// // 	int value = Dice();
		
	// // 	GOTG player = (GOTG)this.hero;
	// // 	GOTG opp = player.chooseOp(player.name); //Choose the GOTG to fight
	// // 	System.out.println(opp.name);
		
	// // 	System.out.println(player.name + " MaxStat is: " + player.maxStat);
	// // 	System.out.println(opp.name + " MaxStat is: " + opp.maxStat);
		
	// // 	do {
	// // 		if(value % 2 != 0) {
	// // 			this.oppHp--;
	// // 		}
	// // 		else {
	// // 			this.heroHp--;
	// // 		}
	// // 	}while(this.heroHp != 0 && this.oppHp != 0);
		
	// // 	if(this.heroHp == 0) {
	// // 		System.out.println(opp.name + " Wins!");
	// // 	}
	// // 	else {
	// // 		System.out.println(player.name + " Wins!");
	// // 	}
			
	// // }
	
	// public int Dice() {
		
	// 	Random dice = new Random();
		
	// 	return dice.nextInt(6);	
	// }
	
	// public void FightVillain() {
		
	// 	int value = Dice();
	// 	switch(value) {
		
	// 		case 0: System.out.println("Strength"); break;
	// 		case 1: System.out.println("Stamina"); break;
	// 		case 2: System.out.println("Evasion"); break;
	// 		case 3: System.out.println("Defence"); break;
	// 		case 4: System.out.println("Accuracy"); break;
	// 		case 5: System.out.println("Instinct"); break;
	// 	}
		
	// 	int heroStat = this.hero.stats.get(value);
	// 	int villainStat = this.villain.stats.get(value);
		
	// 	if(heroStat > villainStat) {
	// 		this.oppHp--;
	// 	}
	// 	else {
	// 		this.heroHp--;
	// 	}
	// }
	

}
