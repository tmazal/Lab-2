package pokerBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class CardTest {

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
	public void TestGeteSuit(){
        Card c1 = new Card(eSuit.SPADES,eRank.KING,0);
        Card c2 = new Card(eSuit.HEARTS,eRank.QUEEN,1);
        assertEquals(c1.geteSuit(),eSuit.SPADES);
        assertEquals(c2.geteSuit(),eSuit.HEARTS);
    }
	
	@Test
	public void TestGeteRank(){
        Card c1 = new Card(eSuit.SPADES,eRank.KING,0);
        Card c2 = new Card(eSuit.HEARTS,eRank.QUEEN,1);
        assertEquals(c1.geteRank(),eRank.KING);
        assertEquals(c2.geteRank(),eRank.QUEEN);
    }
	
	@Test
	public void TestGetCardNo(){
        Card c1 = new Card(eSuit.SPADES,eRank.KING,0);
        Card c2 = new Card(eSuit.HEARTS,eRank.QUEEN,1);
        assertEquals(c1.getiCardNbr(),0);
        assertEquals(c2.getiCardNbr(),1);
    }

}
