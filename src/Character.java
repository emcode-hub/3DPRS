
public abstract class Character extends Roller{
	private int strength, dexterity, constitution, intellect, wisdom, charisma, armorClass, hitPoints;
	boolean advantage, disadvantage = false;
	private Weapon weapon;

	public Character(int str, int dex, int con, int intel, int wis, int cha, int ac, int hp) {
		this.setStrength(str);
		this.setDexterity(dex);
		this.setConstitution(con);
		this.setIntellect(intel);
		this.setWisdom(wis);
		this.setCharisma(cha);
		this.setArmorClass(ac);
		this.setHitPoints(hp);
	}
	
	//Player Characters and NPCs calculate proficiency bonus differently, so we leave that burden to the subclass. Same for calculating attackMod
	public abstract int getProficiencyBonus();
	abstract int getAttackMod();
	abstract int getAttacksPerTurn();
	abstract int getDamageModifiers();
	
	public int attack(int targetAC) {
		int totalDamage=0;
		int numAttacks= this.getAttacksPerTurn();

		while(numAttacks>0) {
			//roll to hit
			int diceRoll = 0;
			if(this.hasAdvantage()) {
				diceRoll = RollAdvantageOneD(20);
			}
			else if (this.hasDisadvantage()) {
				diceRoll = RollDisadvantageOneD(20);
			}
			else {
				diceRoll = RollOneD(20);
			}
			int totalHitRoll = diceRoll + this.getProficiencyBonus() + this.getAttackMod();
			
			//if hit, calculate damage. else return 0 for a miss
			if(targetAC<=totalHitRoll) {
				totalDamage+=this.getWeaponDamage();
				//get damage modifiers
				totalDamage+=this.getDamageModifiers();
			}
			numAttacks--;
		}
		return totalDamage;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		System.out.println("Setting weapon as "+weapon.getWeaponName());
		this.weapon = weapon;
	}

	private int getWeaponDamage() {//this should probably be in weapon, not here
		int weaponDamage=0;
		//if no weapon it would be an unarmed strike, so still deals damage
		weaponDamage+=weapon.rollDamage();
		return weaponDamage;
	}
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getIntellect() {
		return intellect;
	}

	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	
	public int getMod(int stat) {
		return Math.floorDiv(stat,2)-5;
	}
	
	public int getStrMod() {
		return getMod(this.getStrength());
	}
	
	public int getDexMod() {
		return getMod(this.getDexterity());
	}
	
	public int getConMod() {
		return getMod(this.getConstitution());
	}
	
	public int getIntMod() {
		return getMod(this.getIntellect());
	}
	
	public int getWisMod() {
		return getMod(this.getWisdom());
	}
	
	public int getChaMod() {
		return getMod(this.getCharisma());
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	

	public boolean hasAdvantage() {
		return advantage;
	}

	public void setAdvantage(boolean advantage) {
		if(this.hasDisadvantage() && advantage == true) {
			this.advantage = false;
			this.disadvantage = false;
		}
		else{
			this.advantage = advantage;
		}
	}

	public boolean hasDisadvantage() {
		return disadvantage;
	}

	public void setDisadvantage(boolean disadvantage) {
		if(this.hasAdvantage() && disadvantage==true) {
			this.advantage = false;
			this.disadvantage = false;
		}
		else{
			this.disadvantage = disadvantage;
		}
	}
}
