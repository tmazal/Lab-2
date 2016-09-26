package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pokerEnums.eRank;
import pokerEnums.eSuit;
import pokerEnums.eHandStrength;

public class HandTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestHighCard(){
		Hand h1 = new Hand();
		ArrayList<Card> HighCard = new ArrayList<Card>();
		HighCard.add(new Card(eSuit.SPADES,eRank.ACE,0));
		HighCard.add(new Card(eSuit.SPADES,eRank.TWO,1));
		HighCard.add(new Card(eSuit.CLUBS,eRank.QUEEN,2));
		HighCard.add(new Card(eSuit.DIAMONDS,eRank.TEN,3));
		HighCard.add(new Card(eSuit.CLUBS,eRank.SEVEN,4));
		h1.setCardsInHand(HighCard);
		h1.EvalHand();
		HandScore handScore = h1.getHandScore();
		assertEquals(handScore.getHandStrength(),eHandStrength.HighCard.getiHandStrength());
	}
	
	@Test
	public void TestOnePair(){
		Hand h2 = new Hand();
		ArrayList<Card> OnePair = new ArrayList<Card>();
		OnePair.add(new Card(eSuit.SPADES,eRank.ACE,0));
		OnePair.add(new Card(eSuit.SPADES,eRank.TWO,1));
		OnePair.add(new Card(eSuit.CLUBS,eRank.ACE,2));
		OnePair.add(new Card(eSuit.DIAMONDS,eRank.TEN,3));
		OnePair.add(new Card(eSuit.CLUBS,eRank.SEVEN,4));
		Collections.sort(OnePair);
		h2.setCardsInHand(OnePair);
		h2.EvalHand();
		HandScore handScore = h2.getHandScore();
		assertEquals(handScore.getHandStrength(),eHandStrength.Pair.getiHandStrength());
		assertEquals(handScore.getHiHand(),eRank.ACE.getiRankNbr());
	}
	
	@Test
	public void TestTwoPair(){
		Hand h3 = new Hand();
		ArrayList<Card> TwoPair = new ArrayList<Card>();
		TwoPair.add(new Card(eSuit.SPADES,eRank.ACE,0));
		TwoPair.add(new Card(eSuit.SPADES,eRank.TWO,1));
		TwoPair.add(new Card(eSuit.CLUBS,eRank.ACE,2));
		TwoPair.add(new Card(eSuit.DIAMONDS,eRank.TWO,3));
		TwoPair.add(new Card(eSuit.CLUBS,eRank.SEVEN,4));
		Collections.sort(TwoPair);
		h3.setCardsInHand(TwoPair);
		h3.EvalHand();
		HandScore handScore = h3.getHandScore();
		assertEquals(handScore.getHandStrength(),eHandStrength.TwoPair.getiHandStrength());
		assertEquals(handScore.getHiHand(),eRank.ACE.getiRankNbr());
		assertEquals(handScore.getLoHand(),eRank.TWO.getiRankNbr());
	}
	
	@Test
	public void TestThreeOfAKind(){
		Hand h4 = new Hand();
		ArrayList<Card> ThreeOfAKind = new ArrayList<Card>();
		ThreeOfAKind.add(new Card(eSuit.SPADES,eRank.ACE,0));
		ThreeOfAKind.add(new Card(eSuit.SPADES,eRank.THREE,1));
		ThreeOfAKind.add(new Card(eSuit.CLUBS,eRank.THREE,2));
		ThreeOfAKind.add(new Card(eSuit.DIAMONDS,eRank.TWO,3));
		ThreeOfAKind.add(new Card(eSuit.CLUBS,eRank.THREE,4));
		Collections.sort(ThreeOfAKind);
		h4.setCardsInHand(ThreeOfAKind);
		h4.EvalHand();
		HandScore handScore = h4.getHandScore();
		assertEquals(handScore.getHandStrength(),eHandStrength.ThreeOfAKind.getiHandStrength());
		assertEquals(handScore.getHiHand(),eRank.THREE.getiRankNbr());
	}
	
	@Test
	public void TestStraight(){
		Hand h5 = new Hand();
		ArrayList<Card> Straight = new ArrayList<Card>();
		Straight.add(new Card(eSuit.HEARTS,eRank.SEVEN,0));
		Straight.add(new Card(eSuit.SPADES,eRank.SIX,1));
		Straight.add(new Card(eSuit.CLUBS,eRank.THREE,2));
		Straight.add(new Card(eSuit.DIAMONDS,eRank.FIVE,3));
		Straight.add(new Card(eSuit.CLUBS,eRank.FOUR,4));
		Collections.sort(Straight);
		h5.setCardsInHand(Straight);
		h5.EvalHand();
		HandScore handScore = h5.getHandScore();
		assertEquals(handScore.getHandStrength(),eHandStrength.Straight.getiHandStrength());
		assertEquals(handScore.getHiHand(),eRank.SEVEN.getiRankNbr());
	}
	
	@Test
	public void TestFlush(){
		Hand h6 = new Hand();
		ArrayList<Card> Straight = new ArrayList<Card>();
		Straight.add(new Card(eSuit.SPADES,eRank.ACE,0));
		Straight.add(new Card(eSuit.SPADES,eRank.JACK,1));
		Straight.add(new Card(eSuit.SPADES,eRank.THREE,2));
		Straight.add(new Card(eSuit.SPADES,eRank.SEVEN,3));
		Straight.add(new Card(eSuit.SPADES,eRank.FOUR,4));
		Collections.sort(Straight);
		h6.setCardsInHand(Straight);
		h6.EvalHand();
		HandScore handScore = h6.getHandScore();
		assertEquals(handScore.getHandStrength(),eHandStrength.Flush.getiHandStrength());
		assertEquals(handScore.getHiHand(),eRank.ACE.getiRankNbr());
	}
	
	@Test
	public void TestFullHouse(){
		Hand h7 = new Hand();
		ArrayList<Card> FullHouse = new ArrayList<Card>();
		FullHouse.add(new Card(eSuit.CLUBS,eRank.THREE,0));
		FullHouse.add(new Card(eSuit.SPADES,eRank.KING,1));
		FullHouse.add(new Card(eSuit.DIAMONDS,eRank.THREE,2));
		FullHouse.add(new Card(eSuit.HEARTS,eRank.KING,3));
		FullHouse.add(new Card(eSuit.SPADES,eRank.THREE,4));
		Collections.sort(FullHouse);
		h7.setCardsInHand(FullHouse);
		h7.EvalHand();
		HandScore handScore = h7.getHandScore();
		assertEquals(handScore.getHandStrength(),eHandStrength.FullHouse.getiHandStrength());
		assertEquals(handScore.getHiHand(),eRank.KING.getiRankNbr());
		assertEquals(handScore.getLoHand(),eRank.THREE.getiRankNbr());
	}
	
	@Test
	public void TestFourofAKind(){
		Hand h8 = new Hand();
		ArrayList<Card> FourofAKind = new ArrayList<Card>();
		FourofAKind.add(new Card(eSuit.CLUBS,eRank.SIX,0));
		FourofAKind.add(new Card(eSuit.SPADES,eRank.SIX,1));
		FourofAKind.add(new Card(eSuit.DIAMONDS,eRank.SIX,2));
		FourofAKind.add(new Card(eSuit.HEARTS,eRank.SIX,3));
		FourofAKind.add(new Card(eSuit.SPADES,eRank.THREE,4));
		Collections.sort(FourofAKind);
		h8.setCardsInHand(FourofAKind);
		h8.EvalHand();
		HandScore handScore = h8.getHandScore();
		assertEquals(handScore.getHandStrength(),eHandStrength.FourOfAKind.getiHandStrength());
		assertEquals(handScore.getHiHand(),eRank.SIX.getiRankNbr());
	}
	
	@Test
	public void TestStraightFlush(){
		Hand h9 = new Hand();
		ArrayList<Card> FourofAKind = new ArrayList<Card>();
		FourofAKind.add(new Card(eSuit.DIAMONDS,eRank.FIVE,0));
		FourofAKind.add(new Card(eSuit.DIAMONDS,eRank.SIX,1));
		FourofAKind.add(new Card(eSuit.DIAMONDS,eRank.NINE,2));
		FourofAKind.add(new Card(eSuit.DIAMONDS,eRank.SEVEN,3));
		FourofAKind.add(new Card(eSuit.DIAMONDS,eRank.EIGHT,4));
		Collections.sort(FourofAKind);
		h9.setCardsInHand(FourofAKind);
		h9.EvalHand();
		HandScore handScore = h9.getHandScore();
		assertEquals(handScore.getHandStrength(),eHandStrength.StraightFlush.getiHandStrength());
		assertEquals(handScore.getHiHand(),eRank.NINE.getiRankNbr());
	}
	
	@Test
	public void TestRoyalFlush() {
		Hand h10 = new Hand();
		ArrayList<Card> RoyalFlush = new ArrayList<Card>();
		RoyalFlush.add(new Card(eSuit.SPADES,eRank.QUEEN,0));
		RoyalFlush.add(new Card(eSuit.SPADES,eRank.JACK,1));
		RoyalFlush.add(new Card(eSuit.SPADES,eRank.ACE,2));
		RoyalFlush.add(new Card(eSuit.SPADES,eRank.KING,3));
		RoyalFlush.add(new Card(eSuit.SPADES,eRank.TEN,4));
		Collections.sort(RoyalFlush);
		h10.setCardsInHand(RoyalFlush);
		h10.EvalHand();
		HandScore handScore = h10.getHandScore();
		assertEquals(handScore.getHandStrength(),eHandStrength.RoyalFlush.getiHandStrength());
	}
}
	