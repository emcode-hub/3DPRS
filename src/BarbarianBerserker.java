
public class BarbarianBerserker extends Barbarian{
	/*
	 * Frenzy
	 * Starting when you choose this path at 3rd level, you can go into a
	 * frenzy when you rage. If you do so, for the duration of your rage you can
	 * make a single melee weapon attack as a bonus action on each of your turns
	 * after this one. When your rage ends, you suffer one level of exhaustion.	 * 
	 */
	
	//Frenzy
	@Override
	int getAttacksPerTurn() {
		if(super.isRageOn()) {
			return this.getLevel() < 5? 2:3;
		}else {
			return this.getLevel() < 5? 1:2;	
		}
	}
}
