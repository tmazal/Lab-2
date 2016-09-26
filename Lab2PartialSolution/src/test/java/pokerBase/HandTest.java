package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		h2.setCardsInHand(OnePair);
		h2.EvalHand();
		HandScore handScore = h2.getHandScore();
		assertEquals(handScore.getHandStrength(),eHandStrength.Pair.getiHandStrength());
	}
	
	@Test
	public void TestRoyalFlush() {
		Hand h10 = new Hand();
		ArrayList<Card> RoyalFlush = new ArrayList<Card>();
		RoyalFlush.add(new Card(eSuit.HEARTS,eRank.TEN,0));
		RoyalFlush.add(new Card(eSuit.HEARTS,eRank.JACK,1));
		RoyalFlush.add(new Card(eSuit.HEARTS,eRank.QUEEN,2));
		RoyalFlush.add(new Card(eSuit.HEARTS,eRank.KING,3));
		RoyalFlush.add(new Card(eSuit.HEARTS,eRank.ACE,4));
		h10.setCardsInHand(RoyalFlush);
		h10.EvalHand();
		HandScore handScore = h10.getHandScore();
		assertEquals(handScore.getHandStrength(),eHandStrength.RoyalFlush.getiHandStrength());
	}
}
	