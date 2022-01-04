public class Roller {
	static int RollOneD(int maxLimit) {
		return (int) Math.floor(Math.random()*(maxLimit)+1);
	}
	
	static int RollAdvantageOneD(int maxLimit) {
		int num1 = (int) Math.floor(Math.random()*(maxLimit)+1);
		int num2 = (int) Math.floor(Math.random()*(maxLimit)+1);
		return num1 > num2 ? num1 :num2;
	}
	
	static int RollDisadvantageOneD(int maxLimit) {
		int num1 = (int) Math.floor(Math.random()*(maxLimit)+1);
		int num2 = (int) Math.floor(Math.random()*(maxLimit)+1);
		return num1 < num2 ? num1 :num2;
	}
}
