package pokerBase;

public class HandScore {

	private int HandStrength;
	private int HiHand;
	private int LoHand = 0;

	public HandScore() {}
	
	public HandScore(int handStrength, int hiHand, int loHand) {
		super();
		HandStrength = handStrength;
		HiHand = hiHand;
		LoHand = loHand;
	}

	public int getHandStrength() {
		return HandStrength;
	}

	public void setHandStrength(int handStrength) {
		HandStrength = handStrength;
	}

	public int getHiHand() {
		return HiHand;
	}

	public void setHiHand(int hiHand) {
		HiHand = hiHand;
	}

	public int getLoHand() {
		return LoHand;
	}

	public void setLoHand(int loHand) {
		LoHand = loHand;
	}
}