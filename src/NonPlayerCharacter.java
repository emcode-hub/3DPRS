
public class NonPlayerCharacter extends Character{
	private double challengeRating = 0;

	public NonPlayerCharacter(int str, int dex, int con, int intel, int wis, int cha, int ac, int hp) {
		super(str, dex, con, intel, wis, cha, ac, hp);
	}

	@Override
	public int getProficiencyBonus() {
		int CR = this.getChallengeRating() < 1 ? 1 : (int) this.getChallengeRating();
		return (CR-1)/4+2;
	}

	public double getChallengeRating() {
		return challengeRating;
	}

	public void setChallengeRating(double challengeRating) {
		this.challengeRating = challengeRating;
	}

	@Override
	public int attack(int targetAC) {
		// TODO Auto-generated method stub
		return 1;
	}

	
	//we wouldn't know these until the subclass of goblin, for example.
	@Override
	int getAttackMod() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int getAttacksPerTurn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int getDamageModifiers() {
		// TODO Auto-generated method stub
		return 0;
	}


}
