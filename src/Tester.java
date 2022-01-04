import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfTurns = 10000;
//		String char1Class = "Barbarian";
//		int char1Level = 6;
//		String char1Weapon = "Greatsword";
//		String enemy1Choice = "Goblin";
		
		//Barbarian barb1 = new Barbarian();
		Barbarian barb1 = new BarbarianBerserker();
		barb1.setRageOn(true);
		
		
		//Weapon greataxe = new Greataxe();
		Weapon greatsword = new Greatsword();
		
		//public NonPlayerCharacter(int str, int dex, int con, int intel, int wis, int cha, int ac, int hp)
		NonPlayerCharacter enemyGoblin = new NonPlayerCharacter(8,14,10,10,8,8,15,7);
		
		//barb1.setWeapon(greataxe);
		barb1.setWeapon(greatsword);
		
		barb1.setLevel(5);
		barb1.setDisadvantage(true);
		barb1.setAdvantage(false);
		//enemyGoblin.setArmorClass(0);
		
		/*
		 * double averageDamageDone =
		 * runSimulation(barb1,enemyGoblin.getArmorClass(),numberOfTurns);
		 * System.out.println(averageDamageDone +" vs 15 AC Goblin");
		 */
		
		System.out.println(printSimulationTable(barb1));
		in.close();

	}

	private static String printSimulationTable(Barbarian barb1) {
		int numberOfTurns = 10000;
		int minAC = 1;
		int maxAC = 20;
		StringBuilder outputTable = new StringBuilder();
		
		
		//System.out.println("AC=0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t14\t15\t16");
		outputTable.append("\tAC\tDMG\t    |\tAC\tDMG");
		outputTable.append("\n\t----------------------------------------\n");
		for (int i = minAC; i<=maxAC; i++) {
			outputTable.append("\t"+i+ "\t"+ runSimulation(barb1, i , numberOfTurns));
			if(i%2==0) {
				outputTable.append("\n");
			}
			else {
				outputTable.append("\t    |");
			}
		}
		return outputTable.toString();		
	}

	private static double runSimulation(Character pc, int targetAC, int numberOfTurns) {
		int totalDamage = 0;
		
		for(int i = 0; i<numberOfTurns; i++) {
			totalDamage += pc.attack(targetAC);
		}
		
		return (double) totalDamage/numberOfTurns;
	}

}
