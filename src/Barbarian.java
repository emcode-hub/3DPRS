
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

//	public int attack(int targetAC) {
//		int totalDamage=0;
//		int numAttacks= this.getAttacksPerTurn();
//
//		while(numAttacks>0) {
//			//roll to hit
//			int diceRoll = Roller.RollOneD(20);
//			int totalHitRoll = diceRoll + this.getProficiencyBonus() + this.getStrMod();
//			
//			//if hit, calculate damage. else return 0 for a miss
//			if(targetAC<=totalHitRoll) {
//				totalDamage+=this.getWeaponDamage();
//				//get damage modifiers
//				totalDamage+=this.getDamageModifiers();
//			}
//			numAttacks--;
//		}
//		return totalDamage;
//	}

	@Override
	int getAttacksPerTurn() {
		return this.getLevel() < 5? 1:2;
	}

	@Override
	int getDamageModifiers() {
		//a barbarian would add his strengthMod and get +2 if raging
		int totalDamageModifier = 0;

		totalDamageModifier += this.getStrMod();
		if(rageOn){
			totalDamageModifier+=rageBonusDamage;
		}

		return totalDamageModifier;
	}

	@Override
	public int getProficiencyBonus() {
		return (isProficientInWeapon() ? ((this.getLevel()-1)/4+2) : 0);
	}

	@Override
	public int getAttackMod() {
		return this.getStrMod();
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
}
