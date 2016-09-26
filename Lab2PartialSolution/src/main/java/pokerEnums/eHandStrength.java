package pokerEnums;

public enum eHandStrength {

	FiveOfAKind(110),
	RoyalFlush(100),
	StraightFlush(90),
	FourOfAKind(80),
	FullHouse(70),
	Flush(60),
	Straight(50),
	ThreeOfAKind(40),
	TwoPair(30),
	Pair(20),
	HighCard(10);

	private int iHandStrength;

	private eHandStrength(final int handstrength) {
		this.iHandStrength = handstrength;
	}
	
	public int getiHandStrength() {
		return iHandStrength;
	}


}
