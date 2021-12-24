import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfTurns = 1000;
		String char1Class = "Barbarian";
		int char1Level = 6;
		String char1Weapon = "Greatsword";
		String enemy1Choice = "Goblin";
		
		
		
		
		
		Barbarian barb1 = new Barbarian();
		barb1.setRageOn(true);
		
		
		Weapon greataxe = new Greataxe();
		Weapon greatsword = new Greatsword();
		
		//public NonPlayerCharacter(int str, int dex, int con, int intel, int wis, int cha, int ac, int hp)
		NonPlayerCharacter enemyGoblin = new NonPlayerCharacter(8,14,10,10,8,8,15,7);
		
		//barb1.setWeapon(greataxe);
		barb1.setWeapon(greatsword);
		
		barb1.setLevel(6);
		enemyGoblin.setArmorClass(0);
		
		double averageDamageDone = runSimulation(barb1,enemyGoblin,numberOfTurns);
		
		System.out.println(averageDamageDone);

	}

	private static double runSimulation(Barbarian pc, Character target, int numberOfTurns) {
		int totalDamage = 0;
		
		for(int i = 0; i<numberOfTurns; i++) {
			totalDamage += pc.attack(target);
		}
		
		return (double) totalDamage/numberOfTurns;
	}

}
