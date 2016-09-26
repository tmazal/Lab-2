/**
 * 
 */
package pokerBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeckTest {

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
	public void TestBuildDeck() {
		Deck d1 = new Deck();
		assertEquals(d1.DeckSize(), 52);
	}

	@Test
	public void TestDrawFromDeck() {
		Deck d2 = new Deck();
		d2.Draw();
		assertEquals(d2.DeckSize(), 51);
	}

	@Test
	public void TestThriceDrawFromDeck() {
		Deck d2 = new Deck();
		d2.Draw();
		d2.Draw();
		d2.Draw();
		assertEquals(d2.DeckSize(), 49);
	}
}