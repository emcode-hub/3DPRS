
public abstract class Weapon extends Roller{
	private int numberOfDice;
	private int diceMaxValue;
	private String weaponName;
	
	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public int getNumberOfDice() {
		return numberOfDice;
	}

	public void setNumberOfDice(int numberOfDice) {
		this.numberOfDice = numberOfDice;
	}

	public int getDiceMaxVale() {
		return diceMaxValue;
	}

	public void setDiceMaxVale(int diceMaxVale) {
		this.diceMaxValue = diceMaxVale;
	}

	public String getDamageType() {
		return damageType;
	}

	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}

	String damageType;
	
	public int rollDamage() {
		int result=0;
		int diceNum = getNumberOfDice();
		
		while(diceNum>0) {
			result+=RollOneD(diceMaxValue);
			diceNum--;
		}
		
		return result;
	}
}
