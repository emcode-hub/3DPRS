
public class Barbarian extends Character{
	private boolean rageOn = false;
	final int rageBonusDamage=2;
	private int level;
	private Weapon weapon;


	public Barbarian() {
		//the following is using a standard array of [15, 14, 13, 12, 10, 8] and +2str/+1con from racial
		super(17,14,14,8,10,12, 10, 12);
		this.setLevel(1);
		this.setArmorClass(this.getUnarmoredDefense());
	}

	public Barbarian(int str, int dex, int con, int intel, int wis, int cha, int ac, int hp, int level) {
		super(str, dex, con, intel, wis, cha, ac, hp);
		this.setLevel(level);
		int unarmoredDefenseAC = this.getUnarmoredDefense();
		if(ac<unarmoredDefenseAC) {
			this.setArmorClass(unarmoredDefenseAC);
		}
	}

	public int attack(Character target) {
		int totalDamage=0;
		int numAttacks= this.getAttacksPerTurn();

		while(numAttacks>0) {
			//roll to hit
			int diceRoll = Roller.RollOneD(20);
			int totalHitRoll = diceRoll + this.getProficiencyBonus() + this.getStrMod();
			
			//if hit, calculate damage. else return 0 for a miss
			if(target.getArmorClass()<=totalHitRoll) {
				totalDamage+=this.getWeaponDamage();
				//get damage modifiers
				totalDamage+=this.getDamageModifiers();
			}
			numAttacks--;
		}
		return totalDamage;
	}

	private int getAttacksPerTurn() {
		return this.getLevel() < 5? 1:2;
	}

	private int getDamageModifiers() {
		//a barbarian would add his strengthMod and get +2 if raging
		int totalDamageModifier = 0;

		totalDamageModifier += this.getStrMod();
		if(rageOn){
			totalDamageModifier+=rageBonusDamage;
		}

		return totalDamageModifier;
	}

	private int getWeaponDamage() {
		int weaponDamage=0;
		//if no weapon it would be an unarmed strike, so still deals damage
		weaponDamage+=weapon.rollDamage();
		return weaponDamage;
	}

	@Override
	public int getProficiencyBonus() {
		return (isProficientInWeapon() ? ((this.getLevel()-1)/4+2) : 0);
	}

	private boolean isProficientInWeapon() {
		//eventually our classes will have explicit weapon proficiencies. for now assume they are proficient in all
		return true;
	}

	private int getUnarmoredDefense() {
		return 10+this.getDexMod()+this.getConMod();
	}

	public boolean isRageOn() {
		return rageOn;
	}

	public void setRageOn(boolean rageOn) {
		this.rageOn = rageOn;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if(level >0 && level<21) {
			this.level = level;
		}
		else {
			this.level = 1;
		}
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		System.out.println("Setting weapon as "+weapon.getWeaponName());
		this.weapon = weapon;
	}
}
