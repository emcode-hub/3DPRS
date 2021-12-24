
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

}
