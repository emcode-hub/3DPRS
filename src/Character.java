
public abstract class Character extends Roller{
	private int strength, dexterity, constitution, intellect, wisdom, charisma, armorClass, hitPoints;

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
	
	//Player Characters and NPCs calculate proficiency bonus differently, so we leave that burden to the subclass
	public abstract int getProficiencyBonus();
	
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
}
